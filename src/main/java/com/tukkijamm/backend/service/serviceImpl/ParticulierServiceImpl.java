package com.tukkijamm.backend.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tukkijamm.backend.dao.ParticulierRepository;
import com.tukkijamm.backend.model.Particulier;
import com.tukkijamm.backend.service.ParticulierService;

@Service("particulierService")
public class ParticulierServiceImpl implements ParticulierService{

	@Autowired
	private ParticulierRepository particulierRepository;
	@Override
	public Particulier authentification(String login, String password) {
		// TODO Auto-generated method stub
		return particulierRepository.findByLoginAndPassword(login, password);
	}

	@Override
	public Particulier subscription(Particulier particulier) {
		return particulierRepository.save(particulier);
	}

	@Override
	public Particulier save(Particulier entity) {
		// TODO Auto-generated method stub
		return particulierRepository.save(entity);
	}

	@Override
	public void delete(Particulier entity) {
		// TODO Auto-generated method stub
		 particulierRepository.delete(entity);
	}

	@Override
	public Particulier get(Long key) {
		// TODO Auto-generated method stub
		return particulierRepository.findOne(key);
	}

	@Override
	public List<Particulier> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
