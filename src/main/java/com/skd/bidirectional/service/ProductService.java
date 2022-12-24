package com.skd.bidirectional.service;

import com.skd.bidirectional.model.Product;
import com.skd.bidirectional.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product Not Found"));
    }
}
