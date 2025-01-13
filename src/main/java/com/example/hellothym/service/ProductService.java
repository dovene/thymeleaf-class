package com.example.hellothym.service;

import java.time.LocalDate;
import java.util.*;

import org.springframework.stereotype.Service;

import com.example.hellothym.model.Product;

@Service
public class ProductService {

    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product("REF001", "Product 1", 10, "mixte", 5, 100.0, LocalDate.now()));
        productList.add(new Product("REF002", "Product 2", 20, "matériel", 10, 200.0, LocalDate.now()));
        productList.add(new Product("REF003", "Product 3", 30, "logiciel", 15, 300.0, LocalDate.now())); 
    }
    
    public List<Product> findAll() {
        return productList;
    }

    
}
