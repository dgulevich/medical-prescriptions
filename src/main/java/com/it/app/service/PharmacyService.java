package com.it.app.service;

import com.it.app.model.Pharmacy;

import java.util.List;

public interface PharmacyService {

    List<Pharmacy> findAll();

    Pharmacy findById(Long id);

    Pharmacy save(Pharmacy pharmacy);

    Pharmacy update(Pharmacy pharmacy);

    void delete(Pharmacy pharmacy);

    void deleteById(Long id);
}
