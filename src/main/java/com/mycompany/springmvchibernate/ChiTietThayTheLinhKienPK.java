/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author MinhTo
 */
@Embeddable
public class ChiTietThayTheLinhKienPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idLinkKien", nullable = false)
    private int idLinkKien;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDonBaoDuong", nullable = false)
    private int idDonBaoDuong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngaynhaplinhkien", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaynhaplinhkien;

    public ChiTietThayTheLinhKienPK() {
    }

    public ChiTietThayTheLinhKienPK(int idLinkKien, int idDonBaoDuong, Date ngaynhaplinhkien) {
        this.idLinkKien = idLinkKien;
        this.idDonBaoDuong = idDonBaoDuong;
        this.ngaynhaplinhkien = ngaynhaplinhkien;
    }

    public int getIdLinkKien() {
        return idLinkKien;
    }

    public void setIdLinkKien(int idLinkKien) {
        this.idLinkKien = idLinkKien;
    }

    public int getIdDonBaoDuong() {
        return idDonBaoDuong;
    }

    public void setIdDonBaoDuong(int idDonBaoDuong) {
        this.idDonBaoDuong = idDonBaoDuong;
    }

    public Date getNgaynhaplinhkien() {
        return ngaynhaplinhkien;
    }

    public void setNgaynhaplinhkien(Date ngaynhaplinhkien) {
        this.ngaynhaplinhkien = ngaynhaplinhkien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idLinkKien;
        hash += (int) idDonBaoDuong;
        hash += (ngaynhaplinhkien != null ? ngaynhaplinhkien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietThayTheLinhKienPK)) {
            return false;
        }
        ChiTietThayTheLinhKienPK other = (ChiTietThayTheLinhKienPK) object;
        if (this.idLinkKien != other.idLinkKien) {
            return false;
        }
        if (this.idDonBaoDuong != other.idDonBaoDuong) {
            return false;
        }
        if ((this.ngaynhaplinhkien == null && other.ngaynhaplinhkien != null) || (this.ngaynhaplinhkien != null && !this.ngaynhaplinhkien.equals(other.ngaynhaplinhkien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.springmvchibernate.ChiTietThayTheLinhKienPK[ idLinkKien=" + idLinkKien + ", idDonBaoDuong=" + idDonBaoDuong + ", ngaynhaplinhkien=" + ngaynhaplinhkien + " ]";
    }
    
}
