package com.vortex.challenge.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
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
}
