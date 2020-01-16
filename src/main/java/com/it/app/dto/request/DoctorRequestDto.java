package com.it.app.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DoctorRequestDto {

    private Long id;

    @NotNull(message = "{doctor.name.notNull}")
    @NotEmpty(message = "{doctor.name.notEmpty}")
    private String name;

    private Integer age;

    @NotNull(message = "{doctor.specialization.notNull}")
    @NotEmpty(message = "{doctor.specialization.notEmpty}")
    private String specialization;

    @NotNull(message = "{doctor.institution.notNull}")
    private Long institutionId;

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

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }
}
