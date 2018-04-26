package com.tukkijamm.backend.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tukkijamm.backend.dao.ReservationRepository;
import com.tukkijamm.backend.model.Reservation;
import com.tukkijamm.backend.service.ReservationService;

/**
 * 
 * @author mamadou
 *
 */
@Service("reservationService")
public class ReservationServiceImpl implements ReservationService {

	private static final String PASSANGER = "PASSENGER";
	private static final String DRIVER = "DRIVER";
	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public Reservation bookATrip(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation save(Reservation entity) {
		return reservationRepository.save(entity);
	}

	@Override
	public void delete(Reservation entity) {
		reservationRepository.delete(entity);
	}

	@Override
	public Reservation get(Long key) {
		return reservationRepository.findOne(key);
	}

	@Override
	public List<Reservation> findAll() {
		Iterable<Reservation> iteratorToList = reservationRepository.findAll();
		List<Reservation> myList = new ArrayList<Reservation>();
		for (Reservation c : iteratorToList) {
			myList.add(c);
		}
		return myList;
	}

	@Override
	public Reservation cancelReservationByDriver(Long id) {
		Reservation reservation = get(id);
		if (reservation != null) {
			reservation.setStatus(true);
			reservation.setDeletedOwner(PASSANGER);
		}
		return save(reservation);
	}

	@Override
	public Reservation cancelReservationByPassenger(Long id) {
		Reservation reservation = get(id);
		if (reservation != null) {
			reservation.setStatus(true);
			reservation.setDeletedOwner(DRIVER);
		}
		return save(reservation);
	}

}
