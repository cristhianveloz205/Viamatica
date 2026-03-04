package com.mycompany.cine.model;
import jakarta.persistence.*;

@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pelicula;
    private String nombre;
    private Integer duracion;
    private Boolean estado = true;

    // Getters y Setters
    public Integer getId_pelicula() { return id_pelicula; }
    public void setId_pelicula(Integer id_pelicula) { this.id_pelicula = id_pelicula; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Integer getDuracion() { return duracion; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }
    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }
}