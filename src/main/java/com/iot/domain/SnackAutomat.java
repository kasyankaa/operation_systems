package com.iot.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "snack_automat", schema = "third_lab")
public class SnackAutomat {
    private int id;
    private int factoryId;
    private String address;
    private String name;
    private int maxNumberOfSnacks;
    private Collection<AutomatData> automatDataById;
    private Collection<GpsTracker> gpsTrackersById;

    private Collection<Snack> snacksById;
    private Factory factoryByFactoryId;
    private Collection<UpdatingAutomatWithCoins> updatingAutomatWithCoinsById;
    private Collection<UpdatingAutomatWithSnacks> updatingAutomatWithSnacksById;
    private Collection<WithdrawingMoneyFromAutomat> withdrawingMoneyFromAutomatsById;

    public SnackAutomat(int id, int factoryId, String address, String name, int maxNumberOfSnacks, Collection<AutomatData> automatDataById, Collection<GpsTracker> gpsTrackersById, Collection<Snack> snacksById, Factory factoryByFactoryId, Collection<UpdatingAutomatWithCoins> updatingAutomatWithCoinsById, Collection<UpdatingAutomatWithSnacks> updatingAutomatWithSnacksById, Collection<WithdrawingMoneyFromAutomat> withdrawingMoneyFromAutomatsById) {
        this.id = id;
        this.factoryId = factoryId;
        this.address = address;
        this.name = name;
        this.maxNumberOfSnacks = maxNumberOfSnacks;
        this.automatDataById = automatDataById;
        this.gpsTrackersById = gpsTrackersById;
        this.snacksById = snacksById;
        this.factoryByFactoryId = factoryByFactoryId;
        this.updatingAutomatWithCoinsById = updatingAutomatWithCoinsById;
        this.updatingAutomatWithSnacksById = updatingAutomatWithSnacksById;
        this.withdrawingMoneyFromAutomatsById = withdrawingMoneyFromAutomatsById;
    }

    public SnackAutomat() {

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
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "max_number_of_snacks", nullable = false)
    public int getMaxNumberOfSnacks() {
        return maxNumberOfSnacks;
    }

    public void setMaxNumberOfSnacks(int maxNumberOfSnacks) {
        this.maxNumberOfSnacks = maxNumberOfSnacks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SnackAutomat that = (SnackAutomat) o;

        if (id != that.id) return false;
        if (factoryId != that.factoryId) return false;
        if (maxNumberOfSnacks != that.maxNumberOfSnacks) return false;
        if (!Objects.equals(address, that.address)) return false;
        if (!Objects.equals(name, that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + factoryId;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + maxNumberOfSnacks;
        return result;
    }

    @OneToMany(mappedBy = "snackAutomatBySnackAutomatId")
    public Collection<AutomatData> getAutomatDataById() {
        return automatDataById;
    }

    public void setAutomatDataById(Collection<AutomatData> automatDataById) {
        this.automatDataById = automatDataById;
    }

    @OneToMany(mappedBy = "snackAutomatBySnackAutomatId")
    public Collection<GpsTracker> getGpsTrackersById() {
        return gpsTrackersById;
    }

    public void setGpsTrackersById(Collection<GpsTracker> gpsTrackersById) {
        this.gpsTrackersById = gpsTrackersById;
    }


    @OneToMany(mappedBy = "snackAutomatBySnackAutomatId")
    public Collection<Snack> getSnacksById() {
        return snacksById;
    }

    public void setSnacksById(Collection<Snack> snacksById) {
        this.snacksById = snacksById;
    }

    @ManyToOne
    @JoinColumn(name = "factory_id", referencedColumnName = "id", nullable = false)
    public Factory getFactoryByFactoryId() {
        return factoryByFactoryId;
    }

    public void setFactoryByFactoryId(Factory factoryByFactoryId) {
        this.factoryByFactoryId = factoryByFactoryId;
    }

    @OneToMany(mappedBy = "snackAutomatBySnackAutomatId")
    public Collection<UpdatingAutomatWithCoins> getUpdatingAutomatWithCoinsById() {
        return updatingAutomatWithCoinsById;
    }

    public void setUpdatingAutomatWithCoinsById(Collection<UpdatingAutomatWithCoins> updatingAutomatWithCoinsById) {
        this.updatingAutomatWithCoinsById = updatingAutomatWithCoinsById;
    }

    @OneToMany(mappedBy = "snackAutomatBySnackAutomatId")
    public Collection<UpdatingAutomatWithSnacks> getUpdatingAutomatWithSnacksById() {
        return updatingAutomatWithSnacksById;
    }

    public void setUpdatingAutomatWithSnacksById(Collection<UpdatingAutomatWithSnacks> updatingAutomatWithSnacksById) {
        this.updatingAutomatWithSnacksById = updatingAutomatWithSnacksById;
    }

    @OneToMany(mappedBy = "snackAutomatBySnackAutomatId")
    public Collection<WithdrawingMoneyFromAutomat> getWithdrawingMoneyFromAutomatsById() {
        return withdrawingMoneyFromAutomatsById;
    }

    public void setWithdrawingMoneyFromAutomatsById(Collection<WithdrawingMoneyFromAutomat> withdrawingMoneyFromAutomatsById) {
        this.withdrawingMoneyFromAutomatsById = withdrawingMoneyFromAutomatsById;
    }

    @Override
    public String toString() {
        return "SnackAutomat{" +
                "id=" + id +
                ", factoryId=" + factoryId +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", maxNumberOfSnacks=" + maxNumberOfSnacks +
                ", automatDataById=" + automatDataById +
                ", gpsTrackersById=" + gpsTrackersById +
                ", snacksById=" + snacksById +
                ", factoryByFactoryId=" + factoryByFactoryId +
                ", updatingAutomatWithCoinsById=" + updatingAutomatWithCoinsById +
                ", updatingAutomatWithSnacksById=" + updatingAutomatWithSnacksById +
                ", withdrawingMoneyFromAutomatsById=" + withdrawingMoneyFromAutomatsById +
                '}';
    }
}
