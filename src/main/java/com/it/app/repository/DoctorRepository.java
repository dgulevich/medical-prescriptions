package com.it.app.repository;

import com.it.app.model.Doctor;
import com.it.app.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Doctor findByName(String name);

    List<Doctor> findBySpecializationLikeIgnoreCase(String specialization);

    List<Doctor> findByInstitution_Id(Long id);

    List<Doctor> findByInstitution_IdAndSpecializationLikeIgnoreCase(Long institutionId, String specialization);
}
