package com.vortex.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Data
@Setter
@NoArgsConstructor
@Table(name = "REGIONS")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REGION_ID")
    private int regionId;
    @Column(name = "REGION_NAME")
    private String regionName;
    @OneToMany(mappedBy = "regionId")
    private Set<Country> countries = new HashSet<>();

    public Region(String regionName){
        this.regionName = regionName;
    }


    public void addCountry(Country country) {
        countries.add(country);
        country.setRegionId(this);
    }

    public int getRegionId() {
        return regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    @JsonIgnore
    public Set<Country> getCountries() {
        return countries;
    }
}
