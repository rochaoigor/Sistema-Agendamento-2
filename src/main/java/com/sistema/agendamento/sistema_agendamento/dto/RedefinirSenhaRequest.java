package com.sistema.agendamento.sistema_agendamento.dto;

public class RedefinirSenhaRequest {
    private String senhaAtual;
    private String novaSenha;

    // Getters e Setters
    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }
}