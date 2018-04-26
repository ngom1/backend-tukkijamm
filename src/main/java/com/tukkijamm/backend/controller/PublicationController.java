package com.tukkijamm.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tukkijamm.backend.RequestBeans.PublicationRequestParam;
import com.tukkijamm.backend.RequestBeans.SearchTripRequestParam;
import com.tukkijamm.backend.beanconvertor.service.PublicationApiService;
import com.tukkijamm.backend.dto.PublicationDTO;
import com.tukkijamm.backend.model.Particulier;
import com.tukkijamm.backend.model.Publication;
import com.tukkijamm.backend.service.ParticulierService;
import com.tukkijamm.backend.service.PublicationService;

@RestController
@RequestMapping(value = "/api/publications")
public class PublicationController {
	
	@Autowired
	private PublicationService publicationService;

	@Autowired
	private ParticulierService particulierService;

	@Autowired
	private PublicationApiService publicationApiService;

	/**
	 * get all publications
	 * 
	 * @return {@link List} {@link PublicationDTO}
	 */
	@RequestMapping(value = "/getPublications", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<PublicationDTO>> getPublications() {
		List<Publication> publicationList = publicationService.findAll();
		List<PublicationDTO> publicationDTOList = publicationApiService
				.convertoPublicationListToPublicationDTOList(publicationList);
		return new ResponseEntity<List<PublicationDTO>>(publicationDTOList, HttpStatus.OK);
	}

	/**
	 * publish a trip
	 * 
	 * @param publicationToPost
	 *            {@link PublicationRequestParam}
	 * @return {@link ResponseEntity} {@link PublicationDTO}
	 */
	@RequestMapping(value = "/postPublication", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<PublicationDTO> postPublication(@RequestBody PublicationRequestParam publicationToPost) {
		Particulier particulier = particulierService.get(publicationToPost.getId());
		PublicationDTO publicationDTO = null;
		if (particulier != null) {
			Publication publication = new Publication(publicationToPost.getPublication());
			publication.setParticulier(particulier);
			publicationDTO = publicationApiService.convertPublicationToPublicationDTO(publication);
		}
		return new ResponseEntity<PublicationDTO>(publicationDTO, HttpStatus.OK);
	}
	
	/**
	 * publish a trip
	 * 
	 * @param publicationToPost
	 *            {@link PublicationRequestParam}
	 * @return {@link ResponseEntity} {@link PublicationDTO}
	 */
	@RequestMapping(value = "/searchTrip", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<PublicationDTO>> searchTrip(@RequestBody SearchTripRequestParam searchParam) {
		List<Publication> publicationList = publicationService.findByDepartureAndArrivalAndTripDate(searchParam.getDeparture(), searchParam.getArrival(), searchParam.getTripDate());
		List<PublicationDTO> publicationDTOList = publicationApiService.convertoPublicationListToPublicationDTOList(publicationList);
		return new ResponseEntity<List<PublicationDTO>>(publicationDTOList, HttpStatus.OK);
	}
	
	/**
	 * delete a publication from a {@link Particulier} who is a driver
	 * @param publication {@link Publication}
	 * @return deleted {@link Publication} converted to {@link PublicationDTO}
	 */
	@RequestMapping(value = "/cancelPublication", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<PublicationDTO>cancelPublication(@RequestBody Publication publication){
		Publication publicationEntity = null;
		if (publication!=null){
			publicationEntity = publicationService.cancelPublication(publication.getId());
		}
		//convert object to DTO
		PublicationDTO publicationDTO = publicationApiService.convertPublicationToPublicationDTO(publicationEntity);
		return new ResponseEntity<PublicationDTO>(publicationDTO,HttpStatus.OK);
	}
}
