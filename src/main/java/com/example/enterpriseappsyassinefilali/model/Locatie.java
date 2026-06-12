package com.example.enterpriseappsyassinefilali.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Locatie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String naam;

    @NotBlank
    private String adres;

    @Positive
    private int capaciteit;

    public Locatie() {}

    public Locatie(String naam, String adres, int capaciteit) {
        this.naam = naam;
        this.adres = adres;
        this.capaciteit = capaciteit;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNaam() { return naam; }
    public void setNaam(String naam) { this.naam = naam; }
    public String getAdres() { return adres; }
    public void setAdres(String adres) { this.adres = adres; }
    public int getCapaciteit() { return capaciteit; }
    public void setCapaciteit(int capaciteit) { this.capaciteit = capaciteit; }
}
