package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Size(min = 4, max = 20)
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotEmpty//Validar que no este vacio solo para strings
	@Email
	private String email;

	@NotNull//Validar que no este vacio
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE) // Indica el formata en que se guardara en la base de datos --SOLO APLICA EN TIEMPO
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
	
	
//	@PrePersist
//	public void prePersist() {
//		createAt = new Date();
//	}

	

}
