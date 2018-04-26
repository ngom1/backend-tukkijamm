package com.tukkijamm.backend.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tukkijamm.backend.model.Publication;

public interface PublicationRepository extends CrudRepository<Publication, Long> {
	
	/**
	 * find all post for a particuler
	 * @param id particulier Od
	 * @return {@link List} {@link Publication}
	 */
	public List<Publication>findByParticulierId(long id);
	
	/**
	 * For displaying and filtring a search
	 * @param departure
	 * @param arrival
	 * @param tripDate
	 * @return {@link Publication}
	 */
	public List<Publication>findByDepartureAndArrivalAndTripDate(String departure,
			String arrival,Date tripDate);
	
	

	/**
	 * 
	 * @return
	 */
	public List<Publication> findAll();
}
