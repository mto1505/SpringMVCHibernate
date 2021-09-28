package com.mycompany.springmvchibernate.EntityTest;

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

	public static final String CHI_TIET_SAN_PHAM = "chiTietSanPham";
	public static final String DON_DAT_HANG = "donDatHang";
	public static final String ID = "id";
	public static final String SO_LUONG = "soLuong";

}

