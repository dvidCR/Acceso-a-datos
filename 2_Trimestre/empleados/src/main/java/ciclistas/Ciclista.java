package ciclistas;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CICLISTAS")
public class Ciclista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CICLISTA")
    private int idCiclista;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "NACIONALIDAD", length = 3)
    private String nacionalidad;

    @Column(name = "EDAD", nullable = false)
    private int edad;

    @Transient
    private int pulsacionesPorMinuto;

    @Column(name = "KILOMETROS", precision = 10, scale = 3)
    private Double kilometrosRecorridos;

    // Getters y Setters

    public int getIdCiclista() {
        return idCiclista;
    }

    public void setIdCiclista(int idCiclista) {
        this.idCiclista = idCiclista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad.toUpperCase();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPulsacionesPorMinuto() {
        return pulsacionesPorMinuto;
    }

    public void setPulsacionesPorMinuto(int pulsacionesPorMinuto) {
        this.pulsacionesPorMinuto = pulsacionesPorMinuto;
    }

    public Double getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public void setKilometrosRecorridos(Double kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
    }
}