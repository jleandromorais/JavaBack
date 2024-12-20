package com.example.banco2.CARTOES2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
