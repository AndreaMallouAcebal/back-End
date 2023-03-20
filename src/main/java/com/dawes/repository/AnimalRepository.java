package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;

import com.dawes.model.Animal;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {

	
}
