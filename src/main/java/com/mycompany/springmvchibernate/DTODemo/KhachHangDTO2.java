/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.DTODemo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mycompany.springmvchibernate.CustomDeserialize.CustomDateDeserializer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author MinhTo
 */
public class KhachHangDTO2 {

    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd");

    private int id;
    private String ten;
    private String sdt;
    private String gioitinh;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date ngaySinh;

    public KhachHangDTO2() {
    }

    public KhachHangDTO2(int id, String ten, String sdt, String gioitinh, Date ngaySinh) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.ngaySinh = ngaySinh;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    
//    public Date getSubmissionDateConverted(String timeZone) throws ParseException {
//        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
//        return dateFormat.parse(this.ngaySinh);
//    }
//
//    public void setSubmissionDate(Date date, String timezone) {
//        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
//        this.ngaySinh = dateFormat.format(date);
//    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
}
