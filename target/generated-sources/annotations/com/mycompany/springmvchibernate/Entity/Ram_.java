package com.mycompany.springmvchibernate.Entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ram.class)
public abstract class Ram_ {

	public static volatile ListAttribute<Ram, ChiTietSanPham> chiTietSanPhams;
	public static volatile SingularAttribute<Ram, String> id;
	public static volatile SingularAttribute<Ram, String> dungLuong;

	public static final String CHI_TIET_SAN_PHAMS = "chiTietSanPhams";
	public static final String ID = "id";
	public static final String DUNG_LUONG = "dungLuong";

}

