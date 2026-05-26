package com.plataformaeducativa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "INSCRIPCIONES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INSCRIPCION")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_ESTUDIANTE", nullable = false)
    private Estudiante estudiante;

    @ManyToMany
    @JoinTable(
            name = "INSCRIPCION_CURSOS",
            joinColumns = @JoinColumn(name = "ID_INSCRIPCION"),
            inverseJoinColumns = @JoinColumn(name = "ID_CURSO")
    )
    private List<Curso> cursos;

    @Column(name = "TOTAL", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "FECHA_INSCRIPCION", nullable = false)
    private LocalDateTime fechaInscripcion;
}