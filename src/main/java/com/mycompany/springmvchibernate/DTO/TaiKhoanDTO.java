package com.mycompany.springmvchibernate.DTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.mycompany.springmvchibernate.Entity.KhachHang;
import com.mycompany.springmvchibernate.Entity.VaiTro;

public class TaiKhoanDTO {

	private int id;

	private String username;

	// bi-directional many-to-one association to KhachHang

	private VaiTro vaiTro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public VaiTro getVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(VaiTro vaiTro) {
		this.vaiTro = vaiTro;
	}


}
