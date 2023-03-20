package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;

import com.dawes.model.Rol;

import java.util.Optional;

public interface RolRepository extends CrudRepository<Rol, Integer> {
    Optional<Rol> findByNombre(String nombre);
}
