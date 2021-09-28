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

	public static final String MATKHAU = "matkhau";
	public static final String ID_NHAN_VIEN = "idNhanVien";
	public static final String TENTAIKHOAN = "tentaikhoan";
	public static final String ID_QUYEN = "idQuyen";

}

