package com.dawes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dawes.model.Actividad;
import com.dawes.model.ActividadUsuario;
import com.dawes.model.Animal;
import com.dawes.model.Cita;
import com.dawes.model.Patrocinador;
import com.dawes.model.Rol;
import com.dawes.model.Usuario;
import com.dawes.service.ActividadService;
import com.dawes.service.ActividadUsuarioService;
import com.dawes.service.AnimalService;
import com.dawes.service.CitaService;
import com.dawes.service.PatrocinadorService;
import com.dawes.service.RolService;
import com.dawes.service.UsuarioService;

@SpringBootTest
class BackendApplicationTests {


	// instanciamos con autowired
	@Autowired
	AnimalService ans;
	@Autowired
	ActividadService acs;
	@Autowired
	ActividadUsuarioService aus;
	@Autowired
	CitaService cs;
	@Autowired
	PatrocinadorService ps;
	@Autowired
	RolService rs;
	@Autowired
	UsuarioService us;

	
	// Test para insertar un animal nuevo
	@Test
	public void test01() {
		// Si le damos id 0 sabe que tiene que generar el siguinte posible
		// 7
		assertNotNull(ans.save(new Animal(0, "Bob", 3, "border collie", "Muy buenaa", "http://www.imagen.com", "perro",
				new ArrayList<Cita>())));
	}

	// Test para insertar una actividad
	@Test
	public void test02() {
		assertNotNull(acs.save(new Actividad(0, "Puertas abiertas", LocalDate.now(), "Abierto para todos",
				new ArrayList<ActividadUsuario>())));
		assertNotNull(acs.save(new Actividad(0, "Vamos al parque", LocalDate.now(), "Toda la tarde",
				new ArrayList<ActividadUsuario>())));

	}

	// Test para insertar un rol
	@Test
	public void test03() {
		assertNotNull(rs.save(new Rol(0, "Usuario", new ArrayList<Usuario>())));

	}

	// Test para insertar un usuario
	@Test
	public void test04() {
		assertNotNull(us.save(new Usuario(0, "Andrea", "Mallou", "andreamallou11@email.com", "1", "contraseña",
				new ArrayList<Cita>(), rs.findById(2).get())));

	}

	// Test para insertar una actividadusuario
	@Test
	public void test05() {
		assertNotNull(aus.save(new ActividadUsuario(0, acs.findById(15).get(), us.findById(13).get())));
	}
	
	// Test para insertar una cita
	@Test
	public void test06() {
		assertNotNull(cs.save(new Cita(0, LocalDate.now(), ans.findById(12).get(), us.findById(13).get())));
	}
	
	// Test para insertar un patrocinador
	@Test
	public void test07() {
		assertNotNull(ps.save(new Patrocinador(0, "http://patrocinador.es","Patrocinador1" )));
	}

	// Consultamos en cuántas actividades está apuntada Andrea
	// para ello tiene que ser: fetch = FetchType.EAGER, si fuera LAZY nos fallaría
	@Test
	public void test08() {
		assertEquals(1, us.findById(13).get().getActividades().size());
	}

	// Consultamos todas las actividades
	@Test
	public void test09() {
		assertEquals(2, acs.findAll().size());
	}

}