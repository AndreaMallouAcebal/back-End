package com.dawes.service;

import java.util.List;
import java.util.Optional;

import com.dawes.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.model.Actividad;
import com.dawes.model.ActividadUsuario;
import com.dawes.repository.ActividadUsuarioRepository;
@Service
public class ActividadUsuarioService implements ActividadUsuarioRepository{

	
	//Con autowired creamos una inyeccion del elemento, sin necesidad de crear una instancia
			@Autowired
			private ActividadUsuarioRepository acRepository;
		
			@Override
			public List<ActividadUsuario> findAll() {
				return (List<ActividadUsuario>) acRepository.findAll();
			}
			
			@Override
			public <S extends ActividadUsuario> S save(S entity) {
				return acRepository.save(entity);
			}
			
			@Override
			public List<ActividadUsuario> findByActividad(Actividad a) {
				return acRepository.findByActividad(a);
			}

			@Override
			public ActividadUsuario findByActividadAndUsuario(Actividad a, Usuario u) {
				return acRepository.findByActividadAndUsuario(a,u);
			}
			@Override
			public boolean existsByActividadAndUsuario(Actividad a, Usuario u) {
				return acRepository.existsByActividadAndUsuario(a,u);
			}



	@Override
			public Optional<ActividadUsuario> findById(Integer id) {
				// TODO Auto-generated method stub
				return acRepository.findById(id);
			}
			
			@Override
			public void deleteById(Integer id) {
				acRepository.deleteById(id);
			}
	

	@Override
	public <S extends ActividadUsuario> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public Iterable<ActividadUsuario> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void delete(ActividadUsuario entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends ActividadUsuario> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}



}
