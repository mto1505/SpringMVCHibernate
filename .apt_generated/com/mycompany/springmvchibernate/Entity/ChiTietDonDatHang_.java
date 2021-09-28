package com.mycompany.springmvchibernate.Entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ChiTietDonDatHang.class)
public abstract class ChiTietDonDatHang_ {

	public static volatile SingularAttribute<ChiTietDonDatHang, ChiTietSanPham> chiTietSanPham;
	public static volatile SingularAttribute<ChiTietDonDatHang, DonDatHang> donDatHang;
	public static volatile SingularAttribute<ChiTietDonDatHang, ChiTietDonDatHangPK> id;
	public static volatile SingularAttribute<ChiTietDonDatHang, Integer> soLuong;

}

