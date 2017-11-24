package com.sunrise.boss.ui.resmanage.common;

import com.sunrise.boss.ui.base.BaseActionForm;

public class ExceloutResForm extends BaseActionForm {
	private String property;

	private String[] properties;

	private String startindex;

	private String endindex;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		if (property != null && property.trim().length() > 0) {
			this.properties = property.split("\\,");
		}
		this.property = property;
	}

	public String[] getProperties() {
		return properties;
	}

	public void setProperties(String[] properties) {
		StringBuffer sb = new StringBuffer("");
		if (properties != null && properties.length > 0) {
			for (int i = 0; i < properties.length; i++) {
				if (i == properties.length - 1) {
					sb.append(properties[i]);
				} else {
					sb.append(properties[i]).append(",");
				}
			}
		}
		this.property = sb.toString();
		this.properties = properties;
	}

	public String getEndindex() {
		return endindex;
	}

	public void setEndindex(String endindex) {
		this.endindex = endindex;
	}

	public String getStartindex() {
		return startindex;
	}

	public void setStartindex(String startindex) {
		this.startindex = startindex;
	}
}
