package com.mycompany.springmvchibernate.EntityDemo;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BaseEntity.class)
public abstract class BaseEntity_ {

	public static volatile SingularAttribute<BaseEntity, String> createBy;
	public static volatile SingularAttribute<BaseEntity, Date> modifiedDate;
	public static volatile SingularAttribute<BaseEntity, Date> modifiedBy;
	public static volatile SingularAttribute<BaseEntity, Date> createDate;

	public static final String CREATE_BY = "createBy";
	public static final String MODIFIED_DATE = "modifiedDate";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String CREATE_DATE = "createDate";

}

