package com.example.banco2.Cartoes;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartoes")
public class cartoescontroller {
    @Autowired
    private CardService cardService;

    @PostMapping("/{userId}")
    public ResponseEntity<Cartoes> createCard(@PathVariable Long userId, @RequestBody Cartoes card) {
        Cartoes createdCard = cardService.CreatedCard(userId, card);
        return ResponseEntity.ok(createdCard);
    }
}

