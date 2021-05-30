package com.iot.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "updating_automat_with_coins", schema = "third_lab")
public class UpdatingAutomatWithCoins {
    private int id;
    private int snackAutomatId;
    private int workerId;
    private Date dateOfUpdating;
    private int sumOfCoinsInDollars;
    private int numberOfCoins;
    private SnackAutomat snackAutomatBySnackAutomatId;
    private Worker workerByWorkerId;

    public UpdatingAutomatWithCoins(int id, int snackAutomatId, int workerId, Date dateOfUpdating, int sumOfCoinsInDollars, int numberOfCoins, SnackAutomat snackAutomatBySnackAutomatId, Worker workerByWorkerId) {
        this.id = id;
        this.snackAutomatId = snackAutomatId;
        this.workerId = workerId;
        this.dateOfUpdating = dateOfUpdating;
        this.sumOfCoinsInDollars = sumOfCoinsInDollars;
        this.numberOfCoins = numberOfCoins;
        this.snackAutomatBySnackAutomatId = snackAutomatBySnackAutomatId;
        this.workerByWorkerId = workerByWorkerId;
    }

    public UpdatingAutomatWithCoins() {

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
    @Column(name = "date_of_updating", nullable = false)
    public Date getDateOfUpdating() {
        return dateOfUpdating;
    }

    public void setDateOfUpdating(Date dateOfUpdating) {
        this.dateOfUpdating = dateOfUpdating;
    }

    @Basic
    @Column(name = "sum_of_coins_in_dollars", nullable = false, precision = 0)
    public int getSumOfCoinsInDollars() {
        return sumOfCoinsInDollars;
    }

    public void setSumOfCoinsInDollars(int sumOfCoinsInDollars) {
        this.sumOfCoinsInDollars = sumOfCoinsInDollars;
    }

    @Basic
    @Column(name = "number_of_coins", nullable = false)
    public int getNumberOfCoins() {
        return numberOfCoins;
    }

    public void setNumberOfCoins(int numberOfCoins) {
        this.numberOfCoins = numberOfCoins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdatingAutomatWithCoins that = (UpdatingAutomatWithCoins) o;

        if (id != that.id) return false;
        if (snackAutomatId != that.snackAutomatId) return false;
        if (workerId != that.workerId) return false;
        if (sumOfCoinsInDollars != that.sumOfCoinsInDollars) return false;
        if (numberOfCoins != that.numberOfCoins) return false;
        if (!Objects.equals(dateOfUpdating, that.dateOfUpdating))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + snackAutomatId;
        result = 31 * result + workerId;
        result = 31 * result + (dateOfUpdating != null ? dateOfUpdating.hashCode() : 0);
        result = 31 * result + sumOfCoinsInDollars;
        result = 31 * result + numberOfCoins;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "snack_automat_id", referencedColumnName = "id", nullable = false)
    public SnackAutomat getSnackAutomatBySnackAutomatId() {
        return snackAutomatBySnackAutomatId;
    }

    public void setSnackAutomatBySnackAutomatId(SnackAutomat snackAutomatBySnackAutomatId) {
        this.snackAutomatBySnackAutomatId = snackAutomatBySnackAutomatId;
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
        return "UpdatingAutomatWithCoins{" +
                "id=" + id +
                ", snackAutomatId=" + snackAutomatId +
                ", workerId=" + workerId +
                ", dateOfUpdating=" + dateOfUpdating +
                ", sumOfCoinsInDollars=" + sumOfCoinsInDollars +
                ", numberOfCoins=" + numberOfCoins +
                ", snackAutomatBySnackAutomatId=" + snackAutomatBySnackAutomatId +
                ", workerByWorkerId=" + workerByWorkerId +
                '}';
    }
}
