
package com.example.hellothym.service;
import org.springframework.stereotype.Service;

import com.example.hellothym.model.Store;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    private static final List<Store> stores = new ArrayList<>();

    public List<Store> findAll() {
        return stores;
    }

    public Store findById(String id) {
        return stores.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(Store store) {
        Store existing = findById(store.getId());
        if (existing != null) {
            existing.setAddress(store.getAddress());
            existing.setPhoneNumber(store.getPhoneNumber());
        } else {
            stores.add(store);
        }
    }

    public void deleteById(String id) {
        stores.removeIf(s -> s.getId().equals(id));
    }
}
