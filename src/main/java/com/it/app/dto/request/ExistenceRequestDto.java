package com.it.app.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The type Existence request dto.
 */
public class ExistenceRequestDto {

    private Long id;

    @NotNull(message = "{existance.medicament.notNull}")
    private Long medicamentId;

    @NotNull(message = "existance.pharmacy.notNull")
    private Long pharmacyId;

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
     * Gets medicament id.
     *
     * @return the medicament id
     */
    public Long getMedicamentId() {
        return medicamentId;
    }

    /**
     * Sets medicament id.
     *
     * @param medicamentId the medicament id
     */
    public void setMedicamentId(Long medicamentId) {
        this.medicamentId = medicamentId;
    }

    /**
     * Gets pharmacy id.
     *
     * @return the pharmacy id
     */
    public Long getPharmacyId() {
        return pharmacyId;
    }

    /**
     * Sets pharmacy id.
     *
     * @param pharmacyId the pharmacy id
     */
    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
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
