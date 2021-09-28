package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CHIP database table.
 * 
 */
@Entity
@Table(name="CHIP")
@NamedQuery(name="Chip.findAll", query="SELECT c FROM Chip c")
public class Chip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private String id;

	@Column(name="Name")
	private String ten;

	//bi-directional many-to-one association to ChiTietSanPham
	@OneToMany(mappedBy="chip")
	private List<ChiTietSanPham> chiTietSanPhams;

	public Chip() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public List<ChiTietSanPham> getChiTietSanPhams() {
		return this.chiTietSanPhams;
	}

	public void setChiTietSanPhams(List<ChiTietSanPham> chiTietSanPhams) {
		this.chiTietSanPhams = chiTietSanPhams;
	}

	public ChiTietSanPham addChiTietSanPham(ChiTietSanPham chiTietSanPham) {
		getChiTietSanPhams().add(chiTietSanPham);
		chiTietSanPham.setChip(this);

		return chiTietSanPham;
	}

	public ChiTietSanPham removeChiTietSanPham(ChiTietSanPham chiTietSanPham) {
		getChiTietSanPhams().remove(chiTietSanPham);
		chiTietSanPham.setChip(null);

		return chiTietSanPham;
	}

}