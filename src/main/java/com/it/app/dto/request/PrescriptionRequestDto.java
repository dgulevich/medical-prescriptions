package com.it.app.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

/**
 * The type Prescription request dto.
 */
public class PrescriptionRequestDto {

    private Long id;

    @NotNull(message = "{prescription.serial.notNull}")
    @NotEmpty(message = "{prescription.serial.notEmpty}")
    private String serial;

    @NotNull(message = "{prescription.period.notNull}")
    private Integer period;

    private Boolean use;

    private Date date;

    private Long orderId;

    private Long patientId;

    private Long doctorId;

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
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets order id.
     *
     * @return the order id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * Sets order id.
     *
     * @param orderId the order id
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets patient id.
     *
     * @return the patient id
     */
    public Long getPatientId() {
        return patientId;
    }

    /**
     * Sets patient id.
     *
     * @param patientId the patient id
     */
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    /**
     * Gets doctor id.
     *
     * @return the doctor id
     */
    public Long getDoctorId() {
        return doctorId;
    }

    /**
     * Sets doctor id.
     *
     * @param doctorId the doctor id
     */
    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
}
