package com.it.app.model;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * The type Pharmacy.
 */
@Entity
@Table(name = "PHARMACIES")
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{pharmacy.name.notNull}")
    @NotEmpty(message = "{pharmacy.name.notEmpty}")
    @Size(min = 3, max = 150, message = "{pharmacy.name.size}")
    private String name;

    @NotNull(message = "{pharmacy.address.notNull}")
    @NotEmpty(message = "{pharmacy.address.notEmpty}")
    private String address;

    @OneToMany(mappedBy = "pharmacy")
    private List<Existence> existences;

    /**
     * Gets existences.
     *
     * @return the existences
     */
    public List<Existence> getExistences() {
        return existences;
    }

    /**
     * Sets existences.
     *
     * @param existences the existences
     */
    public void setExistences(List<Existence> existences) {
        this.existences = existences;
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
