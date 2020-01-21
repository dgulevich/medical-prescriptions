package com.it.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * The type Institution.
 */
@Entity
@Table(name = "INSTITUTIONS")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{institution.name.notNull}")
    @NotEmpty(message = "{institution.name.notEmpty}")
    @Size(min = 3, max = 255, message = "{institution.name.size}")
    private String name;

    @NotNull(message = "{institution.type.notNull}")
    @NotEmpty(message = "{institution.type.notEmpty}")
    private String type;

    @NotNull(message = "{institution.address.notNull}")
    @NotEmpty(message = "{institution.address.notEmpty}")
    private String address;


    @OneToMany(mappedBy = "institution")
    private List<Doctor> doctors;

    /**
     * Gets doctors.
     *
     * @return the doctors
     */
    public List<Doctor> getDoctors() {
        return doctors;
    }

    /**
     * Sets doctors.
     *
     * @param doctors the doctors
     */
    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
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
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }


}
