package com.it.app.service;

import com.it.app.model.Doctor;
import com.it.app.model.Institution;

import java.util.List;

public interface DoctorService {

    List<Doctor> findAll();

    Doctor findById(Long id);

    List<Doctor> findBySpecialization(String specialization);

    public List<Doctor> findByInstitutionId(Long id);

    public List<Doctor> findByInstitutionIdAndSpecialization(Long institutionId, String specialization);

    Doctor save(Doctor doctor);

    Doctor update(Doctor doctor);

    void delete(Doctor doctor);

    void deleteById(Long id);
}
