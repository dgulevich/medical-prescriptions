package com.it.app.service.impl;

import com.it.app.component.Validation;
import com.it.app.model.Doctor;
import com.it.app.model.Institution;
import com.it.app.repository.InstitutionRepository;
import com.it.app.service.DoctorService;
import com.it.app.service.InstitutionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.print.Doc;
import java.util.List;
import java.util.Objects;

/**
 * The type Institution service.
 */
@Service
@Transactional
public class InstitutionServiceImpl implements InstitutionService {

    private InstitutionRepository institutionRepository;

    private DoctorService doctorService;

    private Validation validation;

    /**
     * Instantiates a new Institution service.
     *
     * @param institutionRepository the institution repository
     * @param validation            the validation
     */
    public InstitutionServiceImpl(InstitutionRepository institutionRepository, Validation validation) {
        this.institutionRepository = institutionRepository;
        this.validation = validation;
    }

    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    public Institution findById(Long id) {
        return institutionRepository.findById(id).orElseThrow(() -> new RuntimeException("Institution doesn't exist"));
    }

    public Institution save(Institution institution) {
        validation.validate(institution.getId() != null, "Transient Institution must not have an ID");
        validation.validate(institutionRepository.existsByName(institution.getName()), "Institution name is not unique");
        return institutionRepository.saveAndFlush(institution);
    }

    public Institution update(Institution institution) {
        final Long id = institution.getId();
        validation.validate(id == null, "Institution must have an ID");
        final Institution duplicateInstitution = institutionRepository.findByName(institution.getName());
        final boolean isDuplicateExists = duplicateInstitution != null && !Objects.equals(duplicateInstitution.getId(), id);
        validation.validate(isDuplicateExists, "Institution name is not unique");
        return institutionRepository.saveAndFlush(institution);
    }

    public void delete(Institution institution) {
        final Long id = institution.getId();
        validation.validate(id == null, "Institution must have an ID");
        findById(id);
        institutionRepository.delete(institution);
    }

    public void deleteById(Long id) {
        findById(id);
        institutionRepository.deleteById(id);
    }
}