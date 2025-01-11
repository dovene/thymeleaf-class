package com.example.hellothym.model;

import jakarta.validation.constraints.NotBlank;

public class Store {
    @NotBlank(message = "L'identifiant est obligatoire")
    private String id;       
    @NotBlank(message = "L'adresse est obligatoire")
    private String address;
    @NotBlank(message = "Le numéro de téléphone est obligatoire")
    private String phoneNumber;

    public Store() {
    }

    public Store(String id, String address, String phoneNumber) {
        this.id = id;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
