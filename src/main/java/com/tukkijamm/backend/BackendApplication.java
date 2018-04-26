package com.tukkijamm.backend;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tukkijamm.backend.model.Particulier;
import com.tukkijamm.backend.model.Publication;
import com.tukkijamm.backend.service.ParticulierService;
import com.tukkijamm.backend.service.PublicationService;
import com.tukkijamm.backend.service.serviceImpl.ParticulierServiceImpl;
import com.tukkijamm.backend.service.serviceImpl.PublicationServiceImpl;

@SpringBootApplication
public class BackendApplication {
	

	
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		
		    ParticulierServiceImpl particulierService = new ParticulierServiceImpl();
			PublicationServiceImpl publicationService = new PublicationServiceImpl();
		    Particulier particulier = new Particulier();
			particulier.setFirstName("John");
			Particulier particulier2 = particulierService.save(particulier);
			
				
	
			List<Particulier> particulierEntity =particulierService.findAll();
			
			Publication publication = new Publication();
			publication.setDeparture("dakar");
			publication.setArrival("thies");
			publication.setTripDate(new Date());
			publication.setAvailablePlaceNumber(2);
			publication.setDescription("le point de depart sera à police parcelles");
			publication.setPrice(452.05);
			publication.setPublicationDate(new Date());
			publication.setParticulier(particulierEntity.get(0));
			
			Publication publicationResultat = publicationService.save(publication);		
			
		
	}
}
