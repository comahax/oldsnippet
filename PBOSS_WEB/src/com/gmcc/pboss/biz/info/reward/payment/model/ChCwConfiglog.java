package com.gmcc.pboss.biz.info.reward.payment.model;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * <p>
 * Title: ChCwConfiglog
 * </p>
 * <p>
 * Description: 酬金一体化配置日志表
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
public class ChCwConfiglog {

	private Long logid;

	private String oprcode;

	private String oprtype;

	private String success;

	private String key;

	private String value;

	private String explain;

	public ChCwConfiglog() {

	}

	public ChCwConfiglog(Long logid) {
		this.logid = logid;
	}

	public ChCwConfiglog(Long logid, String oprcode, String oprtype,
			String success, String key, String value, String explain) {
		this.logid = logid;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
		this.success = success;
		this.key = key;
		this.value = value;
		this.explain = explain;
	}

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
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
