package com.it.app.service;

import com.it.app.model.Prescription;

import java.util.List;

public interface PrescriptionService {

    List<Prescription> findAll();

    Prescription findById(Long id);

    Prescription save(Prescription prescription);

    Prescription update(Prescription prescription);

    void delete(Prescription prescription);

    void deleteById(Long id);
}
