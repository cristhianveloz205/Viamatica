package com.mycompany.cine.dto;
// DTO de salida: Evita exponer la entidad completa de la base de datos por seguridad
public class PeliculaResponseDTO {
    private Integer idPelicula;
    private String nombre;
    private Integer duracion;

    public PeliculaResponseDTO() {}

    public PeliculaResponseDTO(Integer idPelicula, String nombre, Integer duracion) {
        this.idPelicula = idPelicula;
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public Integer getIdPelicula() { return idPelicula; }
    public void setIdPelicula(Integer idPelicula) { this.idPelicula = idPelicula; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Integer getDuracion() { return duracion; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }
}
