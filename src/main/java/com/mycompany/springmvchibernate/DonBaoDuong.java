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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "DonBaoDuong", catalog = "QuanLyBaoDuongDemo", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DonBaoDuong.findAll", query = "SELECT d FROM DonBaoDuong d"),
    @NamedQuery(name = "DonBaoDuong.findById", query = "SELECT d FROM DonBaoDuong d WHERE d.id = :id"),
    @NamedQuery(name = "DonBaoDuong.findByNgayBatDau", query = "SELECT d FROM DonBaoDuong d WHERE d.ngayBatDau = :ngayBatDau"),
    @NamedQuery(name = "DonBaoDuong.findByNgayHoanThanh", query = "SELECT d FROM DonBaoDuong d WHERE d.ngayHoanThanh = :ngayHoanThanh"),
    @NamedQuery(name = "DonBaoDuong.findByTrangthai", query = "SELECT d FROM DonBaoDuong d WHERE d.trangthai = :trangthai"),
    @NamedQuery(name = "DonBaoDuong.findByTongtien", query = "SELECT d FROM DonBaoDuong d WHERE d.tongtien = :tongtien")})
public class DonBaoDuong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "NgayBatDau")
    @Temporal(TemporalType.DATE)
    private Date ngayBatDau;
    @Column(name = "NgayHoanThanh")
    @Temporal(TemporalType.DATE)
    private Date ngayHoanThanh;
    @Size(max = 10)
    @Column(name = "trangthai", length = 10)
    private String trangthai;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tongtien", precision = 19, scale = 4)
    private BigDecimal tongtien;
    @JoinColumn(name = "idNhanVienLapDon", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private NhanVien idNhanVienLapDon;
    @JoinColumn(name = "bienso", referencedColumnName = "bienso", nullable = false)
    @ManyToOne(optional = false)
    private XeMay bienSo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "donBaoDuong")
    private Collection<ChiTietTrangThaiKhiTiepNhanXe> chiTietTrangThaiKhiTiepNhanXeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "donBaoDuong")
    private Collection<ChiTietDonBaoDuong> chiTietDonBaoDuongCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "donBaoDuong")
    private Collection<ChiTietThayTheLinhKien> chiTietThayTheLinhKienCollection;

    public DonBaoDuong() {
    }

    public DonBaoDuong(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayHoanThanh() {
        return ngayHoanThanh;
    }

    public void setNgayHoanThanh(Date ngayHoanThanh) {
        this.ngayHoanThanh = ngayHoanThanh;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public BigDecimal getTongtien() {
        return tongtien;
    }

    public void setTongtien(BigDecimal tongtien) {
        this.tongtien = tongtien;
    }

    public NhanVien getIdNhanVienLapDon() {
        return idNhanVienLapDon;
    }

    public void setIdNhanVienLapDon(NhanVien idNhanVienLapDon) {
        this.idNhanVienLapDon = idNhanVienLapDon;
    }

    public XeMay getBienso() {
        return bienSo;
    }

    public void setBienso(XeMay bienso) {
        this.bienSo = bienso;
    }

    @XmlTransient
    public Collection<ChiTietTrangThaiKhiTiepNhanXe> getChiTietTrangThaiKhiTiepNhanXeCollection() {
        return chiTietTrangThaiKhiTiepNhanXeCollection;
    }

    public void setChiTietTrangThaiKhiTiepNhanXeCollection(Collection<ChiTietTrangThaiKhiTiepNhanXe> chiTietTrangThaiKhiTiepNhanXeCollection) {
        this.chiTietTrangThaiKhiTiepNhanXeCollection = chiTietTrangThaiKhiTiepNhanXeCollection;
    }

    @XmlTransient
    public Collection<ChiTietDonBaoDuong> getChiTietDonBaoDuongCollection() {
        return chiTietDonBaoDuongCollection;
    }

    public void setChiTietDonBaoDuongCollection(Collection<ChiTietDonBaoDuong> chiTietDonBaoDuongCollection) {
        this.chiTietDonBaoDuongCollection = chiTietDonBaoDuongCollection;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DonBaoDuong)) {
            return false;
        }
        DonBaoDuong other = (DonBaoDuong) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.springmvchibernate.DonBaoDuong[ id=" + id + " ]";
    }
    
}
