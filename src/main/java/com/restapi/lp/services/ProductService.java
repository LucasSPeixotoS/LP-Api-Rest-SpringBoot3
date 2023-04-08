package com.restapi.lp.services;

import com.restapi.lp.entities.Category;
import com.restapi.lp.entities.Product;
import com.restapi.lp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            return new Product();
        } else {
            return product.get();
        }

    }
}
