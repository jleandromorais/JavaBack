package com.example.banco2.Cartoes;

import jakarta.persistence.*;
@Entity
public class Cartoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type; // "credit" ou "debit"

    @Column(nullable = false, unique = true, length = 19)
    private String number; // Número formatado "1234 5678 9012 3456"

    @Column(nullable = false)
    private String expiration; // Validade no formato "MM/AAAA"

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Getters e Setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
}
