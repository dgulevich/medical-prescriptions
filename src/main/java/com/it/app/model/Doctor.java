package com.it.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "doctors")
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
    @JoinColumn(name = "institutions_id", nullable = false)
    @NotNull(message = "{doctor.institution.notNull}")
    private Institution institution;

    @OneToMany(mappedBy = "doctor", fetch=FetchType.LAZY)
    private List<Prescription> prescriptions;

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

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

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
