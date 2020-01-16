package com.it.app.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InstitutionRequestDto {

    private Long id;

    @NotNull(message = "{institution.name.notNull}")
    @NotEmpty(message = "{institution.name.notEmpty}")
    @Size(min = 3, max = 50, message = "{institution.name.size}")
    private String name;

    @NotNull(message = "{institution.type.notNull}")
    @NotEmpty(message = "{institution.type.notEmpty}")
    private String type;

    @NotNull(message = "{institution.address.notNull}")
    @NotEmpty(message = "{institution.address.notEmpty}")
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
