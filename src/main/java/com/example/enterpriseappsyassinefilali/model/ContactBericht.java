package com.example.enterpriseappsyassinefilali.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ContactBericht {

    @NotBlank
    private String naam;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String onderwerp;

    @NotBlank
    private String bericht;

    public String getNaam() { return naam; }
    public void setNaam(String naam) { this.naam = naam; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getOnderwerp() { return onderwerp; }
    public void setOnderwerp(String onderwerp) { this.onderwerp = onderwerp; }
    public String getBericht() { return bericht; }
    public void setBericht(String bericht) { this.bericht = bericht; }
}
