package com.example.banco2.Repository;

import com.example.banco2.Models.DadosPessoais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroRepository extends JpaRepository<DadosPessoais,Long> {
    boolean existsByCpf(String cpf);
    DadosPessoais findByCpfAndAgenciaAndNomeCompleto(String cpf, String agencia, String nomeCompleto);
}
