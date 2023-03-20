package com.dawes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.model.Rol;
import com.dawes.service.RolService;
@CrossOrigin(origins="*")
@RestController
//@RequestMapping("/roles")
public class RolController {
	@Autowired
	private RolService rolService;

	// método para listar todos los roles
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/roles")
	public List<Rol> listarRoles() {
		return rolService.findAll();
	}

	// método para guardar un rol
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/roles")
	public Rol guardarRoles(@RequestBody Rol rol) {
		return rolService.save(rol);
	}


	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/roles/{id}")
	public Optional<Rol> recuperarRol(@PathVariable Integer id) {
		return rolService.findById(id);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping("/roles/{id}")
	public ResponseEntity<Rol>  modificarRol(@RequestBody Rol detallesRol, @PathVariable Integer id ) {
		 
		Optional<Rol> rol= rolService.findById(id);
		rol.get().setId(detallesRol.getId());
		rol.get().setNombre(detallesRol.getNombre());		
		
		
		Rol rolActualizado= rolService.save(rol.get());
		
		return ResponseEntity.ok(rolActualizado);
		
	}


	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping("/roles/{id}")
	// retorna verdadero si el elemento fue eliminado, si no lo encuentra
	public void eliminarRol(@PathVariable Integer id) {
		rolService.deleteById(id);
	}
	


}
