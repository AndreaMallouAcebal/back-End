package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;

import com.dawes.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);

}
