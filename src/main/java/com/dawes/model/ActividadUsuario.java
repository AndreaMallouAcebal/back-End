package com.dawes.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
property  = "id", 
scope = Integer.class)
@Entity
@Table(name="actividades_usuarios")
public class ActividadUsuario {
	
	@Id
	@Column(name="idactividades_usuarios")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	

	@ManyToOne
	@JoinColumn(name="idactividades")
	private Actividad actividad;

	@ManyToOne
	@JoinColumn(name="idusuarios")
	private Usuario usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ActividadUsuario(int id, Actividad actividad, Usuario usuario) {
		super();
		this.id = id;
		this.actividad = actividad;
		this.usuario = usuario;
	}

	public ActividadUsuario(Actividad actividad, Usuario usuario) {
		super();
		this.actividad = actividad;
		this.usuario = usuario;
	}

	public ActividadUsuario() {
		super();
	}

	@Override
	public String toString() {
		return "ActividadUsuario [id=" + id + ", actividad=" + actividad + ", usuario=" + usuario + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(actividad, id, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActividadUsuario other = (ActividadUsuario) obj;
		return Objects.equals(actividad, other.actividad) && id == other.id && Objects.equals(usuario, other.usuario);
	}

	
	

}
