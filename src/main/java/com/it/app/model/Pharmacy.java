package com.it.app.model;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "pharmacies")
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{pharmacy.name.notNull}")
    @NotEmpty(message = "{pharmacy.name.notEmpty}")
    @Size(min = 3, max = 50, message = "{pharmacy.name.size}")
    private String name;

    @NotNull(message = "{pharmacy.address.notNull}")
    @NotEmpty(message = "{pharmacy.address.notEmpty}")
    private String address;

    @OneToMany(mappedBy = "pharmacy")
    private List<Existence> existences;

    public List<Existence> getExistences() {
        return existences;
    }

    public void setExistences(List<Existence> existences) {
        this.existences = existences;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
