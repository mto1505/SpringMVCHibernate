package com.mycompany.springmvchibernate.DTO;

import java.math.BigDecimal;
import java.util.List;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mycompany.springmvchibernate.Entity.BoNho;
import com.mycompany.springmvchibernate.Entity.ChiTietDonDatHang;
import com.mycompany.springmvchibernate.Entity.ChiTietGioHang;
import com.mycompany.springmvchibernate.Entity.Chip;
import com.mycompany.springmvchibernate.Entity.Mau;
import com.mycompany.springmvchibernate.Entity.Ram;
import com.mycompany.springmvchibernate.Entity.SanPham;

public class ChiTietSanPhamDTO {
	
	private int id;
	//BigDecimal
	private float donGia;

	private int soLuong;

	private BoNho boNho;

	private Chip chip;

	private Mau mau;

	private Ram ram;
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	private SanPhamDTO sanPham;

	public ChiTietSanPhamDTO() {

	}

	public ChiTietSanPhamDTO(float donGia, int soLuong) {
		super();
		this.donGia = donGia;
		this.soLuong = soLuong;
	}

	public ChiTietSanPhamDTO(int id, float  donGia, int soLuong, BoNho boNho, Chip chip, Mau mau, Ram ram,
			SanPhamDTO sanPham) {

		this.id = id;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.boNho = boNho;
		this.chip = chip;
		this.mau = mau;
		this.ram = ram;
		this.sanPham = sanPham;
	}

	public SanPhamDTO getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPhamDTO sanPham) {
		this.sanPham = sanPham;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float   getDonGia() {
		return donGia;
	}

	public void setDonGia(float  donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public BoNho getBoNho() {
		return boNho;
	}

	public void setBoNho(BoNho boNho) {
		this.boNho = boNho;
	}

	public Chip getChip() {
		return chip;
	}

	public void setChip(Chip chip) {
		this.chip = chip;
	}

	public Mau getMau() {
		return mau;
	}

	public void setMau(Mau mau) {
		this.mau = mau;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

}
