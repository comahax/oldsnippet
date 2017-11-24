package com.sunrise.boss.business.cms.reward.creditstd3g.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.creditstd3glog.persistent.Creditstd3glogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class Creditstd3gVO implements OperationLog,Serializable {

    /** identifier field */
    private Short cityid;

    /** identifier field */
    private String wayattr;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private Double creditstd;

    /** nullable persistent field */
    private Double terminalstd;

    /** nullable persistent field */
    private Double zcterminalstd;

    /** nullable persistent field */
    private Short intvmonth;
    
	//רӪ��������׼
    private Double zyrewardstd;
    //���ֽ�������׼���ŵ겹�����ޣ�
    private Double jfrewardstd;
    //��������ֵ
    private Double jfcreditstd;
    //ȫ��ͨ��������Ҫ��
    private Double gtnstd;

    /** full constructor */
    public Creditstd3gVO(java.lang.Short cityid, java.lang.String wayattr, java.lang.Double rewardstd, java.lang.Double creditstd, java.lang.Double terminalstd, java.lang.Double zcterminalstd, java.lang.Short intvmonth) {
        this.cityid = cityid;
        this.wayattr = wayattr;
        this.rewardstd = rewardstd;
        this.creditstd = creditstd;
        this.terminalstd = terminalstd;
        this.zcterminalstd = zcterminalstd;
        this.intvmonth = intvmonth;
    }

    /** default constructor */
    public Creditstd3gVO() {
    }

    /** minimal constructor */
    public Creditstd3gVO(java.lang.Short cityid, java.lang.String wayattr) {
        this.cityid = cityid;
        this.wayattr = wayattr;
    }

    public java.lang.Short getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.Short cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getWayattr() {
        return this.wayattr;
    }

    public void setWayattr(java.lang.String wayattr) {
        this.wayattr = wayattr;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.Double getCreditstd() {
        return this.creditstd;
    }

    public void setCreditstd(java.lang.Double creditstd) {
        this.creditstd = creditstd;
    }

    public java.lang.Double getTerminalstd() {
        return this.terminalstd;
    }

    public void setTerminalstd(java.lang.Double terminalstd) {
        this.terminalstd = terminalstd;
    }

    public java.lang.Double getZcterminalstd() {
        return this.zcterminalstd;
    }

    public void setZcterminalstd(java.lang.Double zcterminalstd) {
        this.zcterminalstd = zcterminalstd;
    }

    public java.lang.Short getIntvmonth() {
        return this.intvmonth;
    }

    public void setIntvmonth(java.lang.Short intvmonth) {
        this.intvmonth = intvmonth;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("wayattr", getWayattr())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof Creditstd3gVO) ) return false;
        Creditstd3gVO castOther = (Creditstd3gVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getWayattr(), castOther.getWayattr())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getWayattr())
            .toHashCode();
    }
    
    public Class logVOClass() {
		// TODO Auto-generated method stub
    	return Creditstd3glogVO.class;
    }

	public Double getZyrewardstd() {
		return zyrewardstd;
	}

	public void setZyrewardstd(Double zyrewardstd) {
		this.zyrewardstd = zyrewardstd;
	}

	public Double getJfrewardstd() {
		return jfrewardstd;
	}

	public void setJfrewardstd(Double jfrewardstd) {
		this.jfrewardstd = jfrewardstd;
	}

	public Double getJfcreditstd() {
		return jfcreditstd;
	}

	public void setJfcreditstd(Double jfcreditstd) {
		this.jfcreditstd = jfcreditstd;
	}

	public Double getGtnstd() {
		return gtnstd;
	}

	public void setGtnstd(Double gtnstd) {
		this.gtnstd = gtnstd;
	}

}
