package com.it.app.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
