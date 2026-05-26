package com.plataformaeducativa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class InscripcionRequest {

    @NotBlank(message = "El nombre del estudiante es obligatorio")
    private String nombreEstudiante;

    @NotBlank(message = "El correo del estudiante es obligatorio")
    @Email(message = "El correo debe tener un formato válido")
    private String correoEstudiante;

    @NotEmpty(message = "Debe seleccionar al menos un curso")
    private List<Long> cursosIds;
}