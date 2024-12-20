package com.example.banco2.CARTOES2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public List<Card> saveCards(Long loggedUserId, List<Map<String, String>> cards) {


        List<Card> cardEntities = new ArrayList<>();

        for (Map<String, String> cardData : cards) {
            Card card = new Card();
            card.setType(cardData.get("type"));
            card.setNumber(cardData.get("number"));
            card.setExpiration(cardData.get("expiration"));
            card.setLoggedUserId(loggedUserId);

            cardEntities.add(card);
        }

        return cardRepository.saveAll(cardEntities);
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public boolean deleteCard(Long cardId) {
        // Verifica se o cartão existe
        Optional<Card> card = cardRepository.findById(cardId);

        if (card.isPresent()) {
            // Se o cartão existir, exclui
            cardRepository.delete(card.get());
            return true;
        }
        return false; // Retorna false se o cartão não for encontrado
    }
}

