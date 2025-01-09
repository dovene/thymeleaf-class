package com.example.hellothym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.hellothym.model.Store;
import com.example.hellothym.service.StoreService;

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
        model.addAttribute("store", new Store());
        return "store/form";
    }

    @GetMapping("/edit/{id}")
    public String editStoreForm(@PathVariable String id, Model model) {
        Store st = storeService.findById(id);
        if (st == null) {
            return "redirect:/stores";
        }
        model.addAttribute("store", st);
        return "store/form";
    }

    @PostMapping
    public String saveStore(@ModelAttribute("store") Store store) {
        storeService.save(store);
        return "redirect:/stores";
    }

    @GetMapping("/delete/{id}")
    public String deleteStore(@PathVariable String id) {
        storeService.deleteById(id);
        return "redirect:/stores";
    }
}
