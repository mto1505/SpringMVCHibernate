package com.mycompany.springmvchibernate.Entity2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Hinh_Anh_SP database table.
 * 
 */
@Entity
@Table(name="Hinh_Anh_SP")
@NamedQuery(name="Hinh_Anh_SP.findAll", query="SELECT h FROM Hinh_Anh_SP h")
public class Hinh_Anh_SP implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID", unique=true, nullable=false)
	private int id;

	@Column(name="HinhAnh", nullable=false, length=2147483647)
	private String hinhAnh;

	//bi-directional many-to-one association to SanPham
	@OneToMany(mappedBy="hinhAnhSp")
	private List<SanPham> sanPhams;

	public Hinh_Anh_SP() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHinhAnh() {
		return this.hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public List<SanPham> getSanPhams() {
		return this.sanPhams;
	}

	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}

	public SanPham addSanPham(SanPham sanPham) {
		getSanPhams().add(sanPham);
		sanPham.setHinhAnhSp(this);

		return sanPham;
	}

	public SanPham removeSanPham(SanPham sanPham) {
		getSanPhams().remove(sanPham);
		sanPham.setHinhAnhSp(null);

		return sanPham;
	}

}