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
public class ChiTietTrangThaiKhiTiepNhanXePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idDonBaoDuong", nullable = false)
    private int idDonBaoDuong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPhuTungCanKiemTra", nullable = false)
    private int idPhuTungCanKiemTra;

    public ChiTietTrangThaiKhiTiepNhanXePK() {
    }

    public ChiTietTrangThaiKhiTiepNhanXePK(int idDonBaoDuong, int idPhuTungCanKiemTra) {
        this.idDonBaoDuong = idDonBaoDuong;
        this.idPhuTungCanKiemTra = idPhuTungCanKiemTra;
    }

    public int getIdDonBaoDuong() {
        return idDonBaoDuong;
    }

    public void setIdDonBaoDuong(int idDonBaoDuong) {
        this.idDonBaoDuong = idDonBaoDuong;
    }

    public int getIdPhuTungCanKiemTra() {
        return idPhuTungCanKiemTra;
    }

    public void setIdPhuTungCanKiemTra(int idPhuTungCanKiemTra) {
        this.idPhuTungCanKiemTra = idPhuTungCanKiemTra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDonBaoDuong;
        hash += (int) idPhuTungCanKiemTra;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietTrangThaiKhiTiepNhanXePK)) {
            return false;
        }
        ChiTietTrangThaiKhiTiepNhanXePK other = (ChiTietTrangThaiKhiTiepNhanXePK) object;
        if (this.idDonBaoDuong != other.idDonBaoDuong) {
            return false;
        }
        if (this.idPhuTungCanKiemTra != other.idPhuTungCanKiemTra) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.springmvchibernate.ChiTietTrangThaiKhiTiepNhanXePK[ idDonBaoDuong=" + idDonBaoDuong + ", idPhuTungCanKiemTra=" + idPhuTungCanKiemTra + " ]";
    }
    
}
