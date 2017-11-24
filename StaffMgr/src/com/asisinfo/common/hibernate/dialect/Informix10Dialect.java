/**
 * Copyright(c)1999-2008 Sunrise Electronics Developmnet Co.,Ltd<br>
 * All rights reserved. Use is subject to license terms.
 */
package com.asisinfo.common.hibernate.dialect;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.InformixDialect;

/**
 * @author chenhm
 * @created 2009-9-19 下午10:45:27
 * @version $Id: Informix10Dialect.java 19 2009-10-15 12:12:46Z Administrator $
 */
public class Informix10Dialect extends InformixDialect {
	public Informix10Dialect(){
		super();
		registerColumnType(Types.BLOB, "blob");
		registerColumnType(Types.CLOB, "clob");
		registerHibernateType(Types.LONGVARCHAR, Hibernate.STRING.getName());
		registerHibernateType(Types.CHAR, Hibernate.STRING.getName());
	}

	/**
	 * 从informx 10开始支持skip方法
	 */
	@Override
	public String getLimitString(String querySelect, int offset, int limit) {
		return new StringBuffer(querySelect.length() + 20).append(querySelect).insert(querySelect.toLowerCase().indexOf("select") + 6, " skip "
				+ offset + " first " + (limit-offset)).toString();
	}

	@Override
	public boolean supportsLimitOffset() {
		return true;
	}
}
