package com.sistema.agendamento.sistema_agendamento.models;

import jakarta.persistence.*;

@Entity
@Table(name = "polo_curso")
public class PoloCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "polo_id")
    private Polo polo;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}