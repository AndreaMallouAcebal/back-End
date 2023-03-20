//package com.dawes.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.dawes.model.Voluntario;
//import com.dawes.service.VoluntarioService;
//@CrossOrigin(origins="*")
//@RestController
////@RequestMapping("/voluntarios")
//public class VoluntarioController {
//
//	@Autowired
//	private VoluntarioService voluntarioService;
//
//	// método para listar todas las actividades
//	@GetMapping("/voluntarios")
//	public List<Voluntario> listarVoluntarios() {
//		List<Voluntario> v = voluntarioService.findAll();
//		return v;
//	}
//
//	// método para guardar una actividad
//	// @requestBody es para enviar el objeto en formato Json
//	@PostMapping("/voluntarios")
//	public Voluntario guardarVoluntario(@RequestBody Voluntario voluntario) {
//		return voluntarioService.save(voluntario);
//	}
//
//	
//	// método para listar todas los animales
//	@GetMapping("/voluntarios/{id}")
//	public Optional<Voluntario> recuperarVoluntario(@PathVariable Integer id) {
//		return voluntarioService.findById(id);
//	}
//
//	//modificar
//	@PutMapping("/voluntarios/{id}")
//	public ResponseEntity<Voluntario>  modificarVoluntario(@RequestBody Voluntario detallesVoluntario, @PathVariable Integer id ) {
//		 
//		Optional<Voluntario> voluntario= voluntarioService.findById(id);
//		voluntario.get().setId(detallesVoluntario.getId());
//		voluntario.get().setDiaSemana(detallesVoluntario.getDiaSemana());
//		voluntario.get().setHora(detallesVoluntario.getHora());
//		voluntario.get().setUsuario(detallesVoluntario.getUsuario());
//
//		
//		Voluntario voluntarioActualizado= voluntarioService.save(voluntario.get());
//		
//		return ResponseEntity.ok(voluntarioActualizado);
//		
//	}
//
//	@DeleteMapping("/voluntarios/{id}")
//	// retorna verdadero si el elemento fue eliminado, si no lo encuentra
//	public void eliminarVoluntario(@PathVariable Integer id) {
//		voluntarioService.deleteById(id);
//	}
//}
