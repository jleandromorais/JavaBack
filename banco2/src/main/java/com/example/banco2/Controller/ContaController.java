package com.example.banco2.Controller;

import com.example.banco2.Models.Transacao;
import com.example.banco2.Service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin("*")
@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping("/saldo")
    public ResponseEntity<Map<String, Double>> getSaldo() {
        double saldo = transacaoService.getSaldo();
        return ResponseEntity.ok(Map.of("saldo", saldo));
    }

    @PostMapping("/depositar")
    public ResponseEntity<Map<String, String>> depositar(@RequestBody Map<String, Double> body) {
        if (!body.containsKey("valor")) {
            return ResponseEntity.badRequest().body(Map.of("erro", "O valor do depósito é obrigatório."));
        }

        double valor = body.get("valor");
        transacaoService.depositar(valor);

        return ResponseEntity.ok(Map.of("mensagem", "Depósito realizado com sucesso."));
    }

    @PostMapping("/pix")
    public ResponseEntity<Map<String, String>> realizarPix(@RequestBody Map<String, Double> body) {
        if (!body.containsKey("valor")) {
            return ResponseEntity.badRequest().body(Map.of("erro", "O valor do PIX é obrigatório."));
        }

        double valor = body.get("valor");
        boolean sucesso = transacaoService.realizarPix(valor);

        if (sucesso) {
            return ResponseEntity.ok(Map.of("mensagem", "PIX enviado com sucesso!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("erro", "Saldo insuficiente para realizar o PIX."));
    }

    @PostMapping("/pagar-conta")
    public ResponseEntity<String> pagarConta(@RequestBody Map<String, Double> body) {
        double valor = body.get("valor");
        boolean sucesso = transacaoService.pagarConta(valor);
        if (sucesso) {
            return ResponseEntity.ok("Conta paga com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Saldo insuficiente para pagar a conta.");
    }

    // Novo método para retornar o extrato
    @GetMapping("/extrato")
    public ResponseEntity<List<Transacao>> getExtrato() {
        List<Transacao> extrato = transacaoService.getExtrato(); // Obtém o extrato do serviço
        return ResponseEntity.ok(extrato);
    }
}
