package com.mycompany.springmvchibernate;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NhaCungCap.class)
public abstract class NhaCungCap_ {

	public static volatile SingularAttribute<NhaCungCap, String> soDienThoai;
	public static volatile ListAttribute<NhaCungCap, LinhKien> linhKien;
	public static volatile SingularAttribute<NhaCungCap, Boolean> trangthai;
	public static volatile SingularAttribute<NhaCungCap, String> ghichu;
	public static volatile SingularAttribute<NhaCungCap, Integer> id;
	public static volatile SingularAttribute<NhaCungCap, String> ten;

	public static final String SO_DIEN_THOAI = "soDienThoai";
	public static final String LINH_KIEN = "linhKien";
	public static final String TRANGTHAI = "trangthai";
	public static final String GHICHU = "ghichu";
	public static final String ID = "id";
	public static final String TEN = "ten";

}

