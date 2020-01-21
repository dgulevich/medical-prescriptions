package com.it.app.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The type Order request dto.
 */
public class OrderRequestDto {

    private Long id;

    @NotNull(message = "{order.volume.notNull}")
    private Integer volume;

    @NotNull(message = "{order.description.notNull}")
    @NotEmpty(message = "{order.description.notEmpty}")
    private String description;

    @NotNull(message = "{order.medicament.notNull}")
    private Long medicamentId;

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
}
