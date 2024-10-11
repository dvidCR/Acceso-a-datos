package reader;

import java.io.Serializable;

/*
 * Sacamos los productos del fichero y los muestra
 * 
 * @see implements Serializable - Convierte los bits del fichero para que sean legibles a la hora de mostrarlos
 * */

public class Producto implements Serializable { // 
    private String nombre;
    private int codigo;
    private double precio;
    private String descripcion;
    private String rutaImagen;

    /*
     * @param nombre El nombre del producto
	 * @param codigo El codigo del producto
	 * @param precio El precio del producto
	 * @param descripcion La descripcion del producto
	 * @param rutaImagen La ruta en la que esta la imagen guardada
	 * */
    // constructor
    public Producto(String nombre, int codigo, double precio, String descripcion, String rutaImagen) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
    }

    /*
     * @return Devuelve el nombre, codigo, precio, descripcion, rutaImagen del producto
     * */
    // getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getRutaImagen() { return rutaImagen; }
    public void setRutaImagen(String rutaImagen) { this.rutaImagen = rutaImagen; }
    
    /*
     * @return Devuelve todos los productos del fichero*/
    // devuelve el contenido de un producto del fichero
    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", codigo=" + codigo +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", rutaImagen='" + rutaImagen + '\'' +
                '}';
    }
}
