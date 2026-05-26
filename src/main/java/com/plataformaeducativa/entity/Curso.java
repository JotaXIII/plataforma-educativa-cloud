package com.plataformaeducativa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Entity
@Table(name = "CURSOS")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CURSO")
    private Long id;

    @NotBlank(message = "El nombre del curso es obligatorio")
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El profesor es obligatorio")
    @Column(name = "PROFESOR", nullable = false, length = 100)
    private String profesor;

    @NotNull(message = "La duración del curso es obligatoria")
    @Positive(message = "La duración debe ser mayor a cero")
    @Column(name = "DURACION_HORAS", nullable = false)
    private Integer duracionHoras;

    @NotNull(message = "El costo del curso es obligatorio")
    @Positive(message = "El costo debe ser mayor a cero")
    @Column(name = "COSTO", nullable = false, precision = 10, scale = 2)
    private BigDecimal costo;

    public Curso() {
    }

    public Curso(Long id, String nombre, String profesor, Integer duracionHoras, BigDecimal costo) {
        this.id = id;
        this.nombre = nombre;
        this.profesor = profesor;
        this.duracionHoras = duracionHoras;
        this.costo = costo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public Integer getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(Integer duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }
}