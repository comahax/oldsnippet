package com.asisinfo.common.jdbc.commquery;

import java.sql.*;
import com.asisinfo.common.jdbc.*;

/**
 * 
 * <p>
 * �й��ƶ��㶫ʡ�ƶ���˾BOSSϵͳ
 * </p>
 * <p>
 * ��ṹ��,���������ɵ����XML��֤�ļ���map�ļ���commonQueryConfig.xml
 * </p>
 * <p>
 * Copyright (c) 2006
 * </p>
 * <p>
 * �й����ݴ��˵��ӿ������޹�˾
 * </p>
 * 
 * @modified �º���
 * @author ����
 * @version 1.0
 */
public class TableStructureTools {
	// �ֶ���Ϣ��
	private class ColumnInfo {
		/**
		 * �ֶ���
		 */
		public String columnName;

		/**
		 * �Ƿ�Ϊ��
		 */
		public String isNull;

		/**
		 * �ֶ���������
		 */
		public String columnType;

		/**
		 * ��С
		 */
		public int size;
	}

	/**
	 * ����
	 */
	private String tableName;

	/**
	 * �ֶ���Ϣ
	 */
	private ColumnInfo columnInfos[];

	/**
	 * ���ݱ�����ϵͳ���ȡ�ֶδ�С
	 * 
	 * @param tableName ����
	 * @param con ���ݿ�����
	 * @return ���и����ֶδ�С��ɵ���������
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

	// ���ݱ����ӻ�ȡ�ֶ����ͣ�������ʵ�ַ�����һ���Ǹ���ϵͳ���ȡ���ͣ����֣�-->�ı�
	// ��һ�ַ�������Java�ṩ��DatabaseMetaData���ͣ���ȡ�����ͣ��ı�����
	/**
	 * ��ȡ���и��ֶε���������
	 * 
	 * @param tableName ����
	 * @param con ���ݿ�����
	 * @return ���и����ֶ�������ɵ�����
	 */
	private static String[] getColType(String tableName, Connection con) {
		String[] colTypes = null;
		// ������
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
					System.out.println(colNames[i] + "�ֶβ����ڡ�");
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
	 * �жϱ��������ֶ��Ƿ�����Ϊ��
	 * 
	 * @param tableName ����
	 * @param con ���ݿ�����
	 * @return ���ر��и��ֶ��Ƿ�Ϊ�յ��ַ�������
	 */
	public static String[] isNullAble(String tableName, Connection con) {
		TableStructure ts = DBSniffer.getTS(con, tableName);
		// �����ͷǿ��ֶζ�����Ϊ��
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
	 * ͨ����ϵͳ���жϸ����ı��Ƿ����
	 * 
	 * @param tableName ���ݱ���
	 * @param connection ���ݿ�����
	 * @return ����������ݿ��д��ڣ��򷵻�true�����򷵻�false
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
				// System.out.println(tableName + "������!");
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
	 * ��ṹ���캯��
	 * 
	 * @param tableName ����
	 * @param columnNames �ֶ���
	 * @param columnTypes �ֶ�����
	 * @param isNulls �Ƿ�Ϊ��
	 * @param colSizes �ֶδ�С
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
	 * ��ȡ����
	 * 
	 * @return ����
	 */
	public String getTableName() {
		return this.tableName;
	}

	/**
	 * ��ȡ����Ϣ
	 * 
	 * @return ����Ϣ�ַ�����XML��ʽ��
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
