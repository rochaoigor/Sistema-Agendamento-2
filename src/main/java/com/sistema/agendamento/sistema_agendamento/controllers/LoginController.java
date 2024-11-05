package com.sistema.agendamento.sistema_agendamento.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sistema.agendamento.sistema_agendamento.dto.LoginRequest;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") 
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        String email = loginRequest.getEmail();
        String senha = loginRequest.getSenha();
        String tipoUsuario = loginRequest.getTipoUsuario();

        if (tipoUsuario.equals("aluno") && email.equals("aluno@email.com") && senha.equals("al123")) {
            return ResponseEntity.ok("Login bem-sucedido");
        } else if (tipoUsuario.equals("polo") && email.equals("polo@email.com") && senha.equals("pl123")) {
            return ResponseEntity.ok("Login bem-sucedido");
        } else if (tipoUsuario.equals("administrador") && email.equals("admin@email.com") && senha.equals("ad123")) {
            return ResponseEntity.ok("Login bem-sucedido");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }
}