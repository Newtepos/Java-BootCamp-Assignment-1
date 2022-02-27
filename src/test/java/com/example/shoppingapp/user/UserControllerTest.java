package com.example.shoppingapp.user;

import com.example.shoppingapp.entities.User;
import com.example.shoppingapp.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private UserRepository userRepository;

    @Test
    @DisplayName("ทดสอบการ Login จะได้ค่า null กลับมา")
    void login() {
        User user = new User("Testing", "Testing");
        when(userRepository.findByUsername(any())).thenReturn(Optional.of(user));

        UserResponse result = testRestTemplate.getForObject("/login", UserResponse.class);

        assertEquals(null, result.getMessage());
    }
}