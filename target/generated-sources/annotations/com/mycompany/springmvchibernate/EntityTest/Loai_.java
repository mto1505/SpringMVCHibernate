package com.mycompany.springmvchibernate.EntityTest;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Loai.class)
public abstract class Loai_ {

	public static volatile SingularAttribute<Loai, String> name;
	public static volatile SingularAttribute<Loai, String> id;
	public static volatile ListAttribute<Loai, SanPham> sanPhams;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String SAN_PHAMS = "sanPhams";

}

