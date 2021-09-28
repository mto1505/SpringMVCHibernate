package com.mycompany.springmvchibernate.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DON_VI_VAN_CHUYEN database table.
 * 
 */
@Entity
@Table(name="DON_VI_VAN_CHUYEN")
@NamedQuery(name="DonViVanChuyen.findAll", query="SELECT d FROM DonViVanChuyen d")
public class DonViVanChuyen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	
	private String id;

	@Column(name="Name")
	private String ten;

	//bi-directional many-to-one association to DonDatHang
	@OneToMany(mappedBy="donViVanChuyen")
	private List<DonDatHang> donDatHangs;

	public DonViVanChuyen() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public List<DonDatHang> getDonDatHangs() {
		return this.donDatHangs;
	}

	public void setDonDatHangs(List<DonDatHang> donDatHangs) {
		this.donDatHangs = donDatHangs;
	}

	public DonDatHang addDonDatHang(DonDatHang donDatHang) {
		getDonDatHangs().add(donDatHang);
		donDatHang.setDonViVanChuyen(this);

		return donDatHang;
	}

	public DonDatHang removeDonDatHang(DonDatHang donDatHang) {
		getDonDatHangs().remove(donDatHang);
		donDatHang.setDonViVanChuyen(null);

		return donDatHang;
	}

}