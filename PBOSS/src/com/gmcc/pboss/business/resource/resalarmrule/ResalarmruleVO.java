package com.gmcc.pboss.business.resource.resalarmrule;


import com.gmcc.pboss.business.resource.resalarmrulelog.ResalarmrulelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ResalarmruleVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String cityid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String comcategory;

    /** nullable persistent field */
    private Long lowstock;

    /** nullable persistent field */
    private Double upactrate;

    /** nullable persistent field */
    private String handlercode;

    /** full constructor */
    public ResalarmruleVO(java.lang.String cityid, java.lang.String countyid, java.lang.String comcategory, java.lang.Long lowstock, java.lang.Double upactrate, java.lang.String handlercode) {
        this.cityid = cityid;
        this.countyid = countyid;
        this.comcategory = comcategory;
        this.lowstock = lowstock;
        this.upactrate = upactrate;
        this.handlercode = handlercode;
    }

    /** default constructor */
    public ResalarmruleVO() {
    }

    /** minimal constructor */
    public ResalarmruleVO(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.Long getLowstock() {
        return this.lowstock;
    }

    public void setLowstock(java.lang.Long lowstock) {
        this.lowstock = lowstock;
    }

    public java.lang.Double getUpactrate() {
        return this.upactrate;
    }

    public void setUpactrate(java.lang.Double upactrate) {
        this.upactrate = upactrate;
    }

    public java.lang.String getHandlercode() {
        return this.handlercode;
    }

    public void setHandlercode(java.lang.String handlercode) {
        this.handlercode = handlercode;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ResalarmruleVO) ) return false;
        ResalarmruleVO castOther = (ResalarmruleVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return ResalarmrulelogVO.class;
	}

}
