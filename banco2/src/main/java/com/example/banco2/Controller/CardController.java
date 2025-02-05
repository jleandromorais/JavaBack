package com.example.banco2.Controller;

import com.example.banco2.Models.Card;
import com.example.banco2.Repository.CardRepository;
import com.example.banco2.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;
    @Autowired
    private CardRepository cardRepository;

    @PostMapping
    public List<Card> createCards(@RequestBody Map<String, Object> payload) {
        try {
            Long loggedUserId = Long.valueOf((Integer) payload.get("loggedUserId"));
            List<Map<String, String>> cards = (List<Map<String, String>>) payload.get("cards");

            // Salva os novos cartões
            cardService.saveCards(loggedUserId, cards);

            // Retorna apenas os cartões do usuário logado
            return cardRepository.findByLoggedUserId(loggedUserId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao criar cartões", e);
        }
    }
    @GetMapping
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardService.getAllCards();
        if (cards.isEmpty()) {
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.ok(cards);
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long cardId) {
        System.out.println("ID do cartão recebido para exclusão: " + cardId); // Log do ID recebido

        boolean isDeleted = cardService.deleteCard(cardId);

        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

