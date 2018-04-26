package com.tukkijamm.backend.beanconvertor.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tukkijamm.backend.beanconvertor.service.PublicationApiService;
import com.tukkijamm.backend.dto.PublicationDTO;
import com.tukkijamm.backend.model.Publication;

@Service("publicationApiService")
public class PublicationApiServiceImpl implements PublicationApiService {

	@Override
	public PublicationDTO convertPublicationToPublicationDTO(Publication publication) {
		PublicationDTO publicationDTO = new PublicationDTO();
		if (publication!=null){
			publicationDTO.setId(publication.getId());
			publicationDTO.setArrival(publication.getArrival());
			publicationDTO.setDeparture(publication.getDeparture());
			publicationDTO.setAvailablePlaceNumber(publication.getAvailablePlaceNumber());
			publicationDTO.setDescription(publication.getDescription());
			publicationDTO.setPrice(publication.getPrice());
			publicationDTO.setPublicationDate(publication.getPublicationDate());
			publicationDTO.setTripDate(publication.getPublicationDate());
			publicationDTO.setStatus(publication.getStatus());
		}
		return publicationDTO;
	}

	@Override
	public List<PublicationDTO> convertoPublicationListToPublicationDTOList(List<Publication> publications) {
		List<PublicationDTO>publicationDTOList = new ArrayList<PublicationDTO>();
		if (publications!=null && !publications.isEmpty()){
			for (Publication publication : publications) {
				publicationDTOList.add(convertPublicationToPublicationDTO(publication));
			}
		}
		return publicationDTOList;
	}

}
