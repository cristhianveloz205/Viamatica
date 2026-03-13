package com.mycompany.cine.model;
import jakarta.persistence.*;

@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Integer idPelicula; 
    
    private String nombre;
    private Integer duracion;
    
    @Column(name = "estado_logico")
    private Boolean estadoLogico = true;

    
    public Integer getIdPelicula() { return idPelicula; }
    public void setIdPelicula(Integer idPelicula) { this.idPelicula = idPelicula; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Integer getDuracion() { return duracion; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }
    public Boolean getEstadoLogico() { return estadoLogico; }
    public void setEstadoLogico(Boolean estadoLogico) { this.estadoLogico = estadoLogico; }
}