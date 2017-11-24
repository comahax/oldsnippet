package com.asisinfo.common.jdbc;

import java.sql.*;
import java.util.*;

/**
 * <p>
 * Title: �й��ƶ��㶫ʡ�ƶ���˾BOSSϵͳ
 * </p>
 * <p>
 * Description: ���ݿ�̽�⹤����
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: �й����ݴ��˵��ӿ������޹�˾
 * </p>
 * 
 * @author chenhm
 * @version 1.0
 */
public class DBSniffer {
	private static java.util.HashMap TSmap = new HashMap();

	public static synchronized TableStructure getTS(Connection con,
			String tableName) {
		String catalog = "";
		try {
			catalog = con.getCatalog();
			// ��Catalog���ֲ�ͬ�����ݿ�
			String nameKey = catalog + "_" + tableName.toUpperCase();
			Object obj = TSmap.get(nameKey);
			if (obj != null) {
				return (TableStructure) obj;
			}

			java.sql.DatabaseMetaData dmd = con.getMetaData();
			TableStructure ts = new TableStructure(dmd, tableName);
			TSmap.put(nameKey, ts);
			return ts;
		}
		catch (Exception ex) {
			System.out.println("get TableStructure " + catalog + ":"
					+ tableName + " failed.");
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * ��ȡ���ݿ���ֶε�����
	 * 
	 * @param con Connection ���ݿ�����
	 * @param tableName String ���ݿ����
	 * @return String �ֶ���Ϣ�ַ����������ֶ��Զ��ŷָ�
	 */
	public static String getTableColumnName(Connection con, String tableName) {
		String tableColumnInfo = "";
		try {
			tableColumnInfo += getKeyColumnName(con, tableName);
			tableColumnInfo += "," + getNotKeyColumnName(con, tableName);
		}
		catch (Exception e) {
			System.out.print("Exception at DBSniffer.getTableColumnName:");
			e.printStackTrace();
		}
		return tableColumnInfo;
	}

	public static boolean isPK(Connection conn, String tableName,
			String columnName) throws NoTableException {
		TableStructure ts = getTS(conn, tableName);
		if (ts != null) {
			return ts.isPK(columnName);
		}
		throw new NoTableException("Can't load schema from table " + tableName);
	}

	public int getColumnType(Connection conn, String tableName,
			String columnName) throws NoTableException, NoColumnException  {
		TableStructure ts = getTS(conn, tableName);
		if (ts != null) {
			return ts.getColumnType(columnName);
		}
		throw new NoTableException("Can't load schema from table " + tableName);
	}

	/**
	 * ��ȡ����������Ϣ
	 * 
	 * @param con Connection ���ݿ�����
	 * @param tableName String ����
	 * @return String ���������ֶ����������ֶ��Զ��ŷָ�
	 */
	public static String getKeyColumnName(Connection con, String tableName) {
		String keyColumnName = "";
		TableStructure ts = getTS(con, tableName);
		java.util.Vector pkcol = ts.getPrimaryKeyColumnNames();
		for (int i = 0; i < pkcol.size(); i++) {
			if (i == 0) {
				keyColumnName += (String) pkcol.get(i);
			}
			else {
				keyColumnName += "," + (String) pkcol.get(i);
			}
		}
		return keyColumnName;
	}

	/**
	 * ��ȡ���з�������Ϣ
	 * 
	 * @param con Connection ���ݿ�����
	 * @param tableName String ����
	 * @return String ���ط������ֶ����������ֶ��Զ��ŷָ�
	 */
	public static String getNotKeyColumnName(Connection con, String tableName) {
		String notKeyColumnName = "";
		TableStructure ts = getTS(con, tableName);
		java.util.Vector pkcol = ts.getNotPrimaryKeyColumnNames();
		for (int i = 0; i < pkcol.size(); i++) {
			if (i == 0) {
				notKeyColumnName += (String) pkcol.get(i);
			}
			else {
				notKeyColumnName += "," + (String) pkcol.get(i);
			}
		}
		return notKeyColumnName;
	}

	/**
	 * ��ȡ���ݿ������ֶε���������
	 * 
	 * @param con Connection ���ݿ�����
	 * @param tableName String ���ݿ����
	 * @return HashMap �����ֶμ�������hash��
	 */
	public static HashMap getTableColumnDataType(Connection con,
			String tableName) {
		HashMap hm = new HashMap();
		TableStructure ts = getTS(con, tableName);
		java.util.Vector col = ts.getColumnNames();
		java.util.Vector colType = ts.getColumnTypes();
		for (int i = 0; i < col.size(); i++) {
			hm.put((String) col.get(i),
				Integer.valueOf((String) colType.get(i)));
		}
		return hm;
	}

	public static void main(String[] args) throws Exception {
		// ratp0_fee_fidd
		// Connection src = DBTools.getLocalConnection();
		// Connection dst = DBTools.getBossTestConnection();
		// String retStr = getTableColumnName(con, "bilp0_inf_srcdef");
		// System.out.println(retStr);
		// long time = System.currentTimeMillis();
		// TableStructure ts1 = DBSniffer.getTS(src, "ratp0_fee_fidd");
		// TableStructure ts2 = DBSniffer.getTS(dst, "ratp0_fee_fidd");
		//
		// System.out.println(ts1.isSameStructure(ts2));
		// System.out.println(System.currentTimeMillis() - time);
		// DBTools.closeAll(src, null, null);
		// DBTools.closeAll(dst, null, null);
	}
}
