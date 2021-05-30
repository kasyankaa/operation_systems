package com.iot.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "worker", schema = "third_lab")

public class Worker {
    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private Collection<UpdatingAutomatWithCoins> updatingAutomatWithCoinsById;
    private Collection<UpdatingAutomatWithSnacks> updatingAutomatWithSnacksById;
    private Collection<WithdrawingMoneyFromAutomat> withdrawingMoneyFromAutomatsById;
    private Collection<WorkerDelivers> workerDeliversById;

    public Worker(int id, String name, String surname, String phoneNumber, Collection<UpdatingAutomatWithCoins> updatingAutomatWithCoinsById, Collection<UpdatingAutomatWithSnacks> updatingAutomatWithSnacksById, Collection<WithdrawingMoneyFromAutomat> withdrawingMoneyFromAutomatsById, Collection<WorkerDelivers> workerDeliversById) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.updatingAutomatWithCoinsById = updatingAutomatWithCoinsById;
        this.updatingAutomatWithSnacksById = updatingAutomatWithSnacksById;
        this.withdrawingMoneyFromAutomatsById = withdrawingMoneyFromAutomatsById;
        this.workerDeliversById = workerDeliversById;
    }

    public Worker() {

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
    @Column(name = "surname", nullable = false, length = 50)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "phone_number", nullable = false, columnDefinition = "char",length = 12)
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

        Worker worker = (Worker) o;

        if (id != worker.id) return false;
        if (!Objects.equals(name, worker.name)) return false;
        if (!Objects.equals(surname, worker.surname)) return false;
        if (!Objects.equals(phoneNumber, worker.phoneNumber)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "workerByWorkerId")
    public Collection<UpdatingAutomatWithCoins> getUpdatingAutomatWithCoinsById() {
        return updatingAutomatWithCoinsById;
    }

    public void setUpdatingAutomatWithCoinsById(Collection<UpdatingAutomatWithCoins> updatingAutomatWithCoinsById) {
        this.updatingAutomatWithCoinsById = updatingAutomatWithCoinsById;
    }

    @OneToMany(mappedBy = "workerByWorkerId")
    public Collection<UpdatingAutomatWithSnacks> getUpdatingAutomatWithSnacksById() {
        return updatingAutomatWithSnacksById;
    }

    public void setUpdatingAutomatWithSnacksById(Collection<UpdatingAutomatWithSnacks> updatingAutomatWithSnacksById) {
        this.updatingAutomatWithSnacksById = updatingAutomatWithSnacksById;
    }

    @OneToMany(mappedBy = "workerByWorkerId")
    public Collection<WithdrawingMoneyFromAutomat> getWithdrawingMoneyFromAutomatsById() {
        return withdrawingMoneyFromAutomatsById;
    }

    public void setWithdrawingMoneyFromAutomatsById(Collection<WithdrawingMoneyFromAutomat> withdrawingMoneyFromAutomatsById) {
        this.withdrawingMoneyFromAutomatsById = withdrawingMoneyFromAutomatsById;
    }

    @OneToMany(mappedBy = "workerByWorkerId")
    public Collection<WorkerDelivers> getWorkerDeliversById() {
        return workerDeliversById;
    }

    public void setWorkerDeliversById(Collection<WorkerDelivers> workerDeliversById) {
        this.workerDeliversById = workerDeliversById;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", updatingAutomatWithCoinsById=" + updatingAutomatWithCoinsById +
                ", updatingAutomatWithSnacksById=" + updatingAutomatWithSnacksById +
                ", withdrawingMoneyFromAutomatsById=" + withdrawingMoneyFromAutomatsById +
                ", workerDeliversById=" + workerDeliversById +
                '}';
    }
}
