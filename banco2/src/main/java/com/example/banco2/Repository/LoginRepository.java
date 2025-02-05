package com.example.banco2.Repository;

import com.example.banco2.Models.Login;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginRepository extends JpaRepository<Login, Long> {
    boolean existsByNomeCompletoAndAgenciaAndCpf(String nomeCompleto, String agencia, String cpf);


}

