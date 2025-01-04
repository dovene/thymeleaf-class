package com.example.hellothym;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hellothym.model.Person;

@Controller
public class HelloController {
    
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "John Doe");
        model.addAttribute("person", new Person("Doe", "John", 30, null, "1234", "Developer", LocalDate.now(), 100000.0));
        model.addAttribute("persons", new Person[] {
            new Person("Doe", "John", 30, "123 Elm St", "1234", "Developer", LocalDate.now(), 100000.0),
            new Person("Smith", "Jane", 25, "456 Oak St", "5678", "Manager", LocalDate.now(), 150000.0),
            new Person("Jones", "Jim", 35, "789 Pine St", "9101", "Director", LocalDate.now(), 200000.0)
        });
        return "hello";
    }
}