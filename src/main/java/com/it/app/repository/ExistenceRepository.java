package com.it.app.repository;

import com.it.app.model.Existence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExistenceRepository extends JpaRepository<Existence, Long> {

    List<Existence> findByPharmacy_Id(Long pharmacyId);

    List<Existence> findByMedicament_Id(Long medicamentId);

    List<Existence> findByPharmacy_IdAndMedicament_Id(Long pharmacyId, Long medicamentId);
}
