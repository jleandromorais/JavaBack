package com.example.banco2.CARTOES2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository  extends JpaRepository<Card,Long> {
    List<Card> findByLoggedUserId(Long loggedUserId);
}
//alal
