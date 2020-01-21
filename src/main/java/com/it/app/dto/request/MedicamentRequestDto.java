package com.it.app.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The type Medicament request dto.
 */
public class MedicamentRequestDto {

    private Long id;

    @NotNull(message = "{medicament.name.notNull}")
    @NotEmpty(message = "{medicament.name.notEmpty}")
    private String name;

    @NotNull(message = "{medicament.type.notNull}")
    @NotEmpty(message = "{medicament.type.notEmpty}")
    private String type;

    @NotNull(message = "{medicament.unit.notNull}")
    @NotEmpty(message = "{medicament.unit.notEmpty}")
    private String unit;

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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets unit.
     *
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets unit.
     *
     * @param unit the unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }
}
