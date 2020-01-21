package com.it.app.service.impl;

import com.it.app.component.Validation;
import com.it.app.model.Doctor;
import com.it.app.repository.DoctorRepository;
import com.it.app.service.DoctorService;
import com.it.app.service.InstitutionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The type Doctor service.
 */
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    private Validation validation;

    private DoctorRepository doctorRepository;

    private InstitutionService institutionService;

    /**
     * Instantiates a new Doctor service.
     *
     * @param validation         the validation
     * @param doctorRepository   the doctor repository
     * @param institutionService the institution service
     */
    public DoctorServiceImpl(Validation validation, DoctorRepository doctorRepository, InstitutionService institutionService) {
        this.validation = validation;
        this.doctorRepository = doctorRepository;
        this.institutionService = institutionService;
    }

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor doesn't exist"));
    }

    public List<Doctor> findBySpecialization(String specialization) {
        return doctorRepository.findBySpecializationLikeIgnoreCase(specialization);
    }

    public List<Doctor> findByInstitutionId(Long id) {
        return doctorRepository.findByInstitution_Id(id);
    }

    public List<Doctor> findByInstitutionIdAndSpecialization(Long institutionId, String specialization) {
        return doctorRepository.findByInstitution_IdAndSpecializationLikeIgnoreCase(institutionId, specialization);
    }

    public Doctor save(Doctor doctor) {
        validation.validate(doctor.getId() != null, "Transient Doctor must not have an ID");
        return saveAndFlush(doctor);
    }

    public Doctor update(Doctor doctor) {
        final Long id = doctor.getId();
        validation.validate(id == null, "Doctor must have an ID");
        findById(id);
        return saveAndFlush(doctor);
    }

    public void delete(Doctor doctor) {
        final Long id = doctor.getId();
        validation.validate(id == null, "Persistent Doctor must have an ID");
        findById(id);
        doctorRepository.delete(doctor);
    }

    public void deleteById(Long id) {
        findById(id);
        doctorRepository.deleteById(id);
    }

    private Doctor saveAndFlush(Doctor doctor) {
        validation.validate(doctor.getInstitution() == null || doctor.getInstitution().getId() == null,"Doctor must have an Institution");
        doctor.setInstitution(institutionService.findById(doctor.getInstitution().getId()));
        return doctorRepository.saveAndFlush(doctor);
    }
}