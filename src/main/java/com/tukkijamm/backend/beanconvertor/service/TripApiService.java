package com.tukkijamm.backend.beanconvertor.service;

import com.tukkijamm.backend.dto.TripDTO;
import com.tukkijamm.backend.model.Trip;

public interface TripApiService {

	public TripDTO convertTripToTripDTO(Trip trip);
}
