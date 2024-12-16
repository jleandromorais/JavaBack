package com.example.banco2.Registro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroRepository extends JpaRepository<DadosPessoais,Long> {
    boolean existsByCpf(String cpf);
}
