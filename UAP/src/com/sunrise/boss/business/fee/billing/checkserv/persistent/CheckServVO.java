package com.sunrise.boss.business.fee.billing.checkserv.persistent;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class CheckServVO extends BaseVO implements Serializable {

    private Long logid;

    private String servnumber;
    
    private Integer region;
    
	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public String getServnumber() {
		return servnumber;
	}

	public void setServnumber(String servnumber) {
		this.servnumber = servnumber;
	}

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

}
