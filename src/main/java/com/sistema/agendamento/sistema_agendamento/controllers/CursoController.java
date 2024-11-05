package com.sistema.agendamento.sistema_agendamento.controllers;

import com.sistema.agendamento.sistema_agendamento.models.Curso;
import com.sistema.agendamento.sistema_agendamento.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> salvarCurso(@RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.salvarCurso(curso));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Curso>> buscarCursoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.buscarCursoPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos() {
        return ResponseEntity.ok(cursoService.listarCursos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCurso(@PathVariable Long id) {
        cursoService.deletarCurso(id);
        return ResponseEntity.noContent().build();
    }

}