package com.mycompany.springmvchibernate.EntityTest;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BoNho.class)
public abstract class BoNho_ {

	public static volatile ListAttribute<BoNho, ChiTietSanPham> chiTietSanPhams;
	public static volatile SingularAttribute<BoNho, String> id;
	public static volatile SingularAttribute<BoNho, String> dungLuong;

	public static final String CHI_TIET_SAN_PHAMS = "chiTietSanPhams";
	public static final String ID = "id";
	public static final String DUNG_LUONG = "dungLuong";

}

