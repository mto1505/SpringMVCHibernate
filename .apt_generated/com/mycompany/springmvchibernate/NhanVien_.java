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

}

