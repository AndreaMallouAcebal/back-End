//package com.dawes.model;
//
//import java.util.Objects;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.MapsId;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
//property  = "id", 
//scope = Integer.class)
//@Entity
//@Table(name="voluntarios")
//public class Voluntario {
//	
//	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name="id")
//	private int id;
//	
//	@Column(name="diasemana", length= 45, nullable=false)
//	private String diaSemana;
//	
//	@Column(name="hora", length= 45, nullable=false)
//	private String hora;
//	
//	
//	@JsonManagedReference(value="voluntario")
//	@OneToOne(mappedBy = "voluntario")
//	private Usuario usuario;
//
//
//	public Voluntario(String diaSemana, String hora, Usuario usuario) {
//		super();
//		this.diaSemana = diaSemana;
//		this.hora = hora;
//		this.usuario=usuario;
//	}
//
//	public Voluntario() {
//		super();
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getDiaSemana() {
//		return diaSemana;
//	}
//
//	public void setDiaSemana(String diaSemana) {
//		this.diaSemana = diaSemana;
//	}
//
//	public String getHora() {
//		return hora;
//	}
//
//	public void setHora(String hora) {
//		this.hora = hora;
//	}
//
//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}
//
//	@Override
//	public String toString() {
//		return "Voluntatio [id=" + id + ", diaSemana=" + diaSemana + ", hora=" + hora + ", usuario=" + usuario +"]";
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(diaSemana, hora, id, usuario);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Voluntario other = (Voluntario) obj;
//		return Objects.equals(diaSemana, other.diaSemana) && Objects.equals(usuario, other.usuario) && Objects.equals(hora, other.hora) && id == other.id;
//	}
//
//
//}
