package com.sistema.agendamento.sistema_agendamento.dto;

public class UsuarioRequest {
    private String nome;
    private String email;
    private String telefone;
    private String ra;
    private String curso;
    private String periodo;
    private String cidade;
    private String polo;

    // Construtores
    public UsuarioRequest() {}

    public UsuarioRequest(String nome, String email, String telefone, String ra, String curso, String periodo, String cidade, String polo) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.ra = ra;
        this.curso = curso;
        this.periodo = periodo;
        this.cidade = cidade;
        this.polo = polo;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getRa() { return ra; }
    public void setRa(String ra) { this.ra = ra; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getPolo() { return polo; }
    public void setPolo(String polo) { this.polo = polo; }
}