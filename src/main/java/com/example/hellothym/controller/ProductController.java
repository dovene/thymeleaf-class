package com.example.hellothym.controller;


import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.hellothym.model.Product;
import com.example.hellothym.service.ProductService;

import jakarta.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String listProducts(Model model, Locale locale) {
        model.addAttribute("products", productService.findAll());
        return "product/list"; 
    }

    @GetMapping("/products/add")
    public String addProductForm(Model model) {
        model.addAttribute("isEditMode", false);
        model.addAttribute("product", new Product()); 
        return "product/form";
    }

    @GetMapping("/products/edit/{ref}")
    public String editProductForm(@PathVariable("ref") String reference, Model model) {
        Product existingProduct = productService.findByReference(reference);
        if (existingProduct == null) {
            return "redirect:/products";
        }
        model.addAttribute("isEditMode", true);
        model.addAttribute("product", existingProduct);
        return "product/form";
    }

    @PostMapping("/products")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("isEditMode", productService.findByReference(product.getReference()) != null);
            return "product/form";
        }
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{ref}")
    public String deleteProduct(@PathVariable("ref") String reference) {
        productService.deleteByReference(reference);
        return "redirect:/products";
    }
}
