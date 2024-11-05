package com.sistema.agendamento.sistema_agendamento.repositories;

import com.sistema.agendamento.sistema_agendamento.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findByCurso_Id(Long cursoId);

}