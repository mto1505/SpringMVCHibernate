package com.mycompany.springmvchibernate.Entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DonDatHang.class)
public abstract class DonDatHang_ {

	public static volatile SingularAttribute<DonDatHang, Integer> tinhTrang;
	public static volatile SingularAttribute<DonDatHang, KhachHang> khachHang;
	public static volatile SingularAttribute<DonDatHang, Integer> id;
	public static volatile ListAttribute<DonDatHang, ChiTietDonDatHang> chiTietDonDatHangs;
	public static volatile SingularAttribute<DonDatHang, Timestamp> thoiGian;

	public static final String TINH_TRANG = "tinhTrang";
	public static final String KHACH_HANG = "khachHang";
	public static final String ID = "id";
	public static final String CHI_TIET_DON_DAT_HANGS = "chiTietDonDatHangs";
	public static final String THOI_GIAN = "thoiGian";

}

