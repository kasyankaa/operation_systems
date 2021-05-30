package com.iot.domain;

import javax.persistence.*;

@Entity
@Table(name = "gps_tracker", schema = "third_lab")
public class GpsTracker {
    private int id;
    private int snackAutomatId;
    private String name;
    private float latitude;
    private float longtitude;
    private SnackAutomat snackAutomatBySnackAutomatId;

    public GpsTracker(int id, int snackAutomatId, String name, float latitude, float longtitude, SnackAutomat snackAutomatBySnackAutomatId) {
        this.id = id;
        this.snackAutomatId = snackAutomatId;
        this.name = name;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.snackAutomatBySnackAutomatId = snackAutomatBySnackAutomatId;
    }

    public GpsTracker() {

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
    @Column(name = "latitude", nullable = false, precision = 0)
    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longtitude", nullable = false, precision = 0)
    public float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(float longtitude) {
        this.longtitude = longtitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GpsTracker that = (GpsTracker) o;

        if (id != that.id) return false;
        if (snackAutomatId != that.snackAutomatId) return false;
        if (Double.compare(that.latitude, latitude) != 0) return false;
        if (Double.compare(that.longtitude, longtitude) != 0) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + snackAutomatId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longtitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
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

    @Override
    public String toString() {
        return "GpsTracker{" +
                "id=" + id +
                ", snackAutomatId=" + snackAutomatId +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longtitude=" + longtitude +
                ", snackAutomatBySnackAutomatId=" + snackAutomatBySnackAutomatId +
                '}';
    }
}
