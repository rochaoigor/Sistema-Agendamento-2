package com.sistema.agendamento.sistema_agendamento.controllers;

import com.sistema.agendamento.sistema_agendamento.models.Agendamento;
import com.sistema.agendamento.sistema_agendamento.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
@CrossOrigin(origins = "http://localhost:3000")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    // Cria um novo agendamento com verificação de limite por horário
    // @PostMapping
    // public ResponseEntity<Agendamento> criarAgendamento(@RequestBody Agendamento agendamento) {
    // System.out.println("Data recebida no formato ISO: " + agendamento.getDataHora());
    // Agendamento novoAgendamento = agendamentoService.criarAgendamento(agendamento);
    // return ResponseEntity.ok(novoAgendamento);
    // }

//     @PostMapping
// public ResponseEntity<?> criarAgendamento(@RequestBody Agendamento agendamento) { // Alterado para ResponseEntity<?>
//     try {
//         Agendamento novoAgendamento = agendamentoService.criarAgendamento(agendamento);
//         return ResponseEntity.ok(novoAgendamento);
//     } catch (IllegalArgumentException e) {
//         // Retorna um status de erro 409 Conflict com a mensagem de erro
//         return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage()); 
//     }
// }

@PostMapping
public ResponseEntity<?> criarAgendamento(@RequestBody Agendamento agendamento) {
    try {
        Agendamento novoAgendamento = agendamentoService.criarAgendamento(agendamento);
        return ResponseEntity.ok(novoAgendamento);
    } catch (IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage()); 
    }
}

    @PutMapping("/reagendar/{id}")
    public ResponseEntity<?> reagendarProva(@PathVariable Long id, @RequestBody Agendamento novoAgendamento) {
        // Verifica o limite de agendamentos para o novo horário
        if (agendamentoService.isHorarioLotado(novoAgendamento.getDataHora())) {
            return ResponseEntity.badRequest().body("Horário já está cheio. Tente outro horário.");
        }
        Agendamento agendamentoReagendado = agendamentoService.reagendarProva(id, novoAgendamento);
        return ResponseEntity.ok(agendamentoReagendado);
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> listarTodosAgendamentos() {
        List<Agendamento> agendamentos = agendamentoService.listarTodosAgendamentos();
        return ResponseEntity.ok(agendamentos);
    }
}