package empleados;

import java.io.Serializable;
import java.util.Date;

public class Empleado implements Serializable{
	private Long numeroEmpleado;
	private Date fechaNacimiento;
	private String nombre;
	private String apellidos;
	private char genero;
	private Date fechaAlta;
	public Long getNumeroEmpleado() {
		return numeroEmpleado;
	}
	public void setNumeroEmpleado(Long numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	@Override
	public String toString() {
		return "Empleado [numeroEmpleado=" + numeroEmpleado + ", fechaNacimiento=" + fechaNacimiento + ", nombre="
				+ nombre + ", apellidos=" + apellidos + ", genero=" + genero + ", fechaAlta=" + fechaAlta + "]";
	}
	
}