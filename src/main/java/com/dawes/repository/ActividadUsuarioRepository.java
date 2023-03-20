package com.dawes.repository;

import java.util.List;
import java.util.Optional;

import com.dawes.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import com.dawes.model.Actividad;
import com.dawes.model.ActividadUsuario;

public interface ActividadUsuarioRepository extends CrudRepository<ActividadUsuario, Integer>{
	 List<ActividadUsuario> findByActividad(Actividad a);
	 ActividadUsuario findByActividadAndUsuario(Actividad a, Usuario u);
	boolean existsByActividadAndUsuario(Actividad a, Usuario u);

}
