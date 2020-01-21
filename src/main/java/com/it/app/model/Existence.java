package com.it.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The type Existence.
 */
@Entity
@Table(name = "EXISTENCES")
public class Existence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medicament_id", nullable = false)
    @NotNull(message = "{existence.medicament.notNull}")
    private Medicament medicament;

    @ManyToOne
    @JoinColumn(name = "pharmacy_id", nullable = false)
    @NotNull(message = "existence.pharmacy.notNull")
    private Pharmacy pharmacy;

    @NotNull(message = "existance.price.notNull")
    private Integer volume;

    @NotNull(message = "existance.price.notNull")
    private Double price;

    @NotNull(message = "existance.count.notNull")
    private Integer count;

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
     * Gets medicament.
     *
     * @return the medicament
     */
    public Medicament getMedicament() {
        return medicament;
    }

    /**
     * Sets medicament.
     *
     * @param medicament the medicament
     */
    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    /**
     * Gets pharmacy.
     *
     * @return the pharmacy
     */
    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    /**
     * Sets pharmacy.
     *
     * @param pharmacy the pharmacy
     */
    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    /**
     * Gets volume.
     *
     * @return the volume
     */
    public Integer getVolume() {
        return volume;
    }

    /**
     * Sets volume.
     *
     * @param volume the volume
     */
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets count.
     *
     * @param count the count
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}
