package com.tukkijamm.backend.service;

import java.util.List;

import com.tukkijamm.backend.model.Car;

public interface CarService {
   
	/**
	 * get all cars
	 * @return {@link List} {@link Car}
	 */
	public List<Car> findAll();
	
	/**
	 * save a car
	 * @param car {@link Car}
	 */
	public void save(Car car);
}
