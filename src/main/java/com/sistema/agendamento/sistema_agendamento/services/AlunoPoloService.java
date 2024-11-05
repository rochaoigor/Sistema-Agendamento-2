package com.sistema.agendamento.sistema_agendamento.services;

import com.sistema.agendamento.sistema_agendamento.models.AlunoPolo;
import com.sistema.agendamento.sistema_agendamento.repositories.AlunoPoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoPoloService {

    @Autowired
    private AlunoPoloRepository alunoPoloRepository;

    public AlunoPolo salvarAlunoPolo(AlunoPolo alunoPolo) {
        return alunoPoloRepository.save(alunoPolo);
    }

    public Optional<AlunoPolo> buscarAlunoPoloPorId(Long id) {
        return alunoPoloRepository.findById(id);
    }

    public List<AlunoPolo> listarPolosPorAluno(Long alunoId) {
        return alunoPoloRepository.findByAlunoId(alunoId);
    }

    public void deletarAlunoPolo(Long id) {
        alunoPoloRepository.deleteById(id);
    }

}