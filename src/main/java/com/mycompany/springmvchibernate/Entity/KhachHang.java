package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the KHACH_HANG database table.
 * 
 */
@Entity
@Table(name="KHACH_HANG")
@NamedQuery(name="KhachHang.findAll", query="SELECT k FROM KhachHang k")
public class KhachHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="DiaChi")
	private String diaChi;

	@Column(name="Email")
	private String email;

	@Column(name="HoVaTenDem")
	private String hoVaTenDem;

	@Column(name="SoDienThoai")
	private String soDienThoai;

	@Column(name="Ten")
	private String ten;

	//bi-directional many-to-one association to DanhGia
	@OneToMany(mappedBy="khachHang")
	private List<DanhGia> danhGias;

	//bi-directional many-to-one association to DonDatHang
	@OneToMany(mappedBy="khachHang")
	private List<DonDatHang> donDatHangs;

	//bi-directional many-to-one association to GioHang
	@OneToOne(cascade = CascadeType.ALL,optional=false)
	@JoinColumn(name="ID_GH",unique=true)
	private GioHang gioHang;

	//bi-directional many-to-one association to TaiKhoan
	@OneToOne(cascade = CascadeType.ALL,optional=false)
	@JoinColumn(name="ID_TK",unique=true)
	private TaiKhoan taiKhoan;

	public KhachHang() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiaCHi() {
		return this.diaChi;
	}

	public void setDiaCHi(String diaCHi) {
		this.diaChi = diaCHi;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHoVaTenDem() {
		return this.hoVaTenDem;
	}

	public void setHoVaTenDem(String hoVaTenDem) {
		this.hoVaTenDem = hoVaTenDem;
	}

	public String getSoDienThoai() {
		return this.soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public List<DanhGia> getDanhGias() {
		return this.danhGias;
	}

	public void setDanhGias(List<DanhGia> danhGias) {
		this.danhGias = danhGias;
	}

	public DanhGia addDanhGia(DanhGia danhGia) {
		getDanhGias().add(danhGia);
		danhGia.setKhachHang(this);

		return danhGia;
	}

	public DanhGia removeDanhGia(DanhGia danhGia) {
		getDanhGias().remove(danhGia);
		danhGia.setKhachHang(null);

		return danhGia;
	}

	public List<DonDatHang> getDonDatHangs() {
		return this.donDatHangs;
	}

	public void setDonDatHangs(List<DonDatHang> donDatHangs) {
		this.donDatHangs = donDatHangs;
	}

	public DonDatHang addDonDatHang(DonDatHang donDatHang) {
		getDonDatHangs().add(donDatHang);
		donDatHang.setKhachHang(this);

		return donDatHang;
	}

	public DonDatHang removeDonDatHang(DonDatHang donDatHang) {
		getDonDatHangs().remove(donDatHang);
		donDatHang.setKhachHang(null);

		return donDatHang;
	}

	public GioHang getGioHang() {
		return this.gioHang;
	}

	public void setGioHang(GioHang gioHang) {
		this.gioHang = gioHang;
	}

	public TaiKhoan getTaiKhoan() {
		return this.taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

}