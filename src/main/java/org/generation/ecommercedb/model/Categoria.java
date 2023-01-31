package org.generation.ecommercedb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id",unique=true, nullable=false)
	private Long id;
	private String nombre;
	public Categoria(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Categoria () {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Categoria [nombre=" + nombre + "]";
	}
	
	
}
