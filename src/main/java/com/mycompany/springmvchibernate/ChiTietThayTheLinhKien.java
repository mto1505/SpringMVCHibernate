/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MinhTo
 */
@Entity
@Table(name = "ChiTietThayTheLinhKien", catalog = "QuanLyBaoDuongDemo", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChiTietThayTheLinhKien.findAll", query = "SELECT c FROM ChiTietThayTheLinhKien c"),
    @NamedQuery(name = "ChiTietThayTheLinhKien.findByIdLinkKien", query = "SELECT c FROM ChiTietThayTheLinhKien c WHERE c.chiTietThayTheLinhKienPK.idLinkKien = :idLinkKien"),
    @NamedQuery(name = "ChiTietThayTheLinhKien.findByIdDonBaoDuong", query = "SELECT c FROM ChiTietThayTheLinhKien c WHERE c.chiTietThayTheLinhKienPK.idDonBaoDuong = :idDonBaoDuong"),
    @NamedQuery(name = "ChiTietThayTheLinhKien.findByGhichu", query = "SELECT c FROM ChiTietThayTheLinhKien c WHERE c.ghichu = :ghichu"),
    @NamedQuery(name = "ChiTietThayTheLinhKien.findByNgaynhaplinhkien", query = "SELECT c FROM ChiTietThayTheLinhKien c WHERE c.chiTietThayTheLinhKienPK.ngaynhaplinhkien = :ngaynhaplinhkien")})
public class ChiTietThayTheLinhKien implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChiTietThayTheLinhKienPK chiTietThayTheLinhKienPK;
    @Size(max = 50)
    @Column(name = "ghichu", length = 50)
    private String ghichu;
    @JoinColumn(name = "idDonBaoDuong", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DonBaoDuong donBaoDuong;
    @JoinColumns({
        @JoinColumn(name = "idLinkKien", referencedColumnName = "id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ngaynhaplinhkien", referencedColumnName = "ngaynhap", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private LinhKien linhKien;

    public ChiTietThayTheLinhKien() {
    }

    public ChiTietThayTheLinhKien(ChiTietThayTheLinhKienPK chiTietThayTheLinhKienPK) {
        this.chiTietThayTheLinhKienPK = chiTietThayTheLinhKienPK;
    }

    public ChiTietThayTheLinhKien(int idLinkKien, int idDonBaoDuong, Date ngaynhaplinhkien) {
        this.chiTietThayTheLinhKienPK = new ChiTietThayTheLinhKienPK(idLinkKien, idDonBaoDuong, ngaynhaplinhkien);
    }

    public ChiTietThayTheLinhKienPK getChiTietThayTheLinhKienPK() {
        return chiTietThayTheLinhKienPK;
    }

    public void setChiTietThayTheLinhKienPK(ChiTietThayTheLinhKienPK chiTietThayTheLinhKienPK) {
        this.chiTietThayTheLinhKienPK = chiTietThayTheLinhKienPK;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public DonBaoDuong getDonBaoDuong() {
        return donBaoDuong;
    }

    public void setDonBaoDuong(DonBaoDuong donBaoDuong) {
        this.donBaoDuong = donBaoDuong;
    }

    public LinhKien getLinhKien() {
        return linhKien;
    }

    public void setLinhKien(LinhKien linhKien) {
        this.linhKien = linhKien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chiTietThayTheLinhKienPK != null ? chiTietThayTheLinhKienPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietThayTheLinhKien)) {
            return false;
        }
        ChiTietThayTheLinhKien other = (ChiTietThayTheLinhKien) object;
        if ((this.chiTietThayTheLinhKienPK == null && other.chiTietThayTheLinhKienPK != null) || (this.chiTietThayTheLinhKienPK != null && !this.chiTietThayTheLinhKienPK.equals(other.chiTietThayTheLinhKienPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.springmvchibernate.ChiTietThayTheLinhKien[ chiTietThayTheLinhKienPK=" + chiTietThayTheLinhKienPK + " ]";
    }
    
}
