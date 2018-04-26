package com.tukkijamm.backend.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tukkijamm.backend.dao.CarRepository;
import com.tukkijamm.backend.model.Car;
import com.tukkijamm.backend.service.CarService;
@Service("carService")
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarRepository carRepository ;
	@Override
	public List<Car> findAll() {
		Iterable<Car> iteratorToList=carRepository.findAll();  
	    List<Car> myList = new ArrayList<Car>();
	    for (Car c:iteratorToList) {
	        myList.add(c);
	    }
		return myList;
	}

	@Override
	public void save(Car car) {
		// TODO Auto-generated method stub
		carRepository.save(car);
	}

}
