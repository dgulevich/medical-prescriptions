package com.it.app.repository;

import com.it.app.model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Pharmacy repository.
 */
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

    /**
     * Exists by name boolean.
     *
     * @param name the name
     * @return the boolean
     */
    boolean existsByName(String name);

    /**
     * Find by name pharmacy.
     *
     * @param name the name
     * @return the pharmacy
     */
    Pharmacy findByName(String name);
}
