package com.dawes.model;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name="animales")
public class Animal {
	@Id
	@Column(name="idanimales")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", length= 15, nullable=false)
	private String nombre;
	
	@Column(name="edad", nullable=false)
	private int edad;
	
	@Column(name="raza", length= 30, nullable=false)
	private String raza ;
	
	@Column(name="descripcion", length= 150, unique=true, nullable=false)
	private String descripcion;
	
	@Column(name="imagen", length= 200,  nullable=false)
	private String imagen;
	
	@Column(name="tipo", length= 45, nullable=false)
	private String tipo;
	
	
	@JsonBackReference
	@OneToMany(mappedBy="animal",cascade = {CascadeType.ALL})
	private List<Cita> citas;
		
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Animal(int id, String nombre, int edad, String raza, String descripcion, String imagen, String tipo, List<Cita> citas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.tipo = tipo;
		this.citas=citas;
	}

	public Animal(String nombre, int edad, String raza, String descripcion, String imagen, String tipo,List<Cita> citas) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.tipo = tipo;
		this.citas=citas;
	}

	public Animal() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, edad, id, imagen, nombre, raza, tipo,citas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(descripcion, other.descripcion) && edad == other.edad && id == other.id
				&& Objects.equals(imagen, other.imagen) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(raza, other.raza) && Objects.equals(tipo, other.tipo) && Objects.equals(citas, other.citas) ;
	}

	@Override
	public String toString() {
		return "Animal [idanimal=" + id + ", nombre=" + nombre + ", edad=" + edad + ", raza=" + raza
				+ ", descripcion=" + descripcion + ", imagen=" + imagen + ", tipo=" + tipo +", citas=" + citas + "]";
	}
	
}
