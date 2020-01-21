package com.it.app.dto.response;

import java.util.Date;

/**
 * The type Prescription response dto.
 */
public class PrescriptionResponseDto {

    private Long id;

    private String serial;

    private Integer period;

    private Boolean use;

    private String date;

    private OrderResponseDto order;

    private PatientResponseDto patient;

    private DoctorResponseDto doctor;

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
     * Gets serial.
     *
     * @return the serial
     */
    public String getSerial() {
        return serial;
    }

    /**
     * Sets serial.
     *
     * @param serial the serial
     */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * Gets period.
     *
     * @return the period
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     * Sets period.
     *
     * @param period the period
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     * Gets use.
     *
     * @return the use
     */
    public Boolean getUse() {
        return use;
    }

    /**
     * Sets use.
     *
     * @param use the use
     */
    public void setUse(Boolean use) {
        this.use = use;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets order.
     *
     * @return the order
     */
    public OrderResponseDto getOrder() {
        return order;
    }

    /**
     * Sets order.
     *
     * @param order the order
     */
    public void setOrder(OrderResponseDto order) {
        this.order = order;
    }

    /**
     * Gets patient.
     *
     * @return the patient
     */
    public PatientResponseDto getPatient() {
        return patient;
    }

    /**
     * Sets patient.
     *
     * @param patient the patient
     */
    public void setPatient(PatientResponseDto patient) {
        this.patient = patient;
    }

    /**
     * Gets doctor.
     *
     * @return the doctor
     */
    public DoctorResponseDto getDoctor() {
        return doctor;
    }

    /**
     * Sets doctor.
     *
     * @param doctor the doctor
     */
    public void setDoctor(DoctorResponseDto doctor) {
        this.doctor = doctor;
    }
}
