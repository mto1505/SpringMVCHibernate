package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MAU database table.
 * 
 */
@Entity
@Table(name="MAU")
@NamedQuery(name="Mau.findAll", query="SELECT m FROM Mau m")
public class Mau implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID", unique=true, nullable=false, length=10)
	private String id;

	@Column(name="Name", nullable=false)
	private Object name;

	public Mau() {
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