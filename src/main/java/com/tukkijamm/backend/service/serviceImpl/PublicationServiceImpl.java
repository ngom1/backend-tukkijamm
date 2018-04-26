package com.tukkijamm.backend.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tukkijamm.backend.dao.PublicationRepository;
import com.tukkijamm.backend.model.Publication;
import com.tukkijamm.backend.service.PublicationService;

@Service("publicationService")
public class PublicationServiceImpl implements PublicationService {

	@Autowired
	private PublicationRepository publicationRepository;
	@Override
	public Publication postTrip(Publication publication) {
		return publicationRepository.save(publication);
	}

	@Override
	public List<Publication> findByParticulierId(long id) {
		return publicationRepository.findByParticulierId(id);
	}

	@Override
	public List<Publication> findByDepartureAndArrivalAndTripDate(String departure, String arrival, Date tripDate) {
		return publicationRepository.findByDepartureAndArrivalAndTripDate(departure, arrival, tripDate);
	}

	@Override
	public Publication cancelPublication(Long id) {
		Publication publication = publicationRepository.findOne(id);
		publication.setStatus(false);
		return publicationRepository.save(publication);
	}

	@Override
	public List<Publication> findAll() {
		Iterable<Publication> iteratorToList=publicationRepository.findAll();  
	    List<Publication> myList = new ArrayList<Publication>();
	    for (Publication c:iteratorToList) {
	        myList.add(c);
	    }
		return myList;
	}

	@Override
	public Publication save(Publication entity) {
		// TODO Auto-generated method stub
		return publicationRepository.save(entity);
	}

	@Override
	public void delete(Publication entity) {
		publicationRepository.delete(entity);
	}

	@Override
	public Publication get(Long key) {
		return publicationRepository.findOne(key);
	}
}
