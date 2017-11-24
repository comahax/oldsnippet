package com.gmcc.pboss.manager.model;

import java.io.Serializable;
import java.util.Date;
import com.gmcc.pboss.biz.info.node.model.Way;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;

public class WayReversed implements Serializable {
	// Fields

	private String wayid;
	private String wayname;
	private String officetel;   //公务机号码 来自人员表CH_PW_EMPLOYEE
	private String starlevel;	//转换为中文   星级
	private String catetype;	//转换为中文   连线性质
	private String cityid;		//转换为中文   地市公司
	private String countyid;	//转换为中文   分公司
	private String svccode;
	private String formtype;	//转换为中文   业态类型
	private String address;  
	
	public WayReversed(){
		;
	}
	
	public WayReversed(String wayid, String wayname, String officetel,
			String starlevel, String catetype, String cityid, String countyid,
			String svccode, String formtype, String address) {
		super();
		this.wayid = wayid;
		this.wayname = wayname;
		this.officetel = officetel;
		//this.starlevel = starlevel;
		if(starlevel!=null)
			this.starlevel = Constant.getConstantName(ConstantsType.STARLEVEL,starlevel);
		else
			this.starlevel = null;
		//this.catetype = catetype;
		if(catetype!=null)
			this.catetype = Constant.getConstantName(ConstantsType.CATETYPE,catetype);
		else
			this.catetype = null;
		//this.cityid = cityid;
		if(cityid!=null)
			this.cityid = Constant.getConstantName(ConstantsType.BRANCH_NAME,cityid);
		else
			this.cityid = null;
		//this.custtype = custtype;
		this.countyid = Constant.getCountyidchName(countyid);
		this.svccode = svccode;
		//this.formtype = formtype;
		if(formtype!=null)
			this.formtype = Constant.getConstantName(ConstantsType.FORMTYPE,formtype);
		else
			this.formtype = null;
		this.address = address;
	}
	
	public WayReversed(Way way,String officetel){
		this.wayid = way.getWayid();
		this.wayname = way.getWayname();
		if(way.getStarlevel()!=null)
			this.starlevel = Constant.getConstantName(ConstantsType.STARLEVEL,way.getStarlevel().toString());
		else
			this.starlevel = null;
		if(way.getCatetype()!=null)
			this.catetype = Constant.getConstantName(ConstantsType.CATETYPE,way.getCatetype().toString());
		else
			this.catetype = null;
		if(way.getCityid()!=null)
			this.cityid = Constant.getConstantName(ConstantsType.BRANCH_NAME,way.getCityid().toString());
		else
			this.cityid = null;
		this.countyid = Constant.getCountyidchName(way.getCountyid());
		this.svccode = way.getSvccode();
		if(way.getFormtype()!=null)
			this.formtype = Constant.getConstantName(ConstantsType.FORMTYPE,way.getFormtype().toString());
		else
			this.formtype = null;
		this.address = way.getAddress();
		this.officetel = officetel;
	}
	
	public void setWayid(String id){
		this.wayid = id;
	}
	public String getWayid(){
		return this.wayid;
	}
	public void setWayname(String name){
		this.wayname = name;
	}
	public String getWayname(){
		return this.wayname;
	}
	public void setStarlevel(String level){
		this.starlevel = level;
	}
	public String getStarlevel(){
		return this.starlevel;
	}
	public void setCatetype(String t){
		this.catetype = t;
	}
	public String getCatetype(){
		return this.catetype;
	}
	public void setCityid(String id){
		this.cityid = id;
	}
	public String getCityid(){
		return this.cityid;
	}
	public String getCountyid() {
		return countyid;
	}
	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}
	public void setSvccode(String svc){
		this.svccode = svc;
	}
	public String getSvccode(){
		return this.svccode;
	}
	public void setFormtype(String form){
		this.formtype = form;
	}
	public String getFormtype(){
		return this.formtype;
	}
	public void setAddress(String add){
		this.address = add;
	}
	public String getAddress(){
		return this.address;
	}
	
	public String getOfficetel() {
		return officetel;
	}
	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}
}
