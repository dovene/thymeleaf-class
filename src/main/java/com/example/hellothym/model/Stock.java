package com.example.hellothym.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Stock {
    @NotBlank(message = "La référence du produit est obligatoire")
    private String productReference;
    @NotBlank(message = "L'identifiant du magasin est obligatoire")
    private String storeId;
    @Min(value = 1, message = "La quantité en stock doit être supérieure à 0")
    private int stockQuantity;

    public Stock() {
    }

    public Stock(String productReference, String storeId, int stockQuantity) {
        this.productReference = productReference;
        this.storeId = storeId;
        this.stockQuantity = stockQuantity;
    }

    public String getProductReference() {
        return productReference;
    }

    public void setProductReference(String productReference) {
        this.productReference = productReference;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

}

