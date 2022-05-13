package com.mycompany.springmvchibernate.Entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TaiKhoan.class)
public abstract class TaiKhoan_ {

	public static volatile SingularAttribute<TaiKhoan, VaiTro> vaiTro;
	public static volatile SingularAttribute<TaiKhoan, String> password;
	public static volatile SingularAttribute<TaiKhoan, AuthProvider> provider;
	public static volatile SingularAttribute<TaiKhoan, String> providerId;
	public static volatile SingularAttribute<TaiKhoan, String> imageUrl;
	public static volatile SingularAttribute<TaiKhoan, Boolean> active;
	public static volatile SingularAttribute<TaiKhoan, Integer> id;
	public static volatile SingularAttribute<TaiKhoan, KhachHang> khachHangs;
	public static volatile SingularAttribute<TaiKhoan, String> username;
	public static volatile SingularAttribute<TaiKhoan, VerificationTokenEntity> verificationCode;

	public static final String VAI_TRO = "vaiTro";
	public static final String PASSWORD = "password";
	public static final String PROVIDER = "provider";
	public static final String PROVIDER_ID = "providerId";
	public static final String IMAGE_URL = "imageUrl";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String KHACH_HANGS = "khachHangs";
	public static final String USERNAME = "username";
	public static final String VERIFICATION_CODE = "verificationCode";

}

