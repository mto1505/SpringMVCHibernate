package com.mycompany.springmvchibernate;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LoaiXe.class)
public abstract class LoaiXe_ {

	public static volatile SingularAttribute<LoaiXe, Boolean> trangthai;
	public static volatile CollectionAttribute<LoaiXe, XeMay> xeMayCollection;
	public static volatile SingularAttribute<LoaiXe, String> tenloai;
	public static volatile CollectionAttribute<LoaiXe, DichVuBaoDuong> dichVuBaoDuongCollection;
	public static volatile SingularAttribute<LoaiXe, Integer> id;

	public static final String TRANGTHAI = "trangthai";
	public static final String XE_MAY_COLLECTION = "xeMayCollection";
	public static final String TENLOAI = "tenloai";
	public static final String DICH_VU_BAO_DUONG_COLLECTION = "dichVuBaoDuongCollection";
	public static final String ID = "id";

}

