package com.it.app.controller;

import com.it.app.dto.request.ExistenceRequestDto;
import com.it.app.dto.response.ExistenceResponseDto;
import com.it.app.model.Existence;
import com.it.app.model.Medicament;
import com.it.app.model.Pharmacy;
import com.it.app.service.ExistenceService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type Existence controller.
 */
@RestController
@RequestMapping("/existences")
public class ExistenceController {

    private Mapper mapper;

    private ExistenceService existenceService;

    /**
     * Instantiates a new Existence controller.
     *
     * @param mapper           the mapper
     * @param existenceService the existence service
     */
    public ExistenceController(Mapper mapper, ExistenceService existenceService) {
        this.mapper = mapper;
        this.existenceService = existenceService;
    }

    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    @GetMapping("/{id}")
    public ResponseEntity<ExistenceResponseDto> getOne(@PathVariable Long id) {
        final Existence existence = existenceService.findById(id);
        final ExistenceResponseDto existenceResponseDto = mapper.map(existence, ExistenceResponseDto.class);
        return new ResponseEntity<>(existenceResponseDto, HttpStatus.OK);
    }

    /**
     * Gets any.
     *
     * @param pharmacyId   the pharmacy id
     * @param medicamentId the medicament id
     * @return the any
     */
    @GetMapping
    public ResponseEntity<List<ExistenceResponseDto>> getAny(@RequestParam(required = false, defaultValue = "0") Long pharmacyId,
                                                             @RequestParam(required = false, defaultValue = "0") Long medicamentId) {
        final List<Existence> existences;
        if (pharmacyId == 0 && medicamentId == 0) {
            existences = existenceService.findAll();
        } else if (pharmacyId == 0) {
            existences = existenceService.findByMedicament(medicamentId);
        } else if (medicamentId == 0) {
            existences = existenceService.findByPharmacy(pharmacyId);
        } else
            existences = existenceService.findByPharmacyAndMedicament(pharmacyId, medicamentId);
        final List<ExistenceResponseDto> existenceResponseDtoList = existences.stream()
                .map((existence) -> mapper.map(existence, ExistenceResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(existenceResponseDtoList, HttpStatus.OK);
    }

    /**
     * Save response entity.
     *
     * @param existenceRequestDto the existence request dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<ExistenceResponseDto> save(@Valid @RequestBody ExistenceRequestDto existenceRequestDto) {
        existenceRequestDto.setId(null);
        final Existence existence = getExistence(existenceRequestDto);
        final ExistenceResponseDto existenceResponseDto = mapper.map(existenceService.save(existence), ExistenceResponseDto.class);
        return new ResponseEntity<>(existenceResponseDto, HttpStatus.OK);
    }

    /**
     * Update response entity.
     *
     * @param existenceRequestDto the existence request dto
     * @param id                  the id
     * @return the response entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<ExistenceResponseDto> update(@Valid @RequestBody ExistenceRequestDto existenceRequestDto, @PathVariable Long id) {
        if (!Objects.equals(id, existenceRequestDto.getId())) throw new RuntimeException("Url param id is not equals to existenceId!");
        final Existence existence = getExistence(existenceRequestDto);
        final ExistenceResponseDto existenceResponseDto = mapper.map(existenceService.update(existence), ExistenceResponseDto.class);
        return new ResponseEntity<>(existenceResponseDto, HttpStatus.OK);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        existenceService.deleteById(id);
    }

    private Existence getExistence(ExistenceRequestDto existenceRequestDto) {
        final Existence existence = mapper.map(existenceRequestDto, Existence.class);
        final Pharmacy pharmacy = new Pharmacy();
        pharmacy.setId(existenceRequestDto.getPharmacyId());
        existence.setPharmacy(pharmacy);
        final Medicament medicament = new Medicament();
        medicament.setId(existenceRequestDto.getMedicamentId());
        existence.setMedicament(medicament);
        return existence;
    }
}
