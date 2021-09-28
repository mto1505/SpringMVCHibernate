/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate;

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
@Table(name = "NhanVien", catalog = "QuanLyBaoDuongDemo", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cmnd"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhanVien.findAll", query = "SELECT n FROM NhanVien n"),
    @NamedQuery(name = "NhanVien.findById", query = "SELECT n FROM NhanVien n WHERE n.id = :id"),
    @NamedQuery(name = "NhanVien.findByTen", query = "SELECT n FROM NhanVien n WHERE n.ten = :ten"),
    @NamedQuery(name = "NhanVien.findByCmnd", query = "SELECT n FROM NhanVien n WHERE n.cmnd = :cmnd"),
    @NamedQuery(name = "NhanVien.findByGioitinh", query = "SELECT n FROM NhanVien n WHERE n.gioitinh = :gioitinh"),
    @NamedQuery(name = "NhanVien.findBySdt", query = "SELECT n FROM NhanVien n WHERE n.sdt = :sdt"),
    @NamedQuery(name = "NhanVien.findBySinhnhat", query = "SELECT n FROM NhanVien n WHERE n.sinhnhat = :sinhnhat"),
    @NamedQuery(name = "NhanVien.findByTrinhdo", query = "SELECT n FROM NhanVien n WHERE n.trinhdo = :trinhdo")})
public class NhanVien implements Serializable {

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
    @Size(min = 1, max = 20)
    @Column(name = "cmnd", nullable = false, length = 20)
    private String cmnd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "gioitinh", nullable = false, length = 6)
    private String gioitinh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "sdt", nullable = false, length = 15)
    private String sdt;
    @Column(name = "sinhnhat")
    @Temporal(TemporalType.DATE)
    private Date sinhnhat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "trinhdo", nullable = false, length = 40)
    private String trinhdo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNhanVienLapDon")
    private Collection<DonBaoDuong> donBaoDuongCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhanVien")
    private Collection<ChiTietDonBaoDuong> chiTietDonBaoDuongCollection;
    @OneToMany(mappedBy = "idNhanVien")
    private Collection<TaiKhoan> taiKhoanCollection;

    public NhanVien() {
    }

    public NhanVien(Integer id) {
        this.id = id;
    }

    public NhanVien(Integer id, String ten, String cmnd, String gioitinh, String sdt, String trinhdo) {
        this.id = id;
        this.ten = ten;
        this.cmnd = cmnd;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.trinhdo = trinhdo;
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

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getSinhnhat() {
        return sinhnhat;
    }

    public void setSinhnhat(Date sinhnhat) {
        this.sinhnhat = sinhnhat;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }

    @XmlTransient
    public Collection<DonBaoDuong> getDonBaoDuongCollection() {
        return donBaoDuongCollection;
    }

    public void setDonBaoDuongCollection(Collection<DonBaoDuong> donBaoDuongCollection) {
        this.donBaoDuongCollection = donBaoDuongCollection;
    }

    @XmlTransient
    public Collection<ChiTietDonBaoDuong> getChiTietDonBaoDuongCollection() {
        return chiTietDonBaoDuongCollection;
    }

    public void setChiTietDonBaoDuongCollection(Collection<ChiTietDonBaoDuong> chiTietDonBaoDuongCollection) {
        this.chiTietDonBaoDuongCollection = chiTietDonBaoDuongCollection;
    }

    @XmlTransient
    public Collection<TaiKhoan> getTaiKhoanCollection() {
        return taiKhoanCollection;
    }

    public void setTaiKhoanCollection(Collection<TaiKhoan> taiKhoanCollection) {
        this.taiKhoanCollection = taiKhoanCollection;
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
        if (!(object instanceof NhanVien)) {
            return false;
        }
        NhanVien other = (NhanVien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.springmvchibernate.NhanVien[ id=" + id + " ]";
    }
    
}
