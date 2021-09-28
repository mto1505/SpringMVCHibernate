package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Hinh_Anh_SP database table.
 * 
 */
@Entity
@NamedQuery(name="HinhAnhSP.findAll", query="SELECT h FROM HinhAnhSP h")
public class HinhAnhSP implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="HinhAnh")
	private String hinhAnh;

	//bi-directional many-to-one association to SanPham
	@ManyToOne()
	@JoinColumn(name="IdSanPham")
	private SanPham sanPham;

	public HinhAnhSP() {
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

	public SanPham getSanPham() {
		return this.sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	

}