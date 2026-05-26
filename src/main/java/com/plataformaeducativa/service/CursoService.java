package com.plataformaeducativa.service;

import com.plataformaeducativa.dto.CursoRequest;
import com.plataformaeducativa.dto.CursoResponse;
import com.plataformaeducativa.entity.Curso;
import com.plataformaeducativa.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;

    public List<CursoResponse> listarCursos() {
        return cursoRepository.findAll()
                .stream()
                .map(this::convertirACursoResponse)
                .toList();
    }

    public CursoResponse agregarCurso(CursoRequest request) {
        Curso curso = new Curso();
        curso.setNombre(request.getNombre());
        curso.setProfesor(request.getProfesor());
        curso.setDuracionHoras(request.getDuracionHoras());
        curso.setCosto(request.getCosto());

        Curso cursoGuardado = cursoRepository.save(curso);

        return convertirACursoResponse(cursoGuardado);
    }

    private CursoResponse convertirACursoResponse(Curso curso) {
        return new CursoResponse(
                curso.getId(),
                curso.getNombre(),
                curso.getProfesor(),
                curso.getDuracionHoras(),
                curso.getCosto()
        );
    }
}