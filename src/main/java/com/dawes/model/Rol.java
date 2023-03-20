package com.dawes.model;

import java.util.List;
import java.util.Objects;

import com.dawes.security.enums.RolNombre;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Rol {
	@Id
	@Column(name="idroles")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", length= 45, nullable=false)
	private String nombre;
	
	@JsonBackReference
	@OneToMany(mappedBy="rol", cascade = {CascadeType.ALL})
	private List<Usuario> usuarios;

    public Rol(RolNombre nombre) {
		this.nombre=nombre.toString();
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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Rol(int id, String nombre, List<Usuario> usuarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuarios=usuarios;
	}

	public Rol(String nombre, List<Usuario> usuarios) {
		super();
		this.nombre = nombre;
		this.usuarios=usuarios;
	}

	public Rol() {
		super();
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + ", usuarios="+ usuarios +"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, usuarios);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		return id == other.id && Objects.equals(nombre, other.nombre) && Objects.equals(usuarios, other.usuarios) ;
	}
	
	
	
}
