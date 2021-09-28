/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MinhTo
 */
@Entity
@Table(name = "LoaiXe", catalog = "QuanLyBaoDuongDemo", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"tenloai"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoaiXe.findAll", query = "SELECT l FROM LoaiXe l"),
    @NamedQuery(name = "LoaiXe.findById", query = "SELECT l FROM LoaiXe l WHERE l.id = :id"),
    @NamedQuery(name = "LoaiXe.findByTenloai", query = "SELECT l FROM LoaiXe l WHERE l.tenloai = :tenloai"),
    @NamedQuery(name = "LoaiXe.findByTrangthai", query = "SELECT l FROM LoaiXe l WHERE l.trangthai = :trangthai")})
public class LoaiXe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tenloai", nullable = false, length = 20)
    private String tenloai;
    @Column(name = "trangthai")
    private Boolean trangthai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loaiXe")
    private Collection<DichVuBaoDuong> dichVuBaoDuongCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loaiXe")
    private Collection<XeMay> xeMayCollection;

    public LoaiXe() {
    }

    public LoaiXe(Integer id) {
        this.id = id;
    }

    public LoaiXe(Integer id, String tenloai) {
        this.id = id;
        this.tenloai = tenloai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }

    @XmlTransient
    public Collection<DichVuBaoDuong> getDichVuBaoDuongCollection() {
        return dichVuBaoDuongCollection;
    }

    public void setDichVuBaoDuongCollection(Collection<DichVuBaoDuong> dichVuBaoDuongCollection) {
        this.dichVuBaoDuongCollection = dichVuBaoDuongCollection;
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
        if (!(object instanceof LoaiXe)) {
            return false;
        }
        LoaiXe other = (LoaiXe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.springmvchibernate.LoaiXe[ id=" + id + " ]";
    }
    
}
