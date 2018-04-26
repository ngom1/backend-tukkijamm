package com.tukkijamm.backend.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tukkijamm.backend.dao.TripRepository;
import com.tukkijamm.backend.model.Trip;
import com.tukkijamm.backend.service.TripService;
/**
 * 
 * @author mamadou
 *
 */
@Service("tripService")
public class TripServiceImpl implements TripService {
	
	@Autowired
	private TripRepository tripRepository;
	@Override
	public Trip addCommentToAtrip(Trip trip) {
		return tripRepository.save(trip);
	}

	@Override
	public Trip save(Trip entity) {
		return tripRepository.save(entity);
	}

	@Override
	public void delete(Trip entity) {
		tripRepository.delete(entity);
	}

	@Override
	public Trip get(Long key) {
	    return tripRepository.findOne(key);
	}

	@Override
	public List<Trip> findAll() {
		Iterable<Trip> iteratorToList=tripRepository.findAll();  
	    List<Trip> myList = new ArrayList<Trip>();
	    for (Trip c:iteratorToList) {
	        myList.add(c);
	    }
		return myList;
	}

}
