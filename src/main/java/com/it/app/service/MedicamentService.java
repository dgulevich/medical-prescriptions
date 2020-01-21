package com.it.app.service;

import com.it.app.model.Medicament;

import java.util.List;
import java.util.Optional;

/**
 * The interface Medicament service.
 */
public interface MedicamentService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Medicament> findAll();

    /**
     * Find by id medicament.
     *
     * @param id the id
     * @return the medicament
     */
    Medicament findById(Long id);

    /**
     * Find by name and type list.
     *
     * @param name the name
     * @param type the type
     * @return the list
     */
    List<Medicament> findByNameAndType(String name, String type);

    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     */
    List<Medicament> findByName(String name);

    /**
     * Find by type list.
     *
     * @param type the type
     * @return the list
     */
    List<Medicament> findByType(String type);

    /**
     * Save medicament.
     *
     * @param medicament the medicament
     * @return the medicament
     */
    Medicament save(Medicament medicament);

    /**
     * Update medicament.
     *
     * @param medicament the medicament
     * @return the medicament
     */
    Medicament update(Medicament medicament);

    /**
     * Delete.
     *
     * @param medicament the medicament
     */
    void delete(Medicament medicament);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);
}
