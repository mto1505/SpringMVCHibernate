package com.mycompany.springmvchibernate.EntityTest;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.mycompany.springmvchibernate.Entity.Loai;
import com.mycompany.springmvchibernate.Entity.SanPham;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Loai.class)
public abstract class Loai_ {

	public static volatile SingularAttribute<Loai, String> id;
	public static volatile SingularAttribute<Loai, String> ten;
	public static volatile ListAttribute<Loai, SanPham> sanPhams;

}

