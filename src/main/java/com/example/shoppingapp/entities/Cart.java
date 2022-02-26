package com.example.shoppingapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double totalPrice;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("user")
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("cart")
    private List<CartItem> cartItemList = new ArrayList<>();

    public Cart() {
    }

    public Cart(User user) {
        this.user = user;
        this.totalPrice = getTotalPrice();
    }

    public long getId() {
        return id;
    }

    public double getTotalPrice() {
        double sum = 0.0;
        if(cartItemList.isEmpty()) {
            this.totalPrice = sum;
        } else {
            for(CartItem cartItem: cartItemList) {
                sum = sum + cartItem.getTotalPrice();
            }
        }
        return sum;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public void addItemList(CartItem cartItem) {
        cartItemList.add(cartItem);
    }

    public boolean checkProductContain(Long id) {
        return cartItemList.stream().anyMatch(n -> n.getProduct().getId() == id);
    }

}
