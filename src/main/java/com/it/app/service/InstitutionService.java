package com.it.app.service;

import com.it.app.model.Doctor;
import com.it.app.model.Institution;

import javax.print.Doc;
import java.util.List;

public interface InstitutionService {

    List<Institution> findAll();

    Institution findById(Long id);

    Institution save(Institution institution);

    Institution update(Institution institution);

    void delete(Institution institution);

    void deleteById(Long id);
}
