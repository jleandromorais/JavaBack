package com.example.banco2.Cartoes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaoRepository extends JpaRepository<Cartoes, Long> {
    List<Cartoes> findByUserId(Long userId);
}