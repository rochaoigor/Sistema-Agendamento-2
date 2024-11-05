package com.sistema.agendamento.sistema_agendamento.services;

import com.sistema.agendamento.sistema_agendamento.models.PoloAdministrador;
import com.sistema.agendamento.sistema_agendamento.repositories.PoloAdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoloAdministradorService {

    @Autowired
    private PoloAdministradorRepository poloAdministradorRepository;

    public PoloAdministrador salvarPoloAdministrador(PoloAdministrador poloAdministrador) {
        return poloAdministradorRepository.save(poloAdministrador);
    }

    public Optional<PoloAdministrador> buscarPoloAdministradorPorId(Long id) {
        return poloAdministradorRepository.findById(id);
    }

    public List<PoloAdministrador> listarPoloAdministradores() {
        return poloAdministradorRepository.findAll();
    }

    public void deletarPoloAdministrador(Long id) {
        poloAdministradorRepository.deleteById(id);
    }

}