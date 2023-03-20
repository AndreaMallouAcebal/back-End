package com.dawes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.model.Actividad;
import com.dawes.service.ActividadService;

@RestController
@CrossOrigin(origins="*")
public class ActividadController {

	@Autowired
	private ActividadService actividadService;
	

	// método para listar todas las actividades
	@GetMapping("/actividades")
	public List<Actividad> listarActividades() {
		return actividadService.findAllByOrderByFechaDesc();
	}

	// método para guardar una actividad
	// @requestBody es para enviar el objeto en formato Json
	@PostMapping("/actividades")
	public Actividad guardarActividad(@RequestBody Actividad actividad) {
		return actividadService.save(actividad);
	}

	
	// método para listar todas las actividades
	@GetMapping("/actividades/{id}")
	public Optional<Actividad> recuperarActividad(@PathVariable Integer id) {
		return actividadService.findById(id);
	}

	//modificar
	@PutMapping("/actividades/{id}")
	public ResponseEntity<Actividad>  modificarActividad(@RequestBody Actividad detallesActividad, @PathVariable Integer id ) {
		 
		Optional<Actividad> actividad= actividadService.findById(id);
		actividad.get().setId(detallesActividad.getId());
		actividad.get().setNombre(detallesActividad.getNombre());
		actividad.get().setFecha(detallesActividad.getFecha());
		actividad.get().setDescripcion(detallesActividad.getDescripcion());

		
		
		Actividad actividadActualizado= actividadService.save(actividad.get());
		
		return ResponseEntity.ok(actividadActualizado);
	}
	

	@DeleteMapping("/actividades/{id}")
	// retorna verdadero si el elemento fue eliminado, si no lo encuentra
	public void deleteActividad(@PathVariable Integer id) {

		actividadService.deleteById(id);
	}
	
	
}
