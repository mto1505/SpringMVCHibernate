package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@Column(name="ID")
	@GeneratedValue
	private int id;

	//bi-directional many-to-one association to ChiTietGioHang
	@OneToMany(mappedBy="gioHang")
	private List<ChiTietGioHang> chiTietGioHangs;

	//bi-directional many-to-one association to KhachHang
	@OneToOne(mappedBy="gioHang")
	private KhachHang khachHangs;

	public GioHang() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ChiTietGioHang> getChiTietGioHangs() {
		return this.chiTietGioHangs;
	}

	public void setChiTietGioHangs(List<ChiTietGioHang> chiTietGioHangs) {
		this.chiTietGioHangs = chiTietGioHangs;
	}

	public ChiTietGioHang addChiTietGioHang(ChiTietGioHang chiTietGioHang) {
		getChiTietGioHangs().add(chiTietGioHang);
		chiTietGioHang.setGioHang(this);

		return chiTietGioHang;
	}

	public ChiTietGioHang removeChiTietGioHang(ChiTietGioHang chiTietGioHang) {
		getChiTietGioHangs().remove(chiTietGioHang);
		chiTietGioHang.setGioHang(null);

		return chiTietGioHang;
	}

	public KhachHang getKhachHangs() {
		return this.khachHangs;
	}

	public void setKhachHangs(KhachHang khachHangs) {
		this.khachHangs = khachHangs;
	}

	public KhachHang addKhachHang(KhachHang khachHang) {
	
		khachHang.setGioHang(this);

		return khachHang;
	}

	public KhachHang removeKhachHang(KhachHang khachHang) {
		
		khachHang.setGioHang(null);

		return khachHang;
	}

}