package com.mycompany.springmvchibernate;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DichVuBaoDuong.class)
public abstract class DichVuBaoDuong_ {

	public static volatile SingularAttribute<DichVuBaoDuong, BigDecimal> phi;
	public static volatile CollectionAttribute<DichVuBaoDuong, ChiTietDonBaoDuong> chiTietDonBaoDuongCollection;
	public static volatile SingularAttribute<DichVuBaoDuong, Integer> id;
	public static volatile SingularAttribute<DichVuBaoDuong, String> ten;
	public static volatile SingularAttribute<DichVuBaoDuong, LoaiXe> loaiXe;

}

