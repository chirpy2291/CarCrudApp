package com.sneha.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sneha.model.Cars;
import com.sneha.repository.CarsRepository;

@Service
public class CarsService {
	
	@Autowired
	CarsRepository carsRepository;

	public List<Cars> getAllCars() {
		List<Cars> cars = new ArrayList<Cars>();
		carsRepository.findAll().forEach(car -> cars.add(car));
		return cars;
	}

	public Cars getCarsById(int id) {
		return carsRepository.findById(id).get();
	}

	public void saveOrUpdate(Cars cars)  {

		
		carsRepository.save(cars);

	}

	public void delete(int id) {
		carsRepository.deleteById(id);
	}

	public void update(Cars cars, int carid) {
		carsRepository.save(cars);
	}
}