package com.mycompany.springmvchibernate.DTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
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
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Entity.DanhGia;
import com.mycompany.springmvchibernate.Entity.HinhAnhSP;
import com.mycompany.springmvchibernate.Entity.Loai;
import com.mycompany.springmvchibernate.Entity.SanPham;

//@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@PropertySources(value = { @PropertySource("classpath:application.properties")})
public class SanPhamDTO {

	private int id;
	
	@NotNull
	@Size(min=1,max=20)
	private String cameraSau;
	@NotNull
	@Size(min=1,max=200)
	private String cameraTruoc;
	@NotNull
	@Size(min=1,max=200)
	private String manHinh;
	@NotNull
	@Size(min=1,max=200)
	private String moTa;
	@NotNull
	@Size(min=1,max=200)
	private String ten;
	@NotNull
	@Size(min=1,max=200)
	private String pinSac;
	
	@NotNull
	@Size(min=1,max=200)
	private String sim;
	
	@NotNull
	@Valid
	private LoaiDTO loai;
	

	private List<ChiTietSanPhamDTO> chiTietSanPhams = new ArrayList<>();

	private List<DanhGiaDTO> danhGias = new ArrayList<>();
	
	private List<HinhAnhDTO> hinhAnhSps = new ArrayList<>();
	
	@Transient
	private List<CommonsMultipartFile> hinhAnhs = new ArrayList<>();

	

	public SanPhamDTO() {

	}


	public SanPhamDTO(int id, String cameraSau, String cameraTruoc, String manHinh, String moTa, String name,
			String pinSac, String sim, LoaiDTO loai) {

		this.id = id;
		this.cameraSau = cameraSau;
		this.cameraTruoc = cameraTruoc;
		this.manHinh = manHinh;
		this.moTa = moTa;
		this.ten = name;
		this.pinSac = pinSac;
		this.sim = sim;
		this.loai = loai;
		

	}

	public List<HinhAnhDTO> getHinhAnhSps() {
		return hinhAnhSps;
	}


	public void setHinhAnhSps(List<HinhAnhDTO> hinhAnhSps) {
		this.hinhAnhSps = hinhAnhSps;
	}


	public List<DanhGiaDTO> getDanhGias() {
		return danhGias;
	}

	public void setDanhGias(List<DanhGiaDTO> danhGias) {
		this.danhGias = danhGias;
	}

	public List<CommonsMultipartFile> getHinhAnhs() {
		return hinhAnhs;
	}

	public void setHinhAnhs(List<CommonsMultipartFile> hinhAnhs) {
		this.hinhAnhs = hinhAnhs;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public HinhAnhDTO addHinhAnh(HinhAnhDTO hinhAnhSP) {
		getHinhAnhSps().add(hinhAnhSP);
		hinhAnhSP.setSanPham(this);
		return hinhAnhSP;

	}

	public HinhAnhDTO removeHinhAnh(HinhAnhDTO hinhAnhSP) {
		getHinhAnhSps().remove(hinhAnhSP);
		hinhAnhSP.setSanPham(null);
		return hinhAnhSP;

	}

	public ChiTietSanPhamDTO addChiTietSanPham(ChiTietSanPhamDTO ChiTietSanPhamSP) {
		getChiTietSanPhams().add(ChiTietSanPhamSP);
		ChiTietSanPhamSP.setSanPham(this);
		return ChiTietSanPhamSP;

	}

	public ChiTietSanPhamDTO removeChiTietSanPham(ChiTietSanPhamDTO hinhAnhSP) {
		getHinhAnhSps().remove(hinhAnhSP);
		hinhAnhSP.setSanPham(null);
		return hinhAnhSP;
	}

}
