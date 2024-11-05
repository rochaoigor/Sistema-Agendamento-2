package com.sistema.agendamento.sistema_agendamento.repositories;

import com.sistema.agendamento.sistema_agendamento.models.Prova;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProvaRepository extends JpaRepository<Prova, Long> {

    List<Prova> findByCursoId(Long cursoId);

}