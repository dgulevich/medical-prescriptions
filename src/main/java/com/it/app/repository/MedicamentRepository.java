package com.it.app.repository;

import com.it.app.model.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Medicament repository.
 */
public interface MedicamentRepository extends JpaRepository<Medicament, Long> {

    /**
     * Find by name ignore case list.
     *
     * @param name the name
     * @return the list
     */
    List<Medicament> findByNameIgnoreCase(String name);

    /**
     * Find by type ignore case list.
     *
     * @param type the type
     * @return the list
     */
    List<Medicament> findByTypeIgnoreCase(String type);

    /**
     * Find by name like ignore case and type like ignore case list.
     *
     * @param name the name
     * @param type the type
     * @return the list
     */
    List<Medicament> findByNameLikeIgnoreCaseAndTypeLikeIgnoreCase(String name, String type);

}
