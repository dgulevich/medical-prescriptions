package com.it.app.service;

import com.it.app.model.Existence;

import java.util.List;

/**
 * The interface Existence service.
 */
public interface ExistenceService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Existence> findAll();

    /**
     * Find by id existence.
     *
     * @param id the id
     * @return the existence
     */
    Existence findById(Long id);

    /**
     * Find by pharmacy list.
     *
     * @param pharmacyId the pharmacy id
     * @return the list
     */
    List<Existence> findByPharmacy(Long pharmacyId);

    /**
     * Find by medicament list.
     *
     * @param medicamentId the medicament id
     * @return the list
     */
    List<Existence> findByMedicament(Long medicamentId);

    /**
     * Find by pharmacy and medicament list.
     *
     * @param pharmacyId   the pharmacy id
     * @param medicamentId the medicament id
     * @return the list
     */
    List<Existence> findByPharmacyAndMedicament(Long pharmacyId, Long medicamentId);

    /**
     * Save existence.
     *
     * @param existence the existence
     * @return the existence
     */
    Existence save(Existence existence);

    /**
     * Update existence.
     *
     * @param existence the existence
     * @return the existence
     */
    Existence update(Existence existence);

    /**
     * Delete.
     *
     * @param existence the existence
     */
    void delete(Existence existence);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);
}
