package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.List;


/**
 * The persistent class for the VAI_TRO database table.
 * 
 */
@Entity
@Table(name="VAI_TRO")
@NamedQuery(name="VaiTro.findAll", query="SELECT v FROM VaiTro v")
public class VaiTro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")

	private String id;

	@Column(name="Name")
	private String vaiTro;

	//bi-directional many-to-one association to TaiKhoan
	@OneToMany(mappedBy="vaiTro")
	private List<TaiKhoan> taiKhoans;

	

	public VaiTro() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}

	public List<TaiKhoan> getTaiKhoans() {
		return this.taiKhoans;
	}

	public void setTaiKhoans(List<TaiKhoan> taiKhoans) {
		this.taiKhoans = taiKhoans;
	}

	public TaiKhoan addTaiKhoan(TaiKhoan taiKhoan) {
		getTaiKhoans().add(taiKhoan);
		taiKhoan.setVaiTro(this);

		return taiKhoan;
	}

	public TaiKhoan removeTaiKhoan(TaiKhoan taiKhoan) {
		getTaiKhoans().remove(taiKhoan);
		taiKhoan.setVaiTro(null);

		return taiKhoan;
	}

}