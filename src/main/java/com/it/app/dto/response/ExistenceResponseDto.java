package com.it.app.dto.response;

/**
 * The type Existence response dto.
 */
public class ExistenceResponseDto {

    private Long id;

    private MedicamentResponseDto medicament;

    private PharmacyResponseDto pharmacy;

    private Integer volume;

    private Double price;

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
    public MedicamentResponseDto getMedicament() {
        return medicament;
    }

    /**
     * Sets medicament.
     *
     * @param medicament the medicament
     */
    public void setMedicament(MedicamentResponseDto medicament) {
        this.medicament = medicament;
    }

    /**
     * Gets pharmacy.
     *
     * @return the pharmacy
     */
    public PharmacyResponseDto getPharmacy() {
        return pharmacy;
    }

    /**
     * Sets pharmacy.
     *
     * @param pharmacy the pharmacy
     */
    public void setPharmacy(PharmacyResponseDto pharmacy) {
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
