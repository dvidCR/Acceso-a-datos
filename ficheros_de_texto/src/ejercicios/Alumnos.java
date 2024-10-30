package ejercicios;

import java.util.ArrayList;

public class Alumnos {
	
	private String nombre;
	private String edad;
	private String ciclo;
	private String nota_media;
	
	protected Alumnos(ArrayList<String[]> data) {
		this.nombre = data.get(1)[0];
		this.edad = data.get(1)[1];
		this.ciclo = data.get(1)[2];
		this.nota_media = data.get(1)[3];
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getNota_media() {
		return nota_media;
	}

	public void setNota_media(String nota_media) {
		this.nota_media = nota_media;
	}
	
	
}
