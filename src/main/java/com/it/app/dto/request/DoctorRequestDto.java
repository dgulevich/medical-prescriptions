package com.it.app.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The type Doctor request dto.
 */
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
     * Gets institution id.
     *
     * @return the institution id
     */
    public Long getInstitutionId() {
        return institutionId;
    }

    /**
     * Sets institution id.
     *
     * @param institutionId the institution id
     */
    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }
}
