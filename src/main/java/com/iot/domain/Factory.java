package com.iot.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "factory", schema = "third_lab")
public class Factory {
    private int id;
    private int regionId;
    private String address;
    private int numberOfWorkers;
    private String phoneNumber;
    private Region regionByRegionId;
    private Collection<Snack> snacksById;
    private Collection<SnackAutomat> snackAutomatsById;

    public Factory(int id, int regionId, String address, int numberOfWorkers, String phoneNumber, Region regionByRegionId, Collection<Snack> snacksById, Collection<SnackAutomat> snackAutomatsById) {
        this.id = id;
        this.regionId = regionId;
        this.address = address;
        this.numberOfWorkers = numberOfWorkers;
        this.phoneNumber = phoneNumber;
        this.regionByRegionId = regionByRegionId;
        this.snacksById = snacksById;
        this.snackAutomatsById = snackAutomatsById;
    }

    public Factory() {

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
    @Column(name = "address", nullable = false, length = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "number_of_workers", nullable = false)
    public int getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public void setNumberOfWorkers(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }

    @Basic
    @Column(name = "phone_number", nullable = false,columnDefinition = "char", length = 12)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Factory factory = (Factory) o;

        if (id != factory.id) return false;
        if (regionId != factory.regionId) return false;
        if (numberOfWorkers != factory.numberOfWorkers) return false;
        if (!Objects.equals(address, factory.address)) return false;
        if (!Objects.equals(phoneNumber, factory.phoneNumber)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + regionId;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + numberOfWorkers;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "id", nullable = false)
    public Region getRegionByRegionId() {
        return regionByRegionId;
    }

    public void setRegionByRegionId(Region regionByRegionId) {
        this.regionByRegionId = regionByRegionId;
    }

    @OneToMany(mappedBy = "factoryByFactoryId")
    public Collection<Snack> getSnacksById() {
        return snacksById;
    }

    public void setSnacksById(Collection<Snack> snacksById) {
        this.snacksById = snacksById;
    }

    @OneToMany(mappedBy = "factoryByFactoryId")
    public Collection<SnackAutomat> getSnackAutomatsById() {
        return snackAutomatsById;
    }

    public void setSnackAutomatsById(Collection<SnackAutomat> snackAutomatsById) {
        this.snackAutomatsById = snackAutomatsById;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "id=" + id +
                ", regionId=" + regionId +
                ", address='" + address + '\'' +
                ", numberOfWorkers=" + numberOfWorkers +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", regionByRegionId=" + regionByRegionId +
                ", snacksById=" + snacksById +
                ", snackAutomatsById=" + snackAutomatsById +
                '}';
    }
}
