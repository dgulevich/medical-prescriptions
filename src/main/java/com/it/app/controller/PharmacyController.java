package com.it.app.controller;

import com.it.app.dto.request.PharmacyRequestDto;
import com.it.app.dto.response.PharmacyResponseDto;
import com.it.app.model.Pharmacy;
import com.it.app.service.PharmacyService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type Pharmacy controller.
 */
@RestController
@RequestMapping("/pharmacies")
public class PharmacyController {

    private Mapper mapper;

    private PharmacyService pharmacyService;

    /**
     * Instantiates a new Pharmacy controller.
     *
     * @param mapper          the mapper
     * @param pharmacyService the pharmacy service
     */
    public PharmacyController(Mapper mapper, PharmacyService pharmacyService) {
        this.mapper = mapper;
        this.pharmacyService = pharmacyService;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<PharmacyResponseDto>> getAll() {
        final List<Pharmacy> pharmacies = pharmacyService.findAll();
        final List<PharmacyResponseDto> pharmacyResponseDtoList = pharmacies.stream()
                .map((pharmacy) -> mapper.map(pharmacy, PharmacyResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(pharmacyResponseDtoList, HttpStatus.OK);
    }

    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    @RequestMapping("/{id}")
    public ResponseEntity<PharmacyResponseDto> getOne(@PathVariable Long id) {
        final Pharmacy pharmacy = pharmacyService.findById(id);
        final PharmacyResponseDto pharmacyResponseDto = mapper.map(pharmacy, PharmacyResponseDto.class);
        return new ResponseEntity<>(pharmacyResponseDto, HttpStatus.OK);
    }

    /**
     * Save response entity.
     *
     * @param pharmacyRequestDto the pharmacy request dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<PharmacyResponseDto> save(@Valid @RequestBody PharmacyRequestDto pharmacyRequestDto) {
        pharmacyRequestDto.setId(null);
        final Pharmacy pharmacy = mapper.map(pharmacyRequestDto, Pharmacy.class);
        final PharmacyResponseDto pharmacyResponseDto = mapper.map(pharmacyService.save(pharmacy), PharmacyResponseDto.class);
        return new ResponseEntity<>(pharmacyResponseDto, HttpStatus.OK);
    }

    /**
     * Update response entity.
     *
     * @param pharmacyRequestDto the pharmacy request dto
     * @param id                 the id
     * @return the response entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<PharmacyResponseDto> update(@Valid @RequestBody PharmacyRequestDto pharmacyRequestDto, @PathVariable Long id) {
        if (!Objects.equals(id, pharmacyRequestDto.getId())) throw new RuntimeException("Url param id is not equals to pharmacyId!");
        final Pharmacy pharmacy = mapper.map(pharmacyRequestDto, Pharmacy.class);
        final PharmacyResponseDto pharmacyResponseDto = mapper.map(pharmacyService.update(pharmacy), PharmacyResponseDto.class);
        return new ResponseEntity<>(pharmacyResponseDto, HttpStatus.OK);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        pharmacyService.deleteById(id);
    }
}
