package com.it.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "prescriptions", uniqueConstraints = @UniqueConstraint(columnNames = "orders_id"))
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{prescription.serial.notNull}")
    @NotEmpty(message = "{prescription.serial.notEmpty}")
    private String serial;

    @NotNull(message = "{prescription.period.notNull}")
    private Integer period;

    private Boolean use;

    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToOne
    @JoinColumn(name = "orders_id", unique = true)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "patients_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctors_id")
    private Doctor doctor;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public Boolean getUse() {
        return use;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUse(Boolean use) {
        this.use = use;
    }
}
