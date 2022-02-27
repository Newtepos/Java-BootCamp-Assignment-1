package com.example.shoppingapp.cart;

import com.example.shoppingapp.entities.BillAddress;
import com.example.shoppingapp.entities.CartItem;
import com.example.shoppingapp.entities.PaymentAddress;

import java.util.Date;
import java.util.List;

public class CheckOutResponse {
    public Date date = new Date();
    public String name;
    public BillAddress billAddress;
    public PaymentAddress paymentAddress;
    public List<CartItem> cartItemList;

    public CheckOutResponse() {
    }

    public CheckOutResponse(String name, BillAddress billAddress, PaymentAddress paymentAddress, List<CartItem> cartItemList) {
        this.date = new Date();
        this.name = name;
        this.billAddress = billAddress;
        this.paymentAddress = paymentAddress;
        this.cartItemList = cartItemList;
    }

    public CheckOutResponse(String name, List<CartItem> cartItemList) {
        this.name = name;
        this.cartItemList = cartItemList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

}
