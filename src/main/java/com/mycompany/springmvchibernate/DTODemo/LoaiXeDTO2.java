/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.DTODemo;

/**
 *
 * @author MinhTo
 */
public class LoaiXeDTO2 {
   private int id;
   private String tenLoai;
   private Boolean trangThai;

    public void setId(int id) {
        this.id = id;
    }

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public int getId() {
		return id;
	}

    
   
}
