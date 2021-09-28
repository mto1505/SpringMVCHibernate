package com.mycompany.springmvchibernate.EntityTest;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Entity.Mau;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Mau.class)
public abstract class Mau_ {

	public static volatile ListAttribute<Mau, ChiTietSanPham> chiTietSanPhams;
	public static volatile SingularAttribute<Mau, String> id;
	public static volatile SingularAttribute<Mau, String> ten;

}

