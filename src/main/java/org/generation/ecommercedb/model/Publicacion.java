package org.generation.ecommercedb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publicacion")
public class Publicacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id",unique=true, nullable=false)
	private Long id;
	private char ENUM;
	@Column(nullable=false)
	private String titulo;
	@Column(nullable=false)
	private String descripcion;
	private String imagen;
	private Long num_reacciones;
	
	
	
	
	
	
	
}
