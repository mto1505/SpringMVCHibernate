package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DON_VI_VAN_CHUYEN database table.
 * 
 */
@Entity
@Table(name="DON_VI_VAN_CHUYEN")
@NamedQuery(name="DonViVanChuyen.findAll", query="SELECT d FROM DonViVanChuyen d")
public class DonViVanChuyen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID", unique=true, nullable=false, length=10)
	private String id;

	@Column(name="Name", nullable=false)
	private Object name;

	public DonViVanChuyen() {
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