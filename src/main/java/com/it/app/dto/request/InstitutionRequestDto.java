package com.it.app.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The type Institution request dto.
 */
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
