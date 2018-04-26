package com.tukkijamm.backend.dao;

import org.springframework.data.repository.CrudRepository;

import com.tukkijamm.backend.model.Car;

public interface CarRepository extends CrudRepository<Car, Long> {


	/**
	 * This method will find a Car instance in the database by its immatriculationNumber. 
	 * Note that this method is not implemented and its working code will be
	 * automagically generated from its signature by Spring Data JPA.
	 * @param immatriculationNumber
	 * @return {@link String}
	 */
	Car findByImmatriculationNumber(String immatriculationNumber);
}
