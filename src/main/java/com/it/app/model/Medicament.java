package com.it.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * The type Medicament.
 */
@Entity
@Table(name = "MEDICAMENTS")
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "medicament")
    private List<Existence> existances;

    @OneToMany(mappedBy = "medicament")
    private List<Order> orders;

    /**
     * Gets orders.
     *
     * @return the orders
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Sets orders.
     *
     * @param orders the orders
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    /**
     * Gets existances.
     *
     * @return the existances
     */
    public List<Existence> getExistances() {
        return existances;
    }

    /**
     * Sets existances.
     *
     * @param existances the existances
     */
    public void setExistances(List<Existence> existances) {
        this.existances = existances;
    }

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
