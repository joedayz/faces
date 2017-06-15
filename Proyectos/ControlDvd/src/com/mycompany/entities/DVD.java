package com.mycompany.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "DVD")
@NamedQueries({
	@NamedQuery(name = "DVD.findAll", query = "SELECT d FROM DVD d"),
	@NamedQuery(name = "DVD.count", query = "SELECT COUNT(d) FROM DVD d"),
	@NamedQuery(name = "DVD.findByAnno", query = "SELECT d FROM DVD d WHERE d.anno = :anno")
})
public class DVD implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "titulo", length=20, nullable = false)
	private String titulo;
	
	@Column(name = "precio", nullable = false)
	private Double precio;
	

	@Column(name = "anno", nullable = false)
	private int anno;	
	
	
	@Column(name="grupoEdad", nullable = false)
	private int grupoEdad;
	
	
	@OneToOne
	@JoinColumn(name="generoId")
	private Genero genero;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public int getGrupoEdad() {
		return grupoEdad;
	}


	public void setGrupoEdad(int grupoEdad) {
		this.grupoEdad = grupoEdad;
	}


	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	public int getAnno() {
		return anno;
	}


	public void setAnno(int anno) {
		this.anno = anno;
	}
	
	
	
}
