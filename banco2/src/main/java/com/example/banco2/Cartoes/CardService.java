package com.example.banco2.Cartoes;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    private final CartaoRepository cartaoRepository;
    private final userRepository userRepository;

    public CardService(CartaoRepository cartaoRepository, userRepository userRepository) {
        this.cartaoRepository = cartaoRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Cartoes CreatedCard(Long userId, Cartoes card) {
        if (card.getType() == null || (!card.getType().equals("credit") && !card.getType().equals("debit"))) {
            throw new IllegalArgumentException("Tipo de cartão inválido. Deve ser 'credit' ou 'debit'.");
        }

        // Verifica se o usuário existe
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            // Cria um novo usuário se não for encontrado
            user = new User();
            user.setId(userId); // ID é atribuído diretamente
            user.setUsername("user" + userId); // Nome de usuário gerado automaticamente
            userRepository.save(user); // Salva o novo usuário
        }

        card.setUser(user); // Associa o cartão ao usuário
        card.setNumber(generateNumber()); // Gera o número do cartão
        card.setExpiration(generateExpirationDate()); // Gera a validade do cartão

        user.getCards().add(card); // Adiciona o cartão à lista de cartões do usuário
        userRepository.save(user); // Salva o usuário novamente (inclui o cartão)

        return cartaoRepository.save(card); // Salva o cartão
    }

    private String generateNumber() {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            number.append((int) (Math.random() * 10));
            if ((i + 1) % 4 == 0 && i < 15) {
                number.append(" ");
            }
        }
        return number.toString();
    }

    private String generateExpirationDate() {
        int year = java.time.Year.now().getValue() + 4;
        int month = (int) (Math.random() * 12) + 1;
        return String.format("%02d/%d", month, year);
    }
}
