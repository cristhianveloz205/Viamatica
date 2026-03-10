package com.mycompany.cine.model;
import jakarta.persistence.*;

@Entity
@Table(name = "sala_cine")
public class SalaCine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_sala;
    private String nombre;
    private Integer estado;

    // Getters y Setters
    public Integer getId_sala() { return id_sala; }
    public void setId_sala(Integer id_sala) { this.id_sala = id_sala; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Integer getEstado() { return estado; }
    public void setEstado(Integer estado) { this.estado = estado; }
}