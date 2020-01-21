package com.it.app.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The type Pharmacy request dto.
 */
public class PharmacyRequestDto {

    private Long id;

    @NotNull(message = "{pharmacy.name.notNull}")
    @NotEmpty(message = "{pharmacy.name.notEmpty}")
    @Size(min = 3, max = 50, message = "{pharmacy.name.size}")
    private String name;

    @NotNull(message = "{pharmacy.address.notNull}")
    @NotEmpty(message = "{pharmacy.address.notEmpty}")
    private String address;

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
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
