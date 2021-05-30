package com.iot.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "worker_delivers", schema = "third_lab")
public class WorkerDelivers {
    private int id;
    private int deliveryId;
    private int workerId;
    private String addressOfFactory;
    private String addressOfAutomat;
    private Delivery deliveryByDeliveryId;
    private Worker workerByWorkerId;

    public WorkerDelivers(int id, int deliveryId, int workerId, String addressOfFactory, String addressOfAutomat, Delivery deliveryByDeliveryId, Worker workerByWorkerId) {
        this.id = id;
        this.deliveryId = deliveryId;
        this.workerId = workerId;
        this.addressOfFactory = addressOfFactory;
        this.addressOfAutomat = addressOfAutomat;
        this.deliveryByDeliveryId = deliveryByDeliveryId;
        this.workerByWorkerId = workerByWorkerId;
    }

    public WorkerDelivers() {

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
    @Column(name = "address_of_factory", nullable = false, length = 200)
    public String getAddressOfFactory() {
        return addressOfFactory;
    }

    public void setAddressOfFactory(String addressOfFactory) {
        this.addressOfFactory = addressOfFactory;
    }

    @Basic
    @Column(name = "address_of_automat", nullable = false, length = 200)
    public String getAddressOfAutomat() {
        return addressOfAutomat;
    }

    public void setAddressOfAutomat(String addressOfAutomat) {
        this.addressOfAutomat = addressOfAutomat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkerDelivers that = (WorkerDelivers) o;

        if (id != that.id) return false;
        if (deliveryId != that.deliveryId) return false;
        if (workerId != that.workerId) return false;
        if (!Objects.equals(addressOfFactory, that.addressOfFactory))
            return false;
        if (!Objects.equals(addressOfAutomat, that.addressOfAutomat))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + deliveryId;
        result = 31 * result + workerId;
        result = 31 * result + (addressOfFactory != null ? addressOfFactory.hashCode() : 0);
        result = 31 * result + (addressOfAutomat != null ? addressOfAutomat.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "delivery_id", referencedColumnName = "id", nullable = false)
    public Delivery getDeliveryByDeliveryId() {
        return deliveryByDeliveryId;
    }

    public void setDeliveryByDeliveryId(Delivery deliveryByDeliveryId) {
        this.deliveryByDeliveryId = deliveryByDeliveryId;
    }

    @ManyToOne
    @JoinColumn(name = "worker_id", referencedColumnName = "id", nullable = false)
    public Worker getWorkerByWorkerId() {
        return workerByWorkerId;
    }

    public void setWorkerByWorkerId(Worker workerByWorkerId) {
        this.workerByWorkerId = workerByWorkerId;
    }

    @Override
    public String toString() {
        return "WorkerDelivers{" +
                "id=" + id +
                ", deliveryId=" + deliveryId +
                ", workerId=" + workerId +
                ", addressOfFactory='" + addressOfFactory + '\'' +
                ", addressOfAutomat='" + addressOfAutomat + '\'' +
                ", deliveryByDeliveryId=" + deliveryByDeliveryId +
                ", workerByWorkerId=" + workerByWorkerId +
                '}';
    }
}
