package com.mycompany.springmvchibernate.DTO;

public class RamDTO {

	private String id;

	private String dungLuong;

	public String getId() {
		return id;
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

	public RamDTO() {
		super();
	}

	public RamDTO(String id, String dungLuong) {
		super();
		this.id = id;
		this.dungLuong = dungLuong;
	}
	
}
