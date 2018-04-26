package com.tukkijamm.backend.dao;

import org.springframework.data.repository.CrudRepository;

import com.tukkijamm.backend.model.Particulier;

public interface ParticulierRepository extends CrudRepository<Particulier, Long> {

	/**
	 * Find {@link Particulier} by login and password
	 * @param login {@link String}
	 * @param password {@link String}
	 * @return {@link Particulier}
	 */
	public Particulier findByLoginAndPassword(String login,String password);
}
