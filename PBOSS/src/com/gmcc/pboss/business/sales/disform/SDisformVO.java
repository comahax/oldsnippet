package com.gmcc.pboss.business.sales.disform;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class SDisformVO extends BaseVO implements Serializable {

    /** identifier field */
    /** persistent field */
    private String disstate;
    
    private String countyid;
    
    private Long num;
    
    private Long signnum;
    
    private Long unsignnum;
    
    private String mareacode;
    
    private String svccode;
    
//    private java.util.Date createtime;
    
    /** full constructor */
    public SDisformVO(java.lang.String disstate,java.lang.String countyid,java.lang.String svccode, java.lang.String mareacode, java.lang.Long num, java.lang.Long signnum, java.lang.Long unsignnum, java.util.Date createtime) {
    	this.disstate = disstate;
        this.countyid = countyid;
        this.svccode = svccode;
        this.mareacode = mareacode;
        this.signnum = signnum;
        this.unsignnum = unsignnum;
        this.num = num;
    }

    /** default constructor */
    public SDisformVO() {
    }

//    public java.util.Date getCreatetime() {
//		return createtime;
//	}
//
//	public void setCreatetime(java.util.Date createtime) {
//		this.createtime = createtime;
//	}

	/** minimal constructor */
    public SDisformVO(java.lang.String disstate) {
        this.disstate = disstate;
    }



//    public String toString() {
//        return new ToStringBuilder(this)
//            .append("recid", getRecid())
//            .toString();
//    }
//
//    public boolean equals(Object other) {
//        if ( !(other instanceof SDisformVO) ) return false;
//        SDisformVO castOther = (SDisformVO) other;
//        return new EqualsBuilder()
//            .append(this.getRecid(), castOther.getRecid())
//            .isEquals();
//    }
//
//    public int hashCode() {
//        return new HashCodeBuilder()
//            .append(getRecid())
//            .toHashCode();
//    }

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getDisstate() {
		return disstate;
	}

	public void setDisstate(String disstate) {
		this.disstate = disstate;
	}

	public String getMareacode() {
		return mareacode;
	}

	public void setMareacode(String mareacode) {
		this.mareacode = mareacode;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getSvccode() {
		return svccode;
	}

	public void setSvccode(String svccode) {
		this.svccode = svccode;
	}

	public Long getSignnum() {
		return signnum;
	}

	public void setSignnum(Long signnum) {
		this.signnum = signnum;
	}

	public Long getUnsignnum() {
		return unsignnum;
	}

	public void setUnsignnum(Long unsignnum) {
		this.unsignnum = unsignnum;
	}
}
