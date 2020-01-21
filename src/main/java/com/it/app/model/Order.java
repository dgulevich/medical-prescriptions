package com.it.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The type Order.
 */
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{order.volume.notNull}")
    private Integer volume;

    @NotNull(message = "{order.description.notNull}")
    @NotEmpty(message = "{order.description.notEmpty}")
    private String description;

    @ManyToOne
    @JoinColumn(name = "medicament_id", nullable = false)
    @NotNull(message = "{order.medicament.notNull}")
    private Medicament medicament;

    @OneToOne(mappedBy = "order")
    private Prescription prescription;

    /**
     * Gets prescription.
     *
     * @return the prescription
     */
    public Prescription getPrescription() {
        return prescription;
    }

    /**
     * Sets prescription.
     *
     * @param prescription the prescription
     */
    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
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
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
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
}
