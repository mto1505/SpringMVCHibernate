package com.mycompany.springmvchibernate.Entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Loai.class)
public abstract class Loai_ {

	public static volatile SingularAttribute<Loai, String> id;
	public static volatile SingularAttribute<Loai, String> ten;
	public static volatile ListAttribute<Loai, SanPham> sanPhams;

}

