package com.mycompany.springmvchibernate;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ChiTietThayTheLinhKien.class)
public abstract class ChiTietThayTheLinhKien_ {

	public static volatile SingularAttribute<ChiTietThayTheLinhKien, LinhKien> linhKien;
	public static volatile SingularAttribute<ChiTietThayTheLinhKien, ChiTietThayTheLinhKienPK> chiTietThayTheLinhKienPK;
	public static volatile SingularAttribute<ChiTietThayTheLinhKien, DonBaoDuong> donBaoDuong;
	public static volatile SingularAttribute<ChiTietThayTheLinhKien, String> ghichu;

	public static final String LINH_KIEN = "linhKien";
	public static final String CHI_TIET_THAY_THE_LINH_KIEN_PK = "chiTietThayTheLinhKienPK";
	public static final String DON_BAO_DUONG = "donBaoDuong";
	public static final String GHICHU = "ghichu";

}

