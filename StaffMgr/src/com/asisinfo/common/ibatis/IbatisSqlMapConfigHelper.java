/**
 * Copyright(c)1994-2007 SRE. All rights reserved.<br>
 * Use is subject to license terms.
 */
package com.asisinfo.common.ibatis;

import com.asisinfo.common.ibatis.*;

/**
 * @author chenhm
 * @created 2007-6-5 下午07:25:57
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
	 * 将config的初始化放在此处可以防止由于初始化异常导致ClassNotFoundException的问题。
	 * 不过IODH模式已经可以较为容易的定位错误了。
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
