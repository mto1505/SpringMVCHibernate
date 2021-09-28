package com.mycompany.springmvchibernate.DTO;

import javax.persistence.Column;
import javax.persistence.Id;

public class ChipDTO {
	
	private String id;

	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ChipDTO() {
		super();
	}

	public ChipDTO(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
