package com.asisinfo.common.hibernate.dialect;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.Oracle10gDialect;

public class Oracle10Dialect extends Oracle10gDialect{
	public Oracle10Dialect(){
		super();
		registerHibernateType(Types.CLOB, Hibernate.STRING.getName());
		registerHibernateType(Types.DATE, "java.util.Date");
	}
}
