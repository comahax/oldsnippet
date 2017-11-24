package com.gmcc.pboss.business.sales.bgbusiness;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 装载合作商编码和套卡品牌的VO
 * @author zhangsiwei
 *
 */
public class PartnerSMPBrandVO implements Serializable{

	private String wayid;
	private String brand;
	private Long starlevel;
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public PartnerSMPBrandVO(String wayid,String brand) {
		this.wayid = wayid;
		this.brand = brand;
	}
	public PartnerSMPBrandVO(String wayid,String brand,Long starlevel) {
		this.wayid = wayid;
		this.brand = brand;
		this.starlevel = starlevel;
	}
	public PartnerSMPBrandVO() {
	}
	
	public boolean equals(Object other) {
		 if ( !(other instanceof PartnerSMPBrandVO) ) return false;
		 PartnerSMPBrandVO castOther = (PartnerSMPBrandVO) other;
	        return new EqualsBuilder()
	            .append(this.getWayid(), castOther.getWayid())
	            .append(this.getBrand(), castOther.getBrand())
	            .isEquals();
	}
	
	public int hashCode() {
        return new HashCodeBuilder()
            .append(getWayid())
            .append(getBrand())
            .toHashCode();
    }
	public Long getStarlevel() {
		return starlevel;
	}
	public void setStarlevel(Long starlevel) {
		this.starlevel = starlevel;
	}
}
