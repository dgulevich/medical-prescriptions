package com.it.app.controller;

import com.it.app.dto.request.InstitutionRequestDto;
import com.it.app.dto.response.InstitutionResponseDto;
import com.it.app.model.Doctor;
import com.it.app.model.Institution;
import com.it.app.service.InstitutionService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/institutions")
public class InstitutionController {

    private Mapper mapper;

    private InstitutionService institutionService;

    public InstitutionController(Mapper mapper, InstitutionService institutionService) {
        this.mapper = mapper;
        this.institutionService = institutionService;
    }

    @GetMapping
    public ResponseEntity<List<InstitutionResponseDto>> getAll() {
        final List<Institution> institutions = institutionService.findAll();
        final List<InstitutionResponseDto> institutionResponseDtoList = institutions.stream()
                .map((institution) -> mapper.map(institution, InstitutionResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(institutionResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstitutionResponseDto> getOne(@PathVariable Long id) {
        final Institution institution = institutionService.findById(id);
        final InstitutionResponseDto institutionResponseDto = mapper.map(institution, InstitutionResponseDto.class);
        return new ResponseEntity<>(institutionResponseDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InstitutionResponseDto> save(@Valid @RequestBody InstitutionRequestDto institutionRequestDto) {
        institutionRequestDto.setId(null);
        final Institution institution = mapper.map(institutionRequestDto, Institution.class);
        final InstitutionResponseDto institutionResponseDto = mapper.map(institutionService.save(institution), InstitutionResponseDto.class);
        return new ResponseEntity<>(institutionResponseDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstitutionResponseDto> update(@Valid @RequestBody InstitutionRequestDto institutionRequestDto, @PathVariable Long id) {
        if (!Objects.equals(id, institutionRequestDto.getId())) throw new RuntimeException("Url param id is not equals to institutionId!");
        final Institution institution = mapper.map(institutionRequestDto, Institution.class);
        final InstitutionResponseDto institutionResponseDto = mapper.map(institutionService.update(institution), InstitutionResponseDto.class);
        return new ResponseEntity<>(institutionResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        institutionService.deleteById(id);
    }
}
