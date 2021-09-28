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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "XeMay", catalog = "QuanLyBaoDuongDemo", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"bienso"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XeMay.findAll", query = "SELECT x FROM XeMay x"),
    @NamedQuery(name = "XeMay.findByBienso", query = "SELECT x FROM XeMay x WHERE x.bienSo = :bienSo"),
    @NamedQuery(name = "XeMay.findByTenxe", query = "SELECT x FROM XeMay x WHERE x.tenxe = :tenxe")})
public class XeMay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "bienso", nullable = false, length = 15)
    private String bienSo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tenxe", nullable = false, length = 20)
    private String tenxe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bienSo")
    private Collection<DonBaoDuong> donBaoDuongCollection;
    @JoinColumn(name = "idChuSoHuu", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private KhachHang khachHang;
    @JoinColumn(name = "idLoaiXe", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private LoaiXe loaiXe;

    public XeMay() {
    }

    public XeMay(String bienso) {
        this.bienSo = bienSo;
    }

    public XeMay(String bienSo, String tenxe) {
        this.bienSo = bienSo;
        this.tenxe = tenxe;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

 

   
    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    @XmlTransient
    public Collection<DonBaoDuong> getDonBaoDuongCollection() {
        return donBaoDuongCollection;
    }

    public void setDonBaoDuongCollection(Collection<DonBaoDuong> donBaoDuongCollection) {
        this.donBaoDuongCollection = donBaoDuongCollection;
    }

    


    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public LoaiXe getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(LoaiXe loaiXe) {
        this.loaiXe = loaiXe;
    }

  @Override
    public int hashCode() {
        int hash = 0;
        hash += (bienSo != null ? bienSo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XeMay)) {
            return false;
        }
        XeMay other = (XeMay) object;
        if ((this.bienSo == null && other.bienSo != null) || (this.bienSo != null && !this.bienSo.equals(other.bienSo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.springmvchibernate.XeMay[ bienso=" + bienSo + " ]";
    }

}
