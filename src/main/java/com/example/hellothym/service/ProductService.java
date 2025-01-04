package com.example.hellothym.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.hellothym.model.Product;

@Service
public class ProductService {

    private static final List<Product> productList = new ArrayList<>();

    public List<Product> findAll() {
        return productList;
    }

    public Product findByReference(String ref) {
        return productList.stream()
                .filter(p -> p.getReference().equals(ref))
                .findFirst()
                .orElse(null);
    }

    public void save(Product product) {
        Product existingProduct = findByReference(product.getReference());
        if (existingProduct != null) {
            existingProduct.setDesignation(product.getDesignation());
            existingProduct.setQuantityStock(product.getQuantityStock());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setAlertQuantity(product.getAlertQuantity());
            existingProduct.setSalePrice(product.getSalePrice());
            existingProduct.setCreationDate(product.getCreationDate());
        } else {
            productList.add(product);
        }
    }

    public void deleteByReference(String ref) {
        productList.removeIf(p -> p.getReference().equals(ref));
    }
}
