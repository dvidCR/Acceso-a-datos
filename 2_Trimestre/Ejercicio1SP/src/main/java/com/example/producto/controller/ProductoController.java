package com.example.producto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.producto.model.Producto;
import com.example.producto.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
    private ProductoService servicio;

    @GetMapping
    public List<Producto> listarUsuarios() {
        return servicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Producto> obtenerUsuario(@PathVariable Long id) {
        return servicio.obtenerPorId(id);
    }

    @PostMapping
    public Producto crearUsuario(@RequestBody Producto producto) {
        return servicio.guardarProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        servicio.eliminarProducto(id);
    }
    
}
