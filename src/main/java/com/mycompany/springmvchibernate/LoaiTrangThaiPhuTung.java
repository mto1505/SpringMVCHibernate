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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MinhTo
 */
@Entity
@Table(name = "LoaiTrangThaiPhuTung", catalog = "QuanLyBaoDuongDemo", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoaiTrangThaiPhuTung.findAll", query = "SELECT l FROM LoaiTrangThaiPhuTung l"),
    @NamedQuery(name = "LoaiTrangThaiPhuTung.findById", query = "SELECT l FROM LoaiTrangThaiPhuTung l WHERE l.id = :id"),
    @NamedQuery(name = "LoaiTrangThaiPhuTung.findByTenTrangThai", query = "SELECT l FROM LoaiTrangThaiPhuTung l WHERE l.tenTrangThai = :tenTrangThai"),
    @NamedQuery(name = "LoaiTrangThaiPhuTung.findByKyHieu", query = "SELECT l FROM LoaiTrangThaiPhuTung l WHERE l.kyHieu = :kyHieu")})
public class LoaiTrangThaiPhuTung implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 20)
    @Column(name = "TenTrangThai", length = 20)
    private String tenTrangThai;
    @Size(max = 10)
    @Column(name = "KyHieu", length = 10)
    private String kyHieu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrangThaiPhuTung")
    private Collection<ChiTietTrangThaiKhiTiepNhanXe> chiTietTrangThaiKhiTiepNhanXeCollection;

    public LoaiTrangThaiPhuTung() {
    }

    public LoaiTrangThaiPhuTung(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenTrangThai() {
        return tenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }

    public String getKyHieu() {
        return kyHieu;
    }

    public void setKyHieu(String kyHieu) {
        this.kyHieu = kyHieu;
    }

    @XmlTransient
    public Collection<ChiTietTrangThaiKhiTiepNhanXe> getChiTietTrangThaiKhiTiepNhanXeCollection() {
        return chiTietTrangThaiKhiTiepNhanXeCollection;
    }

    public void setChiTietTrangThaiKhiTiepNhanXeCollection(Collection<ChiTietTrangThaiKhiTiepNhanXe> chiTietTrangThaiKhiTiepNhanXeCollection) {
        this.chiTietTrangThaiKhiTiepNhanXeCollection = chiTietTrangThaiKhiTiepNhanXeCollection;
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
        if (!(object instanceof LoaiTrangThaiPhuTung)) {
            return false;
        }
        LoaiTrangThaiPhuTung other = (LoaiTrangThaiPhuTung) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.springmvchibernate.LoaiTrangThaiPhuTung[ id=" + id + " ]";
    }
    
}
