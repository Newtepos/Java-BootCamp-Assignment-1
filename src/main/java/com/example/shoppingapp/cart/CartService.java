package com.example.shoppingapp.cart;

import com.example.shoppingapp.AppResponse;
import com.example.shoppingapp.entities.*;
import com.example.shoppingapp.repository.ProductRepository;
import com.example.shoppingapp.repository.UserRepository;
import com.example.shoppingapp.user.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartGateway cartGateway;


    public List<CartItem> getAllItemUserCart(long id) {
        Optional<User> queryUser = userRepository.findById(id);
        return queryUser.get().getCart().getCartItemList();
    }


    public AppResponse addItemToUserCart(Long userId, Long productId, Integer quantity) {
        Optional<User> userResult = userRepository.findById(userId);
        Optional<Product> productResult = productRepository.findById(productId);
        if(userResult.isPresent() && productResult.isPresent()) {

            Cart userCart = userResult.get().getCart();
            Product product = productResult.get();
            List<CartItem> cartItemList = userCart.getCartItemList();

            //if Cart Empty
            if(cartItemList.isEmpty())
            {
                CartItem cartItem = new CartItem(quantity, product, userCart);
                userCart.addItemList(cartItem);
            }

            //If Cart has same item inside
            else if(userCart.checkProductContain(productId)) {
                for(CartItem cartItem: cartItemList) {
                    if(cartItem.getProduct().getId() == productId) {
                        cartItem.increaseQuantity(quantity);
                    }
                }
            }

            //Cart Not Empty and not match same
            else {
                CartItem cartItem = new CartItem(quantity,product,userCart);
                userCart.addItemList(cartItem);
            }

            userCart.setTotalPrice(userCart.getTotalPrice());
            userRepository.save(userResult.get());

            return new AppResponse("Product Added to you cart!!");
        } else {
            return new AppResponse("ProductID or UserID Incorrect!!");
        }
    }

    public CheckOutResponse userCartCheckout(long id) {
        User queryUser = userRepository.findById(id).get();
        UserResponse bankResponse = cartGateway.userCartCheckOut();
        if(bankResponse.getMessage().equals("Bank Pay Completed")) {
            String username = queryUser.getUsername();
            BillAddress billAddress = queryUser.getBillAddress();
            PaymentAddress paymentAddress = queryUser.getPaymentAddress();
            List<CartItem> cartItemList = queryUser.getCart().getCartItemList();
            return new CheckOutResponse(username,billAddress,paymentAddress,cartItemList);
        }
        return new CheckOutResponse();
    }
}
