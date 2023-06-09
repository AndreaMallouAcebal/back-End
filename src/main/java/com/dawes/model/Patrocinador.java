package com.dawes.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="patrocinadores")
public class Patrocinador {

	@Id
	@Column(name="idpatrocinadores")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", length= 45, nullable = false)
	private String nombre;

	
	@Column(name="imagen", length= 200, nullable=false)
	private String imagen ;


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


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public Patrocinador(int id, String nombre, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
	}


	public Patrocinador(String nombre, String imagen) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
	}


	public Patrocinador() {
		super();
	}


	@Override
	public String toString() {
		return "Patrocinador [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, imagen, nombre);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patrocinador other = (Patrocinador) obj;
		return id == other.id && Objects.equals(imagen, other.imagen) && Objects.equals(nombre, other.nombre);
	}

	
}
