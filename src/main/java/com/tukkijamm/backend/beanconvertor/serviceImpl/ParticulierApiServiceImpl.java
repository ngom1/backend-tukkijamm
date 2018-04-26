package com.tukkijamm.backend.beanconvertor.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tukkijamm.backend.beanconvertor.service.ParticulierApiService;
import com.tukkijamm.backend.dto.ParticulierDTO;
import com.tukkijamm.backend.model.Particulier;

/**
 * 
 * @author mamadou
 *
 */
@Service("particulierApiService")
public class ParticulierApiServiceImpl implements ParticulierApiService {

	@Override
	public ParticulierDTO convertParticulierToParticulierDTO(Particulier particulier) {
		ParticulierDTO particulierDTO = new ParticulierDTO();
		if( particulier!=null){
			particulierDTO.setId(particulier.getId());
			particulierDTO.setBirthday(particulier.getBirthday());
			particulierDTO.setEmail(particulier.getEmail());
			particulierDTO.setFirstName(particulier.getFirstName());
			particulierDTO.setLastName(particulier.getLastName());
			particulierDTO.setLogin(particulier.getLogin());
			particulierDTO.setPassword(particulier.getPassword());
			particulierDTO.setSex(particulier.getSex());
			particulierDTO.setTelephone(particulier.getTelephone());
		}
		return particulierDTO;
	}

	@Override
	public List<ParticulierDTO> convertParticulierListToParticulierDTOList(List<Particulier> particulierList) {
		List<ParticulierDTO>particulierDTOList = new ArrayList<ParticulierDTO>();
		for (Particulier particulier : particulierList){
			particulierDTOList.add(convertParticulierToParticulierDTO(particulier));
		}
		return particulierDTOList;
	}

}
