package com.example.producto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.producto.model.Producto;
import com.example.producto.repository.ProductoRepositorio;

@Service
public class ProductoService {
	
	@Autowired
    private ProductoRepositorio repositorio;
	
	public List<Producto> obtenerTodos() {
		return repositorio.findAll();
	}
	
	public Optional<Producto> obtenerPorId(Long id) {
		return repositorio.findById(id);
	}
	
	public Producto guardarProducto(Producto producto) {
		return repositorio.save(producto);
	}
	
	public void eliminarProducto(Long id) {
		repositorio.deleteById(id);
	}
	
}
