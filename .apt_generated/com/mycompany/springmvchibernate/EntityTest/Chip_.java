package com.mycompany.springmvchibernate.EntityTest;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Entity.Chip;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Chip.class)
public abstract class Chip_ {

	public static volatile ListAttribute<Chip, ChiTietSanPham> chiTietSanPhams;
	public static volatile SingularAttribute<Chip, String> id;
	public static volatile SingularAttribute<Chip, String> ten;

}

