package com.sneha.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sneha.model.Cars;
import com.sneha.repository.CarsRepository;

@Service
@CacheConfig(cacheNames = { "allCars" })
public class CarsService {

	@Autowired
	CarsRepository carsRepository;

	@Cacheable("allCars")
	public List<Cars> getAllCars() {
		List<Cars> cars = new ArrayList<Cars>();

		System.out.println("Going to sleep for 5 Secs.. to serve from  cache on subsequent calls.");
		try {
			Thread.sleep(1000 * 5);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		carsRepository.findAll().forEach(car -> cars.add(car));
		return cars;
	}

	@HystrixCommand(fallbackMethod = "defaultCars")
	public Cars getCarsById(int id) {
		return carsRepository.findById(id).get();
	}

	public Cars defaultCars(int id) {
		return new Cars();
	}

	// everytime post call is implemented,cache is evicted
	@CacheEvict(allEntries = true)
	public void saveOrUpdate(Cars cars) {

		carsRepository.save(cars);

	}

	public void delete(int id) {
		carsRepository.deleteById(id);
	}

	// everytime update happens ,cache is evicted
	@CacheEvict(allEntries = true)
	public void update(Cars cars, int carid) {
		carsRepository.save(cars);
	}
}