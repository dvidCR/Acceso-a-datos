package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "cliente", nullable = false)
	@NotNull(message = "Tienes que poner el nombre del cliente")
	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;
	
	@Column(name = "fecha")
	@NotNull(message = "Tienes que poner una fecha YYYY-MM-DD")
	private LocalDate fecha;
	
	@Column(name = "total")
	private Double total;
	
	@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVenta> detalles;

	public Venta() {
		this.detalles = new ArrayList<DetalleVenta>();
	}
	
	public Venta(Cliente cliente, LocalDate fecha, Double total) {
		this.cliente = cliente;
		this.fecha = fecha;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	public List<DetalleVenta> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleVenta> detalles) {
	    this.detalles = detalles;
	    for (DetalleVenta detalle : detalles) {
	        detalle.setVenta(this);
	    }
	}


	@Override
	public String toString() {
		return "Venta [id=" + id + ", cliente=" + cliente + ", fecha=" + fecha + ", total=" + total + "]";
	}
	
}
