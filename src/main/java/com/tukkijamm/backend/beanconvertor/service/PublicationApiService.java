package com.tukkijamm.backend.beanconvertor.service;

import java.util.List;

import com.tukkijamm.backend.dto.PublicationDTO;
import com.tukkijamm.backend.model.Publication;

public interface PublicationApiService {
	/**
	 * 
	 * @param publication
	 * @return
	 */
	public PublicationDTO convertPublicationToPublicationDTO(Publication publication);
	
	/**
	 * 
	 * @param publications
	 * @return
	 */
	public List<PublicationDTO> convertoPublicationListToPublicationDTOList(List<Publication> publications);
	
}
