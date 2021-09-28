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

}

