package com.sunrise.boss.business.cms.bbc.jfopnmap.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.bbc.jfopnmaplog.persistent.JfopnmaplogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class JfopnmapVO implements OperationLog {
	    
    private String opnid;
    
    private String entid;
    
    private String busiid;
    
    private String cityid;
    
    public String getBusiid() {
		return busiid;
	}

	public void setBusiid(String busiid) {
		this.busiid = busiid;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getEntid() {
		return entid;
	}

	public void setEntid(String entid) {
		this.entid = entid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	/** full constructor */
    public JfopnmapVO(java.lang.String opnid, java.lang.String entid, java.lang.String busiid, java.lang.String cityid){
        this.opnid = opnid;
        this.entid = entid;
        this.busiid = busiid;
        this.cityid = cityid;
    }

    /** default constructor */
    public JfopnmapVO() {
    }

    /** minimal constructor */
    public JfopnmapVO(java.lang.String entid, java.lang.String busiid, java.lang.String opnid) {
        this.entid = entid;
        this.busiid = busiid;
        this.opnid = opnid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("entid", this.getEntid())
            .append("busiid", this.getBusiid())
            .append("opnid", this.getOpnid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof JfopnmapVO) ) return false;
        JfopnmapVO castOther = (JfopnmapVO) other;
        return new EqualsBuilder()
            .append(this.getEntid(), castOther.getEntid())
            .append(this.getBusiid(), castOther.getBusiid())
            .append(this.getOpnid(), castOther.getOpnid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getEntid())
            .append(getBusiid())
            .append(getOpnid())
            .toHashCode();
    }

	public String getOpnid() {
		return opnid;
	}

	public Class logVOClass() {
		return JfopnmaplogVO.class;
	}

}
