package com.it.app.controller;

import com.it.app.dto.request.PatientRequestDto;
import com.it.app.dto.response.PatientResponseDto;
import com.it.app.model.Patient;
import com.it.app.service.PatientService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type Patient controller.
 */
@RestController
@RequestMapping("/patients")
public class PatientController {

    private Mapper mapper;

    private PatientService patientService;

    /**
     * Instantiates a new Patient controller.
     *
     * @param mapper         the mapper
     * @param patientService the patient service
     */
    public PatientController(Mapper mapper, PatientService patientService) {
        this.mapper = mapper;
        this.patientService = patientService;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<PatientResponseDto>> getAll() {
        final List<Patient> patients = patientService.findAll();
        final List<PatientResponseDto> patientResponseDtoList = patients.stream()
                .map((patient) -> mapper.map(patient, PatientResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(patientResponseDtoList, HttpStatus.OK);
    }

    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDto> getOne(@PathVariable Long id) {
        final Patient patient = patientService.findById(id);
        final PatientResponseDto patientResponseDto = mapper.map(patient, PatientResponseDto.class);
        return new ResponseEntity<>(patientResponseDto, HttpStatus.OK);
    }

    /**
     * Save response entity.
     *
     * @param patientRequestDto the patient request dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<PatientResponseDto> save(@RequestBody PatientRequestDto patientRequestDto) {
        patientRequestDto.setId(null);
        final Patient patient = mapper.map(patientRequestDto, Patient.class);
        final PatientResponseDto patientResponseDto = mapper.map(patientService.save(patient), PatientResponseDto.class);
        return new ResponseEntity<>(patientResponseDto, HttpStatus.OK);
    }

    /**
     * Update response entity.
     *
     * @param patientRequestDto the patient request dto
     * @param id                the id
     * @return the response entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDto> update(@RequestBody PatientRequestDto patientRequestDto, @PathVariable Long id) {
        if (!Objects.equals(id, patientRequestDto.getId()))
            throw new RuntimeException("Url param id is not equals to patientId!");
        final Patient patient = mapper.map(patientRequestDto, Patient.class);
        final PatientResponseDto patientResponseDto = mapper.map(patientService.update(patient), PatientResponseDto.class);
        return new ResponseEntity<>(patientResponseDto, HttpStatus.OK);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        patientService.deleteById(id);
    }
}
