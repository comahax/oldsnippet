package com.gmcc.pboss.business.sales.ordercomcate;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OrdercomcateStocksVO extends BaseVO implements Serializable {



    /** persistent field */
    private String ordercomtype;

    /** persistent field */
    private String comcategory;

    /** persistent field */
    private Long orderamt;

    private String countyid;
    private String svccode;
	public String getOrdercomtype() {
		return ordercomtype;
	}
	public void setOrdercomtype(String ordercomtype) {
		this.ordercomtype = ordercomtype;
	}
	public String getComcategory() {
		return comcategory;
	}
	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}
	public Long getOrderamt() {
		return orderamt;
	}
	public void setOrderamt(Long orderamt) {
		this.orderamt = orderamt;
	}
	public String getCountyid() {
		return countyid;
	}
	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}
	public String getSvccode() {
		return svccode;
	}
	public void setSvccode(String svccode) {
		this.svccode = svccode;
	}
    
   

}
