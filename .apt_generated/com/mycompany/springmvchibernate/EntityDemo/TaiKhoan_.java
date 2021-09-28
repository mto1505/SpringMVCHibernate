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

}

