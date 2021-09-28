package com.mycompany.springmvchibernate;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PhuTungCanKiemTra.class)
public abstract class PhuTungCanKiemTra_ {

	public static volatile SingularAttribute<PhuTungCanKiemTra, String> tenPhuTung;
	public static volatile SingularAttribute<PhuTungCanKiemTra, Integer> id;
	public static volatile CollectionAttribute<PhuTungCanKiemTra, ChiTietTrangThaiKhiTiepNhanXe> chiTietTrangThaiKhiTiepNhanXeCollection;

	public static final String TEN_PHU_TUNG = "tenPhuTung";
	public static final String ID = "id";
	public static final String CHI_TIET_TRANG_THAI_KHI_TIEP_NHAN_XE_COLLECTION = "chiTietTrangThaiKhiTiepNhanXeCollection";

}

