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

}

