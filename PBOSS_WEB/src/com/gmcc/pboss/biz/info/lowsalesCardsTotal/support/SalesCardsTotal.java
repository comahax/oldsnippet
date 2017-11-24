package com.gmcc.pboss.biz.info.lowsalesCardsTotal.support;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.biz.info.lowsalesCardsTotal.support.SalesCardsTotal;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;

public class SalesCardsTotal {

	public SalesCardsTotal(){
		super();
	}
	
	public SalesCardsTotal(String wayid,String countyid,String employeeid,
			String employeename,String officetel,String brand,
			String total//String opnid,String opnname,
			){
		super();
		this.wayid=wayid;
		this.countyid=countyid;
		if(countyid!=null)
			this.strcountyid = Constant.getCountyidchName(countyid);
		this.employeeid=employeeid;
		this.employeename=employeename;
		this.officetel=officetel;
		this.brand=brand;
		if (brand != null||!("".equals(brand)))
			this.brandName = Constant.getConstantName(ConstantsType.SIMBRAND,brand.toString());
		//this.opnid=opnid;
		//this.opnname=opnname;
		this.total = total;
	}
	public SalesCardsTotal(SalesCardsTotal sct ){
		super();
		this.wayid=sct.getWayid();
		this.countyid=sct.getCountyid();
		if(countyid!=null)
			this.strcountyid = Constant.getCountyidchName(countyid);
		this.employeeid=sct.getEmployeeid();
		this.employeename=sct.getEmployeename();
		this.officetel=sct.getOfficetel();
		this.brand=sct.getBrand();
		if (brand != null)
			this.brandName = Constant.getConstantName(ConstantsType.SIMBRAND,brand.toString());
		//this.opnid=sct.getOpnid();
		//this.opnname=sct.getOpnname();
		this.total = sct.getTotal();
		
	}
	
	//wayid,countyid查看明细时从页面取不到,从数据库中去出来
	private String wayid;
	private String countyid;
//	private String wayname;
//	private String starlevel;
	private String employeeid;
	private String strcountyid;
	
	private String total;
	private String commond;
	private String employeename;
	private String officetel;
//	private Short brand;
	private String brand;
	//private String opnid;
	//private String opnname;
	private String brandName;
	private Long cnt;
	
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getCommond() {
		return commond;
	}
	public void setCommond(String commond) {
		this.commond = commond;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getOfficetel() {
		return officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

	
	/**
	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getOpnname() {
		return opnname;
	}

	public void setOpnname(String opnname) {
		this.opnname = opnname;
	}
	**/

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public Long getCnt() {
		return cnt;
	}

	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}

	public String getStrcountyid() {
		return strcountyid;
	}

	public void setStrcountyid(String strcountyid) {
		this.strcountyid = strcountyid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	
}
