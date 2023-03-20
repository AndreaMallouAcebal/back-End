package com.dawes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dawes.model.Rol;
import com.dawes.repository.RolRepository;

@Service
public class RolService implements RolRepository{

	
	@Autowired
	private RolRepository rolRepository;
	
	
	@Override
	public List<Rol> findAll() {
		return (List<Rol>) rolRepository.findAll();
	}
	
	@Override
	public <S extends Rol> S save(S entity) {
		return rolRepository.save(entity);
	}

	@Override
	public Optional<Rol> findByNombre(String nombre) {
		return rolRepository.findByNombre(nombre);
	}
	@Override
	public Optional<Rol> findById(Integer id) {
		return rolRepository.findById(id);
	}
	
	@Override
	public void deleteById(Integer id) {
		rolRepository.deleteById(id);
		
	}
	
	
	@Override
	public <S extends Rol> Iterable<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		return false;
	}

	@Override
	public Iterable<Rol> findAllById(Iterable<Integer> ids) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}


	@Override
	public void delete(Rol entity) {

	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {

	}

	@Override
	public void deleteAll(Iterable<? extends Rol> entities) {

	}

	@Override
	public void deleteAll() {

	}
}
