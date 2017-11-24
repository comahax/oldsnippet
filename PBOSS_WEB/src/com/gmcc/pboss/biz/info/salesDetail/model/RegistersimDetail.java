package com.gmcc.pboss.biz.info.salesDetail.model;

import java.io.Serializable;
import java.util.Date;

import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;

public class RegistersimDetail implements Serializable {
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
	private String comname;
	private String comtype;
	private String brandName;
	private String comclassid;
	private String comprice;
	//private Date oprtime;
	//private Date activedate;
	private String oprtime;
	private String activedate;
	private String flag;	

	public RegistersimDetail(){}
	
	public RegistersimDetail(String wayid, String wayname, String countyid, String starlevel, 
			String employeename,String officetel, String mobile, String brand,String comname,String comtype,
			String comclassid, String comprice, String oprtime, String activedate, String flag){
		this.wayid = wayid;
		this.wayname = wayname;
		this.countyid = countyid;
		if(countyid!=null)
			this.strcountyid = Constant.getCountyidchName(countyid);
		this.starlevel = starlevel;
		if (starlevel!= null){
			this.strstarlevel = Constant.getConstantName(ConstantsType.STARLEVEL,starlevel.toString());
		}
		this.employeename = employeename;
		this.officetel = officetel;
		this.mobile = mobile;
		this.brand = brand;
		if (brand != null){
			this.brandName = Constant.getConstantName(ConstantsType.SIMBRAND,brand.toString());
		}
		this.comname = comname;
		this.comtype = comtype;
		if(comtype!=null){
			this.comtype = Constant.getConstantName(ConstantsType.IM_COMTYPE2,comtype.toString());
		}
		if(comclassid!=null && !comclassid.equals("")){
			this.comclassid = Constant.getConstantName(ConstantsType.IM_COMTYPE, comclassid.toString());
		}
		else{
			this.comclassid = null;
		}
		this.comprice = comprice;
		this.oprtime = oprtime;
		this.activedate = activedate;
		if(flag!=null && !"".equals(flag)){
			this.flag = Constant.getConstantName(ConstantsType.CH_MFLAG, flag.toString());
		}
		else{
			this.flag=null;
		}
	}
	
//	public RegistersimDetail(String wayid, String wayname, String countyid, String starlevel, 
//			String employeename,String officetel, String mobile, String brand,
//			String comclassid, String comprice, String oprtime, String activedate, String flag){
//		this.wayid = wayid;
//		this.wayname = wayname;
//		this.countyid = countyid;
//		if(countyid!=null)
//			this.strcountyid = Constant.getCountyidchName(countyid);
//		this.starlevel = starlevel;
//		if (starlevel!= null){
//			this.strstarlevel = Constant.getConstantName(ConstantsType.STARLEVEL,starlevel.toString());
//		}
//		this.employeename = employeename;
//		this.officetel = officetel;
//		this.mobile = mobile;
//		this.brand = brand;
//		if (brand != null){
//			this.brandName = Constant.getConstantName(ConstantsType.SIMBRAND,brand.toString());
//		}
//		if(comclassid!=null && !comclassid.equals("")){
//			this.comclassid = Constant.getConstantName(ConstantsType.IM_COMTYPE, comclassid.toString());
//		}
//		else{
//			this.comclassid = null;
//		}
//		this.comprice = comprice;
//		this.oprtime = oprtime;
//		this.activedate = activedate;
//		if(flag!=null && !"".equals(flag)){
//			this.flag = Constant.getConstantName(ConstantsType.CH_MFLAG, flag.toString());
//		}
//		else{
//			this.flag=null;
//		}
//	}
	
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
	public String  getBrand(){
		return this.brand;
	}
	
	public String getComclassid() {
		return comclassid;
	}
	public void setComclassid(String comclassid) {
		this.comclassid = comclassid;
	}
	public String getComprice() {
		return comprice;
	}
	public void setComprice(String comprice) {
		this.comprice = comprice;
	}
	
	public void setOprtime(String date){
		this.oprtime = date;
	}
	public String getOprtime(){
		return this.oprtime;
	}
	
	public void setActivedate(String activedate){
		this.activedate = activedate;
	}
	public String getActivedate(){
		return this.activedate;
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
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public String getComtype() {
		return comtype;
	}

	public void setComtype(String comtype) {
		this.comtype = comtype;
	}
}
