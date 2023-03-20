package com.dawes.model;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;


@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre", length = 45, nullable = false)
	private String nombre;

	@Column(name = "apellidos", length = 45, nullable = false)
	private String apellidos;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "dni", length = 9, nullable = false)
	private String dni;

	@Column(name = "contraseña", nullable = false)
	private String contrasenia;


	@Column(name = "voluntario", nullable = false)
	private boolean voluntario;

	//Esta anotacion se utiliza para evitar que creando el Json, los usuarios no generen un loop
	//a la hora de serializar
	@JsonBackReference(value="citas")
	@OneToMany(mappedBy="usuario",cascade = {CascadeType.ALL})
	private List<Cita> citas;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idroles")
	private Rol rol;

	
	@JsonBackReference(value="actividades")
	@OneToMany(mappedBy="usuario",cascade = {CascadeType.ALL})
	private List<ActividadUsuario> actividades;


	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public List<ActividadUsuario> getActividades() {
		return actividades;
	}

	public void setActividades(List<ActividadUsuario> actividades) {
		this.actividades = actividades;
	}
//
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario(int id,String nombre, String apellidos, String email, String dni, String contrasenia, List<Cita> citas, Rol rol) {
		this.id=id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.dni = dni;
		this.contrasenia = contrasenia;
		this.citas=citas;
		this.rol=rol;
	}
	
	public Usuario(String nombre, String apellidos, String email, String dni, String contrasenia) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.dni = dni;
		this.contrasenia = contrasenia;
	}

	public Usuario() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, citas, contrasenia, dni, email, id, nombre,rol, actividades);
	}

	public boolean isVoluntario() {
		return voluntario;
	}

	public void setVoluntario(boolean voluntario) {
		this.voluntario = voluntario;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(citas, other.citas)
				&& Objects.equals(contrasenia, other.contrasenia) && Objects.equals(dni, other.dni)
				&& Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(nombre, other.nombre) && Objects.equals(rol, other.rol)&& Objects.equals(actividades, other.actividades);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", dni="
				+ dni + ", contrasenia=" + contrasenia + ", citas=" + citas + ", rol=" + rol +", actividades=" + actividades +"]";
	}


	//Anotacion creada para que solo un usuario pueda borrar su propio usuario
	//Recupera el usuario actual logueado para hacer la comparacion con el que se quiere borrar
	@PreRemove
	private void preventUnAuthorizedRemove() {
		// Recuperamos el email del usuario logueado
		String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		String auth = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		// Comprobamos si el usuario logueado no es el que se quiere borrar
		if(!userEmail.equals(this.email) && !"[ADMIN]".equals(auth)){
			throw new AuthorizationServiceException("User can only delete himself ");
		}
	}

	@PreUpdate
	private void preventUnAuthorizedUpdate() {
		// Recuperamos el email del usuario logueado
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		String auth = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        // Comprobamos si el usuario logueado no es el que se quiere actualizar
        if(!userEmail.equals(this.email) && !"[ADMIN]".equals(auth)){
            throw new AuthorizationServiceException("User can only update himself ");
        }
	}

	}
