package com.gmcc.pboss.business.sales.bgbusiness;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
/**
 * 装载处理人工号和分公司的VO
 * @author zhangsiwei
 *
 */
public class HandlerCountyVO implements Serializable{

	private String handlerCode;
	private String countyid;
	
	public HandlerCountyVO(String handlerCode, String countyid) {
		this.handlerCode = handlerCode;
		this.countyid = countyid;
	}
	public HandlerCountyVO() {}
	
	public String getHandlerCode() {
		return handlerCode;
	}
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}
	public String getCountyid() {
		return countyid;
	}
	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}
	public boolean equals(Object other) {
		if(!(other instanceof HandlerCountyVO)) return false;
		HandlerCountyVO castOther = (HandlerCountyVO)other;
		 return new EqualsBuilder().
		 	append(this.getHandlerCode(), castOther.getHandlerCode())
		 	.append(this.getCountyid(),castOther.getCountyid())
		 	.isEquals();
	}
	public int hashCode() {
		 return new HashCodeBuilder()
		 	.append(this.getHandlerCode())
		 	.append(this.getCountyid())
		 	.toHashCode();
	}
}
