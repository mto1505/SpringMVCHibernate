package com.mycompany.springmvchibernate.Entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VerificationTokenEntity.class)
public abstract class VerificationTokenEntity_ {

	public static volatile SingularAttribute<VerificationTokenEntity, TaiKhoan> taiKhoan;
	public static volatile SingularAttribute<VerificationTokenEntity, Date> expiryDate;
	public static volatile SingularAttribute<VerificationTokenEntity, Long> id;
	public static volatile SingularAttribute<VerificationTokenEntity, String> token;

	public static final String TAI_KHOAN = "taiKhoan";
	public static final String EXPIRY_DATE = "expiryDate";
	public static final String ID = "id";
	public static final String TOKEN = "token";

}

