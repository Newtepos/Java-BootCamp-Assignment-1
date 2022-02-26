package com.example.shoppingapp.cart;

import com.example.shoppingapp.AppResponse;
import com.example.shoppingapp.entities.Cart;
import com.example.shoppingapp.entities.CartItem;
import com.example.shoppingapp.entities.Product;
import com.example.shoppingapp.entities.User;
import com.example.shoppingapp.repository.ProductRepository;
import com.example.shoppingapp.repository.UserRepository;
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
}
