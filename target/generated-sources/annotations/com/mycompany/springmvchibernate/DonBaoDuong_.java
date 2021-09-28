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

	public static final String TONGTIEN = "tongtien";
	public static final String CHI_TIET_DON_BAO_DUONG_COLLECTION = "chiTietDonBaoDuongCollection";
	public static final String NGAY_BAT_DAU = "ngayBatDau";
	public static final String TRANGTHAI = "trangthai";
	public static final String CHI_TIET_THAY_THE_LINH_KIEN_COLLECTION = "chiTietThayTheLinhKienCollection";
	public static final String NGAY_HOAN_THANH = "ngayHoanThanh";
	public static final String ID = "id";
	public static final String CHI_TIET_TRANG_THAI_KHI_TIEP_NHAN_XE_COLLECTION = "chiTietTrangThaiKhiTiepNhanXeCollection";
	public static final String ID_NHAN_VIEN_LAP_DON = "idNhanVienLapDon";
	public static final String BIEN_SO = "bienSo";

}

