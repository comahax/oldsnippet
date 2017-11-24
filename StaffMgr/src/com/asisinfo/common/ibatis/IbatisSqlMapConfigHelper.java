/**
 * Copyright(c)1994-2007 SRE. All rights reserved.<br>
 * Use is subject to license terms.
 */
package com.asisinfo.common.ibatis;

import com.asisinfo.common.ibatis.*;

/**
 * @author chenhm
 * @created 2007-6-5 ����07:25:57
 * @version 1.0
 */
public class IbatisSqlMapConfigHelper {
	private IbatisSqlMapConfigHelper() {
	}

	private static class SingletonHolder {
		static IbatisSqlMapConfig config = new IbatisSqlMapConfig(
				"sql-map-config.xml");
	}

	/**
	 * ��config�ĳ�ʼ�����ڴ˴����Է�ֹ���ڳ�ʼ���쳣����ClassNotFoundException�����⡣
	 * ����IODHģʽ�Ѿ����Խ�Ϊ���׵Ķ�λ�����ˡ�
	 * 
	 * @return
	 */
	public static IbatisSqlMapConfig getIbatisSqlMapConfig() {
		return SingletonHolder.config;
	}

	public static SqlGetter getSqlGetter(String id, Object param) {
		return getIbatisSqlMapConfig().getSqlGetter(id, param);
	}
	
	public static SQLStore getSQLStore(String id, Object param) {
		return getIbatisSqlMapConfig().getSQLStore(id, param);
	}
}
