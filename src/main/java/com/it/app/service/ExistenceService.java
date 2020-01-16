package com.it.app.service;

import com.it.app.model.Existence;

import java.util.List;

public interface ExistenceService {

    List<Existence> findAll();

    Existence findById(Long id);

    List<Existence> findByPharmacy(Long pharmacyId);

    List<Existence> findByMedicament(Long medicamentId);

    List<Existence> findByPharmacyAndMedicament(Long pharmacyId, Long medicamentId);

    Existence save(Existence existence);

    Existence update(Existence existence);

    void delete(Existence existence);

    void deleteById(Long id);
}
