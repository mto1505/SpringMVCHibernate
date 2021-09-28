package com.mycompany.springmvchibernate;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NhanVien.class)
public abstract class NhanVien_ {

	public static volatile CollectionAttribute<NhanVien, ChiTietDonBaoDuong> chiTietDonBaoDuongCollection;
	public static volatile SingularAttribute<NhanVien, String> sdt;
	public static volatile SingularAttribute<NhanVien, String> gioitinh;
	public static volatile SingularAttribute<NhanVien, String> trinhdo;
	public static volatile CollectionAttribute<NhanVien, DonBaoDuong> donBaoDuongCollection;
	public static volatile CollectionAttribute<NhanVien, TaiKhoan> taiKhoanCollection;
	public static volatile SingularAttribute<NhanVien, Date> sinhnhat;
	public static volatile SingularAttribute<NhanVien, Integer> id;
	public static volatile SingularAttribute<NhanVien, String> ten;
	public static volatile SingularAttribute<NhanVien, String> cmnd;

	public static final String CHI_TIET_DON_BAO_DUONG_COLLECTION = "chiTietDonBaoDuongCollection";
	public static final String SDT = "sdt";
	public static final String GIOITINH = "gioitinh";
	public static final String TRINHDO = "trinhdo";
	public static final String DON_BAO_DUONG_COLLECTION = "donBaoDuongCollection";
	public static final String TAI_KHOAN_COLLECTION = "taiKhoanCollection";
	public static final String SINHNHAT = "sinhnhat";
	public static final String ID = "id";
	public static final String TEN = "ten";
	public static final String CMND = "cmnd";

}

