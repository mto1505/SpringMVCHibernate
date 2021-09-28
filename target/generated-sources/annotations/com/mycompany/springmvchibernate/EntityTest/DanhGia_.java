package com.mycompany.springmvchibernate.EntityTest;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DanhGia.class)
public abstract class DanhGia_ {

	public static volatile SingularAttribute<DanhGia, SanPham> sanPham;
	public static volatile SingularAttribute<DanhGia, KhachHang> khachHang;
	public static volatile SingularAttribute<DanhGia, DanhGiaPK> id;
	public static volatile SingularAttribute<DanhGia, String> noiDung;
	public static volatile SingularAttribute<DanhGia, Timestamp> thoiGian;

	public static final String SAN_PHAM = "sanPham";
	public static final String KHACH_HANG = "khachHang";
	public static final String ID = "id";
	public static final String NOI_DUNG = "noiDung";
	public static final String THOI_GIAN = "thoiGian";

}

