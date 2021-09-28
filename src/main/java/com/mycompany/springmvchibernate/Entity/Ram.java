package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RAM database table.
 * 
 */
@Entity
@Table(name="RAM")
@NamedQuery(name="Ram.findAll", query="SELECT r FROM Ram r")
public class Ram implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	
	private String id;

	@Column(name="DungLuong")
	private String dungLuong;

	//bi-directional many-to-one association to ChiTietSanPham
	@OneToMany(mappedBy="ram")
	private List<ChiTietSanPham> chiTietSanPhams;

	public Ram() {
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
		chiTietSanPham.setRam(this);

		return chiTietSanPham;
	}

	public ChiTietSanPham removeChiTietSanPham(ChiTietSanPham chiTietSanPham) {
		getChiTietSanPhams().remove(chiTietSanPham);
		chiTietSanPham.setRam(null);

		return chiTietSanPham;
	}

}