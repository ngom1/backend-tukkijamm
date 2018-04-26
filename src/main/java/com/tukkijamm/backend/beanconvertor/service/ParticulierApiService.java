package com.tukkijamm.backend.beanconvertor.service;

import java.util.List;

import com.tukkijamm.backend.dto.ParticulierDTO;
import com.tukkijamm.backend.model.Particulier;

public interface ParticulierApiService {

	public ParticulierDTO convertParticulierToParticulierDTO(Particulier particulier);
	
	public List<ParticulierDTO> convertParticulierListToParticulierDTOList(List<Particulier> particulierList);
}
