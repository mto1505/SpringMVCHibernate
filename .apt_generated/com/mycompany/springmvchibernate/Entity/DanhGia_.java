package com.mycompany.springmvchibernate.Entity;

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

}

