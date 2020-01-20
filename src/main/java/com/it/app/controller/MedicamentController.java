package com.it.app.controller;

import com.it.app.dto.request.MedicamentRequestDto;
import com.it.app.dto.response.MedicamentResponseDto;
import com.it.app.model.Medicament;
import com.it.app.service.MedicamentService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicaments")
public class MedicamentController {

    private Mapper mapper;

    private MedicamentService medicamentService;

    public MedicamentController(Mapper mapper, MedicamentService medicamentService) {
        this.mapper = mapper;
        this.medicamentService = medicamentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentResponseDto> getOne(@PathVariable Long id) {
        final Medicament medicament = medicamentService.findById(id);
        final MedicamentResponseDto medicamentResponseDto = mapper.map(medicament, MedicamentResponseDto.class);
        return new ResponseEntity<>(medicamentResponseDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MedicamentResponseDto>> getAny(@RequestParam(value = "name", required = false, defaultValue = "%") String name,
                                                              @RequestParam(value = "type", required = false, defaultValue = "%") String type) {
        final List<Medicament> medicaments;
        if (name == null) {
            medicaments = medicamentService.findByType(type);
        } else if (type == null) {
            medicaments = medicamentService.findByName(name);
        } else {
            medicaments = medicamentService.findByNameAndType(name, type);
        };
        final List<MedicamentResponseDto> medicamentResponseDtoList = medicaments.stream()
                .map((medicament) -> mapper.map(medicament, MedicamentResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(medicamentResponseDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MedicamentResponseDto> save(@Valid @RequestBody MedicamentRequestDto medicamentRequestDto) {
        final Medicament medicament = mapper.map(medicamentRequestDto, Medicament.class);
        final MedicamentResponseDto medicamentResponseDto = mapper.map(medicamentService.save(medicament), MedicamentResponseDto.class);
        return new ResponseEntity<>(medicamentResponseDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicamentResponseDto> update(@Valid @RequestBody MedicamentRequestDto medicamentRequestDto, @PathVariable Long id) {
        if (!Objects.equals(id, medicamentRequestDto.getId())) throw new RuntimeException("Url param id is not equals to medicamentId!");
        final Medicament medicament = mapper.map(medicamentRequestDto, Medicament.class);
        final MedicamentResponseDto medicamentResponseDto = mapper.map(medicamentService.update(medicament), MedicamentResponseDto.class);
        return new ResponseEntity<>(medicamentResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        medicamentService.deleteById(id);
    }
}
