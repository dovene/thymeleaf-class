package com.example.hellothym.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Product {
    
    @NotBlank(message = "La référence est obligatoire") 
    private String reference;      

    @NotBlank(message = "La désignation est obligatoire")
    private String designation;    

    @Min(value = 1, message = "La quantité en stock doit être supérieure à 0")
    private int quantityStock;   
    
    @NotBlank(message = "La catégorie est obligatoire")
    private String category;       

    @Min(value = 1, message = "La quantité d'alerte doit être supérieure à 0")
    private int alertQuantity;    
    
    @NotNull(message = "Le prix de vente est obligatoire")
    @Positive(message = "Le prix de vente doit être supérieur à 0")
    private Double salePrice;  

    @NotNull(message = "La date de création est obligatoire")   
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
