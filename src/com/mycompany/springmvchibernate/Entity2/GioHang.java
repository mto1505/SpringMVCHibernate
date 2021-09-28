package com.mycompany.springmvchibernate.Entity2;

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
	@Column(name="ID", unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to ChiTietGioHang
	@OneToMany(mappedBy="gioHang")
	private List<ChiTietGioHang> chiTietGioHangs;

	//bi-directional many-to-many association to ChiTietSanPham
	@ManyToMany(mappedBy="gioHangs")
	private List<ChiTietSanPham> chiTietSanPhams;

	//bi-directional one-to-one association to KhachHang
	@OneToOne(mappedBy="gioHang")
	private KhachHang khachHang;

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

	public List<ChiTietSanPham> getChiTietSanPhams() {
		return this.chiTietSanPhams;
	}

	public void setChiTietSanPhams(List<ChiTietSanPham> chiTietSanPhams) {
		this.chiTietSanPhams = chiTietSanPhams;
	}

	public KhachHang getKhachHang() {
		return this.khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

}