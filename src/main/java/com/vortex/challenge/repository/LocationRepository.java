package com.vortex.challenge.repository;

import com.vortex.challenge.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findByLocationId(short locationId);
    Location findByStreetAdress(String streetAdress);
}
