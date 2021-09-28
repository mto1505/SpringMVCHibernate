package com.mycompany.springmvchibernate.Entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ChiTietGioHang.class)
public abstract class ChiTietGioHang_ {

	public static volatile SingularAttribute<ChiTietGioHang, ChiTietSanPham> chiTietSanPham;
	public static volatile SingularAttribute<ChiTietGioHang, GioHang> gioHang;
	public static volatile SingularAttribute<ChiTietGioHang, ChiTietGioHangPK> id;
	public static volatile SingularAttribute<ChiTietGioHang, Integer> soLuong;

	public static final String CHI_TIET_SAN_PHAM = "chiTietSanPham";
	public static final String GIO_HANG = "gioHang";
	public static final String ID = "id";
	public static final String SO_LUONG = "soLuong";

}

