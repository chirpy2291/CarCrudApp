package com.sneha.repository;

import org.springframework.data.repository.CrudRepository;

import com.sneha.model.Cars;  

public interface CarsRepository extends CrudRepository<Cars, Integer>  
{  
}  