package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GIO_HANG database table.
 * 
 */
@Entity
@Table(name="GIO_HANG")
@NamedQuery(name="GioHang.findAll", query="SELECT g FROM GioHang g")
public class GioHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID", unique=true, nullable=false)
	private int id;

	public GioHang() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}