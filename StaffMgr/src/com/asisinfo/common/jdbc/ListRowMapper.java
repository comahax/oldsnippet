/**
 * 
 */
package com.asisinfo.common.jdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

/**
 * 
 * @author LYQ
 * @since 1.0
 */
public class ListRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int i) throws SQLException {

		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object[] row = new Object[columnCount];
		for (int ii = 1; ii <= columnCount; ii++) {
			Object obj = getColumnValue(rs, ii);
			row[ii - 1] = obj;
		}

		return row;
	}

	/**
	 * @param rs
	 * @param i
	 * @return
	 * @throws SQLException
	 */
	private Object getColumnValue(ResultSet rs, int i) throws SQLException {
		return JdbcUtils.getResultSetValue(rs, i);
	}

}
