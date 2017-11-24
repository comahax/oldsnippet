/**
 * Copyright(c)1994-2007 SRE. All rights reserved.<br>
 * Use is subject to license terms.
 */
package com.asisinfo.common.jdbc;

import java.util.*;

/**
 * @author chenhm
 * @created 2007-6-25 ����11:48:17
 * @version 1.0
 */
public class RowMapperFactory {
	// ����ObjectRowMapper���󣬱���Ƶ��ʹ�÷��䵼�������½�
	private static Map cache = new Hashtable();

	private RowMapperFactory() {

	}

	/**
	 * �˴������ϸ�ĵ������ƣ�����û��synchronized
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
