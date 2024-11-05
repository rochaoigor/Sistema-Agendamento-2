package com.sistema.agendamento.sistema_agendamento.repositories;

import com.sistema.agendamento.sistema_agendamento.models.PoloCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PoloCursoRepository extends JpaRepository<PoloCurso, Long> {

    List<PoloCurso> findByPoloId(Long poloId);

    List<PoloCurso> findByCursoId(Long cursoId);
    
}