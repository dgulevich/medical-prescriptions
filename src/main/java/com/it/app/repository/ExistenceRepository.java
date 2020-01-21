package com.it.app.repository;

import com.it.app.model.Existence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Existence repository.
 */
public interface ExistenceRepository extends JpaRepository<Existence, Long> {

    /**
     * Find by pharmacy id list.
     *
     * @param pharmacyId the pharmacy id
     * @return the list
     */
    List<Existence> findByPharmacy_Id(Long pharmacyId);

    /**
     * Find by medicament id list.
     *
     * @param medicamentId the medicament id
     * @return the list
     */
    List<Existence> findByMedicament_Id(Long medicamentId);

    /**
     * Find by pharmacy id and medicament id list.
     *
     * @param pharmacyId   the pharmacy id
     * @param medicamentId the medicament id
     * @return the list
     */
    List<Existence> findByPharmacy_IdAndMedicament_Id(Long pharmacyId, Long medicamentId);
}
