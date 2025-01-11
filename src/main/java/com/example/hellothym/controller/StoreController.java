package com.example.hellothym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.hellothym.model.Store;
import com.example.hellothym.service.StoreService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public String listStores(Model model) {
        model.addAttribute("stores", storeService.findAll());
        return "store/list";
    }

    @GetMapping("/add")
    public String addStoreForm(Model model) {
        model.addAttribute("isEditMode", false);
        model.addAttribute("store", new Store());
        return "store/form";
    }

    @GetMapping("/edit/{id}")
    public String editStoreForm(@PathVariable String id, Model model) {
        Store store = storeService.findById(id);
        if (store == null) {
            return "redirect:/stores";
        }
        model.addAttribute("isEditMode", true);
        model.addAttribute("store", store);
        return "store/form";
    }

    @PostMapping
    public String saveStore(@Valid @ModelAttribute("store") Store store, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("isEditMode", storeService.findById(store.getId()) != null);
            return "store/form";
        }
        storeService.save(store);
        return "redirect:/stores";
    }

    @GetMapping("/delete/{id}")
    public String deleteStore(@PathVariable String id) {
        storeService.deleteById(id);
        return "redirect:/stores";
    }
}
