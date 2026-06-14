package com.example.enterpriseappsyassinefilali.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;

@Entity
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime tijdstip;

    @NotBlank
    private String titel;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String omschrijving;

    @NotBlank
    private String organisatie;

    @NotBlank
    @Email
    private String mailContactpersoon;

    @ManyToOne
    @JoinColumn(name = "locatie_id")
    private Locatie locatie;

    @Transient
    @NotNull
    @Positive
    private Long locatieId;

    public Evenement() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getTijdstip() { return tijdstip; }
    public void setTijdstip(LocalDateTime tijdstip) { this.tijdstip = tijdstip; }
    public String getTitel() { return titel; }
    public void setTitel(String titel) { this.titel = titel; }
    public String getOmschrijving() { return omschrijving; }
    public void setOmschrijving(String omschrijving) { this.omschrijving = omschrijving; }
    public String getOrganisatie() { return organisatie; }
    public void setOrganisatie(String organisatie) { this.organisatie = organisatie; }
    public String getMailContactpersoon() { return mailContactpersoon; }
    public void setMailContactpersoon(String mailContactpersoon) { this.mailContactpersoon = mailContactpersoon; }
    public Locatie getLocatie() { return locatie; }
    public void setLocatie(Locatie locatie) { this.locatie = locatie; }
    public Long getLocatieId() { return locatieId; }
    public void setLocatieId(Long locatieId) { this.locatieId = locatieId; }
}
