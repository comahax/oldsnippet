package com.gmcc.pboss.biz.info.registernewcnt.support;

import java.util.Date;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class RegisternewcntQueryParameter extends QueryParameter {

	public RegisternewcntQueryParameter() {
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
	private String starlevel;
	private String dateFrom;
	private String dateTo;
	private String cityid;
	private String employeeid;

	public String getStarlevel() {
		return starlevel;
	}

	public void setStarlevel(String starlevel) {
		this.starlevel = starlevel;
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

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
}
