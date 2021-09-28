package com.mycompany.springmvchibernate.Entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(KhachHang.class)
public abstract class KhachHang_ {

	public static volatile SingularAttribute<KhachHang, TaiKhoan> taiKhoan;
	public static volatile SingularAttribute<KhachHang, String> diaChi;
	public static volatile SingularAttribute<KhachHang, String> soDienThoai;
	public static volatile SingularAttribute<KhachHang, GioHang> gioHang;
	public static volatile ListAttribute<KhachHang, DonDatHang> donDatHangs;
	public static volatile ListAttribute<KhachHang, DanhGia> danhGias;
	public static volatile SingularAttribute<KhachHang, Integer> id;
	public static volatile SingularAttribute<KhachHang, String> hoVaTenDem;
	public static volatile SingularAttribute<KhachHang, String> ten;
	public static volatile SingularAttribute<KhachHang, String> email;

	public static final String TAI_KHOAN = "taiKhoan";
	public static final String DIA_CHI = "diaChi";
	public static final String SO_DIEN_THOAI = "soDienThoai";
	public static final String GIO_HANG = "gioHang";
	public static final String DON_DAT_HANGS = "donDatHangs";
	public static final String DANH_GIAS = "danhGias";
	public static final String ID = "id";
	public static final String HO_VA_TEN_DEM = "hoVaTenDem";
	public static final String TEN = "ten";
	public static final String EMAIL = "email";

}

