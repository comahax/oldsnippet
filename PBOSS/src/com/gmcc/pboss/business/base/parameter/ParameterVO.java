package com.gmcc.pboss.business.base.parameter;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ParameterVO extends BaseVO implements Serializable {

    /** identifier field */
	private String paramid;
	
	private String paramname;
	
	private String datatype;
	
	private Short manageable;
	
	private String mnglevel;
	
	private String paramtype;
	
	private Date createdate;
	
	private Short status;
	
	private Date statusdate;
	
    public ParameterVO(java.lang.String paramid, java.lang.String paramname, java.lang.String datatype, java.lang.Short manageable, java.lang.String mnglevel, java.lang.String paramtype, java.util.Date createdate, java.lang.Short status, java.util.Date statusdate) {
        this.paramid = paramid;
        this.paramname = paramname;
        this.datatype = datatype;
        this.manageable = manageable;
        this.mnglevel = mnglevel;
        this.paramtype = paramtype;
        this.status = status;
        this.statusdate = statusdate;
    }

    /** default constructor */
    public ParameterVO() {
    }

    /** minimal constructor */
    public ParameterVO(java.lang.String paramid) {
       this.paramid = paramid;
    }

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public Short getManageable() {
		return manageable;
	}

	public void setManageable(Short manageable) {
		this.manageable = manageable;
	}

	public String getMnglevel() {
		return mnglevel;
	}

	public void setMnglevel(String mnglevel) {
		this.mnglevel = mnglevel;
	}

	public String getParamid() {
		return paramid;
	}

	public void setParamid(String paramid) {
		this.paramid = paramid;
	}

	public String getParamname() {
		return paramname;
	}

	public void setParamname(String paramname) {
		this.paramname = paramname;
	}

	public String getParamtype() {
		return paramtype;
	}

	public void setParamtype(String paramtype) {
		this.paramtype = paramtype;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Date getStatusdate() {
		return statusdate;
	}

	public void setStatusdate(Date statusdate) {
		this.statusdate = statusdate;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("paramid", getParamid())
            
            .toString();
    }

   

}
