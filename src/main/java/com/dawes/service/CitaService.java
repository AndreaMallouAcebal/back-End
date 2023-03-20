package com.dawes.service;

import java.util.List;
import java.util.Optional;

import com.dawes.model.Animal;
import com.dawes.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dawes.model.Cita;
import com.dawes.repository.CitaRepository;

@Service
public class CitaService implements CitaRepository{

	
	@Autowired
	private CitaRepository citaRepository;
	
	
	@Override
	public List<Cita> findAll() {
		return (List<Cita>) citaRepository.findAll();
	}

	@Override
	public List<Cita> findByUsuario(Usuario usuario) {
		return citaRepository.findByUsuario(usuario);
	}

	@Override
	public boolean existsByUsuarioAndAnimal(Usuario usuario, Animal animal) {
		return citaRepository.existsByUsuarioAndAnimal(usuario,animal);
	}

	@Override
  	public Cita findByUsuarioAndAnimal(Usuario usuario, Animal animal) {
		return citaRepository.findByUsuarioAndAnimal(usuario,animal);
	}
	@Override
	public <S extends Cita> S save(S entity) {
		return citaRepository.save(entity);
	}
	
	@Override
	public Optional<Cita> findById(Integer id) {
		return citaRepository.findById(id);
	}
	
	@Override
	public void deleteById(Integer id) {
		citaRepository.deleteById(id);
		
	}
	

	@Override
	public <S extends Cita> Iterable<S> saveAll(Iterable<S> entities) {
		return null;
	}


	@Override
	public boolean existsById(Integer id) {
		return false;
	}

	@Override
	public Iterable<Cita> findAllById(Iterable<Integer> ids) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}


	@Override
	public void delete(Cita entity) {
		//generated
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		//generated

	}

	@Override
	public void deleteAll(Iterable<? extends Cita> entities) {
		//generated

	}

	@Override
	public void deleteAll() {
		//generated

	}

}
