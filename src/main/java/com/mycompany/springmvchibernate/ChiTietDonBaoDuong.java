/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MinhTo
 */
@Entity
@Table(name = "ChiTietDonBaoDuong", catalog = "QuanLyBaoDuongDemo", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChiTietDonBaoDuong.findAll", query = "SELECT c FROM ChiTietDonBaoDuong c"),
    @NamedQuery(name = "ChiTietDonBaoDuong.findByIdDichVuBaoDuong", query = "SELECT c FROM ChiTietDonBaoDuong c WHERE c.chiTietDonBaoDuongPK.idDichVuBaoDuong = :idDichVuBaoDuong"),
    @NamedQuery(name = "ChiTietDonBaoDuong.findByIdDonBaoDuong", query = "SELECT c FROM ChiTietDonBaoDuong c WHERE c.chiTietDonBaoDuongPK.idDonBaoDuong = :idDonBaoDuong"),
    @NamedQuery(name = "ChiTietDonBaoDuong.findBySoluong", query = "SELECT c FROM ChiTietDonBaoDuong c WHERE c.soluong = :soluong"),
    @NamedQuery(name = "ChiTietDonBaoDuong.findByPhuphi", query = "SELECT c FROM ChiTietDonBaoDuong c WHERE c.phuphi = :phuphi"),
    @NamedQuery(name = "ChiTietDonBaoDuong.findByIdNhanVienPhuTrach", query = "SELECT c FROM ChiTietDonBaoDuong c WHERE c.chiTietDonBaoDuongPK.idNhanVienPhuTrach = :idNhanVienPhuTrach")})
public class ChiTietDonBaoDuong implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChiTietDonBaoDuongPK chiTietDonBaoDuongPK;
    @Column(name = "soluong")
    private Integer soluong;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "phuphi", precision = 19, scale = 4)
    private BigDecimal phuphi;
    @JoinColumn(name = "idDichVuBaoDuong", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DichVuBaoDuong dichVuBaoDuong;
    @JoinColumn(name = "idDonBaoDuong", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DonBaoDuong donBaoDuong;
    @JoinColumn(name = "idNhanVienPhuTrach", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NhanVien nhanVien;

    public ChiTietDonBaoDuong() {
    }

    public ChiTietDonBaoDuong(ChiTietDonBaoDuongPK chiTietDonBaoDuongPK) {
        this.chiTietDonBaoDuongPK = chiTietDonBaoDuongPK;
    }

    public ChiTietDonBaoDuong(int idDichVuBaoDuong, int idDonBaoDuong, int idNhanVienPhuTrach) {
        this.chiTietDonBaoDuongPK = new ChiTietDonBaoDuongPK(idDichVuBaoDuong, idDonBaoDuong, idNhanVienPhuTrach);
    }

    public ChiTietDonBaoDuongPK getChiTietDonBaoDuongPK() {
        return chiTietDonBaoDuongPK;
    }

    public void setChiTietDonBaoDuongPK(ChiTietDonBaoDuongPK chiTietDonBaoDuongPK) {
        this.chiTietDonBaoDuongPK = chiTietDonBaoDuongPK;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public BigDecimal getPhuphi() {
        return phuphi;
    }

    public void setPhuphi(BigDecimal phuphi) {
        this.phuphi = phuphi;
    }

    public DichVuBaoDuong getDichVuBaoDuong() {
        return dichVuBaoDuong;
    }

    public void setDichVuBaoDuong(DichVuBaoDuong dichVuBaoDuong) {
        this.dichVuBaoDuong = dichVuBaoDuong;
    }

    public DonBaoDuong getDonBaoDuong() {
        return donBaoDuong;
    }

    public void setDonBaoDuong(DonBaoDuong donBaoDuong) {
        this.donBaoDuong = donBaoDuong;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chiTietDonBaoDuongPK != null ? chiTietDonBaoDuongPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietDonBaoDuong)) {
            return false;
        }
        ChiTietDonBaoDuong other = (ChiTietDonBaoDuong) object;
        if ((this.chiTietDonBaoDuongPK == null && other.chiTietDonBaoDuongPK != null) || (this.chiTietDonBaoDuongPK != null && !this.chiTietDonBaoDuongPK.equals(other.chiTietDonBaoDuongPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.springmvchibernate.ChiTietDonBaoDuong[ chiTietDonBaoDuongPK=" + chiTietDonBaoDuongPK + " ]";
    }
    
}
