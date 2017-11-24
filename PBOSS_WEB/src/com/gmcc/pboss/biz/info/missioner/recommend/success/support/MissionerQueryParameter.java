package com.gmcc.pboss.biz.info.missioner.recommend.success.support;

import java.util.Date;

import com.gmcc.pboss.common.support.QueryParameter;

public class MissionerQueryParameter extends QueryParameter{
	
	//所属代理商编码
	private String wayid;
	
	//所属代理商名称
	private String wayname;
	
	//业务编码
	private String opnid;
	
	//业务名称
	private String opnname;
	
	
	//业务发生时间>=
	private Date oprtimeFrom;
	
	//业务发生时间<=
	private Date oprtimeTo;
	
	//联系电话，专员查询时，限定本专员对应的数据（非页面条件）
	private String telephone;
	
	//所属渠道，代理商查询时，限定代理商对应的数据（非页面条件）
	private String wayidAgency;
	
	//专员号码
	private String oprcode;
	
	//成员属性
	private String empattr2;

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
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

	public Date getOprtimeFrom() {
		return oprtimeFrom;
	}

	public void setOprtimeFrom(Date oprtimeFrom) {
		this.oprtimeFrom = oprtimeFrom;
	}

	public Date getOprtimeTo() {
		return oprtimeTo;
	}

	public void setOprtimeTo(Date oprtimeTo) {
		this.oprtimeTo = oprtimeTo;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getWayidAgency() {
		return wayidAgency;
	}

	public void setWayidAgency(String wayidAgency) {
		this.wayidAgency = wayidAgency;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getEmpattr2() {
		return empattr2;
	}

	public void setEmpattr2(String empattr2) {
		this.empattr2 = empattr2;
	}
}
