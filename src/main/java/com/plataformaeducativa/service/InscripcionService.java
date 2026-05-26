package com.plataformaeducativa.service;

import com.plataformaeducativa.dto.CursoResponse;
import com.plataformaeducativa.dto.InscripcionRequest;
import com.plataformaeducativa.dto.InscripcionResumenResponse;
import com.plataformaeducativa.entity.Curso;
import com.plataformaeducativa.entity.Estudiante;
import com.plataformaeducativa.entity.Inscripcion;
import com.plataformaeducativa.repository.CursoRepository;
import com.plataformaeducativa.repository.EstudianteRepository;
import com.plataformaeducativa.repository.InscripcionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InscripcionService {

    private final CursoRepository cursoRepository;
    private final EstudianteRepository estudianteRepository;
    private final InscripcionRepository inscripcionRepository;

    public InscripcionResumenResponse inscribirEstudiante(InscripcionRequest request) {
        List<Curso> cursos = cursoRepository.findAllById(request.getCursosIds());

        if (cursos.isEmpty()) {
            throw new RuntimeException("No se encontraron cursos para realizar la inscripción");
        }

        if (cursos.size() != request.getCursosIds().size()) {
            throw new RuntimeException("Uno o más cursos seleccionados no existen");
        }

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(request.getNombreEstudiante());
        estudiante.setCorreo(request.getCorreoEstudiante());

        Estudiante estudianteGuardado = estudianteRepository.save(estudiante);

        BigDecimal total = cursos.stream()
                .map(Curso::getCosto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setEstudiante(estudianteGuardado);
        inscripcion.setCursos(cursos);
        inscripcion.setTotal(total);
        inscripcion.setFechaInscripcion(LocalDateTime.now());

        Inscripcion inscripcionGuardada = inscripcionRepository.save(inscripcion);

        List<CursoResponse> cursosResponse = cursos.stream()
                .map(curso -> new CursoResponse(
                        curso.getId(),
                        curso.getNombre(),
                        curso.getProfesor(),
                        curso.getDuracionHoras(),
                        curso.getCosto()
                ))
                .toList();

        return new InscripcionResumenResponse(
                inscripcionGuardada.getId(),
                estudianteGuardado.getNombre(),
                estudianteGuardado.getCorreo(),
                cursosResponse,
                total,
                inscripcionGuardada.getFechaInscripcion()
        );
    }

    public List<InscripcionResumenResponse> listarInscripciones() {
        return inscripcionRepository.findAll()
                .stream()
                .map(this::convertirAResumen)
                .toList();
    }

    private InscripcionResumenResponse convertirAResumen(Inscripcion inscripcion) {
        List<CursoResponse> cursosResponse = inscripcion.getCursos()
                .stream()
                .map(curso -> new CursoResponse(
                        curso.getId(),
                        curso.getNombre(),
                        curso.getProfesor(),
                        curso.getDuracionHoras(),
                        curso.getCosto()
                ))
                .toList();

        return new InscripcionResumenResponse(
                inscripcion.getId(),
                inscripcion.getEstudiante().getNombre(),
                inscripcion.getEstudiante().getCorreo(),
                cursosResponse,
                inscripcion.getTotal(),
                inscripcion.getFechaInscripcion()
        );
    }
}