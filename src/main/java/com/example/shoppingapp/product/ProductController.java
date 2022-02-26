package com.example.shoppingapp.product;

import com.example.shoppingapp.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ResponseEntity getAllProductBySearch(@RequestParam(name = "p") String productName) {
        List<Product> productList = productService.findAllProductByName(productName);
        return new ResponseEntity<Object>(productList, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable long id) {
        Optional<Product> product = productService.findProductById(id);
        return new ResponseEntity<Object>(product, HttpStatus.OK);
//        return product;
    }

}
