package com.mycompany.springmvchibernate.Entity2;

import java.io.Serializable;
import javax.persistence.*;
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
	@Column(name="ID", unique=true, nullable=false, length=10)
	private String id;

	@Column(name="Name", nullable=false)
	private Object name;

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

	public Object getName() {
		return this.name;
	}

	public void setName(Object name) {
		this.name = name;
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