package com.example.banco2.Service;

import com.example.banco2.Models.Transacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {
    // Lista para armazenar as transações
    private final List<Transacao> extrato = new ArrayList<>();
    private double saldo = 2500.75;

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        // Salva a transação no extrato
        extrato.add(new Transacao("Depósito", valor));
    }

    public boolean realizarPix(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            // Salva a transação no extrato
            extrato.add(new Transacao("PIX", -valor));
            return true;
        }
        return false;
    }

    public boolean pagarConta(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            // Salva a transação no extrato
            extrato.add(new Transacao("Pagamento Conta", -valor));
            return true;
        }
        return false;
    }

    // Método para retornar o extrato de transações
    public List<Transacao> getExtrato() {
        return extrato;
    }
}