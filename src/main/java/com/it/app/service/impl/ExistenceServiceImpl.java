package com.it.app.service.impl;

import com.it.app.component.Validation;
import com.it.app.model.Existence;
import com.it.app.repository.ExistenceRepository;
import com.it.app.service.ExistenceService;
import com.it.app.service.MedicamentService;
import com.it.app.service.PharmacyService;
import com.it.app.service.PrescriptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The type Existence service.
 */
@Service
@Transactional
public class ExistenceServiceImpl implements ExistenceService {

    private ExistenceRepository existenceRepository;

    private PharmacyService pharmacyService;

    private MedicamentService medicamentService;

    private PrescriptionService prescriptionService;

    private Validation validation;

    /**
     * Instantiates a new Existence service.
     *
     * @param existenceRepository the existence repository
     * @param pharmacyService     the pharmacy service
     * @param medicamentService   the medicament service
     * @param validation          the validation
     */
    public ExistenceServiceImpl(ExistenceRepository existenceRepository, PharmacyService pharmacyService, MedicamentService medicamentService, Validation validation) {
        this.existenceRepository = existenceRepository;
        this.pharmacyService = pharmacyService;
        this.medicamentService = medicamentService;
        this.validation = validation;
    }

    public List<Existence> findAll() {
        return existenceRepository.findAll();
    }

    public Existence findById(Long id) {
        return existenceRepository.findById(id).orElseThrow(() -> new RuntimeException("Existance doesn't exist"));
    }

    public List<Existence> findByPharmacy(Long pharmacyId) {
        return existenceRepository.findByPharmacy_Id(pharmacyId);
    }

    public List<Existence> findByMedicament(Long medicametId) {
        return existenceRepository.findByMedicament_Id(medicametId);
    }

    public List<Existence> findByPharmacyAndMedicament(Long pharmacyId, Long medicamentId) {
        return existenceRepository.findByPharmacy_IdAndMedicament_Id(pharmacyId, medicamentId);
    }

    public Existence save(Existence existence) {
        validation.validate(existence.getId() != null, "Transient Existance must not have an ID");
        return saveAndFlush(existence);
    }

    public Existence update(Existence existence) {
        final Long id = existence.getId();
        validation.validate(id == null, "Existance must have an ID");
        findById(id);
        return saveAndFlush(existence);
    }

    public void delete(Existence existence) {
        final Long id = existence.getId();
        validation.validate(id == null, "Persistent Existance must have an ID ");
        findById(id);
        existenceRepository.delete(existence);
    }

    public void deleteById(Long id) {
        findById(id);
        existenceRepository.deleteById(id);
    }

    /**
     * Sale existence.
     *
     * @param existence the existence
     * @param volume    the volume
     * @return the existence
     */
    public Existence sale(Existence existence, Integer volume) {
        Integer count = (volume % existence.getVolume()) > 0 ? (volume / existence.getVolume() + 1) : volume / existence.getVolume();
        existence.setCount(existence.getCount() - count);
        return update(existence);
    }

    private Existence saveAndFlush(Existence existence) {
        validation.validate(existence.getPharmacy() == null || existence.getPharmacy().getId() == null, "Existence must have a Pharmacy");
        validation.validate(existence.getMedicament() == null || existence.getMedicament().getId() == null, "Existence must have a Medicament");
        existence.setPharmacy(pharmacyService.findById(existence.getPharmacy().getId()));
        existence.setMedicament(medicamentService.findById(existence.getMedicament().getId()));
        return existenceRepository.saveAndFlush(existence);
    }
}