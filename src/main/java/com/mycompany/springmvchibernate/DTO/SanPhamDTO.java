package com.mycompany.springmvchibernate.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Entity.DanhGia;
import com.mycompany.springmvchibernate.Entity.HinhAnhSP;
import com.mycompany.springmvchibernate.Entity.Loai;

public class SanPhamDTO {

	
	private String id;
	
	private String cameraSau;

	private String cameraTruoc;
	
	private String manHinh;

	private String moTa;

	private String name;

	private String pinSac;
	
	private String sim;

	private LoaiDTO loai;
	
	private List<ChiTietSanPhamDTO> chiTietSanPhams=new ArrayList<>();

	private List<DanhGiaDTO> danhGias=new ArrayList<>();
	
	private List<HinhAnhDTO> hinhAnhSps=new ArrayList<>();

	public SanPhamDTO() {
		super();
	}

	public SanPhamDTO(String id, String cameraSau, String cameraTruoc, String manHinh, String moTa, String name,
			String pinSac, String sim, LoaiDTO loai) {
		
		this.id = id;
		this.cameraSau = cameraSau;
		this.cameraTruoc = cameraTruoc;
		this.manHinh = manHinh;
		this.moTa = moTa;
		this.name = name;
		this.pinSac = pinSac;
		this.sim = sim;
		this.loai = loai;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCameraSau() {
		return cameraSau;
	}

	public void setCameraSau(String cameraSau) {
		this.cameraSau = cameraSau;
	}

	public String getCameraTruoc() {
		return cameraTruoc;
	}

	public void setCameraTruoc(String cameraTruoc) {
		this.cameraTruoc = cameraTruoc;
	}

	public String getManHinh() {
		return manHinh;
	}

	public void setManHinh(String manHinh) {
		this.manHinh = manHinh;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPinSac() {
		return pinSac;
	}

	public void setPinSac(String pinSac) {
		this.pinSac = pinSac;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public LoaiDTO getLoai() {
		return loai;
	}

	public void setLoai(LoaiDTO loai) {
		this.loai = loai;
	}

	public List<ChiTietSanPhamDTO> getChiTietSanPhams() {
		return chiTietSanPhams;
	}

	public void setChiTietSanPhams(List<ChiTietSanPhamDTO> chiTietSanPhams) {
		this.chiTietSanPhams = chiTietSanPhams;
	}

	public List<DanhGiaDTO> getDanhGias() {
		return danhGias;
	}

	public void setDanhGias(List<DanhGiaDTO> danhGias) {
		this.danhGias = danhGias;
	}

	public List<HinhAnhDTO> getHinhAnhSps() {
		return hinhAnhSps;
	}

	public void setHinhAnhSps(List<HinhAnhDTO> hinhAnhSps) {
		this.hinhAnhSps = hinhAnhSps;
	}

}
