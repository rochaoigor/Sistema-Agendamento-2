package com.sistema.agendamento.sistema_agendamento.services;

import com.sistema.agendamento.sistema_agendamento.models.Polo;
import com.sistema.agendamento.sistema_agendamento.repositories.PoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoloService {

    @Autowired
    private PoloRepository poloRepository;

    public Polo salvarPolo(Polo polo) {
        return poloRepository.save(polo);
    }

    public Optional<Polo> buscarPoloPorId(Long id) {
        return poloRepository.findById(id);
    }

    public List<Polo> listarPolos() {
        return poloRepository.findAll();
    }

    public void deletarPolo(Long id) {
        poloRepository.deleteById(id);
    }
    
}