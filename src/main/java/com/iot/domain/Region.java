package com.iot.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "region", schema = "third_lab")
public class Region {
    private int id;
    private String regionName;
    private int countryId;
    private Collection<Factory> factoriesById;
    private Country countryByCountryId;

    public Region(int id, String regionName, int countryId, Collection<Factory> factoriesById, Country countryByCountryId) {
        this.id = id;
        this.regionName = regionName;
        this.countryId = countryId;
        this.factoriesById = factoriesById;
        this.countryByCountryId = countryByCountryId;
    }

    public Region() {

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
    @Column(name = "region_name", nullable = false, length = 50)
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Region region = (Region) o;

        if (id != region.id) return false;
        if (countryId != region.countryId) return false;
        if (regionName != null ? !regionName.equals(region.regionName) : region.regionName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        result = 31 * result + countryId;
        return result;
    }

    @OneToMany(mappedBy = "regionByRegionId")
    public Collection<Factory> getFactoriesById() {
        return factoriesById;
    }

    public void setFactoriesById(Collection<Factory> factoriesById) {
        this.factoriesById = factoriesById;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    public Country getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(Country countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", regionName='" + regionName + '\'' +
                ", countryId=" + countryId +
                ", factoriesById=" + factoriesById +
                ", countryByCountryId=" + countryByCountryId +
                '}';
    }
}
