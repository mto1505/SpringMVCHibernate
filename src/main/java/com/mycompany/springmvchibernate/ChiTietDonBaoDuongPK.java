/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author MinhTo
 */
@Embeddable
public class ChiTietDonBaoDuongPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idDichVuBaoDuong", nullable = false)
    private int idDichVuBaoDuong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDonBaoDuong", nullable = false)
    private int idDonBaoDuong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idNhanVienPhuTrach", nullable = false)
    private int idNhanVienPhuTrach;

    public ChiTietDonBaoDuongPK() {
    }

    public ChiTietDonBaoDuongPK(int idDichVuBaoDuong, int idDonBaoDuong, int idNhanVienPhuTrach) {
        this.idDichVuBaoDuong = idDichVuBaoDuong;
        this.idDonBaoDuong = idDonBaoDuong;
        this.idNhanVienPhuTrach = idNhanVienPhuTrach;
    }

    public int getIdDichVuBaoDuong() {
        return idDichVuBaoDuong;
    }

    public void setIdDichVuBaoDuong(int idDichVuBaoDuong) {
        this.idDichVuBaoDuong = idDichVuBaoDuong;
    }

    public int getIdDonBaoDuong() {
        return idDonBaoDuong;
    }

    public void setIdDonBaoDuong(int idDonBaoDuong) {
        this.idDonBaoDuong = idDonBaoDuong;
    }

    public int getIdNhanVienPhuTrach() {
        return idNhanVienPhuTrach;
    }

    public void setIdNhanVienPhuTrach(int idNhanVienPhuTrach) {
        this.idNhanVienPhuTrach = idNhanVienPhuTrach;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDichVuBaoDuong;
        hash += (int) idDonBaoDuong;
        hash += (int) idNhanVienPhuTrach;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietDonBaoDuongPK)) {
            return false;
        }
        ChiTietDonBaoDuongPK other = (ChiTietDonBaoDuongPK) object;
        if (this.idDichVuBaoDuong != other.idDichVuBaoDuong) {
            return false;
        }
        if (this.idDonBaoDuong != other.idDonBaoDuong) {
            return false;
        }
        if (this.idNhanVienPhuTrach != other.idNhanVienPhuTrach) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.springmvchibernate.ChiTietDonBaoDuongPK[ idDichVuBaoDuong=" + idDichVuBaoDuong + ", idDonBaoDuong=" + idDonBaoDuong + ", idNhanVienPhuTrach=" + idNhanVienPhuTrach + " ]";
    }
    
}
