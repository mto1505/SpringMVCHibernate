package com.mycompany.springmvchibernate;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LinhKien.class)
public abstract class LinhKien_ {

	public static volatile SingularAttribute<LinhKien, LinhKienPK> linhKienPK;
	public static volatile SingularAttribute<LinhKien, Boolean> trangthai;
	public static volatile CollectionAttribute<LinhKien, ChiTietThayTheLinhKien> chiTietThayTheLinhKienCollection;
	public static volatile SingularAttribute<LinhKien, String> tenlinhkien;
	public static volatile SingularAttribute<LinhKien, Integer> soluong;
	public static volatile SingularAttribute<LinhKien, NhaCungCap> nhacungcap;
	public static volatile SingularAttribute<LinhKien, BigDecimal> gia;

	public static final String LINH_KIEN_PK = "linhKienPK";
	public static final String TRANGTHAI = "trangthai";
	public static final String CHI_TIET_THAY_THE_LINH_KIEN_COLLECTION = "chiTietThayTheLinhKienCollection";
	public static final String TENLINHKIEN = "tenlinhkien";
	public static final String SOLUONG = "soluong";
	public static final String NHACUNGCAP = "nhacungcap";
	public static final String GIA = "gia";

}
