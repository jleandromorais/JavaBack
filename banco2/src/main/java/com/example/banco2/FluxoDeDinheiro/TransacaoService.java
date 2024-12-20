package com.example.banco2.FluxoDeDinheiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    @Autowired
    private ExtratoRepository extratoRepository;
    @Autowired
    private SaldoRepository saldoRepository;

    public double getSaldo() {
        return saldoRepository.findById(1L)
                .map(Saldo::getSaldo).orElse(2500.75);
    }

    public void depositar(double valor) {
        Saldo saldo = saldoRepository.findById(1L).orElse(new Saldo());
        saldo.setSaldo(saldo.getSaldo() + valor);
        saldoRepository.save(saldo);

    }

    public boolean realizarPix(double valor) {
        Saldo saldo = saldoRepository.findById(1L).orElse(new Saldo());
        if (getSaldo() >= valor) {
            saldo.setSaldo(saldo.getSaldo() - valor);
            saldoRepository.save(saldo);
            return true;
        }
        return false;
    }

    public boolean pagarConta(double valor) {
        Saldo saldo = saldoRepository.findById(1L).orElse(new Saldo());
        if (saldo.getSaldo() >= valor) {
            saldo.setSaldo(saldo.getSaldo() - valor);
            saldoRepository.save(saldo);

            return true;
        }
        return false;
    }
}