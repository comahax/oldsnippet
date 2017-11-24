package com.sunrise.boss.business.cms.distribute.cpexam.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.distribute.cpexamlog.persistent.CpexamlogVO;

import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class CpexamVO implements  OperationLog {

    /** identifier field */
    private java.lang.Long examid;

    /** persistent field */
    private String cooperauid;

    /** persistent field */
    private java.lang.Long comtype;

    /** persistent field */
    private Short examtype;

    /** persistent field */
    private Double examresult;

    /** persistent field */
    private java.lang.Long basenum;

    /** persistent field */
    private java.lang.Long realnum;

    /** full constructor */
    public CpexamVO(java.lang.Long examid, java.lang.String cooperauid, java.lang.Long comtype, java.lang.Short examtype, java.lang.Double examresult, java.lang.Long basenum, java.lang.Long realnum) {
        this.examid = examid;
        this.cooperauid = cooperauid;
        this.comtype = comtype;
        this.examtype = examtype;
        this.examresult = examresult;
        this.basenum = basenum;
        this.realnum = realnum;
    }

    /** default constructor */
    public CpexamVO() {
    }
    
    public Class logVOClass() {
    	return CpexamlogVO.class;
    }

   

    public java.lang.String getCooperauid() {
        return this.cooperauid;
    }

    public void setCooperauid(java.lang.String cooperauid) {
        this.cooperauid = cooperauid;
    }

   
    public java.lang.Short getExamtype() {
        return this.examtype;
    }

    public void setExamtype(java.lang.Short examtype) {
        this.examtype = examtype;
    }

    public java.lang.Double getExamresult() {
        return this.examresult;
    }

    public void setExamresult(java.lang.Double examresult) {
        this.examresult = examresult;
    }

   

    public String toString() {
        return new ToStringBuilder(this)
            .append("examid", getExamid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CpexamVO) ) return false;
        CpexamVO castOther = (CpexamVO) other;
        return new EqualsBuilder()
            .append(this.getExamid(), castOther.getExamid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getExamid())
            .toHashCode();
    }

	public java.lang.Long getBasenum() {
		return basenum;
	}

	public void setBasenum(java.lang.Long basenum) {
		this.basenum = basenum;
	}

	public java.lang.Long getComtype() {
		return comtype;
	}

	public void setComtype(java.lang.Long comtype) {
		this.comtype = comtype;
	}

	public java.lang.Long getExamid() {
		return examid;
	}

	public void setExamid(java.lang.Long examid) {
		this.examid = examid;
	}

	public java.lang.Long getRealnum() {
		return realnum;
	}

	public void setRealnum(java.lang.Long realnum) {
		this.realnum = realnum;
	}

}
