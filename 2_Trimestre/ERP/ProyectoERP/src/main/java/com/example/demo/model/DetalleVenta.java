package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "detalle_venta")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class DetalleVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "venta_id", nullable = false)
	private Venta venta;

	@ManyToOne
	@JoinColumn(name = "producto_id", nullable = false)
	private Producto producto;

	@NotNull(message = "La cantidad no puede ser nula")
	private int cantidad;

	private Double subtotal;

	public DetalleVenta() {
	}

	public DetalleVenta(Venta venta, Producto producto, int cantidad) {
		this.venta = venta;
		this.producto = producto;
		this.cantidad = cantidad;
		this.subtotal = producto.getPrecio() * cantidad;
	}

	public Long getId() {
		return id;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void calcularSubtotal() {
        if (producto != null) {
            this.subtotal = producto.getPrecio() * this.cantidad;
        } else {
            this.subtotal = 0.0;
        }
    }
}
