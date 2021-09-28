package com.mycompany.springmvchibernate.EntityTest;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.mycompany.springmvchibernate.Entity.BoNho;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BoNho.class)
public abstract class BoNho_ {

	public static volatile ListAttribute<BoNho, ChiTietSanPham> chiTietSanPhams;
	public static volatile SingularAttribute<BoNho, String> id;
	public static volatile SingularAttribute<BoNho, String> dungLuong;

}

