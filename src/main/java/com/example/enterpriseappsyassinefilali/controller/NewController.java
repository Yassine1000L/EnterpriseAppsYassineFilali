package com.example.enterpriseappsyassinefilali.controller;

import com.example.enterpriseappsyassinefilali.model.Evenement;
import com.example.enterpriseappsyassinefilali.repository.LocatieRepository;
import com.example.enterpriseappsyassinefilali.service.EvenementService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewController {

    private final EvenementService evenementService;
    private final LocatieRepository locatieRepository;

    public NewController(EvenementService evenementService, LocatieRepository locatieRepository) {
        this.evenementService = evenementService;
        this.locatieRepository = locatieRepository;
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("evenement", new Evenement());
        model.addAttribute("locaties", locatieRepository.findAll());
        return "new";
    }

    @PostMapping("/new")
    public String submitForm(@Valid Evenement evenement, BindingResult result, Model model) {
        if (evenement.getLocatieId() == null) {
            result.rejectValue("locatieId", "NotNull", "Locatie is verplicht");
        }
        if (result.hasErrors()) {
            model.addAttribute("locaties", locatieRepository.findAll());
            return "new";
        }
        locatieRepository.findById(evenement.getLocatieId())
            .ifPresent(evenement::setLocatie);
        evenementService.opslaan(evenement);
        return "redirect:/?succes=toegevoegd";
    }
}
