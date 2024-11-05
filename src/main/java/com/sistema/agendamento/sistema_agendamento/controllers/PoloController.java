package com.sistema.agendamento.sistema_agendamento.controllers;

import com.sistema.agendamento.sistema_agendamento.models.Polo;
import com.sistema.agendamento.sistema_agendamento.services.PoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/polos")
public class PoloController {

    @Autowired
    private PoloService poloService;

    @PostMapping
    public ResponseEntity<Polo> salvarPolo(@RequestBody Polo polo) {
        return ResponseEntity.ok(poloService.salvarPolo(polo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Polo>> buscarPoloPorId(@PathVariable Long id) {
        return ResponseEntity.ok(poloService.buscarPoloPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Polo>> listarPolos() {
        return ResponseEntity.ok(poloService.listarPolos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPolo(@PathVariable Long id) {
        poloService.deletarPolo(id);
        return ResponseEntity.noContent().build();
    }

}