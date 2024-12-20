package com.example.banco2.CARTOES2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping
    public List<Card> createCards(@RequestBody Map<String, Object> payload) {
        Long loggedUserId = Long.valueOf((Integer) payload.get("loggedUserId"));
        List<Map<String, String>> cards = (List<Map<String, String>>) ((Map<String, Object>) payload.get("allUsersCards")).get(String.valueOf(loggedUserId));

        return cardService.saveCards(loggedUserId, cards);
    }
    @GetMapping
    public ResponseEntity<List<Card>> getAllCards(){
        List<Card> cards =cardService.getAllCards();
        if(cards.isEmpty()){
            return  ResponseEntity.noContent().build();

        }
        return ResponseEntity.ok(cards);
    }
    @DeleteMapping("/{cardId}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long cardId) {
        boolean isDeleted = cardService.deleteCard(cardId);

        if (isDeleted) {
            // Se o cartão foi deletado com sucesso, retorna 204 No Content (sem corpo)
            return ResponseEntity.noContent().build();
        } else {
            // Se o cartão não foi encontrado ou não pôde ser deletado, retorna 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }

}
