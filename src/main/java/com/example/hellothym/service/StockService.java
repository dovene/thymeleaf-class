package com.example.hellothym.service;

import org.springframework.stereotype.Service;

import com.example.hellothym.model.Stock;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    private static final List<Stock> stockEntries = new ArrayList<>();

    static {
        stockEntries.add(new Stock("REF001", "STORE001", 10));
    }
    public List<Stock> findAll() {
        return stockEntries;
    }

    public Stock findByProductAndStore(String productRef, String storeId) {
        return stockEntries.stream()
                .filter(st -> st.getProductReference().equals(productRef) && st.getStoreId().equals(storeId))
                .findFirst()
                .orElse(null);
    }

    public void save(Stock entry) {
        Stock existing = findByProductAndStore(entry.getProductReference(), entry.getStoreId());
        if (existing != null) {
            existing.setStockQuantity(entry.getStockQuantity());
        } else {
            stockEntries.add(entry);
        }
    }

    public void delete(String productRef, String storeId) {
        stockEntries.removeIf(st -> st.getProductReference().equals(productRef) && st.getStoreId().equals(storeId));
    }
}
