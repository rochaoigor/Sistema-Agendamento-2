package com.sistema.agendamento.sistema_agendamento.controllers;

import com.sistema.agendamento.sistema_agendamento.models.PoloCurso;
import com.sistema.agendamento.sistema_agendamento.services.PoloCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/polo_curso")
public class PoloCursoController {

    @Autowired
    private PoloCursoService poloCursoService;

    @PostMapping
    public ResponseEntity<PoloCurso> salvarPoloCurso(@RequestBody PoloCurso poloCurso) {
        return ResponseEntity.ok(poloCursoService.salvarPoloCurso(poloCurso));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PoloCurso>> buscarPoloCursoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(poloCursoService.buscarPoloCursoPorId(id));
    }

    @GetMapping("/polo/{poloId}")
    public ResponseEntity<List<PoloCurso>> listarCursosPorPolo(@PathVariable Long poloId) {
        return ResponseEntity.ok(poloCursoService.listarCursosPorPolo(poloId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPoloCurso(@PathVariable Long id) {
        poloCursoService.deletarPoloCurso(id);
        return ResponseEntity.noContent().build();
    }

}