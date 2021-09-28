package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CHIP database table.
 * 
 */
@Entity
@Table(name="CHIP")
@NamedQuery(name="Chip.findAll", query="SELECT c FROM Chip c")
public class Chip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID", unique=true, nullable=false, length=10)
	private String id;

	@Column(name="Name", nullable=false)
	private Object name;

	public Chip() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getName() {
		return this.name;
	}

	public void setName(Object name) {
		this.name = name;
	}

}