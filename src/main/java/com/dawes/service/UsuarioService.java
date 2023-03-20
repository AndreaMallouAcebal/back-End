package com.dawes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.model.Usuario;
import com.dawes.repository.UsuarioRepository;

@Service
public class UsuarioService implements UsuarioRepository{

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	@Override
	public <S extends Usuario> S save(S entity) {
		return usuarioRepository.save(entity);
	}
	
	@Override
	public Optional<Usuario> findById(Integer id) {
		return usuarioRepository.findById(id);
	}
	
	@Override
	public void deleteById(Integer id) {
		usuarioRepository.deleteById(id);
		
	}
	@Override
	public Optional<Usuario> findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public boolean existsByEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}

	@Override
	public <S extends Usuario> Iterable<S> saveAll(Iterable<S> entities) {
		// Auto-generated method stub
		return null;
	}


	@Override
	public boolean existsById(Integer id) {
		// Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Usuario> findAllById(Iterable<Integer> ids) {
		// Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// Auto-generated method stub
		return 0;
	}


	@Override
	public void delete(Usuario entity) {
		// Auto-generated method stub
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Usuario> entities) {
		// Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// Auto-generated method stub

	}

}
