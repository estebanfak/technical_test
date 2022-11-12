package com.vortex.challenge.repository;

import com.vortex.challenge.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByLocationId(short locationId);
    Location findByStreetAdress(String streetAdress);
}
