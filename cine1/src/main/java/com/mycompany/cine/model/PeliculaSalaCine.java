package com.mycompany.cine.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pelicula_salacine")
public class PeliculaSalaCine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula_sala")
    private Integer idPeliculaSala;

    @ManyToOne 
    @JoinColumn(name = "id_sala_cine")
    private SalaCine salaCine;

    @ManyToOne 
    @JoinColumn(name = "id_pelicula")
    private Pelicula pelicula;

    @Column(name = "fecha_publicacion")
    private LocalDate fechaPublicacion;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    public Integer getIdPeliculaSala() { return idPeliculaSala; }
    public void setIdPeliculaSala(Integer idPeliculaSala) { this.idPeliculaSala = idPeliculaSala; }
    public SalaCine getSalaCine() { return salaCine; }
    public void setSalaCine(SalaCine salaCine) { this.salaCine = salaCine; }
    public Pelicula getPelicula() { return pelicula; }
    public void setPelicula(Pelicula pelicula) { this.pelicula = pelicula; }
    public LocalDate getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(LocalDate fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
}