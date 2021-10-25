package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;


/**
 * The persistent class for the BO_NHO database table.
 * 
 */
@Entity
@Table(name="BO_NHO")
@NamedQuery(name="BoNho.findAll", query="SELECT b FROM BoNho b")
public class BoNho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private String id;

	@Column(name="DungLuong")
	private String dungLuong;

	//bi-directional many-to-one association to ChiTietSanPham
	@OneToMany(mappedBy="boNho")
	@JsonBackReference
	private List<ChiTietSanPham> chiTietSanPhams;

	public BoNho() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDungLuong() {
		return this.dungLuong;
	}

	public void setDungLuong(String dungLuong) {
		this.dungLuong = dungLuong;
	}

	public List<ChiTietSanPham> getChiTietSanPhams() {
		return this.chiTietSanPhams;
	}

	public void setChiTietSanPhams(List<ChiTietSanPham> chiTietSanPhams) {
		this.chiTietSanPhams = chiTietSanPhams;
	}

	public ChiTietSanPham addChiTietSanPham(ChiTietSanPham chiTietSanPham) {
		getChiTietSanPhams().add(chiTietSanPham);
		chiTietSanPham.setBoNho(this);

		return chiTietSanPham;
	}

	public ChiTietSanPham removeChiTietSanPham(ChiTietSanPham chiTietSanPham) {
		getChiTietSanPhams().remove(chiTietSanPham);
		chiTietSanPham.setBoNho(null);

		return chiTietSanPham;
	}

}