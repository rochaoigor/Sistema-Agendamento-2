package com.sistema.agendamento.sistema_agendamento.controllers;

import com.sistema.agendamento.sistema_agendamento.models.Prova;
import com.sistema.agendamento.sistema_agendamento.services.ProvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/provas")
public class ProvaController {

    @Autowired
    private ProvaService provaService;

    @PostMapping
    public ResponseEntity<Prova> salvarProva(@RequestBody Prova prova) {
        return ResponseEntity.ok(provaService.salvarProva(prova));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Prova>> buscarProvaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(provaService.buscarProvaPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Prova>> listarProvas() {
        return ResponseEntity.ok(provaService.listarProvas());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProva(@PathVariable Long id) {
        provaService.deletarProva(id);
        return ResponseEntity.noContent().build();
    }

}