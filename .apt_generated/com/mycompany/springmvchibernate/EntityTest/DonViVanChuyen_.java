package com.mycompany.springmvchibernate.EntityTest;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.mycompany.springmvchibernate.Entity.DonDatHang;
import com.mycompany.springmvchibernate.Entity.DonViVanChuyen;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DonViVanChuyen.class)
public abstract class DonViVanChuyen_ {

	public static volatile ListAttribute<DonViVanChuyen, DonDatHang> donDatHangs;
	public static volatile SingularAttribute<DonViVanChuyen, String> id;
	public static volatile SingularAttribute<DonViVanChuyen, String> ten;

}

