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
        System.out.println("Tentando deletar o cartão com ID: " + cardId);
        Optional<Card> cardOptional = cardRepository.findById(cardId);
        if (cardOptional.isPresent()) {
            cardRepository.deleteById(cardId);
            System.out.println("Cartão deletado com sucesso.");
            return true;
        } else {
            System.out.println("Cartão não encontrado.");
            return false;
        }
    }
}

