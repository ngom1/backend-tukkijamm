package com.tukkijamm.backend.service;

import com.tukkijamm.backend.model.Reservation;

public interface ReservationService extends GenericService<Reservation, Long>{

	/**
	 * Book a trip 
	 * @param reservation {@link Reservation}
	 * @return {@link Reservation}
	 */
	public Reservation bookATrip(Reservation reservation);
	
	/**
	 * cancel {@link Reservation} by driver
	 * @param id {@link Reservation} 
	 * @return the cancelled {@link Reservation} 
	 */
	public Reservation cancelReservationByDriver(Long id);
	
	/**
	 * cancel {@link Reservation} by passenger
	 * @param id {@link Reservation} 
	 * @return the cancelled {@link Reservation} 
	 */
	public Reservation cancelReservationByPassenger(Long id);
	
	
}
