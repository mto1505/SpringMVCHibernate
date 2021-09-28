package com.mycompany.springmvchibernate.EntityDemo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TaiKhoan.class)
public abstract class TaiKhoan_ {

	public static volatile SingularAttribute<TaiKhoan, String> password;
	public static volatile SingularAttribute<TaiKhoan, KhachHang> khachHang;
	public static volatile SingularAttribute<TaiKhoan, Long> id;
	public static volatile SingularAttribute<TaiKhoan, String> userName;

	public static final String PASSWORD = "password";
	public static final String KHACH_HANG = "khachHang";
	public static final String ID = "id";
	public static final String USER_NAME = "userName";

}

