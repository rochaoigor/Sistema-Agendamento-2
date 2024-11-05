package com.sistema.agendamento.sistema_agendamento.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "administradores")
public class Administrador extends Usuario {

    @Id
    private long id;

    private String setor;
    private Integer permissoes;

    // Getters e Setters
    public long getIdAdministrador() {
        return id;
    }

    public void setIdAdministrador(long id) {
        this.id = id;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Integer getPermissoes() {
        
        return permissoes;
    }

    public void setPermissoes(Integer permissoes) {
        this.permissoes = permissoes;
    }

}