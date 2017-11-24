package com.sunrise.boss.business.fee.integral.custintedeta.persistent;

import java.util.Date;

public class CustInteDetaVO implements java.io.Serializable {

	// Fields

	private Long userid;
	private Long validbillcyc;
	private Long custid;
	private Integer jftype;
	
	private Long value;
	private Date oprtime;
	private String memo;
 

	//显示字段
	private String mobilenum;
	private String opercode;
	private Integer intchgrsn;
	private Short type;
	/**
	 * 积分类型重0~7和月总积分/备注
	 */
	private Long consumeinte;
	private Long innetinte;
	private Long creditinte;
	private Long tuneinte;
	private Long yearinte;
	private Long dataoperinte;
	private Long officialderateinte;
	private Long hortationinte;
	private Long sumValue;
	
	private String memo0;
	private String memo1;
	private String memo2;
	private String memo3;
	private String memo4;
	private String memo5;
	private String memo6;
	private String memo7;

	
	


	
	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public String getMemo0() {
		return memo0;
	}

	public void setMemo0(String memo0) {
		this.memo0 = memo0;
	}

	public String getMemo1() {
		return memo1;
	}

	public void setMemo1(String memo1) {
		this.memo1 = memo1;
	}

	public String getMemo2() {
		return memo2;
	}

	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}

	public String getMemo3() {
		return memo3;
	}

	public void setMemo3(String memo3) {
		this.memo3 = memo3;
	}

	public String getMemo4() {
		return memo4;
	}

	public void setMemo4(String memo4) {
		this.memo4 = memo4;
	}

	public String getMemo5() {
		return memo5;
	}

	public void setMemo5(String memo5) {
		this.memo5 = memo5;
	}

	public String getMemo6() {
		return memo6;
	}

	public void setMemo6(String memo6) {
		this.memo6 = memo6;
	}

	public String getMemo7() {
		return memo7;
	}

	public void setMemo7(String memo7) {
		this.memo7 = memo7;
	}

	public Integer getIntchgrsn() {
		return intchgrsn;
	}

	public void setIntchgrsn(Integer intchgrsn) {
		this.intchgrsn = intchgrsn;
	}

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getValidbillcyc() {
		return this.validbillcyc;
	}

	public void setValidbillcyc(Long validbillcyc) {
		this.validbillcyc = validbillcyc;
	}

	public Long getCustid() {
		return this.custid;
	}

	public void setCustid(Long custid) {
		this.custid = custid;
	}


	



	public String getOpercode() {
		return opercode;
	}

	public void setOpercode(String opercode) {
		this.opercode = opercode;
	}

	public String getMobilenum() {
		return mobilenum;
	}

	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}
	

	public Long getConsumeinte() {
		return consumeinte;
	}

	public void setConsumeinte(Long consumeinte) {
		this.consumeinte = consumeinte;
	}

	public Long getCreditinte() {
		return creditinte;
	}

	public void setCreditinte(Long creditinte) {
		this.creditinte = creditinte;
	}

	public Long getDataoperinte() {
		return dataoperinte;
	}

	public void setDataoperinte(Long dataoperinte) {
		this.dataoperinte = dataoperinte;
	}

	public Long getHortationinte() {
		return hortationinte;
	}

	public void setHortationinte(Long hortationinte) {
		this.hortationinte = hortationinte;
	}

	public Long getInnetinte() {
		return innetinte;
	}

	public void setInnetinte(Long innetinte) {
		this.innetinte = innetinte;
	}

	public Long getOfficialderateinte() {
		return officialderateinte;
	}

	public void setOfficialderateinte(Long officialderateinte) {
		this.officialderateinte = officialderateinte;
	}

	public Long getSumValue() {
		return sumValue;
	}

	public void setSumValue(Long sumValue) {
		this.sumValue = sumValue;
	}

	public Long getTuneinte() {
		return tuneinte;
	}

	public void setTuneinte(Long tuneinte) {
		this.tuneinte = tuneinte;
	}

	public Long getYearinte() {
		return yearinte;
	}

	public void setYearinte(Long yearinte) {
		this.yearinte = yearinte;
	}

	public Integer getJftype() {
		return this.jftype;
	}

	public void setJftype(Integer jftype) {
		this.jftype = jftype;
	}

	public Long getValue() {
		return this.value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public Date getOprtime() {
		return this.oprtime;
	}

	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CustInteDetaVO))
			return false;
		CustInteDetaVO castOther = (CustInteDetaVO) other;

		return ((this.getUserid() == castOther.getUserid()) || (this
				.getUserid() != null
				&& castOther.getUserid() != null && this.getUserid().equals(
				castOther.getUserid())))
				&& ((this.getValidbillcyc() == castOther.getValidbillcyc()) || (this
						.getValidbillcyc() != null
						&& castOther.getValidbillcyc() != null && this
						.getValidbillcyc().equals(castOther.getValidbillcyc())))
				&& ((this.getCustid() == castOther.getCustid()) || (this
						.getCustid() != null
						&& castOther.getCustid() != null && this.getCustid()
						.equals(castOther.getCustid())))
				&& ((this.getJftype() == castOther.getJftype()) || (this
						.getJftype() != null
						&& castOther.getJftype() != null && this.getJftype()
						.equals(castOther.getJftype())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserid() == null ? 0 : this.getUserid().hashCode());
		result = 37
				* result
				+ (getValidbillcyc() == null ? 0 : this.getValidbillcyc()
						.hashCode());
		result = 37 * result
				+ (getCustid() == null ? 0 : this.getCustid().hashCode());
		result = 37 * result
				+ (getJftype() == null ? 0 : this.getJftype().hashCode());
		return result;
	}

	

}