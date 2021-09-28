package com.mycompany.springmvchibernate.Entity2;

import java.io.Serializable;
import javax.persistence.*;
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
	@Column(name="ID", unique=true, nullable=false, length=10)
	private String id;

	@Column(name="DungLuong", nullable=false)
	private Object dungLuong;

	//bi-directional many-to-one association to ChiTietSanPham
	@ManyToOne
	@JoinColumn(name="ID", referencedColumnName="ID_BN", nullable=false, insertable=false, updatable=false)
	private ChiTietSanPham chiTietSanPham;

	//bi-directional many-to-one association to ChiTietSanPham
	@OneToMany(mappedBy="boNho")
	private List<ChiTietSanPham> chiTietSanPhams;

	public BoNho() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getDungLuong() {
		return this.dungLuong;
	}

	public void setDungLuong(Object dungLuong) {
		this.dungLuong = dungLuong;
	}

	public ChiTietSanPham getChiTietSanPham() {
		return this.chiTietSanPham;
	}

	public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) {
		this.chiTietSanPham = chiTietSanPham;
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