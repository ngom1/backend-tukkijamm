package com.tukkijamm.backend.beanconvertor.service;

import java.util.List;

import com.tukkijamm.backend.dto.ReservationDTO;
import com.tukkijamm.backend.model.Reservation;

public interface ReservationApiService {
	/**
	 * 
	 * @param Reservation
	 * @return
	 */
	public ReservationDTO convertReservationToReservationDTO(Reservation reservation);
	
	/**
	 * 
	 * @param Reservations
	 * @return
	 */
	public List<ReservationDTO> convertoReservationListToReservationDTOList(List<Reservation> Reservations);
	
}
