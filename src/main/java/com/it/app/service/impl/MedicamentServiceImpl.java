package com.it.app.service.impl;

import com.it.app.component.Validation;
import com.it.app.model.Medicament;
import com.it.app.repository.MedicamentRepository;
import com.it.app.service.MedicamentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedicamentServiceImpl implements MedicamentService {

    private MedicamentRepository medicamentRepository;

    private Validation validation;

    public MedicamentServiceImpl(MedicamentRepository medicamentRepository, Validation validation) {
        this.medicamentRepository = medicamentRepository;
        this.validation = validation;
    }

    public List<Medicament> findAll() {
        return medicamentRepository.findAll();
    }

    public Medicament findById(Long id) {
        return medicamentRepository.findById(id).orElseThrow(() -> new RuntimeException("Medicament doesn't exist"));
    }

    public List<Medicament> findByName(String name) {
        return medicamentRepository.findByNameIgnoreCase(name);
    }

    public List<Medicament> findByType(String type) {
        return medicamentRepository.findByTypeIgnoreCase(type);
    }

    public List<Medicament> findByNameAndType(String name, String type) {
        return medicamentRepository.findByNameLikeIgnoreCaseAndTypeLikeIgnoreCase(name, type);
    }

    public Medicament save(Medicament medicament) {
        validation.validate(medicament.getId() != null, "Transient Medicament must not have an ID");
        return medicamentRepository.saveAndFlush(medicament);
    }

    public Medicament update(Medicament medicament) {
        final Long id = medicament.getId();
        validation.validate(id == null, "Medicament must have an ID");
        findById(id);
        return medicamentRepository.saveAndFlush(medicament);
    }

    public void delete(Medicament medicament) {
        final Long id = medicament.getId();
        validation.validate(id == null,"Persistent Medicament must have an ID ");
        findById(id);
        medicamentRepository.delete(medicament);
    }

    public void deleteById(Long id) {
        findById(id);
        medicamentRepository.deleteById(id);
    }
}