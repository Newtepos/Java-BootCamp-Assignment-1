package com.example.shoppingapp.user;

import com.example.shoppingapp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public UserResponse login(@RequestBody User user) {
        String userLogin = userService.login(user);
        return new UserResponse(userLogin);
    }
}
