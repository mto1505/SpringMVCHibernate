package com.mycompany.springmvchibernate.EntityDemo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(KhachHang.class)
public abstract class KhachHang_ {

	public static volatile SingularAttribute<KhachHang, TaiKhoan> taiKhoan;
	public static volatile SingularAttribute<KhachHang, String> diaChi;
	public static volatile SingularAttribute<KhachHang, String> sdt;
	public static volatile SingularAttribute<KhachHang, GioHang> gioHang;
	public static volatile SingularAttribute<KhachHang, Integer> id;
	public static volatile SingularAttribute<KhachHang, String> ten;
	public static volatile SingularAttribute<KhachHang, String> email;

}

