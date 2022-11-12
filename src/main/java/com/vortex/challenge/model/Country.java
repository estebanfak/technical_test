package com.vortex.challenge.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "COUNTRIES")
public class Country {
    @Id
    @Column(name = "COUNTRY_ID")
    private String countryId;
    @Column(name = "COUNTRY_NAME")
    private String countryName;
    @ManyToOne
    @JoinColumn(name = "REGION_ID")
    private Region regionId;
    @OneToMany(mappedBy = "countryId")
    private Set<Location> locations = new HashSet<>();

    public Country(String countryId, String countryName, Region regionId){
        this.countryId = countryId;
        this.countryName = countryName;
        this.regionId = regionId;
    }

    public void addLocation(Location location) {
        locations.add(location);
        location.setCountryId(this);
    }
}
