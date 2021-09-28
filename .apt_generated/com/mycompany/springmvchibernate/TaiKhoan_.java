package com.mycompany.springmvchibernate;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TaiKhoan.class)
public abstract class TaiKhoan_ {

	public static volatile SingularAttribute<TaiKhoan, String> matkhau;
	public static volatile SingularAttribute<TaiKhoan, NhanVien> idNhanVien;
	public static volatile SingularAttribute<TaiKhoan, String> tentaikhoan;
	public static volatile SingularAttribute<TaiKhoan, Quyen> idQuyen;

}

