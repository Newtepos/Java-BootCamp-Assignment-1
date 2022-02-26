package com.example.shoppingapp;

import com.example.shoppingapp.entities.Product;
import com.example.shoppingapp.entities.User;
import com.example.shoppingapp.product.ProductService;
import com.example.shoppingapp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ShoppingappApplication {

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;


	@PostConstruct
	public void initData() {
		//Create User
		User user = new User("johndoe", "1234");
		userService.createUser(user);

		//Create Product
		Product Orange = new Product("King Orange", 20.00);
		Product Orange2 = new Product("Queen Orange", 10.00);
		productService.addProduct(Orange);
		productService.addProduct(Orange2);
	}

	public static void main(String[] args) {
		SpringApplication.run(ShoppingappApplication.class, args);
	}

}
