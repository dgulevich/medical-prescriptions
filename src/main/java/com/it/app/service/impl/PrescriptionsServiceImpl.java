package com.it.app.service.impl;

import com.it.app.component.Validation;
import com.it.app.model.Prescription;
import com.it.app.repository.PrescriptionRepository;
import com.it.app.service.DoctorService;
import com.it.app.service.OrderService;
import com.it.app.service.PatientService;
import com.it.app.service.PrescriptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PrescriptionsServiceImpl implements PrescriptionService {

    private PrescriptionRepository prescriptionRepository;

    private DoctorService doctorService;

    private PatientService patientService;

    private OrderService orderService;

    private Validation validation;

    public PrescriptionsServiceImpl(PrescriptionRepository prescriptionRepository, DoctorService doctorService, PatientService patientService, OrderService orderService, Validation validation) {
        this.prescriptionRepository = prescriptionRepository;
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.orderService = orderService;
        this.validation = validation;
    }

    public List<Prescription> findAll() {
        return prescriptionRepository.findAll();
    }

    public Prescription findById(Long id) {
        return prescriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Prescription doesn't exist"));
    }

    public Prescription save(Prescription prescription) {
        final Long id = prescription.getId();
        validation.validate(id != null, "Transient Prescription must not have an ID");
        prescription.setUse(false);
        prescription.setDate(new Date());
        return saveAndFlush(prescription);
    }

    public Prescription update(Prescription prescription) {
        final Long id = prescription.getId();
        validation.validate(id == null, "Prescription must have an ID");
        findById(id);
        return saveAndFlush(prescription);
    }

    public void delete(Prescription prescription) {
        final Long id = prescription.getId();
        validation.validate(id == null, "Persistent Prescription must have an ID");
        findById(id);
        prescriptionRepository.delete(prescription);
    }

    public void deleteById(Long id) {
        findById(id);
        prescriptionRepository.deleteById(id);
    }

    public void use(Prescription prescription) {
        validation.validate(isPrescriptionExpired(prescription), "The prescription is not valid");
        prescription.setUse(true);
        update(prescription);
    }

    private Prescription saveAndFlush(Prescription prescription) {
        validation.validate(prescription.getDoctor() == null || prescription.getDoctor().getId() == null, "Prescription must have a Dotor");
        validation.validate(prescription.getPatient() == null || prescription.getPatient().getId() == null, "Prescription must have a Patient");
        validation.validate(prescription.getOrder() == null || prescription.getOrder().getId() == null, "Prescription must have a Oreder");
        prescription.setDoctor(doctorService.findById(prescription.getDoctor().getId()));
        prescription.setPatient(patientService.findById(prescription.getPatient().getId()));
        prescription.setOrder(orderService.findById(prescription.getOrder().getId()));
        return prescriptionRepository.saveAndFlush(prescription);
    }

    private boolean isPrescriptionExpired(Prescription prescription) {
        final Date expiration = new Date(prescription.getDate().getTime() + prescription.getPeriod()*30*24*60*60*1000);
        return expiration.after(dateNow());
    }

    private Date dateNow() {
        return new Date();
    }
}