package com.it.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }
}
