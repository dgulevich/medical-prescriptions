package com.it.app.service;

import com.it.app.model.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> findAll();

    Patient findById(Long id);

    Patient save(Patient patient);

    Patient update(Patient patient);

    void delete(Patient patient);

    void deleteById(Long id);
}
