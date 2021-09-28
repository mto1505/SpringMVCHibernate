package com.mycompany.springmvchibernate.EntityTest;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.mycompany.springmvchibernate.Entity.ChiTietDonDatHang;
import com.mycompany.springmvchibernate.Entity.ChiTietDonDatHangPK;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Entity.DonDatHang;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ChiTietDonDatHang.class)
public abstract class ChiTietDonDatHang_ {

	public static volatile SingularAttribute<ChiTietDonDatHang, ChiTietSanPham> chiTietSanPham;
	public static volatile SingularAttribute<ChiTietDonDatHang, DonDatHang> donDatHang;
	public static volatile SingularAttribute<ChiTietDonDatHang, ChiTietDonDatHangPK> id;
	public static volatile SingularAttribute<ChiTietDonDatHang, Integer> soLuong;

}

