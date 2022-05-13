package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CHI_TIET_GIO_HANG database table.
 * 
 */
@Embeddable
public class ChiTietGioHangPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	@Column(name="ID_GH", insertable=false, updatable=false)
	private int idGh;

	@Column(name="ID_CTSP", insertable=false, updatable=false)
	private int idCtsp;

	public ChiTietGioHangPK() {
	}
	public int getIdGh() {
		return this.idGh;
	}
	public void setIdGh(int idGh) {
		this.idGh = idGh;
	}
	public int getIdCtsp() {
		return this.idCtsp;
	}
	public void setIdCtsp(int idCtsp) {
		this.idCtsp = idCtsp;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ChiTietGioHangPK)) {
			return false;
		}
		ChiTietGioHangPK castOther = (ChiTietGioHangPK)other;
		return 
			(this.idGh == castOther.idGh)
			&& this.idCtsp==castOther.idCtsp;
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idGh;
		hash = hash * prime + this.idCtsp;
		
		return hash;
	}
}