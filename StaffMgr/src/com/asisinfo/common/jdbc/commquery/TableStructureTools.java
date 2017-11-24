package com.asisinfo.common.jdbc.commquery;

import java.sql.*;
import com.asisinfo.common.jdbc.*;

/**
 * 
 * <p>
 * 中国移动广东省移动公司BOSS系统
 * </p>
 * <p>
 * 表结构类,可用来生成单表的XML验证文件，map文件，commonQueryConfig.xml
 * </p>
 * <p>
 * Copyright (c) 2006
 * </p>
 * <p>
 * 中国广州从兴电子开发有限公司
 * </p>
 * 
 * @modified 陈宏明
 * @author 陈敏
 * @version 1.0
 */
public class TableStructureTools {
	// 字段信息类
	private class ColumnInfo {
		/**
		 * 字段名
		 */
		public String columnName;

		/**
		 * 是否为空
		 */
		public String isNull;

		/**
		 * 字段数据类型
		 */
		public String columnType;

		/**
		 * 大小
		 */
		public int size;
	}

	/**
	 * 表名
	 */
	private String tableName;

	/**
	 * 字段信息
	 */
	private ColumnInfo columnInfos[];

	/**
	 * 根据表名从系统表获取字段大小
	 * 
	 * @param tableName 表名
	 * @param con 数据库连接
	 * @return 表中各个字段大小组成的整型数组
	 */
	private static int[] getColSize(String tableName, Connection con) {
		Statement st = null;
		ResultSet rs = null;
		int[] colSizes = null;
		TableStructure tableStructure = DBSniffer.getTS(con,tableName);
		int colCount = tableStructure.getColumnCount();
		colSizes = new int[colCount];
		try {
			
			java.sql.DatabaseMetaData dmd = con.getMetaData();			
			rs = dmd.getColumns(null,null,tableName,null);
			for (int i = 0; i < colCount && rs.next(); i++) {
				colSizes[i] = rs.getInt("COLUMN_SIZE");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBTools.closeDB(null, st, rs);
		}

		return colSizes;
	}

	// 根据表名从获取字段类型，有两种实现方法，一种是根据系统表获取类型（数字）-->文本
	// 另一种方法是用Java提供的DatabaseMetaData类型，获取其类型（文本）。
	/**
	 * 获取表中各字段的数据类型
	 * 
	 * @param tableName 表名
	 * @param con 数据库连接
	 * @return 表中各个字段类型组成的数组
	 */
	private static String[] getColType(String tableName, Connection con) {
		String[] colTypes = null;
		// 方法二
		TableStructure tableStructure = DBSniffer.getTS(con,tableName);
		int colCount = tableStructure.getColumnCount();
		colTypes = new String[colCount];

		String[] colNames = (String[]) tableStructure.getColumnNames().toArray(
			new String[0]);
		ResultSet rs = null;
		try {

			DatabaseMetaData metaData = con.getMetaData();

			int colType;

			for (int i = 0; i < colCount; i++) {
				rs = metaData.getColumns(null, null, tableName, colNames[i]);

				if (rs.next()) {
					colType = rs.getInt("DATA_TYPE");
					switch (colType) {
						case Types.VARCHAR:
							colTypes[i] = "String";
							break;
						case Types.LONGVARCHAR:
							colTypes[i] = "String";
							break;
						case Types.CHAR:
							colTypes[i] = "String";
							break;
						case Types.SMALLINT:
							colTypes[i] = "SmallInt";
							break;
						case Types.INTEGER:
							colTypes[i] = "Integer";
							break;
						case Types.DECIMAL:
							colTypes[i] = "Numeric";
							break;
						case Types.DOUBLE:
							colTypes[i] = "Numeric";
							break;
						case Types.FLOAT:
							colTypes[i] = "Numeric";
							break;
						case Types.NUMERIC:
							colTypes[i] = "Numeric";
							break;
						case Types.REAL:
							colTypes[i] = "Numeric";
							break;
						case Types.TIME:
							colTypes[i] = "Date";
							break;
						case Types.DATE:
							colTypes[i] = "Date";
							break;
						case Types.TIMESTAMP:
							colTypes[i] = "Date";
							break;

					}
				}
				else {
					System.out.println(colNames[i] + "字段不存在。");
				}
			}
			DBTools.closeDB(null,null,rs);

		}
		catch (Exception e) {
			e.printStackTrace();
			DBTools.closeDB(null,null,rs);
		}
		return colTypes;
	}

	/**
	 * 判断表中所有字段是否允许为空
	 * 
	 * @param tableName 表名
	 * @param con 数据库连接
	 * @return 返回表中各字段是否为空的字符串数组
	 */
	public static String[] isNullAble(String tableName, Connection con) {
		TableStructure ts = DBSniffer.getTS(con, tableName);
		// 主键和非空字段都不可为空
		java.util.Vector cols = ts.getColumnNames();
		String[] tmp = new String[cols.size()];

		for (int i = 0; i < tmp.length; i++) {
			if (ts.isPK((String) cols.get(i))
					|| ts.isNullable((String) cols.get(i)).equals("NO")) {
				tmp[i] = "N";
			}
			else {
				tmp[i] = "Y";
			}
		}
		return tmp;
	}

	/**
	 * 通过查系统表判断给出的表是否存在
	 * 
	 * @param tableName 数据表名
	 * @param connection 数据库连接
	 * @return 如果表在数据库中存在，则返回true，否则返回false
	 */
	public static boolean existTable(String tableName, Connection connection) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			String sql = "select count(*) from systables where tabname = '"
					+ tableName + "';";

			rs = st.executeQuery(sql);
			rs.next();
			int tableCount = rs.getInt(1);
			if (tableCount < 1) {
				// System.out.println(tableName + "表不存在!");
				return false;
			}
			else {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			DBTools.closeDB(null, st, rs);
		}

	}

