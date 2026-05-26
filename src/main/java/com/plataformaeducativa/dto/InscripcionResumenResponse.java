package com.plataformaeducativa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionResumenResponse {

    private Long idInscripcion;
    private String estudiante;
    private String correo;
    private List<CursoResponse> cursos;
    private BigDecimal totalPagar;
    private LocalDateTime fechaInscripcion;
}