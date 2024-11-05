package com.sistema.agendamento.sistema_agendamento.controllers;

import com.sistema.agendamento.sistema_agendamento.models.AlunoPolo;
import com.sistema.agendamento.sistema_agendamento.services.AlunoPoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aluno_polo")
public class AlunoPoloController {

    @Autowired
    private AlunoPoloService alunoPoloService;

    @PostMapping
    public ResponseEntity<AlunoPolo> salvarAlunoPolo(@RequestBody AlunoPolo alunoPolo) {
        return ResponseEntity.ok(alunoPoloService.salvarAlunoPolo(alunoPolo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AlunoPolo>> buscarAlunoPoloPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alunoPoloService.buscarAlunoPoloPorId(id));
    }

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<AlunoPolo>> listarPolosPorAluno(@PathVariable Long alunoId) {
        return ResponseEntity.ok(alunoPoloService.listarPolosPorAluno(alunoId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAlunoPolo(@PathVariable Long id) {
        alunoPoloService.deletarAlunoPolo(id);
        return ResponseEntity.noContent().build();
    }

}