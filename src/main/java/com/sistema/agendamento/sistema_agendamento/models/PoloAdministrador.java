package com.sistema.agendamento.sistema_agendamento.models;

import jakarta.persistence.*;

@Entity
@Table(name = "polo_administrador")
public class PoloAdministrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "polo_id")
    private Polo polo;

    @ManyToOne
    @JoinColumn(name = "administrador_id")
    private Administrador administrador;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Polo getPolo() {
        return polo;
    }

    public void setPolo(Polo polo) {
        this.polo = polo;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
}