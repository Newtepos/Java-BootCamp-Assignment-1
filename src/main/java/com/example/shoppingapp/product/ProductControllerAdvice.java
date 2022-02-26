package com.example.shoppingapp.product;

import com.example.shoppingapp.AppResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AppResponse productNotFound(ProductNotFoundException e) {
        return new AppResponse(e.getMessage() + "not found");
    }
}
