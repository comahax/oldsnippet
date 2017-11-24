package com.asisinfo.common.jdbc;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.sql.RowSetMetaData;
import javax.sql.rowset.RowSetMetaDataImpl;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;


/**
 * 使用<code> RowMapperFactory.createObjectRowMapper(requiredType) </code>创建
 * 
 * @author chenhm
 * @created 2006-9-12 下午07:14:40
 * @version 1.0
 */
public class ObjectRowMapper implements RowMapper {
	private static Logger log = Logger.getLogger(ObjectRowMapper.class);

	private Class requiredType;

	private Map methods;

	private static Map methodsCache = new Hashtable();
	
	private RowSetMetaData rsmd;

	protected ObjectRowMapper(Class requiredType) {
		this.requiredType = requiredType;
		Map methods = (Map) methodsCache.get(requiredType);
		if (methods == null) {
			methods = new HashMap();
			java.lang.reflect.Method[] mtds = requiredType.getMethods();
			for (int i = 0; i < mtds.length; i++) {
				Method mtd = mtds[i];
				if (mtd.getName().startsWith("set")) {
					methods.put(mtd.getName(), mtd);
				}
			}
			methodsCache.put(requiredType, methods);
			log.info("reflect class["+requiredType.getName()+"]");
		}
		this.methods = methods;
	}

	protected Object getColumnValue(ResultSet rs, int index)
			throws SQLException {
		return JdbcUtils.getResultSetValue(rs, index);
	}

	/**
	 * 根据列名映射到javabean形式的对象上的属性,属性名全小写,类型由set方法的参数类型确定
	 */
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		if(rsmd == null){
			rsmd = new RowSetMetaDataImpl();
			ResultSetMetaData md = rs.getMetaData();
			rsmd.setColumnCount(md.getColumnCount());
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				rsmd.setColumnName(i, md.getColumnName(i).toLowerCase());
			}
		}

		int columnCount = rsmd.getColumnCount();
		Object obj = null;
		String colName = null;
		try {
			obj = requiredType.newInstance();

			for (int i = 1; i <= columnCount; i++) {
				colName = rsmd.getColumnName(i);

				// 将形如vc_code_name的列名替换为vcCodeName
				StringBuffer att = new StringBuffer(colName);
				att.setCharAt(0, Character.toUpperCase(att.charAt(0)));
				for (int pos = -1; (pos = att.indexOf("_")) != -1;) {
					att.replace(pos, pos + 1, "");
					if (att.length() > pos) {
						att.setCharAt(pos, Character.toUpperCase(att.charAt(pos)));
					}
				}
				Method m = (Method) methods.get("set" + att);

				// 直接使用形如vc_code_name的列名做属性名
				if (m == null) {
					m = (Method) methods.get("set"
							+ colName.substring(0, 1).toUpperCase()
							+ colName.substring(1));
				}

				// 将形如vc_code_name的列名替换为code_name
				if (m == null) {
					int p = colName.indexOf("_");
					if (p != -1 && colName.length() > p + 1) {
						colName = colName.substring(p + 1);
						colName = colName.substring(0, 1).toUpperCase()
								+ colName.substring(1);
						m = (Method) methods.get("set" + colName);
					}
				}

				if (m != null) {
					Class cl = m.getParameterTypes()[0];
					if (Long.class.equals(cl) || long.class.equals(cl)) {
						Long[] os = { new Long(rs.getLong(i)) };
						if (!rs.wasNull())
							m.invoke(obj, os);
					}
					else if (Double.class.equals(cl) || double.class.equals(cl)) {
						Double[] os = { new Double(rs.getDouble(i)) };
						if (!rs.wasNull())
							m.invoke(obj, os);
					}
					else if (Integer.class.equals(cl) || int.class.equals(cl)) {
						Integer[] os = { new Integer(rs.getInt(i)) };
						if (!rs.wasNull())
							m.invoke(obj, os);
					}
					else if (Float.class.equals(cl) || float.class.equals(cl)) {
						Float[] os = { new Float(rs.getFloat(i)) };
						if (!rs.wasNull())
							m.invoke(obj, os);
					}
					else if (BigDecimal.class.equals(cl) ) {
						BigDecimal[] os = { rs.getBigDecimal(i) };
						if (!rs.wasNull())
							m.invoke(obj, os);
					}
					else if (byte[].class.equals(cl)) {
						byte[] os = rs.getBytes(i);
						if (!rs.wasNull())
							m.invoke(obj, new Object[] { os });
					}
					else if (java.sql.Timestamp.class.equals(cl)) {
						m.invoke(obj, new Object[] { rs.getTimestamp(i) });
					}
					else if (java.util.Date.class.equals(cl)) {
						if(rs.getDate(i)==null)
							m.invoke(obj, new Object[] { rs.getDate(i)});
						else
							m.invoke(obj, new Object[] { new java.util.Date(rs.getTimestamp(i).getTime()) });
					}
					else if (String.class.equals(cl)) {
						m.invoke(obj, new Object[] { rs.getString(i) });
					}
					/*else if (Clob.class.equals(cl)){
						String os = "";
						Clob clob = rs.getClob(i);//java.sql.Clob
					    int ic = 0;
					    if(clob != null){
					     InputStream input = clob.getAsciiStream();
					     int len = (int)clob.length();
					     byte by[] = new byte[len];
					     while(-1 != (ic = input.read(by, 0, by.length))){
					      input.read(by, 0, ic);
					     }
					     os = new String(by, "utf-8");
					    }
						m.invoke(obj,new Object[]{os});
					}*/
					else {
						// 其他类型的映射
						log.error("Unsupported map type:" + cl);
					}
				}
			}
		}
		catch (Exception e) {
			log.error("map column[" + colName + "] error:", e);
			throw new SQLException(e.getMessage());
		}
		return obj;
	}

	
}
