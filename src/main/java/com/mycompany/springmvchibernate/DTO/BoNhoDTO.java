package com.mycompany.springmvchibernate.DTO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;

public class BoNhoDTO {

	private String id;

	private String dungLuong;

	public String getId() {
		return id;
	}



	public BoNhoDTO() {
		super();
	}



	public void setId(String id) {
		this.id = id;
	}

	public String getDungLuong() {
		return dungLuong;
	}

	public void setDungLuong(String dungLuong) {
		this.dungLuong = dungLuong;
	}

	public BoNhoDTO(String id, String dungLuong) {
		super();
		this.id = id;
		this.dungLuong = dungLuong;
	}

}
