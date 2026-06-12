package com.example.enterpriseappsyassinefilali.controller;

import com.example.enterpriseappsyassinefilali.service.EvenementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DetailsController {

    private final EvenementService evenementService;

    public DetailsController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        var evenement = evenementService.getById(id);
        if (evenement.isEmpty()) {
            return "redirect:/";
        }
        model.addAttribute("evenement", evenement.get());
        return "details";
    }
}
