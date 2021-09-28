/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.DTODemo;

import com.mycompany.springmvchibernate.KhachHang;
import com.mycompany.springmvchibernate.LoaiXe;

/**
 *
 * @author MinhTo
 */
public class XeMayDTO2 {

    private String bienSo;
    private String tenXe;
    private KhachHangDTO khachHang;
    private LoaiXeDTO loaiXe;

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }


    public String getTenXe() {
		return tenXe;
	}

	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}

	public KhachHangDTO getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHangDTO khachHang) {
        this.khachHang = khachHang;
    }

    public LoaiXeDTO getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(LoaiXeDTO loaiXe) {
        this.loaiXe = loaiXe;
    }



   
}
