package com.vortex.challenge.repository;

import com.vortex.challenge.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
    Region findByRegionId(int regionId);
    Region findByRegionName(String regionName);
}
