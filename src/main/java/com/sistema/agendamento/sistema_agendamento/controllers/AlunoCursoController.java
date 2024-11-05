package com.sistema.agendamento.sistema_agendamento.controllers;

import com.sistema.agendamento.sistema_agendamento.models.AlunoCurso;
import com.sistema.agendamento.sistema_agendamento.services.AlunoCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aluno_curso")
public class AlunoCursoController {

    @Autowired
    private AlunoCursoService alunoCursoService;

    @PostMapping
    public ResponseEntity<AlunoCurso> salvarAlunoCurso(@RequestBody AlunoCurso alunoCurso) {
        return ResponseEntity.ok(alunoCursoService.salvarAlunoCurso(alunoCurso));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AlunoCurso>> buscarAlunoCursoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alunoCursoService.buscarAlunoCursoPorId(id));
    }

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<AlunoCurso>> listarCursosPorAluno(@PathVariable Long alunoId) {
        return ResponseEntity.ok(alunoCursoService.listarCursosPorAluno(alunoId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAlunoCurso(@PathVariable Long id) {
        alunoCursoService.deletarAlunoCurso(id);
        return ResponseEntity.noContent().build();
    }

}