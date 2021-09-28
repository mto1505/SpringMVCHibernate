package com.mycompany.springmvchibernate.EntityTest;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DonViVanChuyen.class)
public abstract class DonViVanChuyen_ {

	public static volatile ListAttribute<DonViVanChuyen, DonDatHang> donDatHangs;
	public static volatile SingularAttribute<DonViVanChuyen, String> name;
	public static volatile SingularAttribute<DonViVanChuyen, String> id;

	public static final String DON_DAT_HANGS = "donDatHangs";
	public static final String NAME = "name";
	public static final String ID = "id";

}

