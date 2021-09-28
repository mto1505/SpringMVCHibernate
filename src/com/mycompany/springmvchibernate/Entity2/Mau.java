package com.mycompany.springmvchibernate.Entity2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MAU database table.
 * 
 */
@Entity
@Table(name="MAU")
@NamedQuery(name="Mau.findAll", query="SELECT m FROM Mau m")
public class Mau implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID", unique=true, nullable=false, length=10)
	private String id;

	@Column(name="Name", nullable=false)
	private Object name;

	//bi-directional many-to-one association to ChiTietSanPham
	@OneToMany(mappedBy="mau")
	private List<ChiTietSanPham> chiTietSanPhams;

	public Mau() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getName() {
		return this.name;
	}

	public void setName(Object name) {
		this.name = name;
	}

	public List<ChiTietSanPham> getChiTietSanPhams() {
		return this.chiTietSanPhams;
	}

	public void setChiTietSanPhams(List<ChiTietSanPham> chiTietSanPhams) {
		this.chiTietSanPhams = chiTietSanPhams;
	}

	public ChiTietSanPham addChiTietSanPham(ChiTietSanPham chiTietSanPham) {
		getChiTietSanPhams().add(chiTietSanPham);
		chiTietSanPham.setMau(this);

		return chiTietSanPham;
	}

	public ChiTietSanPham removeChiTietSanPham(ChiTietSanPham chiTietSanPham) {
		getChiTietSanPhams().remove(chiTietSanPham);
		chiTietSanPham.setMau(null);

		return chiTietSanPham;
	}

}