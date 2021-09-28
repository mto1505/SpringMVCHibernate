package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Hinh_Anh_SP database table.
 * 
 */
@Entity
@Table(name="Hinh_Anh_SP")
@NamedQuery(name="Hinh_Anh_SP.findAll", query="SELECT h FROM Hinh_Anh_SP h")
public class Hinh_Anh_SP implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID", unique=true, nullable=false)
	private int id;

	@Column(name="HinhAnh", nullable=false, length=2147483647)
	private String hinhAnh;

	public Hinh_Anh_SP() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHinhAnh() {
		return this.hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

}