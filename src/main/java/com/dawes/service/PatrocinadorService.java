package com.dawes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.model.Patrocinador;
import com.dawes.repository.PatrocinadorRepository;
@Service
public class PatrocinadorService implements PatrocinadorRepository{

	@Autowired
	private PatrocinadorRepository patrocinadorRepository;
	
	
	@Override
	public List<Patrocinador> findAll() {
		return (List<Patrocinador>) patrocinadorRepository.findAll();
	}
	
	@Override
	public <S extends Patrocinador> S save(S entity) {
		return patrocinadorRepository.save(entity);
	}
	
	@Override
	public Optional<Patrocinador> findById(Integer id) {
		// TODO Auto-generated method stub
		return patrocinadorRepository.findById(id);
	}
	
	@Override
	public void deleteById(Integer id) {
		patrocinadorRepository.deleteById(id);
		
	}
	
	
	@Override
	public <S extends Patrocinador> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public Iterable<Patrocinador> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public void delete(Patrocinador entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Patrocinador> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
