package com.plataformaeducativa.controller;

import com.plataformaeducativa.dto.InscripcionRequest;
import com.plataformaeducativa.dto.InscripcionResumenResponse;
import com.plataformaeducativa.service.InscripcionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
@RequiredArgsConstructor
public class InscripcionController {

    private final InscripcionService inscripcionService;

    @PostMapping
    public ResponseEntity<InscripcionResumenResponse> inscribirEstudiante(
            @Valid @RequestBody InscripcionRequest request
    ) {
        InscripcionResumenResponse resumen = inscripcionService.inscribirEstudiante(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(resumen);
    }

    @GetMapping
    public ResponseEntity<List<InscripcionResumenResponse>> listarInscripciones() {
        return ResponseEntity.ok(inscripcionService.listarInscripciones());
    }
}