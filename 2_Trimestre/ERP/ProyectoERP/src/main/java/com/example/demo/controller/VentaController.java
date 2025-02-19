package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;

import com.example.demo.model.Venta;
import com.example.demo.service.VentaService;

@RestController
@RequestMapping("/venta")
public class VentaController {
	
	@Autowired
    private VentaService servicio;

    @GetMapping
    public List<Venta> listarVentas() {
        return servicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Venta> obtenerVenta(@PathVariable Long id) {
        return servicio.obtenerPorId(id);
    }

    @PostMapping
    public Venta crearVenta(@RequestBody Venta venta) {
        return servicio.guardarVenta(venta);
    }

    @DeleteMapping("/{id}")
    public void eliminarVenta(@PathVariable Long id) {
        servicio.eliminarVenta(id);
    }
    
    @PutMapping("/{id}")
    public void actualizarVenta(@PathVariable Long id, @RequestBody Venta venta) {
    	servicio.actualizarVenta(id, venta);
    }
    
    @GetMapping("/total-mes")
    public Double obtenerTotalVentasDelMes() {
        return servicio.obtenerTotalVentasDelMes();
    }

    @GetMapping("/ventas-mes")
    public Map<String, Integer> obtenerVentasPorMes() {
        return servicio.obtenerVentasPorMes();
    }
    
    @GetMapping("/paginado")
    public Page<Venta> listarVentasPaginadas(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "5") int size) {
        return servicio.listarVentasPaginadas(page, size);
    }
}
