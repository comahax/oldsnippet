package com.gmcc.pboss.common.support;
/**
 * 
 * @author yws
 *
 */
public class ExcelColumn {
	/**
	 * 属性名
	 */
	private String dataKey;
	/**
	 * 列名
	 */
	private String name;
	/**
	 * 列宽
	 */
	private int colWidth;
	/**
	 * 日期格式
	 */
	private String dateFormat;

	public String getDataKey() {
		return dataKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getColWidth() {
		return colWidth;
	}

	public void setColWidth(int colWidth) {
		this.colWidth = colWidth;
	}
	
	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public ExcelColumn(String dataKey, String name, int colWidth) {
		super();
		this.dataKey = dataKey;
		this.name = name;
		this.colWidth = colWidth;
	}
	
	public ExcelColumn(String dataKey, String name, int colWidth,String dateFormat) {
		super();
		this.dataKey = dataKey;
		this.name = name;
		this.colWidth = colWidth;
		this.dateFormat = dateFormat;
	}

}
