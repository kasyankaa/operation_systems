package com.iot.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "withdrawing_money_from_automat", schema = "third_lab")
public class WithdrawingMoneyFromAutomat {
    private int id;
    private int snackAutomatId;
    private int workerId;
    private Date dateOfWithdrawing;
    private int sumOfMoneyInDollars;
    private SnackAutomat snackAutomatBySnackAutomatId;
    private Worker workerByWorkerId;

    public WithdrawingMoneyFromAutomat(int id, int snackAutomatId, int workerId, Date dateOfWithdrawing, int sumOfMoneyInDollars, SnackAutomat snackAutomatBySnackAutomatId, Worker workerByWorkerId) {
        this.id = id;
        this.snackAutomatId = snackAutomatId;
        this.workerId = workerId;
        this.dateOfWithdrawing = dateOfWithdrawing;
        this.sumOfMoneyInDollars = sumOfMoneyInDollars;
        this.snackAutomatBySnackAutomatId = snackAutomatBySnackAutomatId;
        this.workerByWorkerId = workerByWorkerId;
    }

    public WithdrawingMoneyFromAutomat() {

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
    @Column(name = "date_of_withdrawing", nullable = false)
    public Date getDateOfWithdrawing() {
        return dateOfWithdrawing;
    }

    public void setDateOfWithdrawing(Date dateOfWithdrawing) {
        this.dateOfWithdrawing = dateOfWithdrawing;
    }

    @Basic
    @Column(name = "sum_of_money_in_dollars", nullable = false, precision = 0)
    public int getSumOfMoneyInDollars() {
        return sumOfMoneyInDollars;
    }

    public void setSumOfMoneyInDollars(int sumOfMoneyInDollars) {
        this.sumOfMoneyInDollars = sumOfMoneyInDollars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WithdrawingMoneyFromAutomat that = (WithdrawingMoneyFromAutomat) o;

        if (id != that.id) return false;
        if (snackAutomatId != that.snackAutomatId) return false;
        if (workerId != that.workerId) return false;
        if (sumOfMoneyInDollars != that.sumOfMoneyInDollars) return false;
        if (dateOfWithdrawing != null ? !dateOfWithdrawing.equals(that.dateOfWithdrawing) : that.dateOfWithdrawing != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + snackAutomatId;
        result = 31 * result + workerId;
        result = 31 * result + (dateOfWithdrawing != null ? dateOfWithdrawing.hashCode() : 0);
        result = 31 * result + sumOfMoneyInDollars;
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
        return "WithdrawingMoneyFromAutomat{" +
                "id=" + id +
                ", snackAutomatId=" + snackAutomatId +
                ", workerId=" + workerId +
                ", dateOfWithdrawing=" + dateOfWithdrawing +
                ", sumOfMoneyInDollars=" + sumOfMoneyInDollars +
                ", snackAutomatBySnackAutomatId=" + snackAutomatBySnackAutomatId +
                ", workerByWorkerId=" + workerByWorkerId +
                '}';
    }
}
