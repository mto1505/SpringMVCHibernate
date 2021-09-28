package com.mycompany.springmvchibernate;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Sysdiagrams.class)
public abstract class Sysdiagrams_ {

	public static volatile SingularAttribute<Sysdiagrams, Integer> diagramId;
	public static volatile SingularAttribute<Sysdiagrams, String> name;
	public static volatile SingularAttribute<Sysdiagrams, Integer> principalId;
	public static volatile SingularAttribute<Sysdiagrams, byte[]> definition;
	public static volatile SingularAttribute<Sysdiagrams, Integer> version;

	public static final String DIAGRAM_ID = "diagramId";
	public static final String NAME = "name";
	public static final String PRINCIPAL_ID = "principalId";
	public static final String DEFINITION = "definition";
	public static final String VERSION = "version";

}

