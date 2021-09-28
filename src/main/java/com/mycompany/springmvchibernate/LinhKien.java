/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MinhTo
 */
@Entity
@Table(name = "LinhKien", catalog = "QuanLyBaoDuongDemo", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LinhKien.findAll", query = "SELECT l FROM LinhKien l"),
    @NamedQuery(name = "LinhKien.findById", query = "SELECT l FROM LinhKien l WHERE l.linhKienPK.id = :id"),
    @NamedQuery(name = "LinhKien.findByTenlinhkien", query = "SELECT l FROM LinhKien l WHERE l.tenlinhkien = :tenlinhkien"),
    @NamedQuery(name = "LinhKien.findBySoluong", query = "SELECT l FROM LinhKien l WHERE l.soluong = :soluong"),
    @NamedQuery(name = "LinhKien.findByGia", query = "SELECT l FROM LinhKien l WHERE l.gia = :gia"),
    @NamedQuery(name = "LinhKien.findByNhacungcap", query = "SELECT l FROM LinhKien l WHERE l.nhacungcap = :nhacungcap"),
    @NamedQuery(name = "LinhKien.findByNgaynhap", query = "SELECT l FROM LinhKien l WHERE l.linhKienPK.ngaynhap = :ngaynhap"),
    @NamedQuery(name = "LinhKien.findByTrangthai", query = "SELECT l FROM LinhKien l WHERE l.trangthai = :trangthai")})
public class LinhKien implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LinhKienPK linhKienPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tenlinhkien", nullable = false, length = 50)
    private String tenlinhkien;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soluong", nullable = false)
    private int soluong;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "gia", nullable = false, precision = 19, scale = 4)
    private BigDecimal gia;
    @JoinColumn(name = "nhacungcap", nullable = false)
    @ManyToOne(optional = false)
    private NhaCungCap nhacungcap;
    @Column(name = "trangthai")
    private Boolean trangthai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "linhKien")
    private Collection<ChiTietThayTheLinhKien> chiTietThayTheLinhKienCollection;

    public LinhKien() {
    }

    public LinhKien(LinhKienPK linhKienPK) {
        this.linhKienPK = linhKienPK;
    }

    public LinhKien(LinhKienPK linhKienPK, String tenlinhkien, int soluong, BigDecimal gia) {
        this.linhKienPK = linhKienPK;
        this.tenlinhkien = tenlinhkien;
        this.soluong = soluong;
        this.gia = gia;
     
    }

    public LinhKien(int id, Date ngaynhap) {
        this.linhKienPK = new LinhKienPK(id, ngaynhap);
    }

    public LinhKienPK getLinhKienPK() {
        return linhKienPK;
    }

    public void setLinhKienPK(LinhKienPK linhKienPK) {
        this.linhKienPK = linhKienPK;
    }

    public String getTenlinhkien() {
        return tenlinhkien;
    }

    public void setTenlinhkien(String tenlinhkien) {
        this.tenlinhkien = tenlinhkien;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public NhaCungCap getIdNhacungcap() {
        return nhacungcap;
    }

    public void setIdNhacungcap(NhaCungCap idNhacungcap) {
        this.nhacungcap = idNhacungcap;
    }


    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }

    @XmlTransient
    public Collection<ChiTietThayTheLinhKien> getChiTietThayTheLinhKienCollection() {
        return chiTietThayTheLinhKienCollection;
    }

    public void setChiTietThayTheLinhKienCollection(Collection<ChiTietThayTheLinhKien> chiTietThayTheLinhKienCollection) {
        this.chiTietThayTheLinhKienCollection = chiTietThayTheLinhKienCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (linhKienPK != null ? linhKienPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LinhKien)) {
            return false;
        }
        LinhKien other = (LinhKien) object;
        if ((this.linhKienPK == null && other.linhKienPK != null) || (this.linhKienPK != null && !this.linhKienPK.equals(other.linhKienPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.springmvchibernate.LinhKien[ linhKienPK=" + linhKienPK + " ]";
    }
    
}
