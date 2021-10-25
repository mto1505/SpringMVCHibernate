package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;
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
	@Column(name="ID")
	private String id;

	@Column(name="Name")
	private String ten;

	//bi-directional many-to-one association to SanPham
	@OneToMany(mappedBy="loai",cascade=CascadeType.PERSIST)
	@JsonBackReference
	private List<SanPham> sanPhams=new ArrayList<SanPham>();

	public Loai() {
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