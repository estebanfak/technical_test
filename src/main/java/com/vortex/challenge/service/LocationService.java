package com.vortex.challenge.service;

import com.vortex.challenge.exception.LocationNotFoundException;
import com.vortex.challenge.model.Location;

import java.util.Optional;

public interface LocationService {
    Location findByLocationId(short locationId) throws LocationNotFoundException;
}
