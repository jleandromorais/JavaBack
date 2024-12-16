package com.example.banco2.Registro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/Registro")
public class RegistroController {


    @Autowired
    private  RegistroRepository registroRepository;
@PostMapping
public  ResponseEntity<?>registro(@RequestBody Dadostotais dados, UriComponentsBuilder uriBuilder){
    System.out.println("Dados recebidos: " + dados);  // Para verificar os dados no backend

    if (registroRepository.existsByCpf(dados.cpf())) {
        // Criar um mapa com a mensagem de erro
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "O   CPF já está registrado.");
        return ResponseEntity.badRequest().body(errorResponse);  // Retorna um 400 com o erro
    }
    var registro =new DadosPessoais(dados);
    registroRepository.save(registro);
    var uri = uriBuilder.path("/registro/{id}").buildAndExpand(registro.getId()).toUri();
    return ResponseEntity.created(uri).body(new Dadostotais(registro));


}  @GetMapping
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



