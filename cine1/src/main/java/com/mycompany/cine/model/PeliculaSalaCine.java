package com.mycompany.cine.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pelicula_salacine")
public class PeliculaSalaCine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pelicula_sala;
    @ManyToOne @JoinColumn(name = "id_sala_cine")
    private SalaCine salaCine;
    @ManyToOne @JoinColumn(name = "id_pelicula")
    private Pelicula pelicula;
    private LocalDate fecha_publicacion;
    private LocalDate fecha_fin;

    // Getters y Setters
    public Integer getId_pelicula_sala() { return id_pelicula_sala; }
    public void setId_pelicula_sala(Integer id_pelicula_sala) { this.id_pelicula_sala = id_pelicula_sala; }
    public SalaCine getSalaCine() { return salaCine; }
    public void setSalaCine(SalaCine salaCine) { this.salaCine = salaCine; }
    public Pelicula getPelicula() { return pelicula; }
    public void setPelicula(Pelicula pelicula) { this.pelicula = pelicula; }
    public LocalDate getFecha_publicacion() { return fecha_publicacion; }
    public void setFecha_publicacion(LocalDate fecha_publicacion) { this.fecha_publicacion = fecha_publicacion; }
    public LocalDate getFecha_fin() { return fecha_fin; }
    public void setFecha_fin(LocalDate fecha_fin) { this.fecha_fin = fecha_fin; }
}