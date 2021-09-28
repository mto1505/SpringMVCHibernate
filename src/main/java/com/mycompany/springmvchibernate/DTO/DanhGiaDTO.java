package com.mycompany.springmvchibernate.DTO;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.mycompany.springmvchibernate.Entity.KhachHang;
import com.mycompany.springmvchibernate.Entity.SanPham;

public class DanhGiaDTO {

	private int idKh;

	private String idSp;
	
	private String noiDung;

	private Timestamp thoiGian;

	//bi-directional many-to-one association to KhachHang

	private KhachHang khachHang;

	//bi-directional many-to-one association to SanPham
	
	private SanPham sanPham;

	public int getIdKh() {
		return idKh;
	}

	public void setIdKh(int idKh) {
		this.idKh = idKh;
	}

	public String getIdSp() {
		return idSp;
	}

	public void setIdSp(String idSp) {
		this.idSp = idSp;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Timestamp getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Timestamp thoiGian) {
		this.thoiGian = thoiGian;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public DanhGiaDTO(int idKh, String idSp, String noiDung, Timestamp thoiGian, KhachHang khachHang, SanPham sanPham) {
		super();
		this.idKh = idKh;
		this.idSp = idSp;
		this.noiDung = noiDung;
		this.thoiGian = thoiGian;
		this.khachHang = khachHang;
		this.sanPham = sanPham;
	}
	
}
