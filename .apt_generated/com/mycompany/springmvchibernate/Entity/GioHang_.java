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

}

