package com.sistema.agendamento.sistema_agendamento.controllers;

import com.sistema.agendamento.sistema_agendamento.models.Administrador;
import com.sistema.agendamento.sistema_agendamento.services.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @PostMapping
    public ResponseEntity<Administrador> salvarAdministrador(@RequestBody Administrador administrador) {
        return ResponseEntity.ok(administradorService.salvarAdministrador(administrador));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Administrador>> buscarAdministradorPorId(@PathVariable Long id) {
        return ResponseEntity.ok(administradorService.buscarAdministradorPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Administrador>> listarAdministradores() {
        return ResponseEntity.ok(administradorService.listarAdministradores());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAdministrador(@PathVariable Long id) {
        administradorService.deletarAdministrador(id);
        return ResponseEntity.noContent().build();
    }

}