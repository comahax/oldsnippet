package com.gmcc.pboss.business.sales.bgbusiness;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 装载分公司编码和套卡品牌的VO
 * @author zhangsiwei
 *
 */
public class SMPCountyBrandVO implements Serializable {

	private String countyid;
	private String brand;
	
	public SMPCountyBrandVO(String countyid, String brand) {
		this.countyid = countyid;
		this.brand = brand;
	}
	
	public SMPCountyBrandVO() {
	}
	
	public String getCountyid() {
		return countyid;
	}
	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public boolean equals(Object other) {
		if( !(other instanceof SMPCountyBrandVO)) return false;
		SMPCountyBrandVO castother = (SMPCountyBrandVO)other;
		return new EqualsBuilder()
	        .append(this.getCountyid(), castother.getCountyid())
	        .append(this.getBrand(), castother.getBrand())
	        .isEquals();
	}
	
	public int hashCode() {
        return new HashCodeBuilder()
            .append(getCountyid())
            .append(getBrand())
            .toHashCode();
    }
	
}
