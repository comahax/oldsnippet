package com.gmcc.pboss.business.resource.resloadparam;

import com.gmcc.pboss.business.resource.resloadparamlog.ResloadparamlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ResloadparamVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private Long id;

    /** persistent field */
    private String cityid;

    /** persistent field */
    private String restype;

    /** persistent field */
    private String receiveway;

    /** full constructor */
    public ResloadparamVO(java.lang.String cityid, java.lang.String restype, java.lang.String receiveway) {
        this.cityid = cityid;
        this.restype = restype;
        this.receiveway = receiveway;
    }

    /** default constructor */
    public ResloadparamVO() {
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getRestype() {
        return this.restype;
    }

    public void setRestype(java.lang.String restype) {
        this.restype = restype;
    }

    public java.lang.String getReceiveway() {
        return this.receiveway;
    }

    public void setReceiveway(java.lang.String receiveway) {
        this.receiveway = receiveway;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ResloadparamVO) ) return false;
        ResloadparamVO castOther = (ResloadparamVO) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return ResloadparamlogVO.class;
	}

}
