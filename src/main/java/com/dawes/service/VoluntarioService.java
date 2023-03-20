//package com.dawes.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.dawes.model.Voluntario;
//import com.dawes.repository.VoluntarioRepository;
//
//@Service
//public class VoluntarioService implements VoluntarioRepository{
//
//	
//	@Autowired
//	private VoluntarioRepository voluntarioRepository;
//	
//	@Override
//	public List<Voluntario> findAll() {
//		return (List<Voluntario>) voluntarioRepository.findAll();
//	}
//	
//	@Override
//	public <S extends Voluntario> S save(S entity) {
//		return voluntarioRepository.save(entity);
//	}
//	
//	@Override
//	public Optional<Voluntario> findById(Integer id) {
//		// TODO Auto-generated method stub
//		return voluntarioRepository.findById(id);
//	}
//	
//	@Override
//	public void deleteById(Integer id) {
//		voluntarioRepository.deleteById(id);
//		
//	}
//	
//
//	@Override
//	public <S extends Voluntario> Iterable<S> saveAll(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public boolean existsById(Integer id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public Iterable<Voluntario> findAllById(Iterable<Integer> ids) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public long count() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//
//	@Override
//	public void delete(Voluntario entity) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAllById(Iterable<? extends Integer> ids) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAll(Iterable<? extends Voluntario> entities) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAll() {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
