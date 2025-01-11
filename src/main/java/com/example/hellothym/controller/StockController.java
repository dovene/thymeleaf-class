package com.example.hellothym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.hellothym.model.Stock;
import com.example.hellothym.service.ProductService;
import com.example.hellothym.service.StockService;
import com.example.hellothym.service.StoreService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;
    @Autowired
    private ProductService productService;
    @Autowired
    private StoreService storeService;

    @GetMapping
    public String listStock(Model model) {
        model.addAttribute("stock", stockService.findAll());
        return "stock/list";
    }

    @GetMapping("/add")
    public String addStockForm(Model model) {
        model.addAttribute("stock", new Stock());
        model.addAttribute("products", productService.findAll());
        model.addAttribute("stores", storeService.findAll());
        model.addAttribute("isEditMode", false);
        return "stock/form";
    }

    @GetMapping("/edit/{productRef}/{storeId}")
    public String editStockForm(@PathVariable String productRef, @PathVariable String storeId, Model model) {
        Stock entry = stockService.findByProductAndStore(productRef, storeId);
        if (entry == null) {
            return "redirect:/stock";
        }
        model.addAttribute("stock", entry);
        model.addAttribute("products", productService.findAll());
        model.addAttribute("stores", storeService.findAll());
        model.addAttribute("isEditMode", true);
        return "stock/form";
    }

    @PostMapping
    public String saveStock(@Valid @ModelAttribute("stock") Stock stock, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("products", productService.findAll());
            model.addAttribute("stores", storeService.findAll());
            model.addAttribute("isEditMode", stockService.findByProductAndStore(stock.getProductReference(), stock.getStoreId()) != null);
            return "stock/form";
        }
        stockService.save(stock);
        return "redirect:/stock";
    }

    @GetMapping("/delete/{productRef}/{storeId}")
    public String deleteStock(@PathVariable String productRef, @PathVariable String storeId) {
        stockService.delete(productRef, storeId);
        return "redirect:/stock";
    }
}

