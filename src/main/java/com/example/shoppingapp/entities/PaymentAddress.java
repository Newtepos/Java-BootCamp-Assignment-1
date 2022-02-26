package com.example.shoppingapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class PaymentAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public String cardHolder;
    public long cardNumber;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("user")
    public User user;

    public PaymentAddress() {
    }

    public PaymentAddress(String cardHolder, long cardNumber, User user) {
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}