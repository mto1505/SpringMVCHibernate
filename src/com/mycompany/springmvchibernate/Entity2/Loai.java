package com.mycompany.springmvchibernate.Entity2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LOAI database table.
 * 
 */
@Entity
@Table(name="LOAI")
@NamedQuery(name="Loai.findAll", query="SELECT l FROM Loai l")
public class Loai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID", unique=true, nullable=false, length=10)
	private String id;

	@Column(name="Name", nullable=false)
	private Object name;

	//bi-directional many-to-one association to SanPham
	@OneToMany(mappedBy="loai")
	private List<SanPham> sanPhams;

	public Loai() {
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

	public List<SanPham> getSanPhams() {
		return this.sanPhams;
	}

	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}

	public SanPham addSanPham(SanPham sanPham) {
		getSanPhams().add(sanPham);
		sanPham.setLoai(this);

		return sanPham;
	}

	public SanPham removeSanPham(SanPham sanPham) {
		getSanPhams().remove(sanPham);
		sanPham.setLoai(null);

		return sanPham;
	}

}