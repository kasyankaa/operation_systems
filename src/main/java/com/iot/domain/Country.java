package com.iot.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "country", schema = "third_lab")
public class Country {
    public Country(int id, String countryName) {
        this.id = id;
        this.countryName = countryName;
    }

    private int id;
    private String countryName;
    @OneToMany(mappedBy = "countryByCountryId")
    private Collection<Region> regionsById;

    public Country() {

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
    @Column(name = "country_name", nullable = true, length = 50)
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != country.id) return false;
        if (!Objects.equals(countryName, country.countryName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName +
                '}';
    }
}
