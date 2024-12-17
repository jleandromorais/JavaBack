package com.example.banco2.Registro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/registro")
@CrossOrigin("*")

public class RegistroController {


    @Autowired
    private  RegistroRepository registroRepository;
@PostMapping
public ResponseEntity<?> registro(@RequestBody Dadostotais dados, UriComponentsBuilder uriBuilder) {
    // Imprime os dados recebidos para verificar se estão corretos
    System.out.println("Dados recebidos: " + dados);

    // Verifica se o CPF já está registrado no banco de dados
    if (registroRepository.existsByCpf(dados.cpf())) {
        // Se o CPF já estiver registrado, retorna um erro com a mensagem correspondente
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "O CPF já está registrado.");
        return ResponseEntity.badRequest().body(errorResponse);  // Retorna código 400 (Bad Request) com a mensagem de erro
    }

    // Se o CPF não estiver registrado, cria o novo registro e salva no banco
    DadosPessoais registro = new DadosPessoais(dados);  // Cria a instância de DadosPessoais
    registroRepository.save(registro);  // Salva o registro no banco de dados

    // Cria a URI do novo registro com base no ID gerado após o salvamento
    var uri = uriBuilder.path("/registro/{id}").buildAndExpand(registro.getId()).toUri();

    // Retorna a resposta com o código 201 (Created) e a URI do novo registro
    return ResponseEntity.created(uri).body(new Dadostotais(registro));  // Retorna o objeto registrado
}
 @GetMapping
    public ResponseEntity<List<ListaDeCadastro>> listar() {
        var lista = registroRepository.findAll().stream()
                .map(ListaDeCadastro::new)
                .toList();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 No Content se a lista estiver vazia
        }

        return ResponseEntity.ok(lista); // Retorna 200 OK com a lista de objetos
    }

}



