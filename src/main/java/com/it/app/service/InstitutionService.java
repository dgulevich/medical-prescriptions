package com.it.app.service;

import com.it.app.model.Doctor;
import com.it.app.model.Institution;

import javax.print.Doc;
import java.util.List;

/**
 * The interface Institution service.
 */
public interface InstitutionService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Institution> findAll();

    /**
     * Find by id institution.
     *
     * @param id the id
     * @return the institution
     */
    Institution findById(Long id);

    /**
     * Save institution.
     *
     * @param institution the institution
     * @return the institution
     */
    Institution save(Institution institution);

    /**
     * Update institution.
     *
     * @param institution the institution
     * @return the institution
     */
    Institution update(Institution institution);

    /**
     * Delete.
     *
     * @param institution the institution
     */
    void delete(Institution institution);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);
}
