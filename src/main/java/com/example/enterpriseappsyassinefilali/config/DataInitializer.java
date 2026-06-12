package com.example.enterpriseappsyassinefilali.config;

import com.example.enterpriseappsyassinefilali.model.Evenement;
import com.example.enterpriseappsyassinefilali.model.Locatie;
import com.example.enterpriseappsyassinefilali.repository.EvenementRepository;
import com.example.enterpriseappsyassinefilali.repository.LocatieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    private final LocatieRepository locatieRepository;
    private final EvenementRepository evenementRepository;

    public DataInitializer(LocatieRepository locatieRepository, EvenementRepository evenementRepository) {
        this.locatieRepository = locatieRepository;
        this.evenementRepository = evenementRepository;
    }

    @Override
    public void run(String... args) {
        Locatie l1 = locatieRepository.save(new Locatie("Campus Kaai", "Nijverheidskaai 170, 1070 Anderlecht", 150));
        Locatie l2 = locatieRepository.save(new Locatie("Gemeenschapscentrum De Pianofabriek", "Fortstraat 33, 1060 Sint-Gillis", 80));
        Locatie l3 = locatieRepository.save(new Locatie("Park van Vorst", "Volksplein, 1190 Vorst", 200));

        evenementRepository.save(maakEvenement("Buurtfeest Zomer 2026", "Groot buurtfeest met muziek, eten en spelletjes voor jong en oud.", "Eigen beheer", "info@ngo-anderlecht.be", l1, LocalDateTime.of(2026, 7, 15, 14, 0)));
        evenementRepository.save(maakEvenement("Workshop Gezond Koken", "Leer goedkope en gezonde maaltijden bereiden met basisproducten.", "Eigen beheer", "koken@ngo-anderlecht.be", l2, LocalDateTime.of(2026, 6, 10, 10, 0)));
        evenementRepository.save(maakEvenement("Kledinginzameling", "Breng je oude kleding en doneer aan mensen in nood.", "Partner: Caritas", "caritas@partner.be", l1, LocalDateTime.of(2026, 5, 20, 9, 0)));
        evenementRepository.save(maakEvenement("Taallessen Nederlands", "Gratis Nederlandse taallessen voor nieuwkomers.", "Eigen beheer", "taal@ngo-anderlecht.be", l2, LocalDateTime.of(2026, 6, 1, 18, 0)));
        evenementRepository.save(maakEvenement("Repair Café", "Kapotte spullen? Onze vrijwilligers helpen je gratis herstellen.", "Eigen beheer", "repair@ngo-anderlecht.be", l3, LocalDateTime.of(2026, 5, 5, 13, 0)));
        evenementRepository.save(maakEvenement("Jobbeurs Anderlecht", "Ontmoet lokale werkgevers en vind een job.", "Partner: VDAB", "vdab@partner.be", l1, LocalDateTime.of(2026, 9, 12, 10, 0)));
        evenementRepository.save(maakEvenement("Kindermiddag Spelletjes", "Een namiddag vol spelletjes en plezier voor kinderen.", "Eigen beheer", "kinderen@ngo-anderlecht.be", l3, LocalDateTime.of(2026, 8, 8, 14, 0)));
        evenementRepository.save(maakEvenement("Infosessie Energietoelage", "Kom te weten welke energietoelagen er bestaan en hoe je ze aanvraagt.", "Partner: OCMW Anderlecht", "ocmw@anderlecht.be", l2, LocalDateTime.of(2026, 4, 18, 19, 0)));
        evenementRepository.save(maakEvenement("Solidariteitswandeling", "Wandel mee voor het goede doel, langs de mooiste plekjes van Anderlecht.", "Eigen beheer", "wandeling@ngo-anderlecht.be", l3, LocalDateTime.of(2026, 10, 3, 9, 0)));
        evenementRepository.save(maakEvenement("Hulp bij Digitale Toegang", "Krijg gratis hulp met je smartphone, computer of online administratie.", "Eigen beheer", "digitaal@ngo-anderlecht.be", l1, LocalDateTime.of(2026, 5, 12, 10, 0)));
        evenementRepository.save(maakEvenement("Kerstmarkt 2026", "Gezellige kerstmarkt met lokale kraampjes en warme dranken.", "Eigen beheer", "kerst@ngo-anderlecht.be", l3, LocalDateTime.of(2026, 12, 19, 16, 0)));
        evenementRepository.save(maakEvenement("Sportdag voor Iedereen", "Een dag vol sport en beweging, toegankelijk voor alle leeftijden.", "Partner: Sport Vlaanderen", "sport@sportvlaanderen.be", l1, LocalDateTime.of(2026, 6, 28, 10, 0)));
    }

    private Evenement maakEvenement(String titel, String omschrijving, String organisatie, String mail, Locatie locatie, LocalDateTime tijdstip) {
        Evenement e = new Evenement();
        e.setTitel(titel);
        e.setOmschrijving(omschrijving);
        e.setOrganisatie(organisatie);
        e.setMailContactpersoon(mail);
        e.setLocatie(locatie);
        e.setTijdstip(tijdstip);
        return e;
    }
}
