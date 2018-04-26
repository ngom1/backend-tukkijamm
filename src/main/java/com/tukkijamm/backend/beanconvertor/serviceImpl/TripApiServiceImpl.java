package com.tukkijamm.backend.beanconvertor.serviceImpl;

import org.springframework.stereotype.Service;

import com.tukkijamm.backend.beanconvertor.service.TripApiService;
import com.tukkijamm.backend.dto.TripDTO;
import com.tukkijamm.backend.model.Trip;
@Service("tripApiService")
public class TripApiServiceImpl implements TripApiService {

	@Override
	public TripDTO convertTripToTripDTO(Trip trip) {
		TripDTO tripDTO = new TripDTO();
		if(trip!=null){
			tripDTO.setId(trip.getId());
			tripDTO.setAvis(trip.getAvis());
		}
		return tripDTO;
	}
}
