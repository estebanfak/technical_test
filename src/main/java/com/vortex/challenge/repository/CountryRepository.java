package com.vortex.challenge.repository;

import com.vortex.challenge.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByCountryId(String countryId);
}
