package com.gmcc.pboss.biz.info.salesCardsTotal.support;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;

public class SalesCardsTotal {

	public SalesCardsTotal(){
		super();
	}
	//Short brand,Byte starlevel
	public SalesCardsTotal(String wayid,String wayname,String countyid,String starlevel,
			String employeename,String officetel,String mobile,String brand,String opnid,
			String opnname,String total){
		super();
		this.wayid=wayid;
		this.wayname=wayname;
		this.countyid=countyid;
		if(countyid!=null)
			this.strcountyid = Constant.getCountyidchName(countyid);
		this.starlevel=starlevel;
		if (starlevel != null)
			this.strstarlevel = Constant.getConstantName(ConstantsType.STARLEVEL,starlevel.toString());
		this.employeename=employeename;
		this.officetel=officetel;
		this.mobile=mobile;
		this.brand=brand;
//		if (brand != null)
//			this.brandName = Constant.getConstantName(ConstantsType.SIMBRAND,brand.toString());
		this.opnid=opnid;
		this.opnname=opnname;
		this.total=total;
	}
	
	public SalesCardsTotal(SalesCardsTotal sct ){
		super();
		this.wayid=sct.getWayid();
		this.wayname=sct.getWayname();
		this.countyid=sct.getCountyid();
		if(countyid!=null)
			this.strcountyid = Constant.getCountyidchName(countyid);
		this.starlevel=sct.getStarlevel();
		if (starlevel != null)
			this.strstarlevel = Constant.getConstantName(ConstantsType.STARLEVEL,starlevel.toString());
		this.employeename=sct.getEmployeename();
		this.officetel=sct.getOfficetel();
		this.mobile=sct.getMobile();
		this.brand=sct.getBrand();
//		if (brand != null)
//			this.brandName = Constant.getConstantName(ConstantsType.SIMBRAND,brand.toString());
		this.opnid=sct.getOpnid();
		this.opnname=sct.getOpnname();
		this.total=sct.getTotal();
	}
	
	

	private String officetel;
	private String mobile;
//	private Short brand;
	private String brand;
	private String opnid;
	private String opnname;
	private Long cnt;
	private String employeename;
	private String wayid;
	private String countyid;
	private String wayname;
//	private Byte starlevel;
	private String starlevel;
	private String strstarlevel;
	private String total;
	private String commond;
	private String strcountyid;
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
	public String getWayname() {
		return wayname;
	}
	public void setWayname(String wayname) {
		this.wayname = wayname;
	}
	
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

	public String getStrstarlevel() {
		return strstarlevel;
	}

	public void setStrstarlevel(String strstarlevel) {
		this.strstarlevel = strstarlevel;
	}

	public String getOfficetel() {
		return officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


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

	public Long getCnt() {
		return cnt;
	}

	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
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

	public String getStarlevel() {
		return starlevel;
	}

	public void setStarlevel(String starlevel) {
		this.starlevel = starlevel;
	}

	
}
