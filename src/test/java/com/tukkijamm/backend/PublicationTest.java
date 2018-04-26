package com.tukkijamm.backend;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tukkijamm.backend.model.Particulier;
import com.tukkijamm.backend.model.Publication;
import com.tukkijamm.backend.service.ParticulierService;
import com.tukkijamm.backend.service.PublicationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfiguration.class })
@WebAppConfiguration
public class PublicationTest {

	@Autowired
	private PublicationService publicationService;
	
	@Autowired
	private ParticulierService particulierService;
	
	
	@Test
	public void getParticulier(){
		Particulier particulier = new Particulier();
		particulier.setFirstName("John");
		Particulier particulier2 = particulierService.save(particulier);
		
			
	}
	@Test
	public void postTrip(){	
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
		assertEquals(publication.getDeparture(), publicationResultat.getDeparture());
	}
}
