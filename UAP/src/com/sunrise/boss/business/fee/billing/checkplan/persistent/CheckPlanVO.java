package com.sunrise.boss.business.fee.billing.checkplan.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class CheckPlanVO extends BaseVO implements Serializable {

	/** identifier field */
    private Long logid;
    
    private Long batch;
    
    private String prodid;
    
    private String prodname;
    
    private Long subsid;
    
    private String servnumber;
    
    private String tariffitemid;
    
    private Integer region;
    

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public Long getBatch() {
		return batch;
	}

	public void setBatch(Long batch) {
		this.batch = batch;
	}

	public String getProdid() {
		return prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public Long getSubsid() {
		return subsid;
	}

	public void setSubsid(Long subsid) {
		this.subsid = subsid;
	}

	public String getServnumber() {
		return servnumber;
	}

	public void setServnumber(String servnumber) {
		this.servnumber = servnumber;
	}

	public String getTariffitemid() {
		return tariffitemid;
	}

	public void setTariffitemid(String tariffitemid) {
		this.tariffitemid = tariffitemid;
	}

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public boolean equals(Object other) {
        if ( !(other instanceof CheckPlanVO) ) return false;
        CheckPlanVO castOther = (CheckPlanVO) other;
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
