package com.it.app.repository;

import com.it.app.model.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MedicamentRepository extends JpaRepository<Medicament, Long> {

    List<Medicament> findByNameIgnoreCase(String name);

    List<Medicament> findByTypeIgnoreCase(String type);

    List<Medicament> findByNameIgnoreCaseAndTypeIgnoreCase(String name, String type);

    List<Medicament> findByNameLikeIgnoreCaseAndTypeLikeIgnoreCase(String name, String type);

}
