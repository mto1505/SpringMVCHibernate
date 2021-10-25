package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SAN_PHAM database table.
 * 
 */
@Entity
@Table(name = "SAN_PHAM")
@NamedQuery(name = "SanPham.findAll", query = "SELECT s FROM SanPham s")
public class SanPham implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "CameraSau", length = 100)
	private String cameraSau;

	@Column(name = "CameraTruoc", length = 100)
	private String cameraTruoc;

	@Column(name = "ManHinh", length = 100)
	private String manHinh;

	@Column(name = "MoTa", length = 100)
	private String moTa;

	@Column(name = "Ten", length = 50)
	private String ten;

	@Column(name = "PinSac")
	private String pinSac;

	@Basic(optional = false) // @NotNull is both understand by hibernate and can be used by other layer on
								// application
	@Lob
	@Column(name = "Sim")
	private String sim;

	// bi-directional many-to-one association to ChiTietSanPham

	@OneToMany(mappedBy = "sanPham", cascade = CascadeType.PERSIST)
	private List<ChiTietSanPham> chiTietSanPhams = new ArrayList<>();

	// bi-directional many-to-one association to DanhGia

	@OneToMany(mappedBy = "sanPham", cascade = CascadeType.PERSIST)
	private List<DanhGia> danhGias = new ArrayList<>();

	// bi-directional many-to-one association to Hinh_Anh_SP

	@OneToMany(mappedBy = "sanPham", cascade = CascadeType.PERSIST)
	private List<HinhAnhSP> hinhAnhSps = new ArrayList<HinhAnhSP>();

	// bi-directional many-to-one association to Loai
	@ManyToOne
	@JoinColumn(name = "ID_L", nullable = false, referencedColumnName = "id")
	private Loai loai;

	public SanPham() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCameraSau() {
		return this.cameraSau;
	}

	public void setCameraSau(String cameraSau) {
		this.cameraSau = cameraSau;
	}

	public String getCameraTruoc() {
		return this.cameraTruoc;
	}

	public void setCameraTruoc(String cameraTruoc) {
		this.cameraTruoc = cameraTruoc;
	}

	public String getManHinh() {
		return this.manHinh;
	}

	public void setManHinh(String manHinh) {
		this.manHinh = manHinh;
	}

	public String getMoTa() {
		return this.moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getPinSac() {
		return this.pinSac;
	}

	public void setPinSac(String pinSac) {
		this.pinSac = pinSac;
	}

	public String getSim() {
		return this.sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public List<ChiTietSanPham> getChiTietSanPhams() {
		return this.chiTietSanPhams;
	}

	public void setChiTietSanPhams(List<ChiTietSanPham> chiTietSanPhams) {
		this.chiTietSanPhams = chiTietSanPhams;
	}

	public ChiTietSanPham addChiTietSanPham(ChiTietSanPham chiTietSanPham) {
		getChiTietSanPhams().add(chiTietSanPham);
		chiTietSanPham.setSanPham(this);

		return chiTietSanPham;
	}

	public ChiTietSanPham removeChiTietSanPham(ChiTietSanPham chiTietSanPham) {
		getChiTietSanPhams().remove(chiTietSanPham);
		chiTietSanPham.setSanPham(null);

		return chiTietSanPham;
	}

	public List<DanhGia> getDanhGias() {
		return this.danhGias;
	}

	public void setDanhGias(List<DanhGia> danhGias) {
		this.danhGias = danhGias;
	}

	public DanhGia addDanhGia(DanhGia danhGia) {
		getDanhGias().add(danhGia);
		danhGia.setSanPham(this);

		return danhGia;
	}

	public DanhGia removeDanhGia(DanhGia danhGia) {
		getDanhGias().remove(danhGia);
		danhGia.setSanPham(null);

		return danhGia;
	}

	public List<HinhAnhSP> getHinhAnhSps() {
		return this.hinhAnhSps;
	}

	public void setHinhAnhSps(List<HinhAnhSP> hinhAnhSps) {
		this.hinhAnhSps = hinhAnhSps;
	}

	public Loai getLoai() {
		return this.loai;
	}

	public void setLoai(Loai loai) {
		this.loai = loai;
	}

	public HinhAnhSP addHinhAnh(HinhAnhSP hinhAnhSP) {
		getHinhAnhSps().add(hinhAnhSP);
		hinhAnhSP.setSanPham(this);
		return hinhAnhSP;

	}

	public HinhAnhSP removeHinhAnh(HinhAnhSP hinhAnhSP) {
		getHinhAnhSps().remove(hinhAnhSP);
		hinhAnhSP.setSanPham(null);
		return hinhAnhSP;

	}

}