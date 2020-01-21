package com.it.app.controller;

import com.it.app.dto.request.PrescriptionRequestDto;
import com.it.app.dto.response.PrescriptionResponseDto;
import com.it.app.model.Doctor;
import com.it.app.model.Order;
import com.it.app.model.Patient;
import com.it.app.model.Prescription;
import com.it.app.service.PrescriptionService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type Prescription controller.
 */
@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private PrescriptionService prescriptionService;

    private Mapper mapper;

    /**
     * Instantiates a new Prescription controller.
     *
     * @param prescriptionService the prescription service
     * @param mapper              the mapper
     */
    public PrescriptionController(PrescriptionService prescriptionService, Mapper mapper) {
        this.prescriptionService = prescriptionService;
        this.mapper = mapper;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<PrescriptionResponseDto>> getAll() {
        final List<Prescription> prescriptions = prescriptionService.findAll();
        final List<PrescriptionResponseDto> prescriptionResponseDtoList = prescriptions.stream()
                .map((prescription) -> mapper.map(prescription, PrescriptionResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(prescriptionResponseDtoList, HttpStatus.OK);
    }

    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionResponseDto> getOne(@PathVariable Long id) {
        final Prescription prescription = prescriptionService.findById(id);
        final PrescriptionResponseDto prescriptionResponseDto = mapper.map(prescription, PrescriptionResponseDto.class);
        return new ResponseEntity<>(prescriptionResponseDto, HttpStatus.OK);
    }

    /**
     * Save response entity.
     *
     * @param prescriptionRequestDto the prescription request dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<PrescriptionResponseDto> save(@RequestBody PrescriptionRequestDto prescriptionRequestDto) {
        prescriptionRequestDto.setId(null);
        final Prescription prescription = getPrescription(prescriptionRequestDto);
        final PrescriptionResponseDto prescriptionResponseDto = mapper.map(prescriptionService.save(prescription), PrescriptionResponseDto.class);
        return new ResponseEntity<>(prescriptionResponseDto, HttpStatus.OK);
    }

    /**
     * Update response entity.
     *
     * @param prescriptionRequestDto the prescription request dto
     * @param id                     the id
     * @return the response entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<PrescriptionResponseDto> update(@RequestBody PrescriptionRequestDto prescriptionRequestDto, @PathVariable Long id) {
        if (!Objects.equals(id, prescriptionRequestDto.getId())) throw new RuntimeException("Url param id is not equals to prescriptionId!");
        final Prescription prescription = getPrescription(prescriptionRequestDto);
        final PrescriptionResponseDto prescriptionResponseDto = mapper.map(prescriptionService.update(prescription), PrescriptionResponseDto.class);
        return new ResponseEntity<>(prescriptionResponseDto, HttpStatus.OK);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        prescriptionService.deleteById(id);
    }

    private Prescription getPrescription(PrescriptionRequestDto prescriptionRequestDto) {
        final Prescription prescription = mapper.map(prescriptionRequestDto, Prescription.class);
        final Doctor doctor = new Doctor();
        final Patient patient = new Patient();
        final Order order = new Order();
        doctor.setId(prescriptionRequestDto.getDoctorId());
        patient.setId(prescriptionRequestDto.getPatientId());
        order.setId(prescriptionRequestDto.getOrderId());
        prescription.setDoctor(doctor);
        prescription.setPatient(patient);
        prescription.setOrder(order);
        return prescription;
    }
}
