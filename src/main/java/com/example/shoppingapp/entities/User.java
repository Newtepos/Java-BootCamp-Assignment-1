package com.example.shoppingapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnoreProperties("user")
    private BillAddress billAddress;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnoreProperties("user")
    private PaymentAddress paymentAddress;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnoreProperties
    private Cart cart;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BillAddress getBillAddress() {
        return billAddress;
    }

    public void setBillAddress(BillAddress billAddress) {
        this.billAddress = billAddress;
    }

    public PaymentAddress getPaymentAddress() {
        return paymentAddress;
    }

    public void setPaymentAddress(PaymentAddress paymentAddress) {
        this.paymentAddress = paymentAddress;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
