package com.tukkijamm.backend.dao;

import org.springframework.data.repository.CrudRepository;

import com.tukkijamm.backend.model.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
	
}
