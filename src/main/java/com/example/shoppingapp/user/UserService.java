package com.example.shoppingapp.user;

import com.example.shoppingapp.entities.User;
import com.example.shoppingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public String login(User user) {
        Optional<User> QueryUser = userRepository.findByUsername(user.getUsername());
        if(QueryUser.isPresent()) {
          if(QueryUser.get().getPassword().equals(user.getPassword())) {
              return "login success";
          }
              return  "password incorrect";
        }
        return "User not found";
    }

}
