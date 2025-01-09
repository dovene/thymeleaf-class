package com.example.hellothym.model;

public class Stock {
    private String productReference;
    private String storeId;
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

