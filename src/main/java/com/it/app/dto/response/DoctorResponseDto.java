package com.it.app.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.it.app.model.Institution;

/**
 * The type Doctor response dto.
 */
public class DoctorResponseDto {

    private Long id;

    private String name;

    private Integer age;

    private String specialization;

    private InstitutionResponseDto institution;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Gets specialization.
     *
     * @return the specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Sets specialization.
     *
     * @param specialization the specialization
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Gets institution.
     *
     * @return the institution
     */
    public InstitutionResponseDto getInstitution() {
        return institution;
    }

    /**
     * Sets institution.
     *
     * @param institution the institution
     */
    public void setInstitution(InstitutionResponseDto institution) {
        this.institution = institution;
    }
}
