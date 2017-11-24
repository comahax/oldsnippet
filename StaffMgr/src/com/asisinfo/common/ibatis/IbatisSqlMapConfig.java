/**
 * Copyright(c)1994-2007 SRE. All rights reserved.<br>
 * Use is subject to license terms.
 */
package com.asisinfo.common.ibatis;

import com.ibatis.sqlmap.engine.builder.xml.SqlMapConfigParser;
import com.ibatis.sqlmap.engine.mapping.parameter.*;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
import com.ibatis.sqlmap.engine.scope.RequestScope;
import com.ibatis.common.resources.Resources;
import java.io.*;
import java.util.*;
import org.apache.log4j.*;

/**
 * ��չibatis��SqlMapConfigParser����ʵ�ֻ�ȡSQL�Ĺ���<br>
 * ʹ�ø�����Է����ʹ��ibatis��SQLƴװ����
 * 
 * simple:<br>
 * <code>
 * IbatisSqlMapConfig t = new IbatisSqlMapConfig("sql-map-config.xml");
 * Kjava k = new Kjava();
 * k.setTaskid("testid");
 * SqlGetter s = t.getSqlGetter("addInFront", k);
 * System.out.println(s.getSql());
 * </code>
 * 
 * @author chenhm
 * @created 2007-6-5 ����03:01:43
 * @version 1.0
 */
public class IbatisSqlMapConfig extends SqlMapConfigParser {
	protected Logger log = Logger.getLogger(getClass());

	public IbatisSqlMapConfig() {
		super();
	}

	public IbatisSqlMapConfig(String resources) {
		super();
		InputStream reader;
		try {
			reader = Resources.getResourceAsStream(resources);
			parse(reader);
		}
		catch (IOException e) {
			throw new RuntimeException("Can't get resource[" + resources + "]",
					e);
		}
		catch (Exception ex) {
			Throwable t = ex;
			while (t.getCause() != null)
				t = t.getCause();
			log.error("����Ibatis����[" + resources + "]����:", ex);
			throw new RuntimeException("����Ibatis����[" + resources + "]����:" + t);
		}
	}

	public String getSql(String id, Object param) {
		MappedStatement mappedStatement = getMappedStatement(id);
		return getSql(mappedStatement, param);
	}

	public static Object[] getParameters(MappedStatement statement, Object param) {
		RequestScope requestScope = new RequestScope();
		requestScope.setStatement(statement);
		ParameterMap parameterMap = statement.getSql().getParameterMap(
			requestScope, param);

		if (parameterMap == null)
			parameterMap = statement.getParameterMap();

		Object[] value = parameterMap.getParameterObjectValues(requestScope,
			param);
		return value;
	}

	public int[] getParameterType(String id, Object param) {
		MappedStatement statement = getMappedStatement(id);

		RequestScope requestScope = new RequestScope();
		requestScope.setStatement(statement);
		ParameterMap parameterMap = statement.getSql().getParameterMap(
			requestScope, param);

		if (parameterMap == null)
			parameterMap = statement.getParameterMap();

		ParameterMapping[] m = parameterMap.getParameterMappings();
		int[] type = new int[m.length];
		for (int i = 0; i < m.length; i++) {
			BasicParameterMapping baseM = (BasicParameterMapping) m[i];
			type[i] = baseM.getJdbcType();
		}
		return type;
	}

	public Object[] getParameters(String id, Object param) {
		MappedStatement statement = getMappedStatement(id);
		return getParameters(statement, param);
	}

	public MappedStatement getMappedStatement(String id) {
		return vars.delegate.getMappedStatement(id);
	}

	public static String getSql(MappedStatement statement, Object param) {
		RequestScope requestScope = new RequestScope();
		requestScope.setStatement(statement);
		String sql = statement.getSql().getSql(requestScope, param);
		return sql;
	}

	/**
	 * ��ȡSqlGetter
	 * 
	 * @param id
	 * @param param
	 * @return
	 */
	public SqlGetter getSqlGetter(String id, Object param) {
		MappedStatement statement = getMappedStatement(id);

		RequestScope requestScope = new RequestScope();
		requestScope.setStatement(statement);
		ParameterMap parameterMap = statement.getSql().getParameterMap(
			requestScope, param);

		if (parameterMap == null)
			parameterMap = statement.getParameterMap();

		// ƴװ���SQL
		String sql = statement.getSql().getSql(requestScope, param);

		// ����
		Object[] value = parameterMap.getParameterObjectValues(requestScope,
			param);

		// ��������
		ParameterMapping[] m = parameterMap.getParameterMappings();
		int[] type = new int[m.length];
		for (int i = 0; i < m.length; i++) {
			BasicParameterMapping baseM = (BasicParameterMapping) m[i];
			type[i] = baseM.getJdbcType();
		}
		// log.debug(sql);
		// log.debug(org.apache.commons.lang.StringUtils.join(value,'|'));
		return new SqlGetter(sql, value, type);
	}
	
	
	/**
	 * ��ȡSqlGetter
	 * 
	 * @param id
	 * @param param
	 * @return
	 */
	public SQLStore getSQLStore(String id, Object param) {
		MappedStatement statement = getMappedStatement(id);

		RequestScope requestScope = new RequestScope();
		requestScope.setStatement(statement);
		ParameterMap parameterMap = statement.getSql().getParameterMap(
			requestScope, param);

		if (parameterMap == null)
			parameterMap = statement.getParameterMap();

		// ƴװ���SQL
		String sql = statement.getSql().getSql(requestScope, param);

		// ����
		Object[] value = parameterMap.getParameterObjectValues(requestScope,
			param);

		// ��������
		ParameterMapping[] m = parameterMap.getParameterMappings();
		int[] type = new int[m.length];
		String[] propName = new String[m.length];
		for (int i = 0; i < m.length; i++) {
			BasicParameterMapping baseM = (BasicParameterMapping) m[i];
			type[i] = baseM.getJdbcType();
			propName[i] = baseM.getPropertyName();
		}
		// log.debug(sql);
		// log.debug(org.apache.commons.lang.StringUtils.join(value,'|'));
		return new SQLStore(sql, value, type,propName);
	}

}
