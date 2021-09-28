package com.mycompany.springmvchibernate;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ChiTietDonBaoDuong.class)
public abstract class ChiTietDonBaoDuong_ {

	public static volatile SingularAttribute<ChiTietDonBaoDuong, DonBaoDuong> donBaoDuong;
	public static volatile SingularAttribute<ChiTietDonBaoDuong, NhanVien> nhanVien;
	public static volatile SingularAttribute<ChiTietDonBaoDuong, ChiTietDonBaoDuongPK> chiTietDonBaoDuongPK;
	public static volatile SingularAttribute<ChiTietDonBaoDuong, DichVuBaoDuong> dichVuBaoDuong;
	public static volatile SingularAttribute<ChiTietDonBaoDuong, BigDecimal> phuphi;
	public static volatile SingularAttribute<ChiTietDonBaoDuong, Integer> soluong;

	public static final String DON_BAO_DUONG = "donBaoDuong";
	public static final String NHAN_VIEN = "nhanVien";
	public static final String CHI_TIET_DON_BAO_DUONG_PK = "chiTietDonBaoDuongPK";
	public static final String DICH_VU_BAO_DUONG = "dichVuBaoDuong";
	public static final String PHUPHI = "phuphi";
	public static final String SOLUONG = "soluong";

}

