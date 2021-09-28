package com.mycompany.springmvchibernate;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(KhachHang.class)
public abstract class KhachHang_ {

	public static volatile SingularAttribute<KhachHang, String> sdt;
	public static volatile SingularAttribute<KhachHang, String> gioitinh;
	public static volatile CollectionAttribute<KhachHang, XeMay> xeMayCollection;
	public static volatile SingularAttribute<KhachHang, Date> ngaySinh;
	public static volatile SingularAttribute<KhachHang, Integer> id;
	public static volatile SingularAttribute<KhachHang, String> ten;

}

