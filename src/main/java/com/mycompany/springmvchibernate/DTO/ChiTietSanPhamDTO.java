package com.mycompany.springmvchibernate.DTO;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.mycompany.springmvchibernate.Entity.BoNho;
import com.mycompany.springmvchibernate.Entity.ChiTietDonDatHang;
import com.mycompany.springmvchibernate.Entity.ChiTietGioHang;
import com.mycompany.springmvchibernate.Entity.Chip;
import com.mycompany.springmvchibernate.Entity.Mau;
import com.mycompany.springmvchibernate.Entity.Ram;
import com.mycompany.springmvchibernate.Entity.SanPham;

public class ChiTietSanPhamDTO {

	private String id;

	private BigDecimal donGia;

	private int soLuong;

	private BoNhoDTO boNho;

	private ChipDTO chip;

	private MauDTO mau;

	private RamDTO ram;

	private SanPhamDTO sanPham;

	
	public ChiTietSanPhamDTO() {
		super();
	}

	public ChiTietSanPhamDTO(String id, BigDecimal donGia, int soLuong, BoNhoDTO boNho, ChipDTO chip, MauDTO mau,
			RamDTO ram, SanPhamDTO sanPham) {
		super();
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getDonGia() {
		return donGia;
	}

	public void setDonGia(BigDecimal donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public BoNhoDTO getBoNho() {
		return boNho;
	}

	public void setBoNho(BoNhoDTO boNho) {
		this.boNho = boNho;
	}

	public ChipDTO getChip() {
		return chip;
	}

	public void setChip(ChipDTO chip) {
		this.chip = chip;
	}

	public MauDTO getMau() {
		return mau;
	}

	public void setMau(MauDTO mau) {
		this.mau = mau;
	}

	public RamDTO getRam() {
		return ram;
	}

	public void setRam(RamDTO ram) {
		this.ram = ram;
	}

	public ChiTietSanPhamDTO(String id, BigDecimal donGia, int soLuong, BoNhoDTO boNho, ChipDTO chip, MauDTO mau,
			RamDTO ram) {
		super();
		this.id = id;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.boNho = boNho;
		this.chip = chip;
		this.mau = mau;
		this.ram = ram;
	}

}
