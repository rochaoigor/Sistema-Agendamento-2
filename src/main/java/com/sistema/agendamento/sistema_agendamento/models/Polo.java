package com.sistema.agendamento.sistema_agendamento.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "polos")
public class Polo extends Usuario {

    @Id
    private long id;

    private String nomePolo;
    private String endereco;

    // Getters e Setters
    public long getIdPolo() {
        return id;
    }

    public void setIdPolo(long id) {
        this.id = id;
    }

    public String getNomePolo() {
        return nomePolo;
    }

    public void setNomePolo(String nomePolo) {
        this.nomePolo = nomePolo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}