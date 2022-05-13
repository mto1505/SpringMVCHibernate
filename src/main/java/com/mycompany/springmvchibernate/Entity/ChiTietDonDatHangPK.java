package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CHI_TIET_DON_DAT_HANG database table.
 * 
 */
@Embeddable
public class ChiTietDonDatHangPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	
	@Column(name="ID_DDH", insertable=false, updatable=false)
	private int idDdh;

	@Column(name="ID_CTSP", insertable=false, updatable=false)
	private int idCtsp;

	public ChiTietDonDatHangPK() {
	}
	
	public ChiTietDonDatHangPK(int idDdh, int idCtsp) {
	
		this.idDdh = idDdh;
		this.idCtsp = idCtsp;
	}

	public int getIdDdh() {
		return this.idDdh;
	}
	public void setIdDdh(int idDdh) {
		this.idDdh = idDdh;
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
		if (!(other instanceof ChiTietDonDatHangPK)) {
			return false;
		}
		ChiTietDonDatHangPK castOther = (ChiTietDonDatHangPK)other;
		return 
			(this.idDdh == castOther.idDdh)
			&& (this.idCtsp==castOther.idCtsp);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idDdh;
		hash = hash * prime + this.idCtsp;
		
		return hash;
	}
}