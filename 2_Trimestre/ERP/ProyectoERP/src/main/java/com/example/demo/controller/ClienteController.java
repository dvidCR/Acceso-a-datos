package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
    private ClienteService servicio;

    @GetMapping
    public List<Cliente> listarClientes() {
        return servicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> obtenerCliente(@PathVariable Long id) {
        return servicio.obtenerPorId(id);
    }

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return servicio.guardarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        servicio.eliminarCliente(id);
    }
    
    @PutMapping("/{id}")
    public void actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
    	servicio.actualizarCliente(id, cliente);
    }
    
    @GetMapping("/paginado")
    public Page<Cliente> listarVentasPaginadas(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "5") int size) {
        return servicio.listarClientesPaginadas(page, size);
    }
    
}
