package com.asisinfo.common.jdbc.commsave;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;

import com.asisinfo.common.jdbc.DBSniffer;
import com.asisinfo.common.jdbc.DBTools;
import com.asisinfo.common.jdbc.NoColumnException;
import com.asisinfo.common.jdbc.NoPKException;
import com.asisinfo.common.jdbc.TableStructure;

/**
 * <p>
 * Title: �й��ƶ��㶫ʡ�ƶ���˾BOSSϵͳ
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * 
 * <p>
 * Company: asisinfo Electronics Development Co., LTD
 * </p>
 * 
 * @author chenhm
 * @version 1.0
 */
public class SaveCmd {
	/**
	 * ���ݿ�����
	 */
	private Connection connection;

	/**
	 * ����
	 */
	private String tableName;

	/**
	 * ��������
	 */
	private int actionType;

	/**
	 * �ֶ��� insertʱ������Ҫ������ֶ� updateʱ������������Ҫ���µķ������ֶ� deleteʱ��������
	 */
	private Vector columnNames;

	/**
	 * ��ֵ
	 */
	private Vector oldValues;

	/**
	 * ��ֵ
	 */
	private Vector newValues;

	/**
	 * �Ƿ���Ը���,���ڹ���delete��where�Ӿ�
	 */
	private Vector ignore;

	private TableStructure ts;

	/**
	 * ��������
	 * 
	 * @param tableName ����
	 * @param connection ���ݿ�����
	 */
	public SaveCmd(String tableName, Connection connection) {
		tableName = tableName.toUpperCase();

		// ��DCCM�ļ��ű������⴦��
		if ("DATP0_CFG_CDR".equals(tableName))
			this.tableName = "DATP0_DCCM_CDR";
		else if ("DATP0_CFG_REC".equals(tableName))
			this.tableName = "DATP0_DCCM_REC";
		else if ("DATP0_CFG_FLD".equals(tableName))
			this.tableName = "DATP0_DCCM_FLD";
		else
			this.tableName = tableName;
//		System.out.println(this.tableName);

		this.ts = DBSniffer.getTS(connection, this.tableName);

		this.connection = connection;
		this.columnNames = new Vector();
		this.oldValues = new Vector();
		this.newValues = new Vector();
		this.ignore = new Vector();
	}

	public String getTableName() {
		return tableName;
	}

	public int getActionType() {
		return actionType;
	}

	/**
	 * ���ò�������
	 * 
	 * @param actionType ��������
	 */
	public void setActionType(int actionType) {
		this.actionType = actionType;
	}

	public void setColumnInfo(String columnName, String oldValue,
			String newValue) {
		setColumnInfo(columnName, oldValue, newValue, false);
	}

	/**
	 * �����ֶ���Ϣ
	 * 
	 * @param columnName �ֶ���
	 * @param oldValue ��ֵ
	 * @param newValue ��ֵ
	 * @param ignore �ڹ���where����ʱ���Ը���
	 */
	public void setColumnInfo(String columnName, String oldValue,
			String newValue, boolean ignore) {
		columnName = columnName.toLowerCase();
		this.columnNames.addElement(columnName);
		this.ignore.addElement(new Boolean(ignore));
		switch (this.actionType) {
			case CommonSave.INSERT:
				this.newValues.addElement(newValue);
				this.oldValues.addElement(null);
				break;
			case CommonSave.UPDATE:
				this.newValues.addElement(newValue);
				this.oldValues.addElement(oldValue);
				break;
			case CommonSave.DELETE:
				this.newValues.addElement(null);
				this.oldValues.addElement(oldValue);
				break;
		}
	}

	/**
	 * ִ�з��������ݲ�ͬ�Ĳ������͵��ò�ͬ�ķ���
	 * 
	 * @throws java.lang.Exception
	 * @return int
	 */
	public int excute() throws Exception {
		switch (this.actionType) {
			case CommonSave.INSERT:
				return this.insert();
			case CommonSave.UPDATE:
				return this.update();
			case CommonSave.DELETE:
				return this.delete();
		}
		return 0;
	}

	/**
	 * ��PreparedStatement���������ֵ
	 * 
	 * @param pstmt PreparedStatement����
	 * @param position λ��
	 * @param columnType �ֶ�����
	 * @param columnValue �ֶ�ֵ
	 * @throws java.lang.Exception
	 */
	private void setPstmtValue(PreparedStatement pstmt, int position,
			int columnType, String columnValue) throws Exception {

		String javaType = DBTools.JDBCTypeToName(columnType);
		if ("unknown".equals(javaType)) {
			throw new IllegalArgumentException("Unknow columnType:"
					+ columnType);
		}

		if (columnValue == null || columnValue.trim().equals("")) {
			pstmt.setNull(position, columnType);
			return;
		}

		switch (columnType) {
			case Types.CHAR:
			case Types.VARCHAR:
				pstmt.setString(position, columnValue);
				break;
			case Types.DATE:
				java.sql.Date dt = java.sql.Date.valueOf(columnValue.trim());
				pstmt.setDate(position, dt);
				break;
			case Types.TIMESTAMP:
				java.sql.Timestamp timestamp = null;
				try {
					timestamp = java.sql.Timestamp.valueOf(columnValue.trim());
				}
				catch (Exception ex) {
					try {
						timestamp = new java.sql.Timestamp(
								java.sql.Date.valueOf(columnValue.trim()).getTime());
					}
					catch (Exception e) {
						throw new IllegalArgumentException("Not date string:"
								+ columnValue);
					}
				}
				pstmt.setTimestamp(position, timestamp);
				break;
			case Types.LONGVARCHAR:
				pstmt.setString(position, columnValue);
				break;
			case Types.CLOB:
				ByteArrayInputStream bisData = new ByteArrayInputStream(
						columnValue.getBytes("GB2312"));
				// System.out.println(columnValue);

				// java.sql.Clob clob = new com.informix.jdbc.IfxCblob(bisData);
				pstmt.setAsciiStream(position, bisData, bisData.available());
				break;
			case Types.DECIMAL:
			case Types.FLOAT:
				pstmt.setFloat(position, Float.parseFloat(columnValue));
				break;
			case Types.INTEGER:
			case Types.SMALLINT:
			case Types.REAL:
			case Types.BIGINT:
				pstmt.setInt(position, Integer.parseInt(columnValue));
				break;
			default:
				throw new IllegalArgumentException("unsupported columnType:"
						+ javaType);
		}

	}

	/**
	 * ��ȡ����SQL���
	 * 
	 * @return ����SQL���
	 * @throws java.lang.Exception
	 */
	private String getInsertSql() throws Exception {
		String modelName = ts.getSchema();
		String sql = "insert into " + modelName + "." + this.tableName + "(";
		String name = "";
		String value = "";
		for (int i = 0; i < this.columnNames.size(); i++) {
			if (ts.isExist((String) this.columnNames.elementAt(i))) {
				if (name.length() == 0) {
					name += (String) this.columnNames.elementAt(i);
					value += "?";
				}
				else {
					name += "," + (String) this.columnNames.elementAt(i);
					value += ",?";
				}
			}
		}
		sql += name + ") " + "values(" + value + ")";
		return sql;
	}

	/**
	 * ���뷽��
	 * 
	 * @return ���������
	 * @throws java.lang.Exception
	 */
	private int insert() throws Exception {
		String sql = this.getInsertSql();
		 System.out.println(sql);
		PreparedStatement pstmt = null;
		try {
			pstmt = this.connection.prepareStatement(sql);
			for (int i = 0, col = 1; i < this.columnNames.size(); i++) {
				String name = (String) this.columnNames.elementAt(i);
				if (ts.isExist(name)) {
					int columnType = this.ts.getColumnType(name);
					this.setPstmtValue(pstmt, col, columnType,
						(String) this.newValues.elementAt(i));
					col++;
				}
			}
			return pstmt.executeUpdate();
		}
		catch (SQLException ex) {
			if (this.tableName.equals("ratp0_fee")
					&& this.tableName.equals("disp0_fee")) {
				System.out.println(ex.getMessage() + ex.getErrorCode());
			}
			throw ex;
		}
		finally {
			DBTools.closeDB(null, pstmt, null);
		}
	}

	/**
	 * ��ȡ����SQL���
	 * 
	 * @return ����SQL���
	 * @throws java.lang.Exception
	 */
	private String getUpdateSql() throws Exception {
		String modelName = ts.getSchema();
		String sql = "update " + modelName + "." + this.tableName + " set ";
		String notKeyColumns[] = this.getNotKeyColumns();
		if (notKeyColumns.length == 0) {
			throw new NoColumnException("Can't modify primary key column.");
		}
		for (int i = 0; i < notKeyColumns.length; i++) {
			if (i == 0) {
				sql += notKeyColumns[i] + "=?";
			}
			else {
				sql += "," + notKeyColumns[i] + "=?";
			}
		}
		sql += " where ";
		String[] keyColumnNames = ts.getPKColumns();
		// this.dbBean.getPKColumns(this.tableName,
		// this.connection);
		if (keyColumnNames.length == 0) {
			throw new NoPKException("table(" + this.tableName
					+ ") no PrimaryKey");
		}
		for (int i = 0; i < keyColumnNames.length; i++) {
			if (i == 0) {
				sql += keyColumnNames[i] + "=?";
			}
			else {
				sql += " and " + keyColumnNames[i] + "=?";
			}
		}		

		// System.out.println(sql);
		return sql;
	}

	/**
	 * ���·���
	 * 
	 * @throws java.lang.Exception
	 * @return int
	 */
	private int update() throws Exception {
		String sql = this.getUpdateSql();
		// System.out.println(sql);
		PreparedStatement pstmt = null;
		try {
			pstmt = this.connection.prepareStatement(sql);
			String notKeyColumns[] = this.getNotKeyColumns();
			for (int i = 0; i < notKeyColumns.length; i++) {
				int columnType = ts.getColumnType(notKeyColumns[i]);
				String s = this.getNewValueByColumnName(notKeyColumns[i]);
				this.setPstmtValue(pstmt, i + 1, columnType, s);
			}

			String keyColumnNames[] = ts.getPKColumns();
			// this.dbBean.getPKColumns(this.tableName,
			// this.connection);
			for (int i = 0; i < keyColumnNames.length; i++) {
				int columnType = this.ts.getColumnType(keyColumnNames[i]);
				String s = this.getOldValueByColumnName(keyColumnNames[i]);
				this.setPstmtValue(pstmt, notKeyColumns.length + i + 1,
					columnType, s);
			}
			return pstmt.executeUpdate();
		}
		finally {
			DBTools.closeDB(null, pstmt, null);
		}
	}

	/**
	 * ��ȡɾ������SQL���
	 * 
	 * @return ɾ������SQL���
	 * @throws java.lang.Exception
	 */
	private String getDeleteSql() throws Exception {
		String modelName = ts.getSchema();
		String sql = "delete from " + modelName + "." + this.tableName
				+ " where ";
		String[] keyColumnNames = ts.getPKColumns();
		if (keyColumnNames.length == 0) {
			throw new NoPKException("table(" + this.tableName
					+ ") no PrimaryKey");
		}
		String where = "";
		for (int i = 0; i < keyColumnNames.length; i++) {
			if (ignoreColumn(keyColumnNames[i])) {
				continue;
			}
			if (where.length() == 0) {
				where += keyColumnNames[i] + "=?";
			}
			else {
				where += " and " + keyColumnNames[i] + "=?";
			}
		}
		sql += where;
		// System.out.println(sql);
		return sql;
	}

	/**
	 * ɾ������
	 * 
	 * @return ɾ��������
	 * @throws java.lang.Exception
	 */
	private int delete() throws Exception {
		String sql = this.getDeleteSql();
		PreparedStatement pstmt = null;
		try {
			pstmt = this.connection.prepareStatement(sql);
			String keyColumnNames[] = ts.getPKColumns();
			// this.dbBean.getPKColumns(this.tableName,
			// this.connection);
			for (int i = 0, c = 1; i < keyColumnNames.length; i++) {
				if (ignoreColumn(keyColumnNames[i])) {
					continue;
				}
				int columnType = this.ts.getColumnType(keyColumnNames[i]);
				this.setPstmtValue(pstmt, c++, columnType,
					this.getOldValueByColumnName(keyColumnNames[i]));
			}
			return pstmt.executeUpdate();
		}
		finally {
			DBTools.closeDB(null, pstmt, null);
		}
	}

	/**
	 * ��ȡ��ֵͨ���ֶ���
	 * 
	 * @param columnName �ֶ���
	 * @return �ֶ���ֵ
	 * @throws java.lang.Exception
	 */
	private String getNewValueByColumnName(String columnName) throws Exception {
		for (int i = 0; i < this.columnNames.size(); i++) {
			// System.out.println(columnNames.elementAt(i));
			if (((String) this.columnNames.elementAt(i)).equalsIgnoreCase(columnName)) {
				return (String) this.newValues.elementAt(i);
			}
		}
		throw new Exception("need newValue of colums " + columnName
				+ " of table " + this.tableName + ".");
	}

	/**
	 * ��ȡ��ֵͨ���ֶ���
	 * 
	 * @param columnName �ֶ���
	 * @return ��ֵ
	 * @throws java.lang.Exception
	 */
	private String getOldValueByColumnName(String columnName) throws Exception {
		for (int i = 0; i < this.columnNames.size(); i++) {
			if (((String) this.columnNames.elementAt(i)).equalsIgnoreCase(columnName)) {
				return (String) this.oldValues.elementAt(i);
			}
		}
		throw new Exception("need oldValue of column " + columnName
				+ " of table " + this.tableName + ".");
	}

	/**
	 * ��ȡ��Ҫ���µķ������ֶ�,����updateʱ�õ�
	 * 
	 * @return �������ֶ�
	 * @throws java.lang.Exception
	 */
	private String[] getNotKeyColumns() throws Exception {
		Vector vNotKeyColumns = new Vector();
		for (int i = 0; i < this.columnNames.size(); i++) {
			if (ts.isExist((String) this.columnNames.elementAt(i))
					&& !ts.isPK((String) this.columnNames.elementAt(i))) {
				vNotKeyColumns.addElement(this.columnNames.elementAt(i));
			}
		}
		String notKeyColumns[] = new String[vNotKeyColumns.size()];
		vNotKeyColumns.toArray(notKeyColumns);
		return notKeyColumns;
	}

	private boolean ignoreColumn(String colname) {
		for (int i = 0; i < this.columnNames.size(); i++) {
			if (((String) this.columnNames.elementAt(i)).equals(colname)) {
				return ((Boolean) this.ignore.get(i)).booleanValue();
			}
		}
		return false;
	}
}
