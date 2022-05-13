package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Hinh_Anh_SP database table.
 * 
 */
@Entity
@NamedQuery(name="HinhAnhSP.findAll", query="SELECT h FROM HinhAnhSP h")
public class HinhAnhSP implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="HinhAnh")
	private String hinhAnh;

	//bi-directional many-to-one association to SanPham
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="IdSanPham",updatable=false) // insertable = true => khi thêm 1 hình ảnh vào sản phẩm thì khoá ngoại IdSanPham tự động thêm vào bảng hình ảnh 
	private SanPham sanPham;

	public HinhAnhSP() {
	}
	@Transient
    public String getPhotosImagePath() {
        if (hinhAnh == null) return null;
         
        return "/product-photos/" + sanPham.getTen() + "/" + hinhAnh;
    }
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHinhAnh() {
		return this.hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public SanPham getSanPham() {
		return this.sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	

}