package com.sistema.agendamento.sistema_agendamento.repositories;

import com.sistema.agendamento.sistema_agendamento.models.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalTime;
import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Long> {

    List<Horario> findByPoloId(Long poloId);

    List<Horario> findByHorarioInicioBetween(LocalTime inicio, LocalTime fim);
        
}