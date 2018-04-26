package com.tukkijamm.backend.service;

import com.tukkijamm.backend.model.Particulier;

public interface ParticulierService extends GenericService<Particulier, Long>{

	/**
	 * Logging into the app
	 * @param login {@link String}
	 * @param password {@link String}
	 * @return {@link Particulier}
	 */
	public Particulier authentification(String login,String password);
	
	/**
	 * Create a {@link Particulier}
	 * @param particulier {@link Particulier}
	 * @return {@link Particulier}
	 */
	public Particulier subscription(Particulier particulier);
}
