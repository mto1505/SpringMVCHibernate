package com.mycompany.springmvchibernate.Entity2;

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

	//bi-directional many-to-one association to ChiTietSanPham
	@ManyToOne
	@JoinColumn(name="ID_CTSP", nullable=false, insertable=false, updatable=false)
	private ChiTietSanPham chiTietSanPham;

	//bi-directional many-to-one association to GioHang
	@ManyToOne
	@JoinColumn(name="ID_GH", nullable=false, insertable=false, updatable=false)
	private GioHang gioHang;

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

	public ChiTietSanPham getChiTietSanPham() {
		return this.chiTietSanPham;
	}

	public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) {
		this.chiTietSanPham = chiTietSanPham;
	}

	public GioHang getGioHang() {
		return this.gioHang;
	}

	public void setGioHang(GioHang gioHang) {
		this.gioHang = gioHang;
	}

}