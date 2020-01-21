package com.it.app.service;

import com.it.app.model.Prescription;

import java.util.List;

/**
 * The interface Prescription service.
 */
public interface PrescriptionService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Prescription> findAll();

    /**
     * Find by id prescription.
     *
     * @param id the id
     * @return the prescription
     */
    Prescription findById(Long id);

    /**
     * Save prescription.
     *
     * @param prescription the prescription
     * @return the prescription
     */
    Prescription save(Prescription prescription);

    /**
     * Update prescription.
     *
     * @param prescription the prescription
     * @return the prescription
     */
    Prescription update(Prescription prescription);

    /**
     * Delete.
     *
     * @param prescription the prescription
     */
    void delete(Prescription prescription);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);
}
