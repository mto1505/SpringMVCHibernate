package com.mycompany.springmvchibernate;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Quyen.class)
public abstract class Quyen_ {

	public static volatile SingularAttribute<Quyen, String> tenquyen;
	public static volatile CollectionAttribute<Quyen, TaiKhoan> taiKhoanCollection;
	public static volatile SingularAttribute<Quyen, Integer> id;

	public static final String TENQUYEN = "tenquyen";
	public static final String TAI_KHOAN_COLLECTION = "taiKhoanCollection";
	public static final String ID = "id";

}

