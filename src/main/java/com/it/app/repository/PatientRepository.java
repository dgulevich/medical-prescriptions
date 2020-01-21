package com.it.app.repository;

import com.it.app.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Patient repository.
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
