package com.sunrise.jop.ui.component;

/**
 * 
 * @author He Kun
 *
 */
public class Node {

	private String valueObject;

	private String code;

	private String name;

	private String sql;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValueObject() {
		return valueObject;
	}

	public void setValueObject(String valueObject) {
		this.valueObject = valueObject;
	}
	
	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String toString() {
//		ToStringStyle style =new ManageLogToStringStyle();
//		return ReflectionToStringBuilder.toString(this, style);		
		StringBuffer buffer = new StringBuffer(32);
		buffer.append("[Code2Name Node:")
				.append("code=")
				.append(code)
				.append(",")
				.append("name=")
				.append(name)				
				.append(",")
				.append("condition=")
				.append(sql)				
				.append("]");
		return buffer.toString();
		
	}
}
