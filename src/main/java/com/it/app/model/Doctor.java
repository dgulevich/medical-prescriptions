package com.it.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * The type Doctor.
 */
@Entity
@Table(name = "DOCTORS")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{doctor.name.notNull}")
    @NotEmpty(message = "{doctor.name.notEmpty}")
    private String name;

    private Integer age;

    @NotNull(message = "{doctor.specialization.notNull}")
    @NotEmpty(message = "{doctor.specialization.notEmpty}")
    private String specialization;

    @ManyToOne
    @JoinColumn(name = "institution_id", nullable = false)
    @NotNull(message = "{doctor.institution.notNull}")
    private Institution institution;

    @OneToMany(mappedBy = "doctor", fetch=FetchType.LAZY)
    private List<Prescription> prescriptions;

    /**
     * Gets prescriptions.
     *
     * @return the prescriptions
     */
    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    /**
     * Sets prescriptions.
     *
     * @param prescriptions the prescriptions
     */
    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

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
    public Institution getInstitution() {
        return institution;
    }

    /**
     * Sets institution.
     *
     * @param institution the institution
     */
    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
