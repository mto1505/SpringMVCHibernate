package com.mycompany.springmvchibernate.Entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ChiTietSanPham.class)
public abstract class ChiTietSanPham_ {

	public static volatile SingularAttribute<ChiTietSanPham, BoNho> boNho;
	public static volatile SingularAttribute<ChiTietSanPham, Mau> mau;
	public static volatile SingularAttribute<ChiTietSanPham, Chip> chip;
	public static volatile SingularAttribute<ChiTietSanPham, SanPham> sanPham;
	public static volatile ListAttribute<ChiTietSanPham, ChiTietGioHang> chiTietGioHangs;
	public static volatile SingularAttribute<ChiTietSanPham, Integer> id;
	public static volatile ListAttribute<ChiTietSanPham, ChiTietDonDatHang> chiTietDonDatHangs;
	public static volatile SingularAttribute<ChiTietSanPham, BigDecimal> donGia;
	public static volatile SingularAttribute<ChiTietSanPham, Integer> soLuong;
	public static volatile SingularAttribute<ChiTietSanPham, Ram> ram;

	public static final String BO_NHO = "boNho";
	public static final String MAU = "mau";
	public static final String CHIP = "chip";
	public static final String SAN_PHAM = "sanPham";
	public static final String CHI_TIET_GIO_HANGS = "chiTietGioHangs";
	public static final String ID = "id";
	public static final String CHI_TIET_DON_DAT_HANGS = "chiTietDonDatHangs";
	public static final String DON_GIA = "donGia";
	public static final String SO_LUONG = "soLuong";
	public static final String RAM = "ram";

}

