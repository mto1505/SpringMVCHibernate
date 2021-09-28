package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TAI_KHOAN database table.
 * 
 */
@Entity
@Table(name="TAI_KHOAN")
@NamedQuery(name="TaiKhoan.findAll", query="SELECT t FROM TaiKhoan t")
public class TaiKhoan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="Password")
	private String password;

	@Column(name="Username")
	private String username;

	//bi-directional many-to-one association to KhachHang
	@OneToOne(mappedBy="taiKhoan")
	private KhachHang khachHangs;

	//bi-directional many-to-one association to VaiTro
	@ManyToOne
	@JoinColumn(name="ID_VT")
	private VaiTro vaiTro;

	public TaiKhoan() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public KhachHang getKhachHangs() {
		return this.khachHangs;
	}

	public void setKhachHangs(KhachHang khachHangs) {
		this.khachHangs = khachHangs;
	}

	public KhachHang addKhachHang(KhachHang khachHang) {
	
		khachHang.setTaiKhoan(this);

		return khachHang;
	}

	public KhachHang removeKhachHang(KhachHang khachHang) {
		
		khachHang.setTaiKhoan(null);

		return khachHang;
	}

	public VaiTro getVaiTro() {
		return this.vaiTro;
	}

	public void setVaiTro(VaiTro vaiTro) {
		this.vaiTro = vaiTro;
	}

}