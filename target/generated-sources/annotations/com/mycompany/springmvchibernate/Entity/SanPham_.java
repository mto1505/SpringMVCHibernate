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

	public static final String CAMERA_TRUOC = "cameraTruoc";
	public static final String SIM = "sim";
	public static final String CHI_TIET_SAN_PHAMS = "chiTietSanPhams";
	public static final String MAN_HINH = "manHinh";
	public static final String PIN_SAC = "pinSac";
	public static final String DANH_GIAS = "danhGias";
	public static final String LOAI = "loai";
	public static final String ID = "id";
	public static final String MO_TA = "moTa";
	public static final String TEN = "ten";
	public static final String HINH_ANH_SPS = "hinhAnhSps";
	public static final String CAMERA_SAU = "cameraSau";

}

