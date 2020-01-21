package com.it.app.service;

import com.it.app.model.Doctor;
import com.it.app.model.Institution;

import java.util.List;

/**
 * The interface Doctor service.
 */
public interface DoctorService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Doctor> findAll();

    /**
     * Find by id doctor.
     *
     * @param id the id
     * @return the doctor
     */
    Doctor findById(Long id);

    /**
     * Find by specialization list.
     *
     * @param specialization the specialization
     * @return the list
     */
    List<Doctor> findBySpecialization(String specialization);

    /**
     * Find by institution id list.
     *
     * @param id the id
     * @return the list
     */
    public List<Doctor> findByInstitutionId(Long id);

    /**
     * Find by institution id and specialization list.
     *
     * @param institutionId  the institution id
     * @param specialization the specialization
     * @return the list
     */
    public List<Doctor> findByInstitutionIdAndSpecialization(Long institutionId, String specialization);

    /**
     * Save doctor.
     *
     * @param doctor the doctor
     * @return the doctor
     */
    Doctor save(Doctor doctor);

    /**
     * Update doctor.
     *
     * @param doctor the doctor
     * @return the doctor
     */
    Doctor update(Doctor doctor);

    /**
     * Delete.
     *
     * @param doctor the doctor
     */
    void delete(Doctor doctor);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);
}
