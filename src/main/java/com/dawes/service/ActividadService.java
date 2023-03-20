package com.dawes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.model.Actividad;
import com.dawes.repository.ActividadRepository;
@Service
public class ActividadService implements ActividadRepository{

	//Con autowired creamos una inyeccion del elemento, sin necesidad de crear una instancia
			@Autowired
			private ActividadRepository actividadRepository;
		
			@Override
			public List<Actividad> findAll() {
				return (List<Actividad>) actividadRepository.findAll();
			}

			@Override
            public List<Actividad> findAllByOrderByFechaDesc() { return (List<Actividad>) actividadRepository.findAllByOrderByFechaDesc(); }
			@Override
			public <S extends Actividad> S save(S entity) {
				return actividadRepository.save(entity);
			}
			
			@Override
			public Optional<Actividad> findById(Integer id) {
				// TODO Auto-generated method stub
				return actividadRepository.findById(id);
			}
			
			@Override
			public void deleteById(Integer id) {
				actividadRepository.deleteById(id);
				
			}
	
	
	@Override
	public <S extends Actividad> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Iterable<Actividad> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void delete(Actividad entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Actividad> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
