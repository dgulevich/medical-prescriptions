package com.it.app.service;

import com.it.app.model.Patient;

import java.util.List;

/**
 * The interface Patient service.
 */
public interface PatientService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Patient> findAll();

    /**
     * Find by id patient.
     *
     * @param id the id
     * @return the patient
     */
    Patient findById(Long id);

    /**
     * Save patient.
     *
     * @param patient the patient
     * @return the patient
     */
    Patient save(Patient patient);

    /**
     * Update patient.
     *
     * @param patient the patient
     * @return the patient
     */
    Patient update(Patient patient);

    /**
     * Delete.
     *
     * @param patient the patient
     */
    void delete(Patient patient);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);
}
