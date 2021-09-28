/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MinhTo
 */
@Entity
@Table(name = "DichVuBaoDuong", catalog = "QuanLyBaoDuongDemo", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DichVuBaoDuong.findAll", query = "SELECT d FROM DichVuBaoDuong d"),
    @NamedQuery(name = "DichVuBaoDuong.findById", query = "SELECT d FROM DichVuBaoDuong d WHERE d.id = :id"),
    @NamedQuery(name = "DichVuBaoDuong.findByTen", query = "SELECT d FROM DichVuBaoDuong d WHERE d.ten = :ten"),
    @NamedQuery(name = "DichVuBaoDuong.findByPhi", query = "SELECT d FROM DichVuBaoDuong d WHERE d.phi = :phi")})
public class DichVuBaoDuong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 40)
    @Column(name = "ten", length = 40)
    private String ten;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "phi", precision = 19, scale = 4)
    private BigDecimal phi;
    @JoinColumn(name = "idLoaiXe", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private LoaiXe loaiXe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dichVuBaoDuong")
    private Collection<ChiTietDonBaoDuong> chiTietDonBaoDuongCollection;

    public DichVuBaoDuong() {
    }

    public DichVuBaoDuong(Integer id) {
        this.id = id;
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

    public BigDecimal getPhi() {
        return phi;
    }

    public void setPhi(BigDecimal phi) {
        this.phi = phi;
    }

    public LoaiXe getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(LoaiXe loaiXe) {
        this.loaiXe = loaiXe;
    }

    

    @XmlTransient
    public Collection<ChiTietDonBaoDuong> getChiTietDonBaoDuongCollection() {
        return chiTietDonBaoDuongCollection;
    }

    public void setChiTietDonBaoDuongCollection(Collection<ChiTietDonBaoDuong> chiTietDonBaoDuongCollection) {
        this.chiTietDonBaoDuongCollection = chiTietDonBaoDuongCollection;
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
        if (!(object instanceof DichVuBaoDuong)) {
            return false;
        }
        DichVuBaoDuong other = (DichVuBaoDuong) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.springmvchibernate.DichVuBaoDuong[ id=" + id + " ]";
    }
    
}
