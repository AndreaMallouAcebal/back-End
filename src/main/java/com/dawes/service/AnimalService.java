package com.dawes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.model.Animal;
import com.dawes.repository.AnimalRepository;

@Service
public class AnimalService implements AnimalRepository{

	
	//Con autowired creamos una inyeccion del elemento, sin necesidad de crear una instancia
		@Autowired
		private AnimalRepository animalRepository;
	
		@Override
		public List<Animal> findAll() {
			return (List<Animal>) animalRepository.findAll();
		}
		
		@Override
		public <S extends Animal> S save(S entity) {
			return animalRepository.save(entity);
		}
		
		@Override
		public Optional<Animal> findById(Integer id) {
			// TODO Auto-generated method stub
			return animalRepository.findById(id);
		}
		
		@Override
		public void deleteById(Integer id) {
			animalRepository.deleteById(id);
			
		}
		
		//----------------------------------------------------------------------

		@Override
		public <S extends Animal> Iterable<S> saveAll(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public boolean existsById(Integer id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Animal> findAllById(Iterable<Integer> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}


		@Override
		public void delete(Animal entity) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAllById(Iterable<? extends Integer> ids) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll(Iterable<? extends Animal> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}


}
