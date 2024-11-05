package com.sistema.agendamento.sistema_agendamento.services;

import com.sistema.agendamento.sistema_agendamento.models.AlunoCurso;
import com.sistema.agendamento.sistema_agendamento.repositories.AlunoCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoCursoService {

    @Autowired
    private AlunoCursoRepository alunoCursoRepository;

    public AlunoCurso salvarAlunoCurso(AlunoCurso alunoCurso) {
        return alunoCursoRepository.save(alunoCurso);
    }

    public Optional<AlunoCurso> buscarAlunoCursoPorId(Long id) {
        return alunoCursoRepository.findById(id);
    }

    public List<AlunoCurso> listarCursosPorAluno(Long alunoId) {
        return alunoCursoRepository.findByAlunoId(alunoId);
    }

    public List<AlunoCurso> listarAlunosPorCurso(Long cursoId) {
        return alunoCursoRepository.findByCursoId(cursoId);
    }

    public void deletarAlunoCurso(Long id) {
        alunoCursoRepository.deleteById(id);
    }

}