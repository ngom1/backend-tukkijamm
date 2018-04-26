package com.tukkijamm.backend.service;

import java.util.List;

public interface GenericService<E,l> {;
   
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public E save(E entity) ;
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
    public void delete(E entity);
    /**
     * 
     * @param key
     * @return
     */
    public E get(l key);
    /**
     * 
     * @return
     */
    public List<E> findAll() ;
}