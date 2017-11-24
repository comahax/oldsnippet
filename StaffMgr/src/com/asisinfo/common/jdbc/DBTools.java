package com.asisinfo.common.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class DBTools {
	private DBTools() {

	}
	
	public static void closeDB(Connection con){
		if (null != con) {
			try {
				con.close();
				con = null;
			}
			catch (Exception e) {
			}
		}
	}
	
	public static void closeDB(Statement st){
		if (null != st) {
			try {
				st.close();
				st = null;
			}
			catch (Exception e) {
			}
		}
	}
	
	public static void closeDB(ResultSet rs){
		if (null != rs) {
			try {
				rs.close();
				rs = null;
			}
			catch (Exception e) {
			}
		}
	}

	public static void closeDB(Connection con, Statement st, ResultSet rs) {
		closeDB(rs);
		closeDB(st);
		closeDB(con);
	}

	public static void closeDB(Connection con, PreparedStatement st,
			ResultSet rs) {
		closeDB(rs);
		closeDB(st);
		closeDB(con);
	}

	public static String JDBCTypeToName(int i) {
		String s = (String) JDBCTypeToNameTable.get(new Integer(i));
		if (s == null)
			s = new String("unknown");
		return s;
	}

	static Hashtable JDBCTypeToNameTable;

	static {

		if (JDBCTypeToNameTable == null) {
			JDBCTypeToNameTable = new Hashtable(49);
			JDBCTypeToNameTable.put(new Integer(-5), new String(
					"java.sql.Types.BIGINT"));
			JDBCTypeToNameTable.put(new Integer(-2), new String(
					"java.sql.Types.BINARY"));
			JDBCTypeToNameTable.put(new Integer(-7), new String(
					"java.sql.Types.BIT"));
			JDBCTypeToNameTable.put(new Integer(1), new String(
					"java.sql.Types.CHAR"));
			JDBCTypeToNameTable.put(new Integer(91), new String(
					"java.sql.Types.DATE"));
			JDBCTypeToNameTable.put(new Integer(3), new String(
					"java.sql.Types.DECIMAL"));
			JDBCTypeToNameTable.put(new Integer(8), new String(
					"java.sql.Types.DOUBLE"));
			JDBCTypeToNameTable.put(new Integer(6), new String(
					"java.sql.Types.FLOAT"));
			JDBCTypeToNameTable.put(new Integer(4), new String(
					"java.sql.Types.INTEGER"));
			JDBCTypeToNameTable.put(new Integer(-4), new String(
					"java.sql.Types.LONGVARBINARY"));
			JDBCTypeToNameTable.put(new Integer(-1), new String(
					"java.sql.Types.LONGVARCHAR"));
			JDBCTypeToNameTable.put(new Integer(0), new String(
					"java.sql.Types.NULL"));
			JDBCTypeToNameTable.put(new Integer(2), new String(
					"java.sql.Types.NUMERIC"));
			JDBCTypeToNameTable.put(new Integer(7), new String(
					"java.sql.Types.REAL"));
			JDBCTypeToNameTable.put(new Integer(5), new String(
					"java.sql.Types.SMALLINT"));
			JDBCTypeToNameTable.put(new Integer(92), new String(
					"java.sql.Types.TIME"));
			JDBCTypeToNameTable.put(new Integer(93), new String(
					"java.sql.Types.TIMESTAMP"));
			JDBCTypeToNameTable.put(new Integer(-6), new String(
					"java.sql.Types.TINYINT"));
			JDBCTypeToNameTable.put(new Integer(1111), new String(
					"java.sql.Types.OTHER"));
			JDBCTypeToNameTable.put(new Integer(-3), new String(
					"java.sql.Types.VARBINARY"));
			JDBCTypeToNameTable.put(new Integer(12), new String(
					"java.sql.Types.VARCHAR"));
			JDBCTypeToNameTable.put(new Integer(2003), new String(
					"java.sql.Types.ARRAY"));
			JDBCTypeToNameTable.put(new Integer(2004), new String(
					"java.sql.Types.BLOB"));
			JDBCTypeToNameTable.put(new Integer(2005), new String(
					"java.sql.Types.CLOB"));
			JDBCTypeToNameTable.put(new Integer(2001), new String(
					"java.sql.Types.DISTINCT"));
			JDBCTypeToNameTable.put(new Integer(2000), new String(
					"java.sql.Types.JAVA_OBJECT"));
			JDBCTypeToNameTable.put(new Integer(2002), new String(
					"java.sql.Types.STRUCT"));
		}

	}

}
