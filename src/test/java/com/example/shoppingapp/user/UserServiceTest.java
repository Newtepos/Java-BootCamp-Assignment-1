package com.example.shoppingapp.user;

import com.example.shoppingapp.entities.User;
import com.example.shoppingapp.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;


    @Test
    @DisplayName("ทดสอบล็อกอินใส่ testing จะได้ login success")
    void login() {

        //Arrange
        User user = new User("testing","password");
        when(userRepository.findByUsername("testing")).thenReturn(Optional.of(user));

        //Act
        UserService userService = new UserService();
        userService.setUserRepository(userRepository);
        String result = userService.login(user);

        //Assert
        assertEquals("login success", result);
    }
}