package com.sunrise.boss.business.fee.integral.custinte.persistent;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CustInteVO implements Serializable {

	private Long custid;

	private Long integralcyc;

	private Long integral;

	private Long availintegral;

	private Long moveint;

	private Date starttime;

	private Date stoptime;
 
	private Date updatetime;

	private Long unavailint;

	private Long saleint;

	private String memo;

	//业务需要多出的字段
	private Long inte;		//资格要减去的那一部分积分值
	private Long userid;
	private String mobileno;

	
	
	
	
	
	
	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}


	public Long getInte() {
		return inte;
	}

	public void setInte(Long inte) {
		this.inte = inte;
	}

	public Long getSaleint() {
		return saleint;
	}

	public void setSaleint(Long saleint) {
		this.saleint = saleint;
	}

	public Long getCustid() {
		return custid;
	}

	public void setCustid(Long custid) {
		this.custid = custid;
	}

	public Long getIntegralcyc() {
		return integralcyc;
	}

	public void setIntegralcyc(Long integralcyc) {
		this.integralcyc = integralcyc;
	}

	/** default constructor */
	public CustInteVO() {
	}

	/** minimal constructor */
	public CustInteVO(Long custid, Long integralcyc) {
		this.custid = custid;
		this.integralcyc = integralcyc;
	}

	/** full constructor */
	public CustInteVO(Long custid, Long integralcyc, Long integral,
			Long availintegral, Long moveint, Date starttime, Date stoptime,
			Date updatetime, Long unavailint, Long saleint, String memo) {
		this.custid = custid;
		this.integralcyc = integralcyc;
		this.integral = integral;
		this.availintegral = availintegral;
		this.moveint = moveint;
		this.starttime = starttime;
		this.stoptime = stoptime;
		this.updatetime = updatetime;
		this.unavailint = unavailint;
		this.saleint = saleint;
		this.memo = memo;
	}

	// Property accessors

	public Long getIntegral() {
		return this.integral;
	}

	public void setIntegral(Long integral) {
		this.integral = integral;
	}

	public Long getAvailintegral() {
		return this.availintegral;
	}

	public void setAvailintegral(Long availintegral) {
		this.availintegral = availintegral;
	}

	public Long getMoveint() {
		return this.moveint;
	}

	public void setMoveint(Long moveint) {
		this.moveint = moveint;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getStoptime() {
		return this.stoptime;
	}

	public void setStoptime(Date stoptime) {
		this.stoptime = stoptime;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Long getUnavailint() {
		return this.unavailint;
	}

	public void setUnavailint(Long unavailint) {
		this.unavailint = unavailint;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String toString() {
		return new ToStringBuilder(this).append("custid", getCustid())
				.toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof CustInteVO))
			return false;
		CustInteVO castOther = (CustInteVO) other;
		return new EqualsBuilder().append(this.getCustid(),
				castOther.getCustid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getCustid()).toHashCode();
	}

}
