package com.example.enterpriseappsyassinefilali.controller;

import com.example.enterpriseappsyassinefilali.service.EvenementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final EvenementService evenementService;

    public IndexController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("evenementen", evenementService.getLaatste10());
        return "index";
    }
}
