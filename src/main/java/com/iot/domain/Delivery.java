package com.iot.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "delivery")
public class Delivery {
    private int id;
    private int factoryId;
    private String carNumber;

    public Delivery(int id, int factoryId, String carNumber) {
        this.id = id;
        this.factoryId = factoryId;
        this.carNumber = carNumber;

    }

    public Delivery() {

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
    @Column(name = "car_number", nullable = true, length = 12)
    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Delivery delivery = (Delivery) o;

        if (id != delivery.id) return false;
        if (factoryId != delivery.factoryId) return false;
        if (!Objects.equals(carNumber, delivery.carNumber)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + factoryId;
        result = 31 * result + (carNumber != null ? carNumber.hashCode() : 0);
        return result;
    }





    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", factoryId=" + factoryId +
                ", carNumber='" + carNumber + '\'' +
                '}';
    }
}
