package com.example.banco2.Controller;

import com.example.banco2.Models.DadosPessoais;
import com.example.banco2.Repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validar-conta")
@CrossOrigin("*")
public class LoginControler {

    @Autowired
    private RegistroRepository dadosPessoaisRepository; // Acessando a tabela de DadosPessoais

    @PostMapping
    public ResponseEntity<?> validarConta(@RequestBody DadosPessoais dadosPessoaisRequest) {
        // Consultar a tabela DadosPessoais para verificar se já existe esse CPF, agência e nome completo
        DadosPessoais dadosPessoais = dadosPessoaisRepository.findByCpfAndAgenciaAndNomeCompleto(
                dadosPessoaisRequest.getCpf(),
                dadosPessoaisRequest.getAgencia(),
                dadosPessoaisRequest.getNomeCompleto()
        );

        // Verificar se os dados existem
        if (dadosPessoais != null) {
            return ResponseEntity.ok().body("{\"success\": true}");
        } else {
            return ResponseEntity.ok().body("{\"success\": false, \"message\": \"Dados não encontrados.\"}");
        }
    }
}

