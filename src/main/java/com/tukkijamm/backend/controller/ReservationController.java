package com.tukkijamm.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tukkijamm.backend.RequestBeans.ReservationRequestParam;
import com.tukkijamm.backend.beanconvertor.service.ReservationApiService;
import com.tukkijamm.backend.dto.ReservationDTO;
import com.tukkijamm.backend.model.Particulier;
import com.tukkijamm.backend.model.Publication;
import com.tukkijamm.backend.model.Reservation;
import com.tukkijamm.backend.service.ParticulierService;
import com.tukkijamm.backend.service.PublicationService;
import com.tukkijamm.backend.service.ReservationService;

/**
 * 
 * @author mamadou
 *
 */
@RestController
@RequestMapping(value = "/api/reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ParticulierService particulierService;
	
	@Autowired
	private ReservationApiService reservationApiService;
	
	@Autowired
	private PublicationService publicationService; 
	
	/**
	 * get all reserations
	 * @return {@link List} {@link Reservation}
	 */
	@RequestMapping(value = "/getReservations", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<ReservationDTO>> getReservations() {
		List<Reservation> reservationList = reservationService.findAll();
		List<ReservationDTO> reservationDTOList = reservationApiService.convertoReservationListToReservationDTOList(reservationList);
		return new ResponseEntity<>(reservationDTOList,HttpStatus.OK);
	}
	
	/**
	 * make a reservation by a passenger
	 * @param reservation {@link ReservationRequestParam}
	 * @return {@link Reservation}
	 */
	@RequestMapping(value = "/bookAtrip", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<ReservationDTO>bookATrip(@RequestBody ReservationRequestParam postPublication){
		Particulier particulier = particulierService.get(postPublication.getPassengerId());
		Publication publication = publicationService.get(postPublication.getPublicationId());
		ReservationDTO reservationDTO = null;
		if (particulier!=null && publication !=null){
			Reservation reservationToSave = new Reservation();
			reservationToSave.setStatus(false);
			reservationToSave.setParticulier(particulier);
			reservationToSave.setPublication(publication);
			Reservation reservationEntity = reservationService.bookATrip(reservationToSave);
			reservationDTO = reservationApiService.convertReservationToReservationDTO(reservationEntity);
		}
		return new ResponseEntity<ReservationDTO>(reservationDTO,HttpStatus.OK);
	}
	
	/**
	 * cancel a reservation by a drver
	 * @param reservation {@link Reservation}
	 * @return {@link ReservationDTO}
	 */
	@RequestMapping(value = "/cancelReservationByDriver", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<ReservationDTO>cancelReservationByDriver(@RequestBody Reservation reservation){
		Reservation reservationEntity = reservationService.cancelReservationByDriver(reservation.getId());
		ReservationDTO reservationDTO = reservationApiService.convertReservationToReservationDTO(reservationEntity);
		return new ResponseEntity<ReservationDTO>(reservationDTO,HttpStatus.OK);
		
	}
	
	/**
	 * cancel a reservatio by a passenger
	 * @param reservation {@link Reservation}
	 * @return {@link ReservationDTO}
	 */
	@RequestMapping(value = "/cancelReservationByPassenger", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<ReservationDTO>cancelReservationByPassenger(@RequestBody Reservation reservation){
		Reservation reservationEntity = reservationService.cancelReservationByPassenger(reservation.getId());
		ReservationDTO reservationDTO = reservationApiService.convertReservationToReservationDTO(reservationEntity);
		return new ResponseEntity<ReservationDTO>(reservationDTO,HttpStatus.OK);
		
	}
}
