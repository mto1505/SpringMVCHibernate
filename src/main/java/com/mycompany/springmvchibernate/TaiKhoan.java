/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MinhTo
 */
@Entity
@Table(name = "TaiKhoan", catalog = "QuanLyBaoDuongDemo", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaiKhoan.findAll", query = "SELECT t FROM TaiKhoan t"),
    @NamedQuery(name = "TaiKhoan.findByTentaikhoan", query = "SELECT t FROM TaiKhoan t WHERE t.tentaikhoan = :tentaikhoan"),
    @NamedQuery(name = "TaiKhoan.findByMatkhau", query = "SELECT t FROM TaiKhoan t WHERE t.matkhau = :matkhau")})
public class TaiKhoan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tentaikhoan", nullable = false, length = 30)
    private String tentaikhoan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "matkhau", nullable = false, length = 30)
    private String matkhau;
    @JoinColumn(name = "idNhanVien", referencedColumnName = "id")
    @ManyToOne
    private NhanVien idNhanVien;
    @JoinColumn(name = "idQuyen", referencedColumnName = "id")
    @ManyToOne
    private Quyen idQuyen;

    public TaiKhoan() {
    }

    public TaiKhoan(String tentaikhoan) {
        this.tentaikhoan = tentaikhoan;
    }

    public TaiKhoan(String tentaikhoan, String matkhau) {
        this.tentaikhoan = tentaikhoan;
        this.matkhau = matkhau;
    }

    public String getTentaikhoan() {
        return tentaikhoan;
    }

    public void setTentaikhoan(String tentaikhoan) {
        this.tentaikhoan = tentaikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public NhanVien getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(NhanVien idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public Quyen getIdQuyen() {
        return idQuyen;
    }

    public void setIdQuyen(Quyen idQuyen) {
        this.idQuyen = idQuyen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tentaikhoan != null ? tentaikhoan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaiKhoan)) {
            return false;
        }
        TaiKhoan other = (TaiKhoan) object;
        if ((this.tentaikhoan == null && other.tentaikhoan != null) || (this.tentaikhoan != null && !this.tentaikhoan.equals(other.tentaikhoan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.springmvchibernate.TaiKhoan[ tentaikhoan=" + tentaikhoan + " ]";
    }
    
}
