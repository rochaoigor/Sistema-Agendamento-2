package com.sistema.agendamento.sistema_agendamento.repositories;

import com.sistema.agendamento.sistema_agendamento.models.AlunoPolo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlunoPoloRepository extends JpaRepository<AlunoPolo, Long> {

    List<AlunoPolo> findByAlunoId(Long alunoId);

}