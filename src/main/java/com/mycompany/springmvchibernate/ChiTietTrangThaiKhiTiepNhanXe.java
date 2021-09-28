/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MinhTo
 */
@Entity
@Table(name = "ChiTietTrangThaiKhiTiepNhanXe", catalog = "QuanLyBaoDuongDemo", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChiTietTrangThaiKhiTiepNhanXe.findAll", query = "SELECT c FROM ChiTietTrangThaiKhiTiepNhanXe c"),
    @NamedQuery(name = "ChiTietTrangThaiKhiTiepNhanXe.findByIdDonBaoDuong", query = "SELECT c FROM ChiTietTrangThaiKhiTiepNhanXe c WHERE c.chiTietTrangThaiKhiTiepNhanXePK.idDonBaoDuong = :idDonBaoDuong"),
    @NamedQuery(name = "ChiTietTrangThaiKhiTiepNhanXe.findByIdPhuTungCanKiemTra", query = "SELECT c FROM ChiTietTrangThaiKhiTiepNhanXe c WHERE c.chiTietTrangThaiKhiTiepNhanXePK.idPhuTungCanKiemTra = :idPhuTungCanKiemTra")})
public class ChiTietTrangThaiKhiTiepNhanXe implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChiTietTrangThaiKhiTiepNhanXePK chiTietTrangThaiKhiTiepNhanXePK;
    @JoinColumn(name = "idDonBaoDuong", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DonBaoDuong donBaoDuong;
    @JoinColumn(name = "idTrangThaiPhuTung", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private LoaiTrangThaiPhuTung idTrangThaiPhuTung;
    @JoinColumn(name = "idPhuTungCanKiemTra", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PhuTungCanKiemTra phuTungCanKiemTra;

    public ChiTietTrangThaiKhiTiepNhanXe() {
    }

    public ChiTietTrangThaiKhiTiepNhanXe(ChiTietTrangThaiKhiTiepNhanXePK chiTietTrangThaiKhiTiepNhanXePK) {
        this.chiTietTrangThaiKhiTiepNhanXePK = chiTietTrangThaiKhiTiepNhanXePK;
    }

    public ChiTietTrangThaiKhiTiepNhanXe(int idDonBaoDuong, int idPhuTungCanKiemTra) {
        this.chiTietTrangThaiKhiTiepNhanXePK = new ChiTietTrangThaiKhiTiepNhanXePK(idDonBaoDuong, idPhuTungCanKiemTra);
    }

    public ChiTietTrangThaiKhiTiepNhanXePK getChiTietTrangThaiKhiTiepNhanXePK() {
        return chiTietTrangThaiKhiTiepNhanXePK;
    }

    public void setChiTietTrangThaiKhiTiepNhanXePK(ChiTietTrangThaiKhiTiepNhanXePK chiTietTrangThaiKhiTiepNhanXePK) {
        this.chiTietTrangThaiKhiTiepNhanXePK = chiTietTrangThaiKhiTiepNhanXePK;
    }

    public DonBaoDuong getDonBaoDuong() {
        return donBaoDuong;
    }

    public void setDonBaoDuong(DonBaoDuong donBaoDuong) {
        this.donBaoDuong = donBaoDuong;
    }

    public LoaiTrangThaiPhuTung getIdTrangThaiPhuTung() {
        return idTrangThaiPhuTung;
    }

    public void setIdTrangThaiPhuTung(LoaiTrangThaiPhuTung idTrangThaiPhuTung) {
        this.idTrangThaiPhuTung = idTrangThaiPhuTung;
    }

    public PhuTungCanKiemTra getPhuTungCanKiemTra() {
        return phuTungCanKiemTra;
    }

    public void setPhuTungCanKiemTra(PhuTungCanKiemTra phuTungCanKiemTra) {
        this.phuTungCanKiemTra = phuTungCanKiemTra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chiTietTrangThaiKhiTiepNhanXePK != null ? chiTietTrangThaiKhiTiepNhanXePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietTrangThaiKhiTiepNhanXe)) {
            return false;
        }
        ChiTietTrangThaiKhiTiepNhanXe other = (ChiTietTrangThaiKhiTiepNhanXe) object;
        if ((this.chiTietTrangThaiKhiTiepNhanXePK == null && other.chiTietTrangThaiKhiTiepNhanXePK != null) || (this.chiTietTrangThaiKhiTiepNhanXePK != null && !this.chiTietTrangThaiKhiTiepNhanXePK.equals(other.chiTietTrangThaiKhiTiepNhanXePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.springmvchibernate.ChiTietTrangThaiKhiTiepNhanXe[ chiTietTrangThaiKhiTiepNhanXePK=" + chiTietTrangThaiKhiTiepNhanXePK + " ]";
    }
    
}
