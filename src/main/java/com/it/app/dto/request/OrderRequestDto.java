package com.it.app.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OrderRequestDto {

    private Long id;

    @NotNull(message = "{order.volume.notNull}")
    private Integer volume;

    @NotNull(message = "{order.description.notNull}")
    @NotEmpty(message = "{order.description.notEmpty}")
    private String description;

    @NotNull(message = "{order.medicament.notNull}")
    private Long medicamentId;

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

    public Long getMedicamentId() {
        return medicamentId;
    }

    public void setMedicamentId(Long medicamentId) {
        this.medicamentId = medicamentId;
    }
}
