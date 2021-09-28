package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RAM database table.
 * 
 */
@Entity
@Table(name="RAM")
@NamedQuery(name="Ram.findAll", query="SELECT r FROM Ram r")
public class Ram implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID", unique=true, nullable=false, length=10)
	private String id;

	@Column(name="DungLuong", nullable=false)
	private Object dungLuong;

	public Ram() {
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