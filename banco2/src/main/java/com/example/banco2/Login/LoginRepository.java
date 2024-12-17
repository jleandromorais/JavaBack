package com.example.banco2.Login;

import com.example.banco2.Registro.DadosPessoais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
    boolean existsByNomeCompletoAndAgenciaAndCpf(String nomeCompleto, String agencia, String cpf);
}

