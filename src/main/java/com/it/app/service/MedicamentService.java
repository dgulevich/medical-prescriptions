package com.it.app.service;

import com.it.app.model.Medicament;

import java.util.List;
import java.util.Optional;

public interface MedicamentService {

    List<Medicament> findAll();

    Medicament findById(Long id);

    List<Medicament> findByNameAndType(String name, String type);

    List<Medicament> findByName(String name);

    List<Medicament> findByType(String type);

    Medicament save(Medicament medicament);

    Medicament update(Medicament medicament);

    void delete(Medicament medicament);

    void deleteById(Long id);
}
