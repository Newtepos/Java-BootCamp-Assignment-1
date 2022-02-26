package com.example.shoppingapp;

import com.example.shoppingapp.entities.User;
import com.example.shoppingapp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ShoppingappApplication {

	@Autowired
	UserService userService;


	@PostConstruct
	public void initData() {
		User user = new User("johndoe", "1234");
		userService.createUser(user);
	}

	public static void main(String[] args) {
		SpringApplication.run(ShoppingappApplication.class, args);
	}

}
