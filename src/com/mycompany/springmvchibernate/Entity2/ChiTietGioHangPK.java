package com.mycompany.springmvchibernate.Entity2;

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

	@Column(name="ID_GH", insertable=false, updatable=false, unique=true, nullable=false)
	private int idGh;

	@Column(name="ID_CTSP", insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String idCtsp;

	public ChiTietGioHangPK() {
	}
	public int getIdGh() {
		return this.idGh;
	}
	public void setIdGh(int idGh) {
		this.idGh = idGh;
	}
	public String getIdCtsp() {
		return this.idCtsp;
	}
	public void setIdCtsp(String idCtsp) {
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
			&& this.idCtsp.equals(castOther.idCtsp);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idGh;
		hash = hash * prime + this.idCtsp.hashCode();
		
		return hash;
	}
}