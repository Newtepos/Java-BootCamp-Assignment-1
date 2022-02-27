package com.example.shoppingapp.cart;

import com.example.shoppingapp.user.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartGateway {

    @Autowired
    private RestTemplate restTemplate;

    private String baseUrl;

    public CartGateway(@Value("${base_url}") String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public UserResponse userCartCheckOut() {
        UserResponse result = restTemplate.getForObject
                (this.baseUrl + "/checkout",
                        UserResponse.class);
        return result;


    }
}
