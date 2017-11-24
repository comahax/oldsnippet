package com.gmcc.pboss.biz.info.registernewmagcnt.support;

import java.util.Date;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class RegisternewmagcntQueryParameter extends QueryParameter {

	public RegisternewmagcntQueryParameter() {
		setAction(QueryAction.SECTION);// 新业务销售汇总查询分页
	}
	
	private String wayid;
	private String month;
	private String mobile;
	private String countyid;
	private String svccode;
	private String brand;
	private Date startoprtime;
	private Date endoprtime;
	private String employeename;
	private String opnid;
	private String dateFrom;
	private String dateTo;
	private String officetel;
	private String flg;
	private String cityid;
	
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCountyid() {
		return countyid;
	}
	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}
	public String getSvccode() {
		return svccode;
	}
	public void setSvccode(String svccode) {
		this.svccode = svccode;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Date getStartoprtime() {
		return startoprtime;
	}
	public void setStartoprtime(Date startoprtime) {
		this.startoprtime = startoprtime;
	}
	public Date getEndoprtime() {
		return endoprtime;
	}
	public void setEndoprtime(Date endoprtime) {
		this.endoprtime = endoprtime;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getOpnid() {
		return opnid;
	}
	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}
	public String getOfficetel() {
		return officetel;
	}
	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}
	public String getFlg() {
		return flg;
	}
	public void setFlg(String flg) {
		this.flg = flg;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
}
