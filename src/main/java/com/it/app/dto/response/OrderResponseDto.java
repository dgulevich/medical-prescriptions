package com.it.app.dto.response;

/**
 * The type Order response dto.
 */
public class OrderResponseDto {

    private Long id;

    private Integer volume;

    private String description;

    private MedicamentResponseDto medicament;

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
}
