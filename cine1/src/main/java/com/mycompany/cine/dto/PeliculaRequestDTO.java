package com.mycompany.cine.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// DTO de entrada: Filtra y valida los datos que envía el cliente antes de procesarlos
public class PeliculaRequestDTO {
    
    @NotBlank(message = "El nombre de la película es obligatorio")
    private String nombre;

    @NotNull(message = "La duración es obligatoria")
    @Min(value = 1, message = "La duración debe ser mayor a 0 minutos")
    private Integer duracion;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Integer getDuracion() { return duracion; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }
}
