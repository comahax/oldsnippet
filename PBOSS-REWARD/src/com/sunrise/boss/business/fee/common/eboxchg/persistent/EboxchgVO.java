package com.sunrise.boss.business.fee.common.eboxchg.persistent;

import java.io.Serializable;
import java.sql.Timestamp;
//import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class EboxchgVO implements Serializable {
	private static final long serialVersionUID = -8522188991244049186L;

	private Long logid; // 帐本变更日志标识

	private Long eboxid; // 帐户标识

	private Long eboxunitid; // 帐本科目标识

	private Long eboxunitdetid; // 帐本科目明细标识

	private Double beforechgamt; // 变前金额

	private Double afterchgamt; // 变后金额

	private String opercode; // 发起人工号

	private String reason; // 变更原因
	
	private String reason2; // 二级变更原因

	private java.sql.Timestamp chgtime; // 变更时间

	private String source; // 来源
	
	private Long yxplanid; //营销方案标识

	public EboxchgVO(Double afterchgamt, Double beforechgamt, java.sql.Timestamp chgtime, Long eboxid, Long eboxunitdetid, Long eboxunitid, Long logid, String opercode, String reason, String source, Long yxplanid) {
		this.afterchgamt = afterchgamt;
		this.beforechgamt = beforechgamt;
		this.chgtime = chgtime;
		this.eboxid = eboxid;
		this.eboxunitdetid = eboxunitdetid;
		this.eboxunitid = eboxunitid;
		this.logid = logid;
		this.opercode = opercode;
		this.reason = reason;
		this.source = source;
		this.yxplanid = yxplanid;
	}
	
	
	public EboxchgVO(Long logid, Long eboxid, Long eboxunitid, Long eboxunitdetid, Double beforechgamt, Double afterchgamt, String opercode, String reason, String reason2, Timestamp chgtime, String source, Long yxplanid) {
		super();
		// TODO Auto-generated constructor stub
		this.logid = logid;
		this.eboxid = eboxid;
		this.eboxunitid = eboxunitid;
		this.eboxunitdetid = eboxunitdetid;
		this.beforechgamt = beforechgamt;
		this.afterchgamt = afterchgamt;
		this.opercode = opercode;
		this.reason = reason;
		this.reason2 = reason2;
		this.chgtime = chgtime;
		this.source = source;
		this.yxplanid = yxplanid;
	}


	public EboxchgVO() {
	}


	public EboxchgVO(Long logid) {
		this.logid = logid;
	}

	public Long getYxplanid() {
		return yxplanid;
	}

	public void setYxplanid(Long yxplanid) {
		this.yxplanid = yxplanid;
	}

	public Double getAfterchgamt() {
		return afterchgamt;
	}

	public void setAfterchgamt(Double afterchgamt) {
		this.afterchgamt = afterchgamt;
	}

	public Double getBeforechgamt() {
		return beforechgamt;
	}

	public void setBeforechgamt(Double beforechgamt) {
		this.beforechgamt = beforechgamt;
	}

	public java.sql.Timestamp getChgtime() {
		return chgtime;
	}

	public void setChgtime(java.sql.Timestamp chgtime) {
		this.chgtime = chgtime;
	}

	public Long getEboxid() {
		return eboxid;
	}

	public void setEboxid(Long eboxid) {
		this.eboxid = eboxid;
	}

	public Long getEboxunitdetid() {
		return eboxunitdetid;
	}

	public void setEboxunitdetid(Long eboxunitdetid) {
		this.eboxunitdetid = eboxunitdetid;
	}

	public Long getEboxunitid() {
		return eboxunitid;
	}

	public void setEboxunitid(Long eboxunitid) {
		this.eboxunitid = eboxunitid;
	}

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public String getOpercode() {
		return opercode;
	}

	public void setOpercode(String opercode) {
		this.opercode = opercode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	
	public String getReason2() {
		return reason2;
	}

	public void setReason2(String reason2) {
		this.reason2 = reason2;
	}

	public boolean equals(Object other) {
		if (!(other instanceof EboxchgVO))
			return false;
		EboxchgVO castOther = (EboxchgVO) other;
		return new EqualsBuilder()
				.append(this.getLogid(), castOther.getLogid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getLogid()).toHashCode();
	}

}
