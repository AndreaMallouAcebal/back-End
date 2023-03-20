package com.dawes.repository;

import com.dawes.model.Animal;
import com.dawes.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import com.dawes.model.Cita;

import java.util.List;

public interface CitaRepository extends CrudRepository<Cita, Integer> {
    List<Cita> findByUsuario(Usuario usuario);
    boolean existsByUsuarioAndAnimal(Usuario usuario, Animal animal);

    Cita findByUsuarioAndAnimal(Usuario usuario, Animal animal);
}
