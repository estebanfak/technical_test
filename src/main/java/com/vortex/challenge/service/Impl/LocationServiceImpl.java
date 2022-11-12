package com.vortex.challenge.service.Impl;

import com.vortex.challenge.constant.Messages;
import com.vortex.challenge.exception.LocationNotFoundException;
import com.vortex.challenge.model.Location;
import com.vortex.challenge.repository.LocationRepository;
import com.vortex.challenge.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Override
    public Location findByLocationId(short locationId) throws LocationNotFoundException {
        return locationRepository.findByLocationId(locationId).orElseThrow(()-> new LocationNotFoundException(Messages.LOCATION_NOT_FOUND));
    }
}
