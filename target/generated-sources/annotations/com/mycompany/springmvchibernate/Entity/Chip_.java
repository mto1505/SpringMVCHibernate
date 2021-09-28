package com.mycompany.springmvchibernate.Entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Chip.class)
public abstract class Chip_ {

	public static volatile ListAttribute<Chip, ChiTietSanPham> chiTietSanPhams;
	public static volatile SingularAttribute<Chip, String> id;
	public static volatile SingularAttribute<Chip, String> ten;

	public static final String CHI_TIET_SAN_PHAMS = "chiTietSanPhams";
	public static final String ID = "id";
	public static final String TEN = "ten";

}

