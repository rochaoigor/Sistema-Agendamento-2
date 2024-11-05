package com.sistema.agendamento.sistema_agendamento.repositories;

import com.sistema.agendamento.sistema_agendamento.models.AlunoCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlunoCursoRepository extends JpaRepository<AlunoCurso, Long> {

    List<AlunoCurso> findByAlunoId(Long alunoId);

    List<AlunoCurso> findByCursoId(Long cursoId);
    
}