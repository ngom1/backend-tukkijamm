package com.tukkijamm.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tukkijamm.backend.model.Car;
import com.tukkijamm.backend.service.CarService;

@RestController
@RequestMapping(value = "/api/cars")
public class CarController {

	@Autowired
	private CarService carService;

	@RequestMapping(value = "/getCars", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<Car>> getCars() {
		Car car = new Car();
		car.setBrand("NISSAN");
		car.setColor("RED");
		car.setImmatriculationNumber("A589FG");
		car.setModel("MICRA");
		carService.save(car);
		List<Car> cars = carService.findAll();
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveCar", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<Car> saveCar() {
		Car car = new Car();
		car.setBrand("NISSAN");
		car.setColor("RED");
		car.setImmatriculationNumber("A589FG");
		car.setModel("MICRA");
		
		return new ResponseEntity<Car>(car,HttpStatus.OK);
	}

}
