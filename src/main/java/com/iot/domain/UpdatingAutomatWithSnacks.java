package com.iot.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "updating_automat_with_snacks", schema = "third_lab")
public class UpdatingAutomatWithSnacks {
    private int id;
    private int snackAutomatId;
    private int workerId;
    private Date dateOfUpdating;
    private String nameOfSnack;
    private int numberOfSnacks;
    private SnackAutomat snackAutomatBySnackAutomatId;
    private Worker workerByWorkerId;

    public UpdatingAutomatWithSnacks(int id, int snackAutomatId, int workerId, Date dateOfUpdating, String nameOfSnack, int numberOfSnacks, SnackAutomat snackAutomatBySnackAutomatId, Worker workerByWorkerId) {
        this.id = id;
        this.snackAutomatId = snackAutomatId;
        this.workerId = workerId;
        this.dateOfUpdating = dateOfUpdating;
        this.nameOfSnack = nameOfSnack;
        this.numberOfSnacks = numberOfSnacks;
        this.snackAutomatBySnackAutomatId = snackAutomatBySnackAutomatId;
        this.workerByWorkerId = workerByWorkerId;
    }

    public UpdatingAutomatWithSnacks() {

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
    @Column(name = "name_of_snack", nullable = false, length = 50)
    public String getNameOfSnack() {
        return nameOfSnack;
    }

    public void setNameOfSnack(String nameOfSnack) {
        this.nameOfSnack = nameOfSnack;
    }

    @Basic
    @Column(name = "number_of_snacks", nullable = false)
    public int getNumberOfSnacks() {
        return numberOfSnacks;
    }

    public void setNumberOfSnacks(int numberOfSnacks) {
        this.numberOfSnacks = numberOfSnacks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdatingAutomatWithSnacks that = (UpdatingAutomatWithSnacks) o;

        if (id != that.id) return false;
        if (snackAutomatId != that.snackAutomatId) return false;
        if (workerId != that.workerId) return false;
        if (numberOfSnacks != that.numberOfSnacks) return false;
        if (!Objects.equals(dateOfUpdating, that.dateOfUpdating))
            return false;
        if (!Objects.equals(nameOfSnack, that.nameOfSnack)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + snackAutomatId;
        result = 31 * result + workerId;
        result = 31 * result + (dateOfUpdating != null ? dateOfUpdating.hashCode() : 0);
        result = 31 * result + (nameOfSnack != null ? nameOfSnack.hashCode() : 0);
        result = 31 * result + numberOfSnacks;
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
        return "UpdatingAutomatWithSnacks{" +
                "id=" + id +
                ", snackAutomatId=" + snackAutomatId +
                ", workerId=" + workerId +
                ", dateOfUpdating=" + dateOfUpdating +
                ", nameOfSnack='" + nameOfSnack + '\'' +
                ", numberOfSnacks=" + numberOfSnacks +
                ", snackAutomatBySnackAutomatId=" + snackAutomatBySnackAutomatId +
                ", workerByWorkerId=" + workerByWorkerId +
                '}';
    }
}
