package com.mycompany.springmvchibernate.Entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Mau.class)
public abstract class Mau_ {

	public static volatile ListAttribute<Mau, ChiTietSanPham> chiTietSanPhams;
	public static volatile SingularAttribute<Mau, String> id;
	public static volatile SingularAttribute<Mau, String> ten;

	public static final String CHI_TIET_SAN_PHAMS = "chiTietSanPhams";
	public static final String ID = "id";
	public static final String TEN = "ten";

}

