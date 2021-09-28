package com.mycompany.springmvchibernate.Entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SanPham.class)
public abstract class SanPham_ {

	public static volatile SingularAttribute<SanPham, String> cameraTruoc;
	public static volatile SingularAttribute<SanPham, String> sim;
	public static volatile ListAttribute<SanPham, ChiTietSanPham> chiTietSanPhams;
	public static volatile SingularAttribute<SanPham, String> manHinh;
	public static volatile SingularAttribute<SanPham, String> pinSac;
	public static volatile ListAttribute<SanPham, DanhGia> danhGias;
	public static volatile SingularAttribute<SanPham, Loai> loai;
	public static volatile SingularAttribute<SanPham, String> id;
	public static volatile SingularAttribute<SanPham, String> moTa;
	public static volatile SingularAttribute<SanPham, String> ten;
	public static volatile ListAttribute<SanPham, HinhAnhSP> hinhAnhSps;
	public static volatile SingularAttribute<SanPham, String> cameraSau;

}

