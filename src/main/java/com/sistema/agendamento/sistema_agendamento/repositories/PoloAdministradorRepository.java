package com.sistema.agendamento.sistema_agendamento.repositories;

import com.sistema.agendamento.sistema_agendamento.models.PoloAdministrador;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PoloAdministradorRepository extends JpaRepository<PoloAdministrador, Long> {

    List<PoloAdministrador> findByPoloId(Long poloId);

}