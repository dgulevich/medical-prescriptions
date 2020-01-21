package com.it.app.repository;

import com.it.app.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Prescription repository.
 */
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
