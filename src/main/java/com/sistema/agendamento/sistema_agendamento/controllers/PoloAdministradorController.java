package com.sistema.agendamento.sistema_agendamento.controllers;

import com.sistema.agendamento.sistema_agendamento.models.PoloAdministrador;
import com.sistema.agendamento.sistema_agendamento.services.PoloAdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/polo_administrador")
public class PoloAdministradorController {

    @Autowired
    private PoloAdministradorService poloAdministradorService;

    @PostMapping
    public ResponseEntity<PoloAdministrador> salvarPoloAdministrador(@RequestBody PoloAdministrador poloAdministrador) {
        return ResponseEntity.ok(poloAdministradorService.salvarPoloAdministrador(poloAdministrador));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PoloAdministrador>> buscarPoloAdministradorPorId(@PathVariable Long id) {
        return ResponseEntity.ok(poloAdministradorService.buscarPoloAdministradorPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<PoloAdministrador>> listarPoloAdministradores() {
        return ResponseEntity.ok(poloAdministradorService.listarPoloAdministradores());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPoloAdministrador(@PathVariable Long id) {
        poloAdministradorService.deletarPoloAdministrador(id);
        return ResponseEntity.noContent().build();
    }

}