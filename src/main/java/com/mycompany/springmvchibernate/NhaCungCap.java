/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
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
@Table(name = "NhaCungCap", catalog = "QuanLyBaoDuongDemo", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ten"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhaCungCap.findAll", query = "SELECT n FROM NhaCungCap n"),
    @NamedQuery(name = "NhaCungCap.findById", query = "SELECT n FROM NhaCungCap n WHERE n.id = :id"),
    @NamedQuery(name = "NhaCungCap.findByTen", query = "SELECT n FROM NhaCungCap n WHERE n.ten = :ten"),
    @NamedQuery(name = "NhaCungCap.findByGhichu", query = "SELECT n FROM NhaCungCap n WHERE n.ghichu = :ghichu"),
    @NamedQuery(name = "NhaCungCap.findBySoDienThoai", query = "SELECT n FROM NhaCungCap n WHERE n.soDienThoai = :soDienThoai"),
    @NamedQuery(name = "NhaCungCap.findByTrangthai", query = "SELECT n FROM NhaCungCap n WHERE n.trangthai = :trangthai")})
public class NhaCungCap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false) //ở cấp độ đối tượng java
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ten", nullable = false, length = 30)
    private String ten;
    @Size(max = 100)
    @Column(name = "ghichu", length = 100)
    private String ghichu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "soDienThoai", nullable = false, length = 10)
    private String soDienThoai;

    @Column(name = "trangthai")
    private Boolean trangthai;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "nhacungcap")
    private List<LinhKien> linhKien;

    @XmlTransient
    public List<LinhKien> getLinhKien() {
        return linhKien;
    }

    public void setLinhKien(List<LinhKien> linhKien) {
        this.linhKien = linhKien;
    }

    public NhaCungCap() {
    }

    public NhaCungCap(Integer id) {
        this.id = id;
    }

    public NhaCungCap(Integer id, String ten, String soDienThoai) {
        this.id = id;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
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

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
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
        if (!(object instanceof NhaCungCap)) {
            return false;
        }
        NhaCungCap other = (NhaCungCap) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.springmvchibernate.NhaCungCap[ id=" + id + " ]";
    }

}
