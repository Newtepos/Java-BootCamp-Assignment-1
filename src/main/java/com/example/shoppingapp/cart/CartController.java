package com.example.shoppingapp.cart;

import com.example.shoppingapp.AppResponse;
import com.example.shoppingapp.entities.CartItem;
import com.example.shoppingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/user/{userID}/cart/add/{productID}/{quantity}")
    public AppResponse addItem(@PathVariable long userID, @PathVariable long productID, @PathVariable int quantity) {
        return cartService.addItemToUserCart(userID,productID,quantity);
    }
}
