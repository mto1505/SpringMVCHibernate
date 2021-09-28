package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DANH_GIA database table.
 * 
 */
@Embeddable
public class DanhGiaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	@Column(name="ID_KH", insertable=false, updatable=false)
	private int idKh;

	@Column(name="ID_SP", insertable=false, updatable=false)
	private String idSp;

	public DanhGiaPK() {
	}
	public int getIdKh() {
		return this.idKh;
	}
	public void setIdKh(int idKh) {
		this.idKh = idKh;
	}
	public String getIdSp() {
		return this.idSp;
	}
	public void setIdSp(String idSp) {
		this.idSp = idSp;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DanhGiaPK)) {
			return false;
		}
		DanhGiaPK castOther = (DanhGiaPK)other;
		return 
			(this.idKh == castOther.idKh)
			&& this.idSp.equals(castOther.idSp);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idKh;
		hash = hash * prime + this.idSp.hashCode();
		
		return hash;
	}
}