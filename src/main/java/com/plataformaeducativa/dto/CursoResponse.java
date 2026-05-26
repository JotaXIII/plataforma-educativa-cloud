package com.plataformaeducativa.dto;

import java.math.BigDecimal;

public class CursoResponse {

    private Long id;
    private String nombre;
    private String profesor;
    private Integer duracionHoras;
    private BigDecimal costo;

    public CursoResponse() {
    }

    public CursoResponse(Long id, String nombre, String profesor, Integer duracionHoras, BigDecimal costo) {
        this.id = id;
        this.nombre = nombre;
        this.profesor = profesor;
        this.duracionHoras = duracionHoras;
        this.costo = costo;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public Integer getDuracionHoras() {
        return duracionHoras;
    }

    public BigDecimal getCosto() {
        return costo;
    }
}