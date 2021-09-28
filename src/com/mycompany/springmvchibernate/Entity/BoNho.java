package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BO_NHO database table.
 * 
 */
@Entity
@Table(name="BO_NHO")
@NamedQuery(name="BoNho.findAll", query="SELECT b FROM BoNho b")
public class BoNho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID", unique=true, nullable=false, length=10)
	private String id;

	@Column(name="DungLuong", nullable=false)
	private Object dungLuong;

	public BoNho() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getDungLuong() {
		return this.dungLuong;
	}

	public void setDungLuong(Object dungLuong) {
		this.dungLuong = dungLuong;
	}

}