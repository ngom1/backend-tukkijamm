package com.tukkijamm.backend.service;

import com.tukkijamm.backend.model.Trip;

public interface TripService extends GenericService<Trip, Long>{

	/**
	 * 
	 * @param comment {@link Trip}
	 * @return {@link Trip}
	 */
	public Trip addCommentToAtrip(Trip trip);
}
