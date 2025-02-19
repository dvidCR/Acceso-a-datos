package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
    private ClienteRepository repositorio;
	
	public List<Cliente> obtenerTodos() {
		return repositorio.findAll();
	}
	
	public Optional<Cliente> obtenerPorId(Long id) {
		return repositorio.findById(id);
	}
	
	public Cliente guardarCliente(Cliente cliente) {
		return repositorio.save(cliente);
	}
	
	public void eliminarCliente(Long id) {
		repositorio.deleteById(id);
	}
	
	public Cliente actualizarCliente(Long id, Cliente clienteActualizada) {
        return repositorio.findById(id).map(cliente -> {
        	cliente.setNombre(clienteActualizada.getNombre());
        	cliente.setEmail(clienteActualizada.getEmail());
        	cliente.setTelefono(clienteActualizada.getTelefono());
        	cliente.setVentas(clienteActualizada.getVentas());
            return repositorio.save(cliente);
        }).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
	}
	
	public Page<Cliente> listarClientesPaginadas(int page, int size) {
	    Pageable pageable = PageRequest.of(page, size, Sort.by("nombre").descending());
	    return repositorio.findAll(pageable);
	}
	
}
