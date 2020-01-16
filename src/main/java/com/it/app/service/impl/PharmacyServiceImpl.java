package com.it.app.service.impl;

import com.it.app.component.Validation;
import com.it.app.model.Pharmacy;
import com.it.app.repository.PharmacyRepository;
import com.it.app.service.PharmacyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class PharmacyServiceImpl implements PharmacyService {

    private Validation validation;

    private PharmacyRepository pharmacyRepository;

    public PharmacyServiceImpl(Validation validation, PharmacyRepository pharmacyRepository) {
        this.validation = validation;
        this.pharmacyRepository = pharmacyRepository;
    }

    public List<Pharmacy> findAll() {
        return pharmacyRepository.findAll();
    }

    public Pharmacy findById(Long id) {
        return pharmacyRepository.findById(id).orElseThrow(() -> new RuntimeException("Pharmacy doesn't exist"));
    }

    public Pharmacy save(Pharmacy pharmacy) {
        validation.validate(pharmacy.getId() != null, "Transient Pharmacy must not have an ID");
        validation.validate(pharmacyRepository.existsByName(pharmacy.getName()), "Pharmacy name is not unique");
        return pharmacyRepository.saveAndFlush(pharmacy);
    }

    public Pharmacy update(Pharmacy pharmacy) {
        final Long id = pharmacy.getId();
        validation.validate(id == null, "Pharmacy must have an ID");
        final Pharmacy duplicatePharmacy = pharmacyRepository.findByName(pharmacy.getName());
        final boolean isDuplicateExist = duplicatePharmacy != null && !Objects.equals(duplicatePharmacy.getId(), id);
        validation.validate(isDuplicateExist,"Pharmacy name is not unique");
        return pharmacyRepository.saveAndFlush(pharmacy);
    }

    public void delete(Pharmacy pharmacy) {
        final Long id = pharmacy.getId();
        validation.validate(id == null, "Persistent Pharmacy must have an ID");
        findById(id);
        pharmacyRepository.delete(pharmacy);
    }

    public void deleteById(Long id) {
        findById(id);
        pharmacyRepository.deleteById(id);
    }
}
