package com.example.enterpriseappsyassinefilali.controller;

import com.example.enterpriseappsyassinefilali.model.ContactBericht;
import jakarta.mail.internet.MimeMessage;
import jakarta.validation.Valid;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    private final JavaMailSender mailSender;

    public ContactController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @GetMapping("/contact")
    public String showForm(Model model) {
        model.addAttribute("contactBericht", new ContactBericht());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitForm(@Valid ContactBericht bericht, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "contact";
        }
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo("info@ngo-anderlecht.be");
            helper.setReplyTo(bericht.getEmail());
            helper.setSubject("Contactformulier: " + bericht.getOnderwerp());
            helper.setText("Naam: " + bericht.getNaam() + "\nEmail: " + bericht.getEmail()
                + "\n\nBericht:\n" + bericht.getBericht());
            mailSender.send(message);
            model.addAttribute("succes", true);
        } catch (Exception e) {
            model.addAttribute("error", true);
        }
        model.addAttribute("contactBericht", new ContactBericht());
        return "contact";
    }
}
