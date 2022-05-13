package com.mycompany.springmvchibernate.Entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DonDatHang.class)
public abstract class DonDatHang_ {

	public static volatile SingularAttribute<DonDatHang, String> diaChi;
	public static volatile SingularAttribute<DonDatHang, Integer> tinhTrang;
	public static volatile SingularAttribute<DonDatHang, KhachHang> khachHang;
	public static volatile SingularAttribute<DonDatHang, Integer> id;
	public static volatile ListAttribute<DonDatHang, ChiTietDonDatHang> chiTietDonDatHangs;
	public static volatile SingularAttribute<DonDatHang, Timestamp> thoiGian;
	public static volatile SingularAttribute<DonDatHang, String> chuThich;

}

