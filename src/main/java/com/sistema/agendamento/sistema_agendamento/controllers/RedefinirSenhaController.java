package com.sistema.agendamento.sistema_agendamento.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.agendamento.sistema_agendamento.dto.RedefinirSenhaRequest;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RedefinirSenhaController {

    @PostMapping("/api/redefinir-senha")
    public ResponseEntity<?> redefinirSenha(@RequestBody RedefinirSenhaRequest redefinirSenhaRequest) {
        // Adiciona log para depuração
        System.out.println("Senha atual recebida: " + redefinirSenhaRequest.getSenhaAtual());
        
        if ("2413".equals(redefinirSenhaRequest.getSenhaAtual())) {
            return ResponseEntity.ok("Senha redefinida com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Senha atual incorreta");
        }
    }
}    