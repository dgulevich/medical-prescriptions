package com.it.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "institutions")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{institution.name.notNull}")
    @NotEmpty(message = "{institution.name.notEmpty}")
    @Size(min = 3, max = 50, message = "{institution.name.size}")
    private String name;

    @NotNull(message = "{institution.type.notNull}")
    @NotEmpty(message = "{institution.type.notEmpty}")
    private String type;

    @NotNull(message = "{institution.address.notNull}")
    @NotEmpty(message = "{institution.address.notEmpty}")
    private String address;


    @OneToMany(mappedBy = "institution")
    private List<Doctor> doctors;

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
