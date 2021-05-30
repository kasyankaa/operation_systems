package com.iot.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "snack", schema = "third_lab")

public class Snack {
    private int id;
    private int factoryId;
    private int snackAutomatId;
    private String name;
    private int priceInDollars;
    private int massInGrams;
    private int calories;
    private Factory factoryByFactoryId;
    private SnackAutomat snackAutomatBySnackAutomatId;

    public Snack(int id, int factoryId, int snackAutomatId, String name, int priceInDollars, int massInGrams, int calories, Factory factoryByFactoryId, SnackAutomat snackAutomatBySnackAutomatId) {
        this.id = id;
        this.factoryId = factoryId;
        this.snackAutomatId = snackAutomatId;
        this.name = name;
        this.priceInDollars = priceInDollars;
        this.massInGrams = massInGrams;
        this.calories = calories;
        this.factoryByFactoryId = factoryByFactoryId;
        this.snackAutomatBySnackAutomatId = snackAutomatBySnackAutomatId;
    }

    public Snack() {

    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price_in_dollars", nullable = false)
    public int getPriceInDollars() {
        return priceInDollars;
    }

    public void setPriceInDollars(int priceInDollars) {
        this.priceInDollars = priceInDollars;
    }

    @Basic
    @Column(name = "mass_in_grams", nullable = false)
    public int getMassInGrams() {
        return massInGrams;
    }

    public void setMassInGrams(int massInGrams) {
        this.massInGrams = massInGrams;
    }

    @Basic
    @Column(name = "calories", nullable = false)
    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Snack snack = (Snack) o;

        if (id != snack.id) return false;
        if (factoryId != snack.factoryId) return false;
        if (snackAutomatId != snack.snackAutomatId) return false;
        if (priceInDollars != snack.priceInDollars) return false;
        if (massInGrams != snack.massInGrams) return false;
        if (calories != snack.calories) return false;
        return Objects.equals(name, snack.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + factoryId;
        result = 31 * result + snackAutomatId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + priceInDollars;
        result = 31 * result + massInGrams;
        result = 31 * result + calories;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "factory_id", referencedColumnName = "id", nullable = false)
    public Factory getFactoryByFactoryId() {
        return factoryByFactoryId;
    }

    public void setFactoryByFactoryId(Factory factoryByFactoryId) {
        this.factoryByFactoryId = factoryByFactoryId;
    }

    @ManyToOne
    @JoinColumn(name = "snack_automat_id", referencedColumnName = "id", nullable = false)
    public SnackAutomat getSnackAutomatBySnackAutomatId() {
        return snackAutomatBySnackAutomatId;
    }

    public void setSnackAutomatBySnackAutomatId(SnackAutomat snackAutomatBySnackAutomatId) {
        this.snackAutomatBySnackAutomatId = snackAutomatBySnackAutomatId;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "id=" + id +
                ", factoryId=" + factoryId +
                ", snackAutomatId=" + snackAutomatId +
                ", name='" + name + '\'' +
                ", priceInDollars=" + priceInDollars +
                ", massInGrams=" + massInGrams +
                ", calories=" + calories +
                ", factoryByFactoryId=" + factoryByFactoryId +
                ", snackAutomatBySnackAutomatId=" + snackAutomatBySnackAutomatId +
                '}';
    }
}
