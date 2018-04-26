package com.tukkijamm.backend.service;

import java.util.Date;
import java.util.List;

import com.tukkijamm.backend.model.Publication;

public interface PublicationService  extends GenericService<Publication, Long>{
	/**
	 * This method allows us to post a tripe
	 * @param publication {@link Publication}
	 */
	public Publication postTrip(Publication publication);
	
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
	 * Cancel a publication
	 * @param id {@link Publication} ID
	 * @return cancelled {@link Publication} 
	 */
	public Publication cancelPublication (Long id);

	/**
	 * 
	 * @return
	 */
	public List<Publication> findAll();
	
	
}
