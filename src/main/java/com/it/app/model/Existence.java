package com.it.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "existences")
public class Existence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medicaments_id", nullable = false)
    @NotNull(message = "{existence.medicament.notNull}")
    private Medicament medicament;

    @ManyToOne
    @JoinColumn(name = "pharmacies_id", nullable = false)
    @NotNull(message = "existence.pharmacy.notNull")
    private Pharmacy pharmacy;

    @NotNull(message = "existance.price.notNull")
    @NotEmpty(message = "existence.price.notEmpty")
    private Integer volume;

    @NotNull(message = "existance.price.notNull")
    @NotEmpty(message = "existence.price.notEmpty")
    private Double price;

    @NotNull(message = "existance.count.notNull")
    @NotEmpty(message = "existence.count.notEmpty")
    private Integer count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
