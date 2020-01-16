package com.it.app.repository;

import com.it.app.model.Doctor;
import com.it.app.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    boolean existsByName(String name);

    Institution findByName(String name);
}
