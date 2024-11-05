package com.sistema.agendamento.sistema_agendamento.services;


import com.sistema.agendamento.sistema_agendamento.models.Administrador;
import com.sistema.agendamento.sistema_agendamento.repositories.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public Administrador salvarAdministrador(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    public Optional<Administrador> buscarAdministradorPorId(Long id) {
        return administradorRepository.findById(id);
    }

    public List<Administrador> listarAdministradores() {
        return administradorRepository.findAll();
    }

    public void deletarAdministrador(Long id) {
        administradorRepository.deleteById(id);
    }
    
}