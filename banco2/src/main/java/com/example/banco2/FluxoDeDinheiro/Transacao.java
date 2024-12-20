package com.example.banco2.FluxoDeDinheiro;

public class Transacao {
    private String descricao;
    private double valor;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Transacao(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }
}
