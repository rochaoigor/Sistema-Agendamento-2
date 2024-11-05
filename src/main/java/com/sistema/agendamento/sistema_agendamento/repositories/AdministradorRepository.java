package com.sistema.agendamento.sistema_agendamento.repositories;

import com.sistema.agendamento.sistema_agendamento.models.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    Optional<Administrador> findByEmail(String email);
    
}