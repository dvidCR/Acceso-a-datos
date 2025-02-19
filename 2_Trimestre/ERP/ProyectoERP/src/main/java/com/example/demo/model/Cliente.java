package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	@NotNull(message = "Tienes que poner el nombre")
	@Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
	private String nombre;
	
	@Column(name = "email")
	@NotNull(message = "Tienes que poner un email")
	private String email;
	
	@Column(name = "telefono")
	@Size(min = 9, max = 15, message = "El teléfono debe tener entre 9 y 15 caracteres")
	private String telefono;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Venta> ventas;
	
	public Cliente() {
		
	}
	
	public Cliente(String nombre, String email, String telefono) {
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", ventas="
				+ ventas + "]";
	}
	
}
