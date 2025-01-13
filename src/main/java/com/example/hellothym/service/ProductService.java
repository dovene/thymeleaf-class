package com.example.hellothym.service;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hellothym.controller.repository.ProductRepository;
import com.example.hellothym.model.Product;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findByReference(String ref) {
        return productRepository.findById(ref).orElse(null);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void deleteByReference(String ref) {
        productRepository.deleteById(ref);
    }
}
