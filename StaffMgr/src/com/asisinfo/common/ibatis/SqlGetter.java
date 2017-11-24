/**
 * Copyright(c)1994-2007 SRE. All rights reserved.<br>
 * Use is subject to license terms.
 */
package com.asisinfo.common.ibatis;

/**
 * @author chenhm
 * @created 2007-6-5 обнГ06:40:13
 * @version 1.0
 */
public class SqlGetter {
	String sql;

	Object[] value;

	int[] type;

	public SqlGetter(String sql, Object[] value, int[] type) {
		this.sql = sql;
		this.value = value;
		this.type = type;
	}

	public String getSql() {
		return sql;
	}

	public int[] getType() {
		return type;
	}

	public Object[] getValue() {
		return value;
	}
}
