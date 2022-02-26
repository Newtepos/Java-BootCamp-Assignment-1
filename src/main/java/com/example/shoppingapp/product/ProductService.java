package com.example.shoppingapp.product;

import com.example.shoppingapp.entities.Product;
import com.example.shoppingapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> findAllProductByName(String name) {
      List<Product> result = productRepository.findByProductNameContainsIgnoreCase(name);
      if(result.isEmpty()) {
          throw new ProductNotFoundException("");
      }
      return result;
    }

    public Optional<Product> findProductById(long id) {
        Optional<Product> result = productRepository.findById(id);
        if(result.isPresent()) {
            return  result;
        }
        throw new ProductNotFoundException("ProductID");
    }


}
