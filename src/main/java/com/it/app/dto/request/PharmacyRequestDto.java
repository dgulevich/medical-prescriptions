package com.it.app.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PharmacyRequestDto {

    private Long id;

    @NotNull(message = "{pharmacy.name.notNull}")
    @NotEmpty(message = "{pharmacy.name.notEmpty}")
    @Size(min = 3, max = 50, message = "{pharmacy.name.size}")
    private String name;

    @NotNull(message = "{pharmacy.address.notNull}")
    @NotEmpty(message = "{pharmacy.address.notEmpty}")
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
