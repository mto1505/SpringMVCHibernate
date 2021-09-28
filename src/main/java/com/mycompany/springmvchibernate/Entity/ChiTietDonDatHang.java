package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CHI_TIET_DON_DAT_HANG database table.
 * 
 */
@Entity
@Table(name="CHI_TIET_DON_DAT_HANG")
@NamedQuery(name="ChiTietDonDatHang.findAll", query="SELECT c FROM ChiTietDonDatHang c")
public class ChiTietDonDatHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ChiTietDonDatHangPK id;

	@Column(name="SoLuong")
	private int soLuong;

	//bi-directional many-to-one association to ChiTietSanPham
	@ManyToOne
	@JoinColumn(name="ID_CTSP",insertable=false ,updatable=false)
	private ChiTietSanPham chiTietSanPham;

	//bi-directional many-to-one association to DonDatHang
	@ManyToOne
	@JoinColumn(name="ID_DDH",insertable=false ,updatable=false)
	private DonDatHang donDatHang;

	public ChiTietDonDatHang() {
	}

	public ChiTietDonDatHangPK getId() {
		return this.id;
	}

	public void setId(ChiTietDonDatHangPK id) {
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

	public DonDatHang getDonDatHang() {
		return this.donDatHang;
	}

	public void setDonDatHang(DonDatHang donDatHang) {
		this.donDatHang = donDatHang;
	}

}