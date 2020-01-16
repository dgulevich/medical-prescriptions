package com.it.app.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ExistenceRequestDto {

    private Long id;

    @NotNull(message = "{existance.medicament.notNull}")
    private Long medicamentId;

    @NotNull(message = "existance.pharmacy.notNull")
    private Long pharmacyId;

    @NotNull(message = "existance.price.notNull")
    @NotEmpty(message = "existance.price.notEmpty")
    private Integer volume;

    @NotNull(message = "existance.price.notNull")
    @NotEmpty(message = "existance.price.notEmpty")
    private Double price;

    @NotNull(message = "existance.count.notNull")
    @NotEmpty(message = "existance.count.notEmpty")
    private Integer count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMedicamentId() {
        return medicamentId;
    }

    public void setMedicamentId(Long medicamentId) {
        this.medicamentId = medicamentId;
    }

    public Long getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