	public static TableStructureTools getTableStructure(String tableName,
			Connection con) {
		TableStructureTools ts = null;
		TableStructure tableStructure = DBSniffer.getTS(con, tableName);
		
		if (tableStructure == null)
			System.exit(-1);
		
		try {
			String[] columnNames = (String[]) tableStructure.getColumnNames().toArray(
				new String[0]);
			String[] columnTypes = getColType(tableName, con);
			String[] isNulls = isNullAble(tableName, con);
			int[] colSizes = getColSize(tableName, con);

			ts = new TableStructureTools(tableName, columnNames, columnTypes,
					isNulls, colSizes);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return ts;
	}

	/**
	 * 表结构构造函数
	 * 
	 * @param tableName 表名
	 * @param columnNames 字段名
	 * @param columnTypes 字段类型
	 * @param isNulls 是否为空
	 * @param colSizes 字段大小
	 */
	private TableStructureTools(String tableName, String[] columnNames,
			String[] columnTypes, String[] isNulls, int[] colSizes) {
		this.tableName = tableName;
		this.columnInfos = new ColumnInfo[columnNames.length];
		for (int i = 0; i < columnNames.length; i++) {
			this.columnInfos[i] = new ColumnInfo();
			this.columnInfos[i].columnName = columnNames[i];
			this.columnInfos[i].columnType = columnTypes[i];
			this.columnInfos[i].isNull = isNulls[i];
			this.columnInfos[i].size = colSizes[i];
		}

	}

	/**
	 * 获取表名
	 * 
	 * @return 表名
	 */
	public String getTableName() {
		return this.tableName;
	}

	/**
	 * 获取表信息
	 * 
	 * @return 表信息字符串（XML形式）
	 */
	public String getVerifyXml() {
		String rtXml = "<?xml version=\"1.0\" encoding=\"GB2312\"?>\n<verifys>\n<verify verifyModule='simpleTable'>\n";
		// String rtXml ="<verifys><verify verifyModule='" + this.tableName +
		// "'>";
		for (int i = 0; i < columnInfos.length; i++) {
			rtXml += "<htmlObj>\n";

			rtXml += "<id>" + columnInfos[i].columnName.toUpperCase()
					+ "</id>\n<idName>"
					+ columnInfos[i].columnName.replace('_', ' ').toLowerCase()
					+ "</idName>\n";
			rtXml += "<dataType>" + columnInfos[i].columnType + "</dataType>\n";
			rtXml += "<isNull>" + columnInfos[i].isNull + "</isNull>\n";
			if (columnInfos[i].columnType.trim().equals("String")) {
				if (columnInfos[i].isNull.equals("N")) {
					rtXml += "<minValue available='Y'>1</minValue>\n";
				}
				else {
					rtXml += "<minValue available='Y'>0</minValue>\n";
				}
				rtXml += "<maxValue available='Y'>" + columnInfos[i].size
						+ "</maxValue>\n";

			}

			if (columnInfos[i].columnType.trim().equals("SmallInt")) {
				if (columnInfos[i].isNull.equals("N")) {
					rtXml += "<minValue available='Y'>-32768</minValue>\n";
				}
				else {
					rtXml += "<minValue available='Y'>-32768</minValue>\n";
				}
				rtXml += "<maxValue available='Y'>" + 32767 + "</maxValue>\n";

			}

			if (columnInfos[i].columnType.trim().equals("Integer")) {
				if (columnInfos[i].isNull.equals("N")) {
					rtXml += "<minValue available='Y'>-2147483648</minValue>\n";
				}
				else {
					rtXml += "<minValue available='Y'>-2147483648</minValue>\n";
				}
				rtXml += "<maxValue available='Y'>" + 2147483647
						+ "</maxValue>\n";

			}

			if (columnInfos[i].columnType.trim().equals("Numeric")) {
				if (columnInfos[i].isNull.equals("N")) {
					rtXml += "<minValue available='Y'>-9999999999999.9999999</minValue>\n";
				}
				else {
					rtXml += "<minValue available='Y'>-9999999999999.9999999</minValue>\n";
				}
				rtXml += "<maxValue available='Y'>" + 99999999999999.99999999
						+ "</maxValue>\n";

			}

			if (columnInfos[i].columnType.trim().equals("Date")) {

				rtXml += "<minValue available='N'></minValue>\n";
				rtXml += "<maxValue available='N'></maxValue>\n";

			}

			rtXml += "</htmlObj>\n";
		}

		rtXml += "</verify>\n</verifys>\n";
		return rtXml;
	}

	public String getMapXml() {
		String rtXml = "<?xml version=\"1.0\" encoding=\"GB2312\"?>\n<maps>\n";
		// String rtXml ="<verifys><verify verifyModule='" + this.tableName +
		// "'>";
		for (int i = 0; i < columnInfos.length; i++) {
			rtXml += "\t<map columnName=\""
					+ columnInfos[i].columnName.toUpperCase()
					+ "\"\t\t\t fieldName=\""
					+ columnInfos[i].columnName.toUpperCase() + "\"/>\n";
		}
		rtXml += "</maps>";
		return rtXml;
	}

	public String getTableHtml() {
		String rtXml = "<table class=\"table2\" width=\"100%\">\n\t<tr>\n";
		for (int i = 0; i < columnInfos.length; i++) {
			rtXml += "\t\t<td class=\"td2\" width=\"25%\" align=\"right\">"
					+ columnInfos[i].columnName.replace('_', ' ').toLowerCase()
					+ "</td>\n\t\t<td class=\"td2\" width=\"25%\"><input type=\"text\" size=\"19\" id=\""
					+ columnInfos[i].columnName.toUpperCase() + "\" /></td>\n";
			if ((i + 1) % 2 == 0) {
				rtXml += "\t</tr>\n\t<tr>\n";
			}
		}
		rtXml += "\t</tr>\n</table>\n";
		return rtXml;
	}

	public String getConfigXml() {
		String rtXml = "<" + tableName.toUpperCase() + " tableName=\""
				+ tableName.toUpperCase() + "\">\n";
		// String rtXml ="<verifys><verify verifyModule='" + this.tableName +
		// "'>";
		for (int i = 0; i < columnInfos.length; i++) {
			rtXml += "\t<" + columnInfos[i].columnName.toUpperCase() + ">\n"
					+ "\t\t<headName>"
					+ columnInfos[i].columnName.replace('_', ' ').toLowerCase()
					+ "</headName>\n" + "\t</"
					+ columnInfos[i].columnName.toUpperCase() + ">\n";
		}
		rtXml += "</" + tableName.toUpperCase() + ">";
		return rtXml;
	}

	public void printTableInfo() {
		System.out.println(getVerifyXml());
		System.out.println(getMapXml());
		System.out.println(getConfigXml());
		System.out.println(getTableHtml());
	}

	public static void main(String[] args) {
//		String strMsg = "";
//		String tableName = "DATP0_CFG_REPART_UNIT_COUNT".toUpperCase();
//		Connection con = null;
//		try {
//			con = treeapplet.Database.getConnection();
//			TableStructureTools ts = getTableStructure(tableName, con);
//			ts.printTableInfo();
//			con.close();
//		}
//		catch (Exception e) {
//			DBTools.closeDB(con, null, null);
//			e.printStackTrace();
//		}
	}

}
