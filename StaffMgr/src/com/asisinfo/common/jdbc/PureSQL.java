/**
 * Copyright(c)1994-2007 SRE. All rights reserved.<br>
 * Use is subject to license terms.
 */
package com.asisinfo.common.jdbc;

import java.util.*;

/**
 * @author chenhm
 * @created 2007-7-10 обнГ03:27:05
 * @version 1.0
 */
public interface PureSQL {
	public List getAllSql();

	public List getQuerySql();

	public List getUpdateSql();
}
