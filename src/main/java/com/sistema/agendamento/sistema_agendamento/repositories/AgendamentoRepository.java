package com.sistema.agendamento.sistema_agendamento.repositories;

import com.sistema.agendamento.sistema_agendamento.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findByCanceladoFalse();

    List<Agendamento> findByDisciplina(String disciplina);

    List<Agendamento> findByDataHora(LocalDateTime dataHora);

    List<Agendamento> findByAlunoId(Long alunoId);

    List<Agendamento> findByDisciplinaAndDataHora(String disciplina, LocalDateTime dataHora);
    
}