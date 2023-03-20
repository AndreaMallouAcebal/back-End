package com.dawes.controller;

import java.util.List;
import java.util.Optional;
import com.dawes.model.Usuario;
import com.dawes.service.UsuarioService;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.dawes.model.Cita;
import com.dawes.service.CitaService;
@CrossOrigin(origins="*")
@RestController
//@RequestMapping("/citas")
public class CitaController {
	
	@Autowired
	private CitaService citaService;
	@Autowired
	private UsuarioService usuarioService;
	

	// método para listar todas las citas
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/citas")
	public List<Cita> listarCitas() {
		return citaService.findAll();
	}
	@PostMapping("/mis-citas")
	public List<Cita> listarMisCitas(@RequestParam("userEmail") String userEmail) {
		Usuario u = usuarioService.findByEmail(userEmail).get();
		return citaService.findByUsuario(u);
	}

	// método para guardar una cita
	@PostMapping("/citas")
	public Cita guardarCitas(@RequestBody Cita cita) {
		return citaService.save(cita);
	}

	@PostMapping("/citas/{email}")
	public Cita guardarCitaSinUsuario(@RequestBody Cita cita, @PathVariable String email) {
		Usuario usuario = usuarioService.findByEmail(email).get();
		cita.setUsuario(usuarioService.findByEmail(email).get());
		if(citaService.existsByUsuarioAndAnimal(usuario, cita.getAnimal())) {
			cita.setId(citaService.findByUsuarioAndAnimal(usuario, cita.getAnimal()).getId());
		}
		return citaService.save(cita);
	}
	
	
	// método para listar todas las citas
	@GetMapping("/citas/{id}")
	public Optional<Cita> recuperarCita(@PathVariable Integer id) {
		return citaService.findById(id);
	}

	//modificar
	@PreUpdate
	@PutMapping("/citas/{id}")
	public ResponseEntity<Cita>  modificarRol(@RequestBody Cita detallesCita, @PathVariable Integer id ) {
		 
		Optional<Cita> cita= citaService.findById(id);
		cita.get().setId(detallesCita.getId());
		cita.get().setFecha(detallesCita.getFecha());
		cita.get().setAnimal(detallesCita.getAnimal());
		cita.get().setUsuario(detallesCita.getUsuario());
		
		Cita citaActualizada= citaService.save(cita.get());
		
		return ResponseEntity.ok(citaActualizada);
		
	}

	@PreRemove
	@DeleteMapping("/citas/{id}")
	// retorna verdadero si el elemento fue eliminado, si no lo encuentra
	public void eliminarCita(@PathVariable Integer id) {
		citaService.deleteById(id);
	}

}
