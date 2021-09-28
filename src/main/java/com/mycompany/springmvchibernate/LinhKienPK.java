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
public class LinhKienPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngaynhap", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaynhap;

    public LinhKienPK() {
    }

    public LinhKienPK(int id, Date ngaynhap) {
        this.id = id;
        this.ngaynhap = ngaynhap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (ngaynhap != null ? ngaynhap.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LinhKienPK)) {
            return false;
        }
        LinhKienPK other = (LinhKienPK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.ngaynhap == null && other.ngaynhap != null) || (this.ngaynhap != null && !this.ngaynhap.equals(other.ngaynhap))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.springmvchibernate.LinhKienPK[ id=" + id + ", ngaynhap=" + ngaynhap + " ]";
    }
    
}
