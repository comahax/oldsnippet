package com.gmcc.pboss.biz.info.salesDetail.model;

import java.io.Serializable;
import java.util.Date;

import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RegisternewDetail implements Serializable {	
	private String wayid;
	private String wayname;
	private String countyid;
	private String strcountyid;
	private String starlevel;
	private String strstarlevel;
	private String employeename;
	private String officetel;
	private String mobile;
	private String brand;
	private String brandName;
	private String opnid;
	private String opnname;
	//private Date oprtime;
	private String oprtime;//查询时转换成字符串，方便输出
	
	public RegisternewDetail(){
		;
	}
	
	public RegisternewDetail(String wayid, String wayname, String countyid, String starlevel, 
			String employeename,String officetel, String mobile, String brand, 
			String opnid, String opnname, String oprtime){
		this.wayid = wayid;
		this.wayname = wayname;
		this.countyid = countyid;
		if(countyid!=null)
			this.strcountyid = Constant.getCountyidchName(countyid);
		this.starlevel = starlevel;
		if (starlevel != null)
			this.strstarlevel = Constant.getConstantName(ConstantsType.STARLEVEL,starlevel.toString());
		this.employeename = employeename;
		this.officetel = officetel;
		this.mobile = mobile;
		this.brand = brand;
		if (brand != null)
			this.brandName = Constant.getConstantName(ConstantsType.SIMBRAND,brand.toString());
		this.opnid = opnid;
		this.opnname = opnname;
		this.oprtime = oprtime;
	}
	
	public void setWayid(String wayid){
		this.wayid = wayid;
	}
	public String getWayid(){
		return this.wayid;
	}

	public String getWayname() {
		return this.wayname;
	}
	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public String getCountyid() {
		return this.countyid;
	}
	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getStarlevel() {
		return this.starlevel;
	}
	public void setStarlevel(String starlevel) {
		this.starlevel = starlevel;
	}
	
	public String getEmployeename() {
		return this.employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	
	public void setOfficetel(String officetel){
		this.officetel = officetel;
	}
	public String getOfficetel(){
		return this.officetel;
	}
	
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	public String getMobile(){
		return this.mobile;
	}
	
	public void setBrand(String brand){
		this.brand = brand;
	}
	public String getBrand(){
		return this.brand;
	}
	
	public void setOpnid(String opnid){
		this.opnid = opnid;
	}
	public String getOpnid(){
		return this.opnid;
	}
	
	public void setOpnname(String opnname){
		this.opnname = opnname;
	}
	public String getOpnname(){
		return this.opnname;
	}
	
	public void setOprtime(String date){
		this.oprtime = date;
	}
	public String getOprtime(){
		return this.oprtime;
	}
	
	public String getStrstarlevel() {
		return strstarlevel;
	}
	public void setStrstarlevel(String strstarlevel) {
		this.strstarlevel = strstarlevel;
	}
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public String getStrcountyid() {
		return strcountyid;
	}
	public void setStrcountyid(String strcountyid) {
		this.strcountyid = strcountyid;
	}
}
