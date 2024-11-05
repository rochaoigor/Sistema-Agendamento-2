package com.sistema.agendamento.sistema_agendamento.services;

import com.sistema.agendamento.sistema_agendamento.models.Prova;
import com.sistema.agendamento.sistema_agendamento.repositories.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvaService {

    @Autowired
    private ProvaRepository provaRepository;

    public Prova salvarProva(Prova prova) {
        return provaRepository.save(prova);
    }

    public Optional<Prova> buscarProvaPorId(Long id) {
        return provaRepository.findById(id);
    }

    public List<Prova> listarProvas() {
        return provaRepository.findAll();
    }

    public void deletarProva(Long id) {
        provaRepository.deleteById(id);
    }
}