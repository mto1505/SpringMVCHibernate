package com.mycompany.springmvchibernate.DTO;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mycompany.springmvchibernate.Entity.ChiTietDonDatHangPK;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Entity.DonDatHang;

public class ChiTietDonDatHangDTO {

	private int idIdDdh;

	private int idIdCtsp;
	
	private int soLuong;

	private ChiTietSanPhamDTO chiTietSanPham;

	






	public ChiTietDonDatHangDTO() {
		super();
	}


	public ChiTietDonDatHangDTO(int idIdDdh, int idIdCtsp, int soLuong, ChiTietSanPhamDTO chiTietSanPham,
			DonDatHangDTO donDatHang) {
		
		this.idIdDdh = idIdDdh;
		this.idIdCtsp = idIdCtsp;
		this.soLuong = soLuong;
		this.chiTietSanPham = chiTietSanPham;
		this.donDatHang = donDatHang;
	}


	public int getIdIdDdh() {
		return idIdDdh;
	}


	public void setIdIdDdh(int idIdDdh) {
		this.idIdDdh = idIdDdh;
	}


	public int getIdIdCtsp() {
		return idIdCtsp;
	}


	public void setIdIdCtsp(int idIdCtsp) {
		this.idIdCtsp = idIdCtsp;
	}


	public int getSoLuong() {
		return soLuong;
	}


	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}


	public ChiTietSanPhamDTO getChiTietSanPham() {
		return chiTietSanPham;
	}


	public void setChiTietSanPham(ChiTietSanPhamDTO chiTietSanPham) {
		this.chiTietSanPham = chiTietSanPham;
	}


	public DonDatHangDTO getDonDatHang() {
		return donDatHang;
	}


	public void setDonDatHang(DonDatHangDTO donDatHang) {
		this.donDatHang = donDatHang;
	}


	private DonDatHangDTO donDatHang;

	
}
