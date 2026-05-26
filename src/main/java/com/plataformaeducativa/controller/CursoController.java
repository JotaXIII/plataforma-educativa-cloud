package com.plataformaeducativa.controller;

import com.plataformaeducativa.dto.CursoRequest;
import com.plataformaeducativa.dto.CursoResponse;
import com.plataformaeducativa.service.CursoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<CursoResponse>> listarCursos() {
        return ResponseEntity.ok(cursoService.listarCursos());
    }

    @PostMapping
    public ResponseEntity<CursoResponse> agregarCurso(@Valid @RequestBody CursoRequest request) {
        CursoResponse cursoCreado = cursoService.agregarCurso(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoCreado);
    }
}