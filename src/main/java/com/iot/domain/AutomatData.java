package com.iot.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "automat_data", schema = "third_lab")
public class AutomatData {
    private int id;
    private int snackAutomatId;
    private Timestamp timeOfSendingData;
    private SnackAutomat snackAutomatBySnackAutomatId;

    public AutomatData(int id, int snackAutomatId, Timestamp timeOfSendingData, SnackAutomat snackAutomatBySnackAutomatId) {
        this.id = id;
        this.snackAutomatId = snackAutomatId;
        this.timeOfSendingData = timeOfSendingData;
        this.snackAutomatBySnackAutomatId = snackAutomatBySnackAutomatId;
    }

    public AutomatData() {
         
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
    @Column(name = "time_of_sending_data", nullable = false)
    public Timestamp getTimeOfSendingData() {
        return timeOfSendingData;
    }

    public void setTimeOfSendingData(Timestamp timeOfSendingData) {
        this.timeOfSendingData = timeOfSendingData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutomatData that = (AutomatData) o;

        if (id != that.id) return false;
        if (snackAutomatId != that.snackAutomatId) return false;
        if (!Objects.equals(timeOfSendingData, that.timeOfSendingData))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + snackAutomatId;
        result = 31 * result + (timeOfSendingData != null ? timeOfSendingData.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "snack_automat_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public SnackAutomat getSnackAutomatBySnackAutomatId() {
        return snackAutomatBySnackAutomatId;
    }

    public void setSnackAutomatBySnackAutomatId(SnackAutomat snackAutomatBySnackAutomatId) {
        this.snackAutomatBySnackAutomatId = snackAutomatBySnackAutomatId;
    }

    @Override
    public String toString() {
        return "AutomatData{" +
                "id=" + id +
                ", snackAutomatId=" + snackAutomatId +
                ", timeOfSendingData=" + timeOfSendingData +
                ", snackAutomatBySnackAutomatId=" + snackAutomatBySnackAutomatId +
                '}';
    }
}
