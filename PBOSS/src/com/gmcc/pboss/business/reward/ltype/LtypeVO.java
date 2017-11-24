package com.gmcc.pboss.business.reward.ltype;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.reward.ltypelog.LtypelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class LtypeVO extends BaseVO implements BusinessLog  {

	/** identifier field */
    private Long seq;
    
    /** identifier field */
    private String ltype;

    /** identifier field */
    private String optype;

    /** nullable persistent field */
    private String cityid;

    /** full constructor */
    public LtypeVO(Long seq,String ltype, String optype, String cityid) {
    	this.seq = seq;
    	this.ltype = ltype;
        this.optype = optype;
        this.cityid = cityid;
    }
    
    public LtypeVO(String optype, String ltype) {
    	this.ltype = ltype;
        this.optype = optype;
    }
	
    /** default constructor */
    public LtypeVO() {
    }
    
    /** minimal constructor */
    public LtypeVO(java.lang.Long seq) {
        this.seq = seq;
    }
   
    /** minimal constructor */
    public LtypeVO(String optype) {
        this.optype = optype;
    }

    public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public java.lang.String getLtype() {
        return this.ltype;
    }

    public void setLtype(java.lang.String ltype) {
        this.ltype = ltype;
    }

    public java.lang.String getOptype() {
        return this.optype;
    }

    public void setOptype(java.lang.String optype) {
        this.optype = optype;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }
    
    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof LtypeVO) ) return false;
        LtypeVO castOther = (LtypeVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return LtypelogVO.class;
	}

}
