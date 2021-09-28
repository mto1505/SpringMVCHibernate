package com.mycompany.springmvchibernate.EntityTest;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VaiTro.class)
public abstract class VaiTro_ {

	public static volatile SingularAttribute<VaiTro, String> name;
	public static volatile SingularAttribute<VaiTro, String> id;
	public static volatile ListAttribute<VaiTro, TaiKhoan> taiKhoans;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String TAI_KHOANS = "taiKhoans";

}

