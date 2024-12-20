package com.example.banco2.CARTOES2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByLoggedUserId(Long loggedUserId);
}

