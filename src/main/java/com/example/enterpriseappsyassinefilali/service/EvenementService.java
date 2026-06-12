package com.example.enterpriseappsyassinefilali.service;

import com.example.enterpriseappsyassinefilali.model.Evenement;
import com.example.enterpriseappsyassinefilali.repository.EvenementRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EvenementService {

    private final EvenementRepository evenementRepository;

    public EvenementService(EvenementRepository evenementRepository) {
        this.evenementRepository = evenementRepository;
    }

    public List<Evenement> getLaatste10() {
        return evenementRepository.findTop10ByOrderByTijdstipDesc();
    }

    public Optional<Evenement> getById(Long id) {
        return evenementRepository.findById(id);
    }

    public Evenement opslaan(Evenement evenement) {
        return evenementRepository.save(evenement);
    }
}
