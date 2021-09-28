package com.mycompany.springmvchibernate;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(XeMay.class)
public abstract class XeMay_ {

	public static volatile SingularAttribute<XeMay, KhachHang> khachHang;
	public static volatile SingularAttribute<XeMay, String> tenxe;
	public static volatile CollectionAttribute<XeMay, DonBaoDuong> donBaoDuongCollection;
	public static volatile SingularAttribute<XeMay, LoaiXe> loaiXe;
	public static volatile SingularAttribute<XeMay, String> bienSo;

}

