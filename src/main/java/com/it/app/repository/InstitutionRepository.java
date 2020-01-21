package com.it.app.repository;

import com.it.app.model.Doctor;
import com.it.app.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Institution repository.
 */
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    /**
     * Exists by name boolean.
     *
     * @param name the name
     * @return the boolean
     */
    boolean existsByName(String name);

    /**
     * Find by name institution.
     *
     * @param name the name
     * @return the institution
     */
    Institution findByName(String name);
}
