package com.example.shoppingapp.product;

import com.example.shoppingapp.entities.Product;
import com.example.shoppingapp.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private ProductRepository productRepository;

    @Test
    @DisplayName("ทดสอบใส่ array ของ product เพื่อดึงค่ากลับทั้งหมดเวลาค้นหา")
    void getAllProductBySearch() {
       Product product = new Product("Testing", 20);
       Product product1 = new Product("Testing2", 20);
       List<Product> productList = new ArrayList<>();
       productList.add(product);
       productList.add(product1);
       when(productRepository.findByProductNameContainsIgnoreCase("Testing")).thenReturn(productList);
       List result = testRestTemplate.getForObject("/product?p=Testing", List.class);
       assertEquals("[{id=0, productName=Testing, price=20.0}, {id=0, productName=Testing2, price=20.0}]", result.toString());
    }

    @Test
    @DisplayName("ทดสอบใส่โปรดัคแล้วค้นหา จะได้ค่าเดิม")
    void getProductById() {
        Product product = new Product("Testing", 20);
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));

        Product result = testRestTemplate.getForObject("/product/2", Product.class);

        assertEquals(product.getProductName(), result.getProductName());
    }
}