package com.sunrise.boss.ui.commons.multiselect;

import java.io.Serializable;

public class MultiselectData implements Serializable {
	private static final long serialVersionUID = -3419344329648349451L;

	private String code;

	private String name;

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
}
