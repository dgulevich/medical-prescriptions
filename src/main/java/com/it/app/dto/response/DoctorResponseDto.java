package com.it.app.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.it.app.model.Institution;

public class DoctorResponseDto {

    private Long id;

    private String name;

    private Integer age;

    private String specialization;

    private InstitutionResponseDto institution;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public InstitutionResponseDto getInstitution() {
        return institution;
    }

    public void setInstitution(InstitutionResponseDto institution) {
        this.institution = institution;
    }
}
