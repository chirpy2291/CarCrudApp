package com.sneha.controller;

import com.sneha.model.Cars;
import com.sneha.service.CarsService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarsController {

	@Autowired
	CarsService carsService;

	@GetMapping("/car")
	private List<Cars> getAllCars() {
		return carsService.getAllCars();
	}

	@GetMapping("/car/{carid}")
	private Cars getCarsById(@PathVariable("carid") int carid) {
		return carsService.getCarsById(carid);
	}

	@DeleteMapping("/car/{carid}")
	private void deleteCar(@PathVariable("carid") int carid) {
		carsService.delete(carid);
	}

	@PostMapping("/cars")
	private int saveCar(@Valid @RequestBody Cars cars) {

		carsService.saveOrUpdate(cars);
		return cars.getCarid();
	}

	@PutMapping("/cars")
	private Cars update(@Valid @RequestBody Cars cars) {
		carsService.saveOrUpdate(cars);
		return cars;
	}
	
}