package com.tukkijamm.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tukkijamm.backend.RequestBeans.LoginRequestParam;
import com.tukkijamm.backend.RequestBeans.TripRequestParam;
import com.tukkijamm.backend.beanconvertor.service.ParticulierApiService;
import com.tukkijamm.backend.beanconvertor.service.PublicationApiService;
import com.tukkijamm.backend.beanconvertor.service.ReservationApiService;
import com.tukkijamm.backend.beanconvertor.service.TripApiService;
import com.tukkijamm.backend.dto.ParticulierDTO;
import com.tukkijamm.backend.dto.PublicationDTO;
import com.tukkijamm.backend.dto.ReservationDTO;
import com.tukkijamm.backend.dto.TripDTO;
import com.tukkijamm.backend.model.Particulier;
import com.tukkijamm.backend.model.Reservation;
import com.tukkijamm.backend.model.Trip;
import com.tukkijamm.backend.service.ParticulierService;
import com.tukkijamm.backend.service.ReservationService;
import com.tukkijamm.backend.service.TripService;

/**
 * 
 * @author mamadou
 *
 */
@RestController
@RequestMapping(value = "/api/particuliers")
public class ParticulierController {

	@Autowired
	private ParticulierService particulierService;

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private TripService tripService;

	@Autowired
	private ParticulierApiService particulierApiService;

	@Autowired
	private PublicationApiService publicationApiService;

	@Autowired
	private ReservationApiService reservationApiService;

	@Autowired
	private TripApiService tripApiService;

	/**
	 * add a comment to a {@link Reservation}
	 * 
	 * @param param
	 *            {@link TripRequestParam}
	 * @return {@link TripDTO}
	 */
	@RequestMapping(value = "/addCommentToAtrip", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<TripDTO> addCommentToAtrip(@RequestBody TripRequestParam param) {
		Reservation reservation = reservationService.get(param.getReservationId());
		TripDTO tripDTO = null;
		if (reservation != null) {
			Trip trip = new Trip();
			trip.setAvis(param.getComments());
			Trip tripEntity = tripService.save(trip);
			tripDTO = tripApiService.convertTripToTripDTO(tripEntity);
		}
		return new ResponseEntity<TripDTO>(tripDTO, HttpStatus.OK);
	}

	/**
	 * get all particuliers
	 * 
	 * @return {@link List} {@link ParticulierDTO}
	 */
	@RequestMapping(value = "/getParticuliers", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<ParticulierDTO>> getParticuluers() {
		List<Particulier> particulierList = particulierService.findAll();
		List<ParticulierDTO> particulierDTOList = particulierApiService
				.convertParticulierListToParticulierDTOList(particulierList);
		return new ResponseEntity<List<ParticulierDTO>>(particulierDTOList, HttpStatus.OK);
	}

	/**
	 * authentification into the application
	 * 
	 * @param loginParam
	 *            {@link LoginRequestParam} {@link ParticulierDTO}
	 */
	@RequestMapping(value = "/authentification", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<ParticulierDTO> authentification(@RequestBody LoginRequestParam loginParam) {
		ParticulierDTO particulierDTO = null;
		if (!loginParam.getLogin().isEmpty() && !loginParam.getPassword().isEmpty()) {
			Particulier particulier = particulierService.authentification(loginParam.getLogin(),
					loginParam.getPassword());
			if (particulier != null) {
				// convert beans into DTOS
				List<PublicationDTO> publicationDTOList = publicationApiService
						.convertoPublicationListToPublicationDTOList(particulier.getPublications());
				List<ReservationDTO> reservationDTOList = reservationApiService
						.convertoReservationListToReservationDTOList(particulier.getReservations());

				particulierDTO = particulierApiService.convertParticulierToParticulierDTO(particulier);
				particulierDTO.setPublications(publicationDTOList);
				particulierDTO.setReservations(reservationDTOList);
			}
			return new ResponseEntity<ParticulierDTO>(particulierDTO, HttpStatus.OK);
		}
		return new ResponseEntity<ParticulierDTO>(particulierDTO, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * create a particuluer 
	 * @param particulier
	 * @return
	 */
	@RequestMapping(value = "/subscription", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<ParticulierDTO> subscription(@RequestBody Particulier particulier) {
		//TODO check if not already exist with the same username
		ParticulierDTO particulierDTO = particulierApiService.convertParticulierToParticulierDTO(particulierService.subscription(particulier));
		return new ResponseEntity<ParticulierDTO>(particulierDTO,HttpStatus.OK);
	}
	
	

}
