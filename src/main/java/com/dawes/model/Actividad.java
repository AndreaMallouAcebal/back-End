package com.dawes.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="actividades")
public class Actividad {
	@Id
	@Column(name="idactividades")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="nombre", length= 30, nullable=false)
	private String nombre;
	
	@Column(name="fecha", nullable=false)
	private LocalDate fecha;

	@Column(name="descripcion", length= 600, unique=true, nullable=false)
	private String descripcion;

	@JsonBackReference("usuarios")
	@OneToMany(mappedBy="actividad",cascade = {CascadeType.ALL})
	private List<ActividadUsuario> usuarios;

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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ActividadUsuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<ActividadUsuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Actividad(int id, String nombre, LocalDate fecha, String descripcion,
			List<ActividadUsuario> usuarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.usuarios = usuarios;
	}

	public Actividad(String nombre, LocalDate fecha, String descripcion, List<ActividadUsuario> usuarios) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.usuarios = usuarios;
	}

	public Actividad() {
		super();
	}

	@Override
	public String toString() {
		return "Actividad [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", descripcion=" + descripcion
				+ ", actividadesUsuarios=" + usuarios + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(usuarios, descripcion, fecha, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actividad other = (Actividad) obj;
		return Objects.equals(usuarios, other.usuarios)
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(fecha, other.fecha)
				&& id == other.id && Objects.equals(nombre, other.nombre);
	}
	
	
	
}
