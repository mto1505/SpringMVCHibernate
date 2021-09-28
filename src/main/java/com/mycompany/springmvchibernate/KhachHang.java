/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mycompany.springmvchibernate.CustomDeserialize.CustomDateDeserializer;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MinhTo
 */
@Entity
@Table(name = "KhachHang", catalog = "QuanLyBaoDuongDemo", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KhachHang.findAll", query = "SELECT k FROM KhachHang k"),
    @NamedQuery(name = "KhachHang.findById", query = "SELECT k FROM KhachHang k WHERE k.id = :id"),
    @NamedQuery(name = "KhachHang.findByTen", query = "SELECT k FROM KhachHang k WHERE k.ten = :ten"),
    @NamedQuery(name = "KhachHang.findBySdt", query = "SELECT k FROM KhachHang k WHERE k.sdt = :sdt"),
    @NamedQuery(name = "KhachHang.findByGioitinh", query = "SELECT k FROM KhachHang k WHERE k.gioitinh = :gioitinh"),
    @NamedQuery(name = "KhachHang.findByNgaysinh", query = "SELECT k FROM KhachHang k WHERE k.ngaySinh = :ngaySinh")})
public class KhachHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ten", nullable = false, length = 30)
    private String ten;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "sdt", nullable = false, length = 15)
    private String sdt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "gioitinh", nullable = false, length = 6)
    private String gioitinh;
    @Column(name = "ngaysinh")
    @Temporal(TemporalType.DATE)
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date ngaySinh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khachHang")
    private Collection<XeMay> xeMayCollection;

    public KhachHang() {
    }

    public KhachHang(Integer id) {
        this.id = id;
    }

    public KhachHang(Integer id, String ten, String sdt, String gioitinh) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

   

    @XmlTransient
    public Collection<XeMay> getXeMayCollection() {
        return xeMayCollection;
    }

    public void setXeMayCollection(Collection<XeMay> xeMayCollection) {
        this.xeMayCollection = xeMayCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KhachHang)) {
            return false;
        }
        KhachHang other = (KhachHang) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.springmvchibernate.KhachHang[ id=" + id + " ]";
    }
    
}
