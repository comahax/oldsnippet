package com.asisinfo.common.jdbc.dialect;


/**
 * An SQL dialect for Oracle 9 (uses ANSI-style syntax where possible).
 * 
 * @author Gavin King, David Channon
 */
public class Oracle9Dialect extends Dialect {

	public Oracle9Dialect() {
		super();
	}

	public String getAddColumnString() {
		return "add";
	}

	public String getSequenceNextValString(String sequenceName) {
		return "select " + sequenceName + ".nextval from dual";
	}

	public String getCreateSequenceString(String sequenceName) {
		return "create sequence " + sequenceName; // starts with 1, implicitly
	}

	public String getDropSequenceString(String sequenceName) {
		return "drop sequence " + sequenceName;
	}

	public String getCascadeConstraintsString() {
		return " cascade constraints";
	}

	public boolean dropConstraints() {
		return false;
	}

	public String getForUpdateNowaitString() {
		return " for update nowait";
	}

	public boolean supportsSequences() {
		return true;
	}

	public boolean supportsLimit() {
		return true;
	}

	public String getLimitString(String sql) {
		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);

		pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");

		pagingSelect.append(sql);

		pagingSelect.append(" ) row_ where rownum <= ?) where rownum_ > ?");

		return pagingSelect.toString();
	}
	
	public String getCountString(String sql){
		StringBuffer countSelect = new StringBuffer(sql.length() + 30);

		countSelect.append("select count(*) from ( ");
		countSelect.append(sql);
		countSelect.append(" )");

		return countSelect.toString();

	}
}
