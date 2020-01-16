package com.it.app.repository;

import com.it.app.model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

    boolean existsByName(String name);

    Pharmacy findByName(String name);
}
