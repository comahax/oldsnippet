/**
 * Copyright(c)1994-2007 SRE. All rights reserved.<br>
 * Use is subject to license terms.
 */
package com.asisinfo.common.jdbc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Calendar;

import com.asisinfo.common.Tools;

/**
 * @author chenhm
 * @created 2007-7-10 上午10:46:41
 * @version 1.0
 */
public class SqlPreparedStatement extends SqlStatement implements
		PreparedStatement {

	protected String currentSql;

	private String[] splitSql;

	private String[] param;

	private boolean[] setFlag;

	private int numqmarks;

	public SqlPreparedStatement(String sql) throws SQLException {
		currentSql = sql;
		if (this instanceof CallableStatement) {
			setqmarks(cntqmarks(sql, "="));
		}
		else {
			setqmarks(cntqmarks(sql));
		}
		setupExecutePrepare();
	}

	void setupExecutePrepare() throws SQLException {
		splitSql = Tools.split(currentSql, "?");
		param = new String[numqmarks];
		setFlag = new boolean[numqmarks];
		clearParameters();
	}

	private void markSetFlag(int i) {
		setFlag[i - 1] = true;
	}

	String getSql() throws SQLException {
		for (int i = 0; i < setFlag.length; i++) {
			if (setFlag[i] == false) {
				throw new SQLException(
						"Too many or too few host variables given");
			}
		}
		int size = Math.min(param.length, splitSql.length);
		StringBuffer sql = new StringBuffer();
		for (int i = 0; i < size; i++) {
			sql.append(splitSql[i]).append(param[i]);
		}

		if (splitSql.length > size) {
			for (int i = size; i < splitSql.length; i++) {
				sql.append(splitSql[i]);
			}
		}
		else if (param.length > size) {
			for (int i = size; i < param.length; i++) {
				sql.append(param[i]);
			}
		}
		return sql.toString();
	}

	private void throwUnimplementedException() throws SQLException {
		throw new SQLException("This method is not implemented");
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#addBatch()
	 */
	public void addBatch() throws SQLException {
		String sql = getSql();
		BatchVector.add(sql);
		clearParameters();
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#clearParameters()
	 */
	public void clearParameters() throws SQLException {
		for (int i = 0; i < setFlag.length; i++) {
			setFlag[i] = false;
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#execute()
	 */
	public boolean execute() throws SQLException {
		String sql = getSql();
		allSql.add(sql);
		return true;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#executeQuery()
	 */
	public ResultSet executeQuery() throws SQLException {
		execute();
		return null;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#executeUpdate()
	 */
	public int executeUpdate() throws SQLException {
		execute();
		return 0;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#getMetaData()
	 */
	public ResultSetMetaData getMetaData() throws SQLException {
		// ignore
		return null;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#getParameterMetaData()
	 */
	public ParameterMetaData getParameterMetaData() throws SQLException {
		// ignore
		return null;
	}

	protected void setItem(int parameterIndex, String value)
			throws SQLException {
		if (parameterIndex < 1 || parameterIndex > numqmarks) {
			throw new SQLException("Too many or too few host variables given");
		}
		param[parameterIndex - 1] = value;
		markSetFlag(parameterIndex);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setArray(int, java.sql.Array)
	 */
	public void setArray(int i, Array x) throws SQLException {
		throwUnimplementedException();
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setAsciiStream(int, java.io.InputStream,
	 *      int)
	 */
	public void setAsciiStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		if (x == null) {
			setNull(parameterIndex, Types.VARCHAR);
			return;
		}
		try {
			String s = org.apache.commons.io.IOUtils.toString(x);
			setString(parameterIndex, s);
		}
		catch (IOException e) {
			throw new SQLException(e.getMessage());
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setBigDecimal(int, java.math.BigDecimal)
	 */
	public void setBigDecimal(int parameterIndex, BigDecimal x)
			throws SQLException {
		if (x == null) {
			setNull(parameterIndex, Types.DECIMAL);
			return;
		}
		setItem(parameterIndex, x.toString());
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setBinaryStream(int, java.io.InputStream,
	 *      int)
	 */
	public void setBinaryStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		throwUnimplementedException();

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setBlob(int, java.sql.Blob)
	 */
	public void setBlob(int i, Blob x) throws SQLException {
		throwUnimplementedException();

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setBoolean(int, boolean)
	 */
	public void setBoolean(int parameterIndex, boolean x) throws SQLException {
		setItem(parameterIndex, x ? "'t'" : "'f'");
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setByte(int, byte)
	 */
	public void setByte(int parameterIndex, byte x) throws SQLException {
		throwUnimplementedException();

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setBytes(int, byte[])
	 */
	public void setBytes(int parameterIndex, byte[] x) throws SQLException {
		throwUnimplementedException();

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setCharacterStream(int, java.io.Reader,
	 *      int)
	 */
	public void setCharacterStream(int parameterIndex, Reader reader, int length)
			throws SQLException {
		if (reader == null) {
			setNull(parameterIndex, Types.VARCHAR);
			return;
		}
		try {
			String s = org.apache.commons.io.IOUtils.toString(reader);
			setString(parameterIndex, s);
		}
		catch (IOException e) {
			throw new SQLException(e.getMessage());
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setClob(int, java.sql.Clob)
	 */
	public void setClob(int i, Clob x) throws SQLException {
		throwUnimplementedException();
		/*ByteArrayInputStream valueByte=null;
		try {
			valueByte = new ByteArrayInputStream(
					(x.toString()).getBytes("GB2312"));
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		setAsciiStream(i, valueByte, valueByte.available());*/
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setDate(int, java.sql.Date)
	 */
	public void setDate(int parameterIndex, Date x) throws SQLException {
		if (x == null) {
			setNull(parameterIndex, Types.DATE);
			return;
		}
		String s = new java.text.SimpleDateFormat("yyyyMMdd").format(x);
		setItem(parameterIndex, "to_date('" + s + "','YYYYMMDD')");
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setDate(int, java.sql.Date,
	 *      java.util.Calendar)
	 */
	public void setDate(int parameterIndex, Date x, Calendar cal)
			throws SQLException {
		if (x == null) {
			setNull(parameterIndex, Types.DATE);
			return;
		}

		if (cal == null)
			cal = Calendar.getInstance(java.util.TimeZone.getDefault());
		cal.setTime(x);
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		String day = String.valueOf(cal.get(Calendar.DATE));
		setItem(parameterIndex, "to_date('" + year + month + day
				+ "','YYYYMMDD')");
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setDouble(int, double)
	 */
	public void setDouble(int parameterIndex, double x) throws SQLException {
		setItem(parameterIndex, String.valueOf(x));
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setFloat(int, float)
	 */
	public void setFloat(int parameterIndex, float x) throws SQLException {
		setItem(parameterIndex, String.valueOf(x));
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setInt(int, int)
	 */
	public void setInt(int parameterIndex, int x) throws SQLException {
		setItem(parameterIndex, String.valueOf(x));
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setLong(int, long)
	 */
	public void setLong(int parameterIndex, long x) throws SQLException {
		setItem(parameterIndex, String.valueOf(x));
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setNull(int, int)
	 */
	public void setNull(int parameterIndex, int sqlType) throws SQLException {
		setItem(parameterIndex, "null");
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setNull(int, int, java.lang.String)
	 */
	public void setNull(int paramIndex, int sqlType, String typeName)
			throws SQLException {
		setItem(paramIndex, "null");
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setObject(int, java.lang.Object)
	 */
	public void setObject(int parameterIndex, Object x) throws SQLException {
		setObject(parameterIndex, x, Types.OTHER);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setObject(int, java.lang.Object, int)
	 */
	public void setObject(int parameterIndex, Object x, int targetSqlType)
			throws SQLException {
		setObject(parameterIndex, x, targetSqlType, -1);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setObject(int, java.lang.Object, int,
	 *      int)
	 */
	public void setObject(int parameterIndex, Object x, int targetSqlType,
			int scale) throws SQLException {
		if (x == null) {
			setNull(parameterIndex, targetSqlType);
			return;
		}

		//System.out.println("targetSqlType:"+targetSqlType);

		switch (targetSqlType) {
			case Types.ARRAY:
			case Types.BINARY:
			case Types.BIT:
			case Types.BLOB:
			case Types.DATALINK:
			case Types.DISTINCT:
			case Types.NULL:
			case Types.LONGVARBINARY:
			case Types.JAVA_OBJECT:
			case Types.REAL:
			case Types.REF:
			case Types.STRUCT:
			case Types.VARBINARY:
			case Types.CLOB:
				throwUnimplementedException();
				break;
			/*case Types.CLOB:
				ByteArrayInputStream valueByte=null;
				try {
					valueByte = new ByteArrayInputStream(
							((String)x).getBytes("GB2312"));
				} catch (UnsupportedEncodingException e) {
					
					e.printStackTrace();
				}
				setAsciiStream(parameterIndex, valueByte, valueByte.available());
				break;*/
			case Types.BIGINT:
			case Types.INTEGER:
			case Types.SMALLINT:
			case Types.TINYINT:
				if (x instanceof Number) {
					Number n = (Number) x;
					setInt(parameterIndex, n.intValue());
				}
				else {
					setInt(parameterIndex, Integer.parseInt(x.toString()));
				}
				break;
			case Types.BOOLEAN:
				Boolean b = (Boolean) x;
				setBoolean(parameterIndex, b.booleanValue());
				break;
			case Types.CHAR:
			case Types.LONGVARCHAR:
			case Types.VARCHAR:
				setString(parameterIndex, (String) x);
				break;
			case Types.DECIMAL:
			case Types.NUMERIC:
				if (x instanceof java.math.BigDecimal && scale >= 0) {
					java.math.BigDecimal d = (java.math.BigDecimal) x;
					d.setScale(scale);
					setString(parameterIndex, d.toString());
				}
				else if (x instanceof Number) {
					Number d = (Number) x;
					setDouble(parameterIndex, d.doubleValue());
				}
				else {
					setDouble(parameterIndex, Double.parseDouble(x.toString()));
				}
				break;
			case Types.DOUBLE:
			case Types.FLOAT:
				if (x instanceof Number) {
					Number d = (Number) x;
					setDouble(parameterIndex, d.doubleValue());
				}
				else {
					setDouble(parameterIndex, Double.parseDouble(x.toString()));
				}
				break;
			case Types.DATE:
				setDate(parameterIndex, (java.sql.Date) x);
				break;
			case Types.TIME:
				setTime(parameterIndex, (java.sql.Time) x);
				break;
			case Types.TIMESTAMP:
				java.sql.Timestamp tp = new Timestamp(
						((java.util.Date) x).getTime());
				setTimestamp(parameterIndex, tp);
				break;
			case Types.OTHER:
				Class cl = x.getClass();
				if (x instanceof Integer || x instanceof Long) {
					setObject(parameterIndex, x, Types.INTEGER);
				}
				else if (x instanceof Double || x instanceof Float) {
					setObject(parameterIndex, x, Types.DOUBLE);
				}
				else if (String.class.equals(cl)) {
					setObject(parameterIndex, x, Types.VARCHAR);
				}
				else if (x instanceof java.util.Date) {
					setObject(parameterIndex, x, Types.TIMESTAMP);
				}
				else if (x instanceof java.math.BigDecimal) {
					setObject(parameterIndex, x, Types.DECIMAL);
				}
				else if (byte[].class.equals(cl)) {
					setObject(parameterIndex, x, Types.BINARY);
				}
				else {
					throw new SQLException("Unsupported class:" + cl.getName());
				}
				break;
			default:
				break;
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setRef(int, java.sql.Ref)
	 */
	public void setRef(int i, Ref x) throws SQLException {
		throwUnimplementedException();
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setShort(int, short)
	 */
	public void setShort(int parameterIndex, short x) throws SQLException {
		setItem(parameterIndex, String.valueOf(x));

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setString(int, java.lang.String)
	 */
	public void setString(int parameterIndex, String x) throws SQLException {
		if (x == null) {
			setNull(parameterIndex, Types.VARCHAR);
		}
		else {
			x = x.replaceAll("'", "''");
			setItem(parameterIndex, "'" + x + "'");
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setTime(int, java.sql.Time)
	 */
	public void setTime(int parameterIndex, Time x) throws SQLException {
		if (x == null) {
			setNull(parameterIndex, Types.TIME);
			return;
		}

		String s = new java.text.SimpleDateFormat("yyyyMMdd HH:mm:ss").format(x);
		setItem(parameterIndex, "to_date('" + s + "','YYYYMMDD HH24:MI:SS')");
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setTime(int, java.sql.Time,
	 *      java.util.Calendar)
	 */
	public void setTime(int parameterIndex, Time x, Calendar cal)
			throws SQLException {
		if (x == null) {
			setNull(parameterIndex, Types.TIME);
			return;
		}

		if (cal == null)
			cal = Calendar.getInstance(java.util.TimeZone.getDefault());
		cal.setTime(x);
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		String day = String.valueOf(cal.get(Calendar.DATE));

		String hour = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
		String minute = String.valueOf(cal.get(Calendar.MINUTE));
		String second = String.valueOf(cal.get(Calendar.SECOND));

		setItem(parameterIndex, "to_date('" + year + month + day + " " + hour
				+ minute + second + "','YYYYMMDD HH24MISS')");
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setTimestamp(int, java.sql.Timestamp)
	 */
	public void setTimestamp(int parameterIndex, Timestamp x)
			throws SQLException {
		if (x == null) {
			setNull(parameterIndex, Types.TIMESTAMP);
			return;
		}
		String s = new java.text.SimpleDateFormat("yyyyMMdd HH:mm:ss").format(x);
		setItem(parameterIndex, "to_date('" + s + "','YYYYMMDD HH24:MI:SS')");
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setTimestamp(int, java.sql.Timestamp,
	 *      java.util.Calendar)
	 */
	public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal)
			throws SQLException {
		if (x == null) {
			setNull(parameterIndex, Types.TIMESTAMP);
			return;
		}

		if (cal == null)
			cal = Calendar.getInstance(java.util.TimeZone.getDefault());
		cal.setTime(x);
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		String day = String.valueOf(cal.get(Calendar.DATE));

		String hour = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
		String minute = String.valueOf(cal.get(Calendar.MINUTE));
		String second = String.valueOf(cal.get(Calendar.SECOND));

		setItem(parameterIndex, "to_date('" + year + month + day + " " + hour
				+ minute + second + "','YYYYMMDD HH24MISS')");

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.sql.PreparedStatement#setURL(int, java.net.URL)
	 */
	public void setURL(int parameterIndex, URL x) throws SQLException {
		if (x == null) {
			setNull(parameterIndex, Types.VARCHAR);
			return;
		}
		setString(parameterIndex, x.toString());
	}

	/**
	 * 
	 * @see java.sql.PreparedStatement#setUnicodeStream(int,
	 *      java.io.InputStream, int)
	 * @deprecated
	 */
	public void setUnicodeStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		// deprecated method
		throwUnimplementedException();
	}

	private int cntqmarks(String s) {
		return cntqmarks(s, null);
	}

	/**
	 * 统计prepared sql中的<code>?</code>个数 对于PROCEDURE的统计需要先抛弃'='之前的内容
	 * 
	 * @param sql
	 * @param fromStr
	 * @return SQL中'?'的个数
	 */
	private int cntqmarks(String sql, String fromStr) {
		int i = 0;
		if (fromStr != null) {
			int j = sql.indexOf(fromStr);
			if (j != -1)
				sql = sql.substring(j);
		}
		i = sql.indexOf("?");
		if (i != -1) {
			int k = sql.length();
			int l = 1;
			int i1;
			for (i++; i < k; i = i1 + 1) {
				i1 = 0;
				if ((i1 = sql.indexOf('?', i)) < 0)
					break;
				l++;
			}

			return l;
		}
		else {
			return 0;
		}
	}

	void setqmarks(int i) {
		numqmarks = i;
	}

	@Override
	public void setRowId(int parameterIndex, RowId x) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNString(int parameterIndex, String value)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value,
			long length) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNClob(int parameterIndex, NClob value) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClob(int parameterIndex, Reader reader, long length)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream, long length)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNClob(int parameterIndex, Reader reader, long length)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSQLXML(int parameterIndex, SQLXML xmlObject)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, long length)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, long length)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader,
			long length) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClob(int parameterIndex, Reader reader) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNClob(int parameterIndex, Reader reader) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
