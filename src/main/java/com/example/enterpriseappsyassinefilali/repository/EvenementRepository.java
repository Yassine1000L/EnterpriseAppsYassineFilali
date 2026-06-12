package com.example.enterpriseappsyassinefilali.repository;

import com.example.enterpriseappsyassinefilali.model.Evenement;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface EvenementRepository extends CrudRepository<Evenement, Long> {
    List<Evenement> findTop10ByOrderByTijdstipDesc();
}
