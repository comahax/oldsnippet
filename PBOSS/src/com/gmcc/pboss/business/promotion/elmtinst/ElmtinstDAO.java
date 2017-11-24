/**
 * auto-generated code
 * Mon Sep 14 14:47:12 CST 2009
 */
package com.gmcc.pboss.business.promotion.elmtinst;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import open.tool.rule.data.VO;

import org.hibernate.Session;

import com.gmcc.pboss.business.promotion.elmttmpl.DefaultVO;
import com.gmcc.pboss.business.promotion.elmttmpl.ElmttmplDBParam;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: ElmtinstDAO
 * </p>
 * <p>
 * Description: Data Access Object for CompanyVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class ElmtinstDAO extends AbstractDAO {

	/**
	 * default constructor
	 */
	public ElmtinstDAO() {
		super(ElmtinstVO.class);
	}

	public DataPackage queryElmttmplByInstId(String instId) throws Exception {
		ElmttmplDBParam params = new ElmttmplDBParam();
		params
				.setSelectFieldsString("GATHERINGMODE,GATHERINGLOGIC,COLUMNSINFO");
		params.getQueryConditions().put("instid", instId);

		return queryByNamedSqlQuery(
				"com.gmcc.pboss.business.promotion.elmtinst.queryElmttmplByInstId",
				params);
	}

	public List<VO> gartherDataBySQLMode(String sqlString) throws Exception {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<VO> resultList = new ArrayList<VO>();
		try {
			Session ssession = SessionUtils.currentSession(getDbFlag());
			conn = ssession.connection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlString);
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int columnCount = rsMetaData.getColumnCount();
			String[] columnNames = new String[columnCount];
			String[] columnClass = new String[columnCount];
			for (int i = 0; i < columnCount; i++) {
				columnNames[i] = rsMetaData.getColumnName(i + 1);
				columnClass[i] = rsMetaData.getColumnClassName(i + 1);
			}
			while (rs.next()) {
				DefaultVO vo = new DefaultVO();
				HashMap<String, Object> keys = new HashMap<String, Object>();
				Object value = null;
				for (int i = 0; i < columnCount; i++) {
					if ("业务量".equalsIgnoreCase(columnNames[i])) { // BUSIVALUE -> 业务量
						value = new Double((rs.getBigDecimal(i + 1)
								.doubleValue()));
					} else {
						if ("java.lang.String".equalsIgnoreCase(columnClass[i])
								|| "java.lang.Character"
										.equalsIgnoreCase(columnClass[i])) {
							keys.put(columnNames[i], rs.getString(i + 1));
						} else if ("java.lang.Integer"
								.equalsIgnoreCase(columnClass[i])) {
							keys.put(columnNames[i], rs.getInt(i + 1));
						} else if ("java.lang.Long"
								.equalsIgnoreCase(columnClass[i])) {
							keys.put(columnNames[i], rs.getLong(i + 1));
						} else if ("java.lang.Double"
								.equalsIgnoreCase(columnClass[i])) {
							keys.put(columnNames[i], rs.getDouble(i + 1));
						} else if ("java.lang.Float"
								.equalsIgnoreCase(columnClass[i])) {
							keys.put(columnNames[i], rs.getFloat(i + 1));
						} else if ("java.lang.Short"
								.equalsIgnoreCase(columnClass[i])) {
							keys.put(columnNames[i], rs.getShort(i + 1));
						} else if ("java.lang.Byte"
								.equalsIgnoreCase(columnClass[i])) {
							keys.put(columnNames[i], rs.getByte(i + 1));
						} else if ("java.util.Date"
								.equalsIgnoreCase(columnClass[i])) {
							keys.put(columnNames[i], rs.getTimestamp(i + 1));
						}
					}
				}
				vo.setKeys(keys);
				vo.setValue(value);
				resultList.add(vo);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
		}
		return resultList;
	}

	/**
	 * <pre>
	 *  用于促销后台程序--&gt;数据采集模块--&gt;&quot;程序&quot;采集模式:
	 *  根据&quot;采集逻辑&quot;给出的具体类来采集数据;
	 *  这些具体类都必须实现com.sunrise.pboss.gathering.Gathering接口
	 * </pre>
	 * 
	 * @param clazzName
	 * @param params
	 * @return
	 */
	public List<VO> gatherDataByPGMMode(String clazzName, Object params)
			throws Exception {
		Class clazz = Class.forName(clazzName);
		Object obj = clazz.newInstance();
		Method method = clazz.getMethod("gather", java.util.Map.class);
		return (List<VO>) method.invoke(obj, params);
	}
}
