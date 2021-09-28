package com.mycompany.springmvchibernate.EntityTest;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Entity.Ram;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ram.class)
public abstract class Ram_ {

	public static volatile ListAttribute<Ram, ChiTietSanPham> chiTietSanPhams;
	public static volatile SingularAttribute<Ram, String> id;
	public static volatile SingularAttribute<Ram, String> dungLuong;

}

