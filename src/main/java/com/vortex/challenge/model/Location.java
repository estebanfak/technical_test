package com.vortex.challenge.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "LOCATIONS")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCATION_ID")
    private short locationId;
    @Column(name = "STREET_ADRESS")
    private String streetAdress;
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE_PROVINCE")
    private String stateProvince;
    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country countryId;
    @OneToMany(mappedBy = "locationId")
    private Set<Department> departments = new HashSet<>();

    public Location(String streetAdress, String postalCode, String city, String stateProvince, Country country){
        this.streetAdress = streetAdress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.countryId = country;
    }

    public void addDepartment(Department department) {
        departments.add(department);
        department.setLocationId(this);
    }
}
