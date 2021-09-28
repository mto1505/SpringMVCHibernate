/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.EntityDemo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mycompany.springmvchibernate.CustomDeserialize.CustomDateDeserializer;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "KhachHang")
public class KhachHang implements Serializable {

  
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue
    @Column(name = "id", nullable = false)
    
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ten", nullable = false, length = 30)
    private String ten;
    
    @Size(min = 1, max = 15)
    @Column(name = "sdt", nullable = false, length = 15)
    private String sdt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diachi", nullable = false, length = 50)
    private String diaChi;
    
    @Basic(optional = true)
    @Column(name = "email", nullable = true, length = 50)
    private String email;
    /*@Column(name = "ngaysinh")
    @Temporal(TemporalType.DATE)
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date ngaySinh;*/
    @OneToOne
    @JoinColumn(name="idGioHang",referencedColumnName="id",nullable=false)
    private GioHang gioHang;
    @OneToOne(mappedBy="khachHang")
    private TaiKhoan taiKhoan;
    
    public KhachHang() {
    }

    public KhachHang(Integer id) {
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

  

  /*  public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
*/
   

  /*  @XmlTransient
    public Collection<XeMay> getXeMayCollection() {
        return xeMayCollection;
    }

    public void setXeMayCollection(Collection<XeMay> xeMayCollection) {
        this.xeMayCollection = xeMayCollection;
    }*/

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
