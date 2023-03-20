package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;

import com.dawes.model.Actividad;

import java.util.List;

public interface ActividadRepository extends CrudRepository<Actividad, Integer>{

    List<Actividad> findAllByOrderByFechaDesc();

}
