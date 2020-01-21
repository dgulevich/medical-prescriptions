package com.it.app.repository;

import com.it.app.model.Doctor;
import com.it.app.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * The interface Doctor repository.
 */
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    /**
     * Find by name doctor.
     *
     * @param name the name
     * @return the doctor
     */
    Doctor findByName(String name);

    /**
     * Find by specialization like ignore case list.
     *
     * @param specialization the specialization
     * @return the list
     */
    List<Doctor> findBySpecializationLikeIgnoreCase(String specialization);

    /**
     * Find by institution id list.
     *
     * @param id the id
     * @return the list
     */
    List<Doctor> findByInstitution_Id(Long id);

    /**
     * Find by institution id and specialization like ignore case list.
     *
     * @param institutionId  the institution id
     * @param specialization the specialization
     * @return the list
     */
    List<Doctor> findByInstitution_IdAndSpecializationLikeIgnoreCase(Long institutionId, String specialization);
}
