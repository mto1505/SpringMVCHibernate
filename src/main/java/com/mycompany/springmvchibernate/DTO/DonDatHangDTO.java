package com.mycompany.springmvchibernate.DTO;

import java.sql.Timestamp;
import java.util.List;



public class DonDatHangDTO {
	
	private String chuThich;
	private String diaChi;
	private Timestamp thoiGian;
	private int tinhTrang;
	
	
	private KhachHangDTO khachHang;
	
	private List<ChiTietDonDatHangDTO> chiTietDonDatHangs;

	private int id;

	
	public DonDatHangDTO() {
		
	}

	public DonDatHangDTO(String chuThich, String diaChi, Timestamp thoiGian, int tinhTrang, KhachHangDTO khachHang,
			List<ChiTietDonDatHangDTO> chiTietDonDatHangs, int id) {
		
		this.chuThich = chuThich;
		this.diaChi = diaChi;
		this.thoiGian = thoiGian;
		this.tinhTrang = tinhTrang;
		this.khachHang = khachHang;
		this.chiTietDonDatHangs = chiTietDonDatHangs;
		this.id = id;
	}

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
	
	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	public String getChuThich() {
		return chuThich;
	}

	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}

	
	public List<ChiTietDonDatHangDTO> getChiTietDonDatHangs() {
		return chiTietDonDatHangs;
	}

	public void setChiTietDonDatHangs(List<ChiTietDonDatHangDTO> chiTietDonDatHangs) {
		this.chiTietDonDatHangs = chiTietDonDatHangs;
	}
	public ChiTietDonDatHangDTO addChiTietDonDatHang(ChiTietDonDatHangDTO chiTietDonDatHang) {
		getChiTietDonDatHangs().add(chiTietDonDatHang);
		chiTietDonDatHang.setDonDatHang(this);
		return chiTietDonDatHang;
	}

	public ChiTietDonDatHangDTO removeChiTietDonDatHang(ChiTietDonDatHangDTO chiTietDonDatHang) {
		getChiTietDonDatHangs().remove(chiTietDonDatHang);
		chiTietDonDatHang.setDonDatHang(null);
		return chiTietDonDatHang;
	}
	
}
