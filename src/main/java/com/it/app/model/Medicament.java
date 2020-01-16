package com.it.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "medicaments")
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Existence> getExistances() {
        return existances;
    }

    public void setExistances(List<Existence> existances) {
        this.existances = existances;
    }

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
