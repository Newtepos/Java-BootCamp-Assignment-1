package com.example.shoppingapp.product;

import com.example.shoppingapp.entities.Product;
import com.example.shoppingapp.repository.ProductRepository;
import com.example.shoppingapp.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;



    @Test
    @DisplayName("ทดสอบใส่ค่า array ของ product โดยค้นหากลับมาจะได้ array เดิม")
    void findAllProductByName() {
        //Arrange
        Product product = new Product("ProductTesting", 10);
        Product product2 = new Product("ProductTesting2", 10);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product2);
        when(productRepository.findByProductNameContainsIgnoreCase("testing")).thenReturn(productList);

        //Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<Product> result = productService.findAllProductByName("testing");

        //Assert
        assertEquals(productList, result);
    }
}