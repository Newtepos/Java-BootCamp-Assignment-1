package com.example.shoppingapp.user;

import com.example.shoppingapp.entities.User;
import com.example.shoppingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

}
