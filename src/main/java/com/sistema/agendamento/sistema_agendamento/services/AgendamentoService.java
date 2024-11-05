package com.sistema.agendamento.sistema_agendamento.services;

import com.sistema.agendamento.sistema_agendamento.models.Agendamento;
import com.sistema.agendamento.sistema_agendamento.repositories.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    private static final int LIMITE_VAGAS = 1;

    public Agendamento criarAgendamento(Agendamento agendamento) {
        if (isHorarioLotado(agendamento.getDataHora())) {
            throw new IllegalArgumentException("Horário já está cheio, escolha outro.");
        }

        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> listarTodosAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public Agendamento reagendarProva(Long id, Agendamento novoAgendamento) {

        Agendamento agendamentoExistente = agendamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));
    
        agendamentoExistente.setCancelado(true);
        agendamentoRepository.save(agendamentoExistente);
    
        novoAgendamento.setReagendamento(agendamentoExistente);
    
        if (isHorarioLotado(novoAgendamento.getDataHora(), id)) { 
            throw new IllegalArgumentException("Horário já está cheio. Tente outro horário.");
        }
    
        return criarAgendamento(novoAgendamento);
    }

    public boolean isHorarioLotado(LocalDateTime dataHora, Long... agendamentoId) {
        List<Agendamento> agendamentosNoHorario = agendamentoRepository.findByDataHora(dataHora);
        int vagasOcupadas = (int) agendamentosNoHorario.stream()
                .filter(a -> !a.isCancelado() && (agendamentoId.length == 0 || !a.getId().equals(agendamentoId[0])))
                .count();
        return vagasOcupadas >= LIMITE_VAGAS;
    }
}