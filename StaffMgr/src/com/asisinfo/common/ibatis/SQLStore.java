/**
 * Copyright(c)1994-2007 SRE. All rights reserved.<br>
 * Use is subject to license terms.
 */
package com.asisinfo.common.ibatis;

/**
 * @author chenhm
 * @created 2007-6-5 ÏÂÎç06:40:13
 * @version 1.0
 */
public class SQLStore {
	private String sql;

	private Object[] value;

	private int[] type;
	
	private String[] propName;

	public SQLStore(String sql, Object[] value, int[] type,String[] propName) {
		this.sql = sql;
		this.value = value;
		this.type = type;
		this.propName = propName;
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
	
	public String[] getPropName(){
		return propName;
	}
}
