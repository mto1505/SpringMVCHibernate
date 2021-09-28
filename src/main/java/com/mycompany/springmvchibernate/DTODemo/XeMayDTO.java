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
public class XeMayDTO {

    private String bienSo;
    private String tenXe;
    private String tenChuSoHuu;
    private String loaiXe;

    public XeMayDTO(String bienSo, String tenXe, String tenChuSoHuu, String loaiXe) {
        this.bienSo = bienSo;
        this.tenXe = tenXe;
        this.tenChuSoHuu = tenChuSoHuu;
        this.loaiXe = loaiXe;
    }

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

    public String getTenChuSoHuu() {
        return tenChuSoHuu;
    }

    public void setTenChuSoHuu(String tenChuSoHuu) {
        this.tenChuSoHuu = tenChuSoHuu;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

}
