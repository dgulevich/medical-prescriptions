package com.it.app.service;

import com.it.app.model.Pharmacy;

import java.util.List;

/**
 * The interface Pharmacy service.
 */
public interface PharmacyService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Pharmacy> findAll();

    /**
     * Find by id pharmacy.
     *
     * @param id the id
     * @return the pharmacy
     */
    Pharmacy findById(Long id);

    /**
     * Save pharmacy.
     *
     * @param pharmacy the pharmacy
     * @return the pharmacy
     */
    Pharmacy save(Pharmacy pharmacy);

    /**
     * Update pharmacy.
     *
     * @param pharmacy the pharmacy
     * @return the pharmacy
     */
    Pharmacy update(Pharmacy pharmacy);

    /**
     * Delete.
     *
     * @param pharmacy the pharmacy
     */
    void delete(Pharmacy pharmacy);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);
}
