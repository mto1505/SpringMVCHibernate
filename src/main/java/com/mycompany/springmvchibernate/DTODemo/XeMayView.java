/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.DTODemo;

import com.mycompany.springmvchibernate.LoaiXe;

/**
 *
 * @author MinhTo
 */
public interface XeMayView {


    public String getBienSo();

    public String getTenxe() ;
    	
    public KhachHangView getChuSoHuu();

    public LoaiXeView getLoaiXe() ;
    
    interface LoaiXeView{
        String getTenloai();
    }
    interface KhachHangView{
        String getTen();
    }
    /*String json="
     {
      "bienSo":"13123213",
      "tenXe":"sh mode",
      "chuSoHuu":"{
      		"ten":"BuiMinhTo"
      }",
      "loaiXe":"{
      		"ten":"SH"
      }"
     }"*/
    
}

