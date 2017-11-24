package com.gmcc.pboss.biz.info.salesDetail.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class OperationsmsParameter extends QueryParameter {
	private String cityid;
	public void setCityid(String cityid){
		this.cityid = cityid;
	}
	public String getCityid(){
		return this.cityid;
	}
	
	private short opntype;
	public short getOpntype() {
		return opntype;
	}
	public void setOpntype(short opntype) {
		this.opntype = opntype;
	}
	
	//业务编码
	private String opnid;
	public String getOpnid() {
		return opnid;
	}
	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}
	//业务名称
	private String opnname;
	public String getOpnname() {
		return opnname;
	}
	public void setOpnname(String opnname) {
		this.opnname = opnname;
	}
	
}
