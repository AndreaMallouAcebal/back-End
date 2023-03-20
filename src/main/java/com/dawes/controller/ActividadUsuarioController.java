package com.dawes.controller;

import java.util.List;
import java.util.Optional;

import com.dawes.model.Actividad;
import com.dawes.model.Usuario;
import com.dawes.service.ActividadService;
import com.dawes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.dawes.model.ActividadUsuario;
import com.dawes.service.ActividadUsuarioService;

@CrossOrigin(origins="*")
@RestController
//@RequestMapping("/actividadesusuarios")
public class ActividadUsuarioController {


	@Autowired
	private ActividadUsuarioService actividadusuarioService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ActividadService actividadService;
	

	// método para listar todas las actividadesusuarios
	@GetMapping("/actividadesusuarios")
	public List<ActividadUsuario> listarActividadesUsuarios() {
		return actividadusuarioService.findAll();
	}
	
	@GetMapping("/ver-usuarios/{id}")
	public List<ActividadUsuario> listarActividadesUsuariosByActividad(@PathVariable Integer id) {
		return actividadusuarioService.findByActividad(actividadService.findById(id).get());
	}

	// método para guardar una actividadusuario
	@PostMapping("/actividadesusuarios")
	public ActividadUsuario guardarActividadUsuario(@RequestParam("idActividad") Integer idActividad, @RequestParam("userEmail") String userEmail) {
		ActividadUsuario actividadusuario = new ActividadUsuario();
		Actividad a = actividadService.findById(idActividad).get();
		Usuario u = usuarioService.findByEmail(userEmail).get();
		if(actividadusuarioService.existsByActividadAndUsuario(a,u)){
			throw new AuthorizationServiceException("Usuario ya apuntado a la actividad");
		}
		actividadusuario.setActividad(a);
		actividadusuario.setUsuario(u);
		return actividadusuarioService.save(actividadusuario);
	}

	
	// método para listar actividadesusuarios por id
	@GetMapping("/actividadesusuarios/{id}")
	public Optional<ActividadUsuario> recuperarActividadUsuario(@PathVariable Integer id) {
		return actividadusuarioService.findById(id);
	}

	//modificar actividadesusuarios
	@PutMapping("/actividadesusuarios/{id}")
	public ResponseEntity<ActividadUsuario>  modificarActividadUsuario(@RequestBody ActividadUsuario detallesActividadUsuario, @PathVariable Integer id ) {
		 
		Optional<ActividadUsuario> actividadusuario= actividadusuarioService.findById(id);
		actividadusuario.get().setId(detallesActividadUsuario.getId());
		actividadusuario.get().setActividad(detallesActividadUsuario.getActividad());
		actividadusuario.get().setUsuario(detallesActividadUsuario.getUsuario());
		
		ActividadUsuario actividadActualizado= actividadusuarioService.save(actividadusuario.get());
		
		return ResponseEntity.ok(actividadActualizado);
	}
	

	@DeleteMapping("/actividadesusuarios/{id}")
	public void deleteActividadUsuario(@PathVariable Integer id) {
		String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		ActividadUsuario actividadusuario =
				actividadusuarioService.findByActividadAndUsuario(actividadService.findById(id).get(),
																	usuarioService.findByEmail(userEmail).get());
		actividadusuarioService.deleteById(actividadusuario.getId());
	}
	
	
}
