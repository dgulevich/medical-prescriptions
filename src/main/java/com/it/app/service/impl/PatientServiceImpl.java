package com.it.app.service.impl;

import com.it.app.component.Validation;
import com.it.app.model.Patient;
import com.it.app.repository.PatientRepository;
import com.it.app.service.PatientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The type Patient service.
 */
@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    private Validation validation;

    /**
     * Instantiates a new Patient service.
     *
     * @param patientRepository the patient repository
     * @param validation        the validation
     */
    public PatientServiceImpl(PatientRepository patientRepository, Validation validation) {
        this.patientRepository = patientRepository;
        this.validation = validation;
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient findById(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient doesn't exist"));
    }

    public Patient save(Patient patient) {
        validation.validate(patient.getId() != null, "Transient Patient must not have an ID");
        return patientRepository.saveAndFlush(patient);
    }

    public Patient update(Patient patient) {
        final Long id = patient.getId();
        validation.validate(id == null, "Patient must have an ID");
        findById(id);
        return patientRepository.saveAndFlush(patient);
    }

    public void delete(Patient patient) {
        final Long id = patient.getId();
        validation.validate(id == null, "Persistent Patient must have an ID");
        findById(id);
        patientRepository.delete(patient);
    }

    public void deleteById(Long id) {
        findById(id);
        patientRepository.deleteById(id);
    }
}