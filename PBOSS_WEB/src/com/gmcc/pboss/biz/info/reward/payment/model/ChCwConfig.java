package com.gmcc.pboss.biz.info.reward.payment.model;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * <p>
 * Title: ChCwConfig
 * </p>
 * <p>
 * Description: 酬金一体化配置表
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author caiwr
 * @version 1.0
 */
public class ChCwConfig {
	private String key;

	private String value;

	private String explain;

	public ChCwConfig() {

	}

	public ChCwConfig(String key) {
		this.key = key;
	}

	public ChCwConfig(String key, String value, String explain) {
		this.key = key;
		this.value = value;
		this.explain = explain;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
