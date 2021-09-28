package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the DANH_GIA database table.
 * 
 */
@Entity
@Table(name="DANH_GIA")
@NamedQuery(name="DanhGia.findAll", query="SELECT d FROM DanhGia d")
public class DanhGia implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DanhGiaPK id;

	@Lob
	@Column(name="NoiDung")
	private String noiDung;

	@Column(name="ThoiGian")
	private Timestamp thoiGian;

	//bi-directional many-to-one association to KhachHang
	@ManyToOne
	@JoinColumn(name="ID_KH",updatable=false,insertable=false)
	private KhachHang khachHang;

	//bi-directional many-to-one association to SanPham
	@ManyToOne
	@JoinColumn(name="ID_SP",updatable=false,insertable=false)
	private SanPham sanPham;

	public DanhGia() {
	}

	public DanhGiaPK getId() {
		return this.id;
	}

	public void setId(DanhGiaPK id) {
		this.id = id;
	}

	public String getNoiDung() {
		return this.noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Timestamp getThoiGian() {
		return this.thoiGian;
	}

	public void setThoiGian(Timestamp thoiGian) {
		this.thoiGian = thoiGian;
	}

	public KhachHang getKhachHang() {
		return this.khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public SanPham getSanPham() {
		return this.sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

}