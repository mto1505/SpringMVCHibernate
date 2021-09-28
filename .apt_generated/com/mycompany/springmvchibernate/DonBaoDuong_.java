package com.mycompany.springmvchibernate;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DonBaoDuong.class)
public abstract class DonBaoDuong_ {

	public static volatile SingularAttribute<DonBaoDuong, BigDecimal> tongtien;
	public static volatile CollectionAttribute<DonBaoDuong, ChiTietDonBaoDuong> chiTietDonBaoDuongCollection;
	public static volatile SingularAttribute<DonBaoDuong, Date> ngayBatDau;
	public static volatile SingularAttribute<DonBaoDuong, String> trangthai;
	public static volatile CollectionAttribute<DonBaoDuong, ChiTietThayTheLinhKien> chiTietThayTheLinhKienCollection;
	public static volatile SingularAttribute<DonBaoDuong, Date> ngayHoanThanh;
	public static volatile SingularAttribute<DonBaoDuong, Integer> id;
	public static volatile CollectionAttribute<DonBaoDuong, ChiTietTrangThaiKhiTiepNhanXe> chiTietTrangThaiKhiTiepNhanXeCollection;
	public static volatile SingularAttribute<DonBaoDuong, NhanVien> idNhanVienLapDon;
	public static volatile SingularAttribute<DonBaoDuong, XeMay> bienSo;

}

