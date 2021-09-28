package com.mycompany.springmvchibernate;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LoaiTrangThaiPhuTung.class)
public abstract class LoaiTrangThaiPhuTung_ {

	public static volatile SingularAttribute<LoaiTrangThaiPhuTung, Integer> id;
	public static volatile SingularAttribute<LoaiTrangThaiPhuTung, String> tenTrangThai;
	public static volatile CollectionAttribute<LoaiTrangThaiPhuTung, ChiTietTrangThaiKhiTiepNhanXe> chiTietTrangThaiKhiTiepNhanXeCollection;
	public static volatile SingularAttribute<LoaiTrangThaiPhuTung, String> kyHieu;

}

