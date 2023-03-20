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

import com.dawes.model.Patrocinador;
import com.dawes.service.PatrocinadorService;

@RestController
//@RequestMapping("/patrocinadores")
@CrossOrigin(origins="*")
public class PatrocinadorController {
	@Autowired
	private PatrocinadorService patrocinadorService;
	

	// método para listar todos los patrocinadores
	@GetMapping("/patrocinadores")
	public List<Patrocinador> listarPatrocinadores() {
		return patrocinadorService.findAll();
	}

	// método para guardar un patrocinador
	@PostMapping("/patrocinadores")
	public Patrocinador guardarPatrocinador(@RequestBody Patrocinador animal) {
		return patrocinadorService.save(animal);
	}

	
	// método para listar todos los patrocinadores
	@GetMapping("/patrocinadores/{id}")
	public Optional<Patrocinador> recuperarPatrocinador(@PathVariable Integer id) {
		return patrocinadorService.findById(id);
	}

	//modificar
	@PutMapping("/patrocinadores/{id}")
	public ResponseEntity<Patrocinador>  modificarPatrocinador(@RequestBody Patrocinador detallesPatrocinador, @PathVariable Integer id ) {
		 
		Optional<Patrocinador> patrocinador= patrocinadorService.findById(id);
		patrocinador.get().setId(detallesPatrocinador.getId());
		patrocinador.get().setNombre(detallesPatrocinador.getNombre());
		patrocinador.get().setImagen(detallesPatrocinador.getImagen());
		
		
		
		Patrocinador patrocinadorActualizado= patrocinadorService.save(patrocinador.get());
		
		return ResponseEntity.ok(patrocinadorActualizado);
	}
	

	@DeleteMapping("/patrocinadores/{id}")
	// retorna verdadero si el elemento fue eliminado, si no lo encuentra
	public void deletePatrocinador(@PathVariable Integer id) {

		patrocinadorService.deleteById(id);
	}
}
