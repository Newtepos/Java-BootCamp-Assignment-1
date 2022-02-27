package com.example.shoppingapp;

import com.example.shoppingapp.entities.*;
import com.example.shoppingapp.product.ProductService;
import com.example.shoppingapp.repository.ProductRepository;
import com.example.shoppingapp.repository.UserRepository;
import com.example.shoppingapp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ShoppingappApplication {

	@Autowired
	ProductService productService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProductRepository productRepository;


	@PostConstruct
	public void initData() {
		//Create User
		User user = new User("johndoe", "1234");
		Cart cart = new Cart(user);
		BillAddress billAddress = new BillAddress(user);
		PaymentAddress paymentAddress = new PaymentAddress(user);
		user.setCart(cart);
		user.setBillAddress(billAddress);
		user.setPaymentAddress(paymentAddress);
		userRepository.save(user);

		//Create Product
		Product Orange = new Product("King Orange", 20.00);
		Product Orange2 = new Product("Queen Orange", 10.00);
		productRepository.save(Orange);
		productRepository.save(Orange2);
	}

	public static void main(String[] args) {
		SpringApplication.run(ShoppingappApplication.class, args);
	}

}
