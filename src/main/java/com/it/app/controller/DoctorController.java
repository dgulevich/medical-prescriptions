package com.it.app.controller;

import com.it.app.dto.request.DoctorRequestDto;
import com.it.app.dto.response.DoctorResponseDto;
import com.it.app.model.Doctor;
import com.it.app.model.Institution;
import com.it.app.service.DoctorService;
import com.it.app.service.InstitutionService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private Mapper mapper;

    private DoctorService doctorService;

    private InstitutionService institutionService;

    public DoctorController(Mapper mapper, DoctorService doctorService, InstitutionService institutionService) {
        this.mapper = mapper;
        this.doctorService = doctorService;
        this.institutionService = institutionService;
    }

/*    @GetMapping
    public ResponseEntity<List<DoctorResponseDto>> getAll() {
        final List<Doctor> doctors = doctorService.findAll();
        final List<DoctorResponseDto> doctorResponseDtoList = doctors.stream()
                .map((doctor) -> mapper.map(doctor, DoctorResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(doctorResponseDtoList, HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponseDto> getOne(@PathVariable Long id) {
        final Doctor doctor = doctorService.findById(id);
        final DoctorResponseDto doctorResponseDto = mapper.map(doctor, DoctorResponseDto.class);
        return new ResponseEntity<>(doctorResponseDto, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<DoctorResponseDto>> findAny(@RequestParam(required = false, defaultValue = "0") Long institutionId,
                                                           @RequestParam(required = false, defaultValue = "%") String specialization) {
        final List<Doctor> doctors;
        if (institutionId == 0) {
            doctors = doctorService.findBySpecialization(specialization);
        } else {
            doctors = doctorService.findByInstitutionIdAndSpecialization(institutionId, specialization);
        }
        final List<DoctorResponseDto> doctorResponseDtoList = doctors.stream()
                .map((doctor) -> mapper.map(doctor, DoctorResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(doctorResponseDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DoctorResponseDto> save(@Valid @RequestBody DoctorRequestDto doctorRequestDto) {
        doctorRequestDto.setId(null);
        final Doctor doctor = getDoctor(doctorRequestDto);
        final DoctorResponseDto doctorResponseDto = mapper.map(doctorService.save(doctor), DoctorResponseDto.class);
        return new ResponseEntity<>(doctorResponseDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponseDto> update(@Valid @RequestBody DoctorRequestDto doctorRequestDto, @PathVariable Long id) {
        if (!Objects.equals(id, doctorRequestDto.getId())) throw new RuntimeException("Url param id is not equals to doctorId!");
        final Doctor doctor = getDoctor(doctorRequestDto);
        final DoctorResponseDto doctorResponseDto = mapper.map(doctorService.update(doctor), DoctorResponseDto.class);
        return new ResponseEntity<>(doctorResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        doctorService.deleteById(id);
    }

    private Doctor getDoctor(DoctorRequestDto doctorRequestDto) {
        final Doctor doctor = mapper.map(doctorRequestDto, Doctor.class);
        final Institution institution = new Institution();
        institution.setId(doctorRequestDto.getInstitutionId());
        doctor.setInstitution(institution);
        return doctor;
    }
}
