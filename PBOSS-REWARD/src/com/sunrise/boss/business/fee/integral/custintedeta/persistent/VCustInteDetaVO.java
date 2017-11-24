package com.sunrise.boss.business.fee.integral.custintedeta.persistent;

/**
 * @author mys
 * @version 1.0
 */
public class VCustInteDetaVO implements java.io.Serializable {


	private String id;
	private Long userid;
	private Long validbillcyc;
	private Long custid;
	
	/**  积分类型重0~7和月总积分  **/	
	private Long value0;
	private Long value1;
	private Long value2;
	private Long value3;
	private Long value5;
	private Long value6;
	private Long sumvalue;
	
	
	public Long getCustid() {
		return custid;
	}
	public void setCustid(Long custid) {
		this.custid = custid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getSumvalue() {
		return sumvalue;
	}
	public void setSumvalue(Long sumvalue) {
		this.sumvalue = sumvalue;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getValidbillcyc() {
		return validbillcyc;
	}
	public void setValidbillcyc(Long validbillcyc) {
		this.validbillcyc = validbillcyc;
	}
	public Long getValue0() {
		return value0;
	}
	public void setValue0(Long value0) {
		this.value0 = value0;
	}
	public Long getValue1() {
		return value1;
	}
	public void setValue1(Long value1) {
		this.value1 = value1;
	}
	public Long getValue2() {
		return value2;
	}
	public void setValue2(Long value2) {
		this.value2 = value2;
	}
	public Long getValue3() {
		return value3;
	}
	public void setValue3(Long value3) {
		this.value3 = value3;
	}
	public Long getValue5() {
		return value5;
	}
	public void setValue5(Long value5) {
		this.value5 = value5;
	}
	public Long getValue6() {
		return value6;
	}
	public void setValue6(Long value6) {
		this.value6 = value6;
	}

	
	

	

	

}