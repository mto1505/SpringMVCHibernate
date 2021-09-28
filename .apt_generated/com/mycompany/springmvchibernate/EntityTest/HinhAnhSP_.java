package com.mycompany.springmvchibernate.EntityTest;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.mycompany.springmvchibernate.Entity.HinhAnhSP;
import com.mycompany.springmvchibernate.Entity.SanPham;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HinhAnhSP.class)
public abstract class HinhAnhSP_ {

	public static volatile SingularAttribute<HinhAnhSP, SanPham> sanPham;
	public static volatile SingularAttribute<HinhAnhSP, String> hinhAnh;
	public static volatile SingularAttribute<HinhAnhSP, Integer> id;

}

