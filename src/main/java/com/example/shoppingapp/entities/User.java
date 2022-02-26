package com.example.shoppingapp.entities;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public String username;
    public String password;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    public BillAddress billAddress;

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
}
