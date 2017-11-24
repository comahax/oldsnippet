package com.sunrise.boss.business.fee.billing.uapreq.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class UapReqVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** persistent field */
    private Long validbillcyc;

    /** persistent field */
    private Long batch;

    /** persistent field */
    private String req_type;

    /** nullable persistent field */
    private String req_dst;

    /** persistent field */
    private Short state;

    /** nullable persistent field */
    private java.util.Date req_time;
    
    private java.util.Date deal_time;

    /** persistent field */
    private String operator;

    /** nullable persistent field */
    private String param;

    /** persistent field */
    private Integer region;

    /** nullable persistent field */
    private String remark;

    

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public Long getValidbillcyc() {
		return validbillcyc;
	}

	public void setValidbillcyc(Long validbillcyc) {
		this.validbillcyc = validbillcyc;
	}

	public Long getBatch() {
		return batch;
	}

	public void setBatch(Long batch) {
		this.batch = batch;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public String getReq_type() {
		return req_type;
	}

	public void setReq_type(String req_type) {
		this.req_type = req_type;
	}

	public String getReq_dst() {
		return req_dst;
	}

	public void setReq_dst(String req_dst) {
		this.req_dst = req_dst;
	}

	public java.util.Date getReq_time() {
		return req_time;
	}

	public void setReq_time(java.util.Date req_time) {
		this.req_time = req_time;
	}

	public java.util.Date getDeal_time() {
		return deal_time;
	}

	public void setDeal_time(java.util.Date deal_time) {
		this.deal_time = deal_time;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean equals(Object other) {
        if ( !(other instanceof UapReqVO) ) return false;
        UapReqVO castOther = (UapReqVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
