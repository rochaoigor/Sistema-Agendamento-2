package com.sistema.agendamento.sistema_agendamento.repositories;

import com.sistema.agendamento.sistema_agendamento.models.Polo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PoloRepository extends JpaRepository<Polo, Long> {

    List<Polo> findByNomeContaining(String nome);
    
}