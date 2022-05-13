package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CHI_TIET_SAN_PHAM database table.
 * 
 */
@Entity
@Table(name="CHI_TIET_SAN_PHAM")
@NamedQuery(name="ChiTietSanPham.findAll", query="SELECT c FROM ChiTietSanPham c")
public class ChiTietSanPham implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue
	private int id;

	@Column(name="DonGia")
	private BigDecimal donGia;

	@Column(name="SoLuong")
	private int soLuong;

	//bi-directional many-to-one association to ChiTietDonDatHang
	@OneToMany(mappedBy="chiTietSanPham") 
	private List<ChiTietDonDatHang> chiTietDonDatHangs;
	
/*	@ManyToMany(mappedBy="chiTietSanPhams")
	private List<DonDatHang> DonDatHangs;*/
		
	//bi-directional many-to-one association to ChiTietGioHang
	@OneToMany(mappedBy="chiTietSanPham")
	private List<ChiTietGioHang> chiTietGioHangs;

	//bi-directional many-to-one association to BoNho
	@ManyToOne
	@JoinColumn(name="ID_BN")
	private BoNho boNho;

	//bi-directional many-to-one association to Chip
	@ManyToOne
	@JoinColumn(name="ID_C")
	private Chip chip;

	//bi-directional many-to-one association to Mau
	@ManyToOne
	@JoinColumn(name="ID_M")
	private Mau mau;

	//bi-directional many-to-one association to Ram
	@ManyToOne
	@JoinColumn(name="ID_R")
	private Ram ram;

	//bi-directional many-to-one association to SanPham
	@ManyToOne
	@JoinColumn(name="ID_SP")  // phía con (phía sở hữu)
	private SanPham sanPham;

	public ChiTietSanPham() {
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public BigDecimal getDonGia() {
		return this.donGia;
	}

	public void setDonGia(BigDecimal donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public List<ChiTietDonDatHang> getChiTietDonDatHangs() {
		return this.chiTietDonDatHangs;
	}

	public void setChiTietDonDatHangs(List<ChiTietDonDatHang> chiTietDonDatHangs) {
		this.chiTietDonDatHangs = chiTietDonDatHangs;
	}

	public ChiTietDonDatHang addChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang) {
		getChiTietDonDatHangs().add(chiTietDonDatHang);
		chiTietDonDatHang.setChiTietSanPham(this);

		return chiTietDonDatHang;
	}

	public ChiTietDonDatHang removeChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang) {
		getChiTietDonDatHangs().remove(chiTietDonDatHang);
		chiTietDonDatHang.setChiTietSanPham(null);

		return chiTietDonDatHang;
	}

	public List<ChiTietGioHang> getChiTietGioHangs() {
		return this.chiTietGioHangs;
	}

	public void setChiTietGioHangs(List<ChiTietGioHang> chiTietGioHangs) {
		this.chiTietGioHangs = chiTietGioHangs;
	}

	public ChiTietGioHang addChiTietGioHang(ChiTietGioHang chiTietGioHang) {
		getChiTietGioHangs().add(chiTietGioHang);
		chiTietGioHang.setChiTietSanPham(this);

		return chiTietGioHang;
	}

	public ChiTietGioHang removeChiTietGioHang(ChiTietGioHang chiTietGioHang) {
		getChiTietGioHangs().remove(chiTietGioHang);
		chiTietGioHang.setChiTietSanPham(null);

		return chiTietGioHang;
	}

	public BoNho getBoNho() {
		return this.boNho;
	}

	public void setBoNho(BoNho boNho) {
		this.boNho = boNho;
	}

	public Chip getChip() {
		return this.chip;
	}

	public void setChip(Chip chip) {
		this.chip = chip;
	}

	public Mau getMau() {
		return this.mau;
	}

	public void setMau(Mau mau) {
		this.mau = mau;
	}

	public Ram getRam() {
		return this.ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public SanPham getSanPham() {
		return this.sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

}