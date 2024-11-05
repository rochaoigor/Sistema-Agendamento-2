package com.sistema.agendamento.sistema_agendamento.controllers;

import com.sistema.agendamento.sistema_agendamento.models.Horario;
import com.sistema.agendamento.sistema_agendamento.services.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @PostMapping
    public ResponseEntity<Horario> salvarHorario(@RequestBody Horario horario) {
        return ResponseEntity.ok(horarioService.salvarHorario(horario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Horario>> buscarHorarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(horarioService.buscarHorarioPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Horario>> listarHorarios() {
        return ResponseEntity.ok(horarioService.listarHorarios());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarHorario(@PathVariable Long id) {
        horarioService.deletarHorario(id);
        return ResponseEntity.noContent().build();
    }

}