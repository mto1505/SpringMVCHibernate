package com.mycompany.springmvchibernate.Entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GioHang.class)
public abstract class GioHang_ {

	public static volatile ListAttribute<GioHang, ChiTietGioHang> chiTietGioHangs;
	public static volatile SingularAttribute<GioHang, Integer> id;
	public static volatile SingularAttribute<GioHang, KhachHang> khachHangs;

	public static final String CHI_TIET_GIO_HANGS = "chiTietGioHangs";
	public static final String ID = "id";
	public static final String KHACH_HANGS = "khachHangs";

}

