package com.mycompany.springmvchibernate.EntityTest;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Chip.class)
public abstract class Chip_ {

	public static volatile ListAttribute<Chip, ChiTietSanPham> chiTietSanPhams;
	public static volatile SingularAttribute<Chip, String> name;
	public static volatile SingularAttribute<Chip, String> id;

	public static final String CHI_TIET_SAN_PHAMS = "chiTietSanPhams";
	public static final String NAME = "name";
	public static final String ID = "id";

}

