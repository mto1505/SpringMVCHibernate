package com.mycompany.springmvchibernate.DTO;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mycompany.springmvchibernate.Entity.DonViVanChuyen;
import com.mycompany.springmvchibernate.Entity.KhachHang;

public class DonDatHangDTO {
	

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Timestamp thoiGian) {
		this.thoiGian = thoiGian;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}


	public KhachHangDTO getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHangDTO khachHang) {
		this.khachHang = khachHang;
	}

	private Timestamp thoiGian;

	private int tinhTrang;
	
	
	private KhachHangDTO khachHang;

	
	
}
