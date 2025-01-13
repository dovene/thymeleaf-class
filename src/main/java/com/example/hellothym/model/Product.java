package com.example.hellothym.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Product {
    
    private String reference;      
    private String designation;    
    private int quantityStock;     
    private String category;       
    private int alertQuantity;    
    private Double salePrice;     

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    public Product() {
    }

    public Product(String reference, String designation, int quantityStock, String category, 
                   int alertQuantity, Double salePrice, LocalDate creationDate) {
        this.reference = reference;
        this.designation = designation;
        this.quantityStock = quantityStock;
        this.category = category;
        this.alertQuantity = alertQuantity;
        this.salePrice = salePrice;
        this.creationDate = creationDate;
    }

    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public int getQuantityStock() {
        return quantityStock;
    }
    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getAlertQuantity() {
        return alertQuantity;
    }
    public void setAlertQuantity(int alertQuantity) {
        this.alertQuantity = alertQuantity;
    }
    public Double getSalePrice() {
        return salePrice;
    }
    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
