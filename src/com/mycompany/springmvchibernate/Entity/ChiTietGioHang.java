package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CHI_TIET_GIO_HANG database table.
 * 
 */
@Entity
@Table(name="CHI_TIET_GIO_HANG")
@NamedQuery(name="ChiTietGioHang.findAll", query="SELECT c FROM ChiTietGioHang c")
public class ChiTietGioHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ChiTietGioHangPK id;

	@Column(name="SoLuong", nullable=false)
	private int soLuong;

	public ChiTietGioHang() {
	}

	public ChiTietGioHangPK getId() {
		return this.id;
	}

	public void setId(ChiTietGioHangPK id) {
		this.id = id;
	}

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

}