package com.sunrise.boss.business.resmanage.common.excelout.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.persister.entity.BasicEntityPersister;

import com.sunrise.boss.business.resmanage.common.excelout.ExceloutRet;
import com.sunrise.boss.business.resmanage.oprresmanage.base.SheetUtils;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

public class ExceloutDAO extends BaseDAO {
	private static Logger log = Logger.getLogger(ExceloutDAO.class);

	public ExceloutDAO(Class voClass, User user) {
		super(voClass, user.getCityid());
	}

	public ExceloutRet query(Object params, List queryFields) throws Exception {
		int _pagesize = 20, _pageno = 1;
		int begIdx, endIdx;
		try {
			_pagesize = Integer.parseInt((String) BeanUtils.getProperty(params,
					"_pagesize"));
		} catch (Exception ex) {
			_pagesize = Integer.MAX_VALUE;
		}
		if (_pagesize > MAX_QUERY_COUNT) {
			_pagesize = MAX_QUERY_COUNT;
			/** @todo 做一个查询量的限制，以后需要修改 */
		}

		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(params,
					"_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}
		if (_pageno == 1) {
			begIdx = 1;
		} else {
			begIdx = (_pageno - 1) * _pagesize + 1;
		}
		if (SheetUtils.containsProperty(params, "endindex")) {
			try {
				endIdx = Integer.parseInt((String) BeanUtils.getProperty(
						params, "endindex"));
				endIdx = endIdx * _pagesize;
			} catch (Exception ex) {
				endIdx = begIdx + _pagesize - 1;
			}
		} else {
			endIdx = begIdx + _pagesize - 1;
		}

		String _orderby = null, _desc = null, orderClause = "";
		try {
			_orderby = (String) BeanUtils.getProperty(params, "_orderby");
		} catch (Exception ex) {
			_orderby = "";
		}

		try {
			_desc = (String) BeanUtils.getProperty(params, "_desc");
		} catch (Exception ex) {
			_desc = "";
		}
		if (_desc == null) {
			_desc = "0"; // 默认递增
		}

		if (StringUtils.isEmpty(_orderby)) {
			String[] pks = this.getPKs();
			for (int i = 0; i < pks.length; i++) {
				_orderby += pks[i] + (_desc.equals("1") ? " desc " : " asc ")
						+ ",";
			}
			_orderby = _orderby.substring(0, _orderby.length() - 1);
		}
		orderClause = "order by " + _orderby;
		// if (!StringUtils.isEmpty(_orderby)) {
		// orderClause = "order by " + _orderby + (_desc.equals("1") ? " desc "
		// : " asc ");
		// }

		String query_fields = "";
		if (queryFields != null && queryFields.size() > 0) {
			Iterator it = queryFields.iterator();
			while (it.hasNext()) {
				query_fields += (String) it.next() + ",";
			}
			query_fields = query_fields.substring(0, query_fields.length() - 1);
		} else {
			query_fields = "*";
		}

		Map placeholders = new HashMap();
		List dateParamList = new ArrayList();
		String whereClause = this.buildHQL(params, "t1", placeholders,
				dateParamList);
		if (whereClause.length() > 4) {
			whereClause = " where " + whereClause;
		}
		String tableName = getTableName();
		String querySql = "select "
				+ query_fields
				+ " from "
				+ tableName
				+ " where rowid in ("
				+ "select rid from ( select t.rowid rid,rownum as linenum from ("
				+ "select t1.rowid from " + tableName + " t1 " + whereClause
				+ " " + orderClause + ") t where rownum<=" + endIdx
				+ " ) where linenum>=" + begIdx + ") " + orderClause;
		Session session = SessionUtil.currentSession(this.getDbFlag());
		Connection conn = session.connection();
		PreparedStatement ops = conn
				.prepareStatement(querySql, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
		if (placeholders != null && placeholders.size() > 0) {
			Set keyset = placeholders.keySet();
			for (Iterator it = keyset.iterator(); it.hasNext();) {
				String key = (String) it.next();
				int idx = Integer.parseInt(key.substring(1));
				Object value = placeholders.get(key);
				// 针对日期做特殊判断
				if (dateParamList.indexOf(key) != -1) {
					if (value.toString().length() == 10) {// yyyy-MM-dd
						java.sql.Date date = new java.sql.Date(
								(new SimpleDateFormat("yyyy-MM-dd")).parse(
										value.toString()).getTime());
						ops.setDate(idx, date);
					} else {// yyyy-MM-dd HH:mm:ss
						java.util.Date date = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss").parse(value.toString());
						java.sql.Timestamp ts = new java.sql.Timestamp(
								new Timestamp(date.getTime()).getTime());
						ops.setTimestamp(idx, ts);
					}
				} else {
					ops.setObject(idx, value);
				}
			}
		}
		ResultSet rs = ops.executeQuery();
		rs.setFetchSize(1);

		ExceloutRet ert = new ExceloutRet();
		List dataList = buildVO(rs, queryFields);
		ert.setDatas(dataList);
		ert.setRs(rs);
		if (rs.isLast() || rs.isAfterLast()) {
			ert.setHaveDatas(false);
			rs.close();
			if (ops != null) {
				ops.close();
			}
		} else {
			ert.setHaveDatas(true);
		}
		// ops.close();
		return ert;
	}

	private String getTableName() {
		String tableName = "";
		try {
			SessionFactory sf = SessionUtil.obtainSessionFactory(this
					.getDbFlag());
			BasicEntityPersister bep = (BasicEntityPersister) sf
					.getClassMetadata(voClass.getName());
			tableName = bep.getTableName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (log.isInfoEnabled()) {
				log.info("error occurs when get the table name of the entity: "
						+ voClass.getName());
			}
		}
		return tableName;
	}

	private List buildVO(ResultSet rs, List queryFields) throws Exception {
		List dataList = new ArrayList();
		if (rs == null) {
			return dataList;
		}
		while (rs.next()) {
			Object vo = voClass.newInstance();
			String propertyName = null;
			Object value = null;
			Class propertyClass = null;

			if (queryFields != null && queryFields.size() > 0) {
				Iterator it = queryFields.iterator();
				while (it.hasNext()) {
					propertyName = (String) it.next();
					// if (!SheetUtils.containsProperty(vo, propertyName)){
					// continue;
					// }
					propertyClass = PropertyUtils.getPropertyDescriptor(vo,
							propertyName).getPropertyType();
					value = this
							.getValueByType(propertyClass, rs, propertyName);
					if (value == null) {
						continue;
					}
					PropertyUtils.setProperty(vo, propertyName.toLowerCase(),
							value);
				}
			} else {
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				for (int i = 1; i <= columnCount; i++) {
					propertyName = rsmd.getColumnName(i).toLowerCase();
					if (!SheetUtils.containsProperty(vo, propertyName)) {
						continue;
					}
					propertyClass = PropertyUtils.getPropertyDescriptor(vo,
							propertyName).getPropertyType();
					value = this
							.getValueByType(propertyClass, rs, propertyName);
					if (value == null) {
						continue;
					}
					PropertyUtils.setProperty(vo, propertyName.toLowerCase(),
							value);
				}
			}

			dataList.add(vo);
			if (dataList.size() == 1000) {
				return dataList;
			}
		}
		return dataList;
	}

	private Object getValueByType(Class propertyClass, ResultSet rs,
			String propertyName) throws Exception {
		Object value = null;
		if (propertyClass.equals(Long.class)
				|| propertyClass.equals(long.class)) {
			long longValue = rs.getLong(propertyName);
			if (rs.wasNull()) {
				return null;
			}
			value = new Long(longValue);
		} else if (propertyClass.equals(Integer.class)
				|| propertyClass.equals(int.class)) {
			int intValue = rs.getInt(propertyName);
			if (rs.wasNull()) {
				return null;
			}
			value = new Integer(intValue);
		} else if (propertyClass.equals(Double.class)
				|| propertyClass.equals(double.class)) {
			double doubleValue = rs.getDouble(propertyName);
			if (rs.wasNull()) {
				return null;
			}
			value = new Double(doubleValue);
		} else if (propertyClass.equals(String.class)) {
			value = rs.getString(propertyName);
			if (rs.wasNull()) {
				return null;
			}
		} else if (propertyClass.equals(Boolean.class)
				|| propertyClass.equals(boolean.class)) {
			boolean booleanValue = rs.getBoolean(propertyName);
			if (rs.wasNull()) {
				return null;
			}
			value = new Boolean(booleanValue);
		} else if (propertyClass.equals(Short.class)
				|| propertyClass.equals(short.class)) {
			short shortValue = rs.getShort(propertyName);
			if (rs.wasNull()) {
				return null;
			}
			value = new Short(shortValue);
		} else if (propertyClass.equals(Float.class)
				|| propertyClass.equals(float.class)) {
			float floatValue = rs.getFloat(propertyName);
			if (rs.wasNull()) {
				return null;
			}
			value = new Float(floatValue);
		} else if (propertyClass.equals(Byte.class)
				|| propertyClass.equals(byte.class)) {
			byte b = rs.getByte(propertyName);
			if (rs.wasNull()) {
				return null;
			}
			value = new Byte(b);
		} else if (propertyClass.equals(java.util.Date.class)
				|| propertyClass.equals(java.sql.Date.class)
				|| propertyClass.equals(java.sql.Timestamp.class)) {
			java.sql.Timestamp ts = rs.getTimestamp(propertyName);
			if (rs.wasNull()) {
				return null;
			}
			value = (java.util.Date) ts;
		} else if (propertyClass.equals(java.sql.Clob.class)) {
			value = rs.getClob(propertyName);
			if (rs.wasNull()) {
				return null;
			}
		} else if (propertyClass.equals(java.sql.Blob.class)) {
			value = rs.getBlob(propertyName);
			if (rs.wasNull()) {
				return null;
			}
		}

		return value;
	}

	public ExceloutRet getMoreDatas(List queryFields, ResultSet rs)
			throws Exception {
		ExceloutRet ert = new ExceloutRet();
		ert.setDatas(this.buildVO(rs, queryFields));
		ert.setRs(rs);
		if (rs.isLast() || rs.isAfterLast()) {
			ert.setHaveDatas(false);
			rs.close();
			if (rs.getStatement() != null) {
				rs.getStatement().close();
			}
		} else {
			ert.setHaveDatas(true);
		}

		return ert;
	}
}
