/**
 * Copyright(c)1994-2007 SRE. All rights reserved.<br>
 * Use is subject to license terms.
 */
package com.asisinfo.common.jdbc;

import java.util.*;

/**
 * @author chenhm
 * @created 2007-6-25 上午11:48:17
 * @version 1.0
 */
public class RowMapperFactory {
	// 缓存ObjectRowMapper对象，避免频繁使用反射导致性能下降
	private static Map cache = new Hashtable();

	private RowMapperFactory() {

	}

	/**
	 * 此处无需严格的单例限制，所以没有synchronized
	 * 
	 * @param requiredType
	 * @return
	 */
	public static ObjectRowMapper createObjectRowMapper(Class requiredType) {
//		ObjectRowMapper orm = (ObjectRowMapper) cache.get(requiredType.getName());
//		if (orm == null) {
//			orm = new ObjectRowMapper(requiredType);
//			cache.put(requiredType.getName(), orm);
//		}
		return new ObjectRowMapper(requiredType);
	}
}
