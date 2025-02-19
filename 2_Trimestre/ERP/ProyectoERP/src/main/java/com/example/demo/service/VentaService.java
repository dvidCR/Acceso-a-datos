package com.example.demo.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.model.DetalleVenta;
import com.example.demo.model.Producto;
import com.example.demo.model.Venta;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.VentaRepository;

@Service
public class VentaService {
	
	@Autowired
    private VentaRepository ventaRepository;
	
	@Autowired
    private ProductoRepository productoRepository;
	
	public List<Venta> obtenerTodos() {
		return ventaRepository.findAll();
	}
	
	public Optional<Venta> obtenerPorId(Long id) {
		return ventaRepository.findById(id);
	}
	
	public Venta guardarVenta(Venta venta) {
		if (venta.getCliente() == null || venta.getCliente().getId() == null) {
            throw new IllegalArgumentException("La venta debe tener un cliente válido.");
        }

        double total = 0;
        for (DetalleVenta detalle : venta.getDetalles()) {
            Producto producto = productoRepository.findById(detalle.getProducto().getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + detalle.getProducto().getId()));

            if (producto.getStock() < detalle.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para el producto: " + producto.getNombre());
            }

            producto.setStock(producto.getStock() - detalle.getCantidad());

            detalle.setProducto(producto);
            detalle.setVenta(venta);
            detalle.calcularSubtotal();

            total += detalle.getSubtotal();
        }

        venta.setTotal(total);
        Venta ventaGuardada = ventaRepository.save(venta);

        return ventaRepository.findById(ventaGuardada.getId()).orElseThrow();
	}
	
	public void eliminarVenta(Long id) {
		ventaRepository.deleteById(id);
	}
	
	public Venta actualizarVenta(Long id, Venta ventaActualizada) {
        return ventaRepository.findById(id).map(venta -> {
            venta.setCliente(ventaActualizada.getCliente());
            venta.setFecha(ventaActualizada.getFecha());
            venta.setTotal(ventaActualizada.getTotal());
            return ventaRepository.save(venta);
        }).orElseThrow(() -> new RuntimeException("Venta no encontrada"));
	}
	
	public Double obtenerTotalVentasDelMes() {
        return ventaRepository.obtenerTotalVentasDelMes();
    }

    public Map<String, Integer> obtenerVentasPorMes() {
        List<Object[]> resultados = ventaRepository.obtenerVentasAgrupadasPorMes();
        Map<String, Integer> ventasPorMes = new LinkedHashMap<>();
        for (Object[] resultado : resultados) {
            ventasPorMes.put(resultado[0].toString(), ((Number) resultado[1]).intValue());
        }
        return ventasPorMes;
    }
	
	public Page<Venta> listarVentasPaginadas(int page, int size) {
	    Pageable pageable = PageRequest.of(page, size, Sort.by("fecha").descending());
	    return ventaRepository.findAll(pageable);
	}
}