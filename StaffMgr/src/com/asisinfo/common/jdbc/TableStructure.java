package com.asisinfo.common.jdbc;

import java.sql.*;
import java.util.*;

/**
 * 
 * <p>
 * Title: 中国移动广东省移动公司BOSS系统
 * </p>
 * 
 * <p>
 * Description: 表结构描述类,其数据类型为java.sql.Types类型
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * 
 * <p>
 * Company: Sunrise Electronics Development Co., LTD
 * </p>
 * 
 * @author chenhm
 * @version 1.0
 */
public class TableStructure {
	private String tableName;

	private String table_schema;

	private Vector columnNames = new Vector();

	private Vector columnTypes = new Vector();
	
	private Vector columnLengths = new Vector();

	private Vector isNull = new Vector();

	private Vector primaryKeyColumnNames = new Vector();

	private Vector notPrimaryKeyColumnNames = new Vector();

	public String getTableName() {
		return tableName;
	}

	public String getSchema() {
		return table_schema;
	}

	public TableStructure(DatabaseMetaData dmd, String tableName)
			throws SQLException {
		this.tableName = tableName.toUpperCase();
		// 取表字段和字段类型
		ResultSet rs = dmd.getColumns(null, null, tableName, null);
		if (rs.next()) {
			//modified by daiwen 201204 由于可能比较两个不同数据库表结构，所以名称统一为大写
			table_schema = rs.getString("TABLE_SCHEM").trim().toUpperCase();
			columnNames.addElement(rs.getString("COLUMN_NAME").trim().toUpperCase());
			columnTypes.addElement(rs.getString("DATA_TYPE").trim());
			columnLengths.addElement(rs.getString("COLUMN_SIZE").trim());
			isNull.add(rs.getString("IS_NULLABLE").trim().toUpperCase());

			while (rs.next()) {
				table_schema = rs.getString("TABLE_SCHEM").trim().toUpperCase();
				columnNames.addElement(rs.getString("COLUMN_NAME").trim().toUpperCase());
				columnTypes.addElement(rs.getString("DATA_TYPE").trim());
				columnLengths.addElement(rs.getString("COLUMN_SIZE").trim());
				isNull.add(rs.getString("IS_NULLABLE").trim().toUpperCase());
			}
		}
		else {
			throw new NoTableException("Not found table " + tableName);
		}

		DBTools.closeDB(null, null, rs);
		// 取主键
		rs = dmd.getPrimaryKeys(null, null, tableName);
		while (rs.next()) {
			String primaryKeyColumnName = rs.getString("COLUMN_NAME").trim().toUpperCase();
			primaryKeyColumnNames.addElement(primaryKeyColumnName);
		}
		DBTools.closeDB(null, null, rs);

		// 取非主键
		for (int j = 0; j < columnNames.size(); j++) {
			boolean isPrimaryKey = false;
			String columnName = (String) columnNames.elementAt(j);
			if (!isPK(columnName)) {
				notPrimaryKeyColumnNames.addElement(columnNames.elementAt(j));
			}

			// for (int k = 0; k < primaryKeyColumnNames.size(); k++)
			// {
			// String primaryKeyColumnName = (String) primaryKeyColumnNames.
			// elementAt(k);
			// if (columnName.equals(primaryKeyColumnName))
			// {
			// isPrimaryKey = true;
			// break;
			// }
			// }
			// if (!isPrimaryKey)
			// {
			// notPrimaryKeyColumnNames.addElement(columnNames.elementAt(j));
			// // notPrimaryKeyColumnTypes.addElement(columnTypes.elementAt(j));
			// }
		}
	}

	public int getColumnCount() {
		return columnNames.size();
	}

	public Vector getColumnNames() {
		return (Vector) columnNames.clone();
	}

	public Vector getColumnTypes() {
		return (Vector) columnTypes.clone();
	}
	
    public Vector getColumnLengths()
    {
	    return (Vector) columnLengths.clone();
    }

	/**
	 * 取得指定列的数据类型
	 * 
	 * @param colNo int 从0开始
	 * @return int java.sql.Types
	 */
	public int getColumnType(int colNo) {
		if (colNo < 0 || colNo >= columnTypes.size()) {
			return java.sql.Types.NULL;
		}
		return Integer.parseInt((String) columnTypes.elementAt(colNo));
	}

	/**
	 * 取得指定列名的数据类型
	 * 
	 * @param colName String
	 * @return int java.sql.Types
	 */
	public int getColumnType(String colName) throws NoColumnException {
		for (int i = 0; i < columnNames.size(); i++) {
			if (colName.equalsIgnoreCase((String) columnNames.elementAt(i))) {
				return Integer.parseInt((String) columnTypes.elementAt(i));
			}
		}
		throw new NoColumnException("Not found column " + colName
				+ " in table " + tableName);
	}

	public Vector getNotPrimaryKeyColumnNames() {
		return (Vector) notPrimaryKeyColumnNames.clone();
	}

	public String[] getNotPKColumns() {
		String[] s = new String[notPrimaryKeyColumnNames.size()];
		notPrimaryKeyColumnNames.toArray(s);
		return s;
	}

	public Vector getPrimaryKeyColumnNames() {
		return (Vector) primaryKeyColumnNames.clone();
	}

	public String[] getPKColumns() {
		String[] s = new String[primaryKeyColumnNames.size()];
		primaryKeyColumnNames.toArray(s);
		return s;
	}

	public boolean isPK(String colName) {
		for (int i = 0; i < primaryKeyColumnNames.size(); i++) {
			if (colName.equalsIgnoreCase((String) primaryKeyColumnNames.elementAt(i))) {
				return true;
			}
		}
		return false;
	}

	public boolean isExist(String colName) {
		for (int i = 0; i < columnNames.size(); i++) {
			if (colName.equalsIgnoreCase((String) columnNames.elementAt(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * "NO" means column definitely does not allow NULL values; "YES" means the
	 * column might allow NULL values. An empty string means nobody knows.
	 * 
	 * @param colName String
	 * @return String
	 */
	public String isNullable(String colName) {
		for (int i = 0; i < this.columnNames.size(); i++) {
			if (colName.equalsIgnoreCase((String) columnNames.elementAt(i))) {
				return (String) isNull.get(i);
			}
		}
		return "";
	}

	/**
	 * 判断两个表的结构是否相等，列名、列类型、主键字段相等
	 * 
	 * @param t TableStructure
	 * @return boolean
	 */
	public boolean isSameStructure(TableStructure t) {
		if (this.columnNames.equals(t.columnNames)
				&& this.columnTypes.equals(t.columnTypes)
				&& this.primaryKeyColumnNames.equals(t.primaryKeyColumnNames)
				&& this.columnLengths.equals(t.columnLengths)
		        && this.isNull.equals(t.isNull)) {
			return true;
		}
		else {
			return false;
		}
	}
}
