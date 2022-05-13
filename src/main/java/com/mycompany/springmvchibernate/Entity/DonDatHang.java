package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the DON_DAT_HANG database table.
 * 
 */
@Entity
@Table(name = "DON_DAT_HANG")
@NamedQuery(name = "DonDatHang.findAll", query = "SELECT d FROM DonDatHang d")
public class DonDatHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "ThoiGian")
	private Timestamp thoiGian;

	@Column(name = "TinhTrang")
	private int tinhTrang;

	@Column(name = "DiaChi", length = 200)
	private String diaChi;

	@Column(name = "ChuThich", length = 200)
	private String chuThich;

	// bi-directional many-to-one association to ChiTietDonDatHang
	@OneToMany(mappedBy = "donDatHang",cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<ChiTietDonDatHang> chiTietDonDatHangs;
	

	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name="ChiTietDonDatHang", joinColumns= {
	 * 
	 * @JoinColumn(name="ID_DDH") }, inverseJoinColumns= {
	 * 
	 * @JoinColumn(name="ID_CTSP")} ) private List<ChiTietSanPham> chiTietSanPhams;
	 */
	// bi-directional many-to-one association to DonViVanChuyen

//	@ManyToOne
//	@JoinColumn(name="ID_DVVC")
//	private DonViVanChuyen donViVanChuyen;

	// bi-directional many-to-one association to KhachHang
	@ManyToOne
	@JoinColumn(name = "ID_KH")
	private KhachHang khachHang;
	public DonDatHang() {
	}
	
	
	public KhachHang getKhachHang() {
		return khachHang;
	}


	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}


	public String getChuThich() {
		return chuThich;
	}

	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getThoiGian() {
		return this.thoiGian;
	}

	public void setThoiGian(Timestamp thoiGian) {
		this.thoiGian = thoiGian;
	}

	public int getTinhTrang() {
		return this.tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public List<ChiTietDonDatHang> getChiTietDonDatHangs() {
		return this.chiTietDonDatHangs;
	}

	public void setChiTietDonDatHangs(List<ChiTietDonDatHang> chiTietDonDatHangs) {
		this.chiTietDonDatHangs = chiTietDonDatHangs;
	}

	public ChiTietDonDatHang addChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang) {
		getChiTietDonDatHangs().add(chiTietDonDatHang);
		chiTietDonDatHang.setDonDatHang(this);

		return chiTietDonDatHang;
	}

	public ChiTietDonDatHang removeChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang) {
		getChiTietDonDatHangs().remove(chiTietDonDatHang);
		chiTietDonDatHang.setDonDatHang(null);

		return chiTietDonDatHang;
	}

//	public DonViVanChuyen getDonViVanChuyen() {
//		return this.donViVanChuyen;
//	}
//
//	public void setDonViVanChuyen(DonViVanChuyen donViVanChuyen) {
//		this.donViVanChuyen = donViVanChuyen;
//	}


}