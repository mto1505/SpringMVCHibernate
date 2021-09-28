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
@Table(name = "PhuTungCanKiemTra", catalog = "QuanLyBaoDuongDemo", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhuTungCanKiemTra.findAll", query = "SELECT p FROM PhuTungCanKiemTra p"),
    @NamedQuery(name = "PhuTungCanKiemTra.findById", query = "SELECT p FROM PhuTungCanKiemTra p WHERE p.id = :id"),
    @NamedQuery(name = "PhuTungCanKiemTra.findByTenPhuTung", query = "SELECT p FROM PhuTungCanKiemTra p WHERE p.tenPhuTung = :tenPhuTung")})
public class PhuTungCanKiemTra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 50)
    @Column(name = "TenPhuTung", length = 50)
    private String tenPhuTung;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phuTungCanKiemTra")
    private Collection<ChiTietTrangThaiKhiTiepNhanXe> chiTietTrangThaiKhiTiepNhanXeCollection;

    public PhuTungCanKiemTra() {
    }

    public PhuTungCanKiemTra(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenPhuTung() {
        return tenPhuTung;
    }

    public void setTenPhuTung(String tenPhuTung) {
        this.tenPhuTung = tenPhuTung;
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
        if (!(object instanceof PhuTungCanKiemTra)) {
            return false;
        }
        PhuTungCanKiemTra other = (PhuTungCanKiemTra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.springmvchibernate.PhuTungCanKiemTra[ id=" + id + " ]";
    }
    
}
