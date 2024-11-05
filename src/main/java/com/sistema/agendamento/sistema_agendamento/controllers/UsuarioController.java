package com.sistema.agendamento.sistema_agendamento.controllers;

import com.sistema.agendamento.sistema_agendamento.models.Usuario;
import com.sistema.agendamento.sistema_agendamento.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import com.sistema.agendamento.sistema_agendamento.dto.UsuarioRequest;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuario));
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Optional<Usuario>> buscarUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/usuarios")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        // Simula a criação de um novo usuário (salva no banco de dados ou mokado)
        System.out.println("Usuário cadastrado com sucesso: " + usuarioRequest.getNome());
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso!");
    }

    @GetMapping("/perfil")
    public ResponseEntity<UsuarioRequest> getPerfil() {
        // Dados mokados
        UsuarioRequest perfil = new UsuarioRequest("João Silva", "joao.silva@email.com", "+55 24 91234-5678", "E12345", "Engenharia de Software", "6º Período", "Valença", "Polo Valença");
        return ResponseEntity.ok(perfil);
    }
}