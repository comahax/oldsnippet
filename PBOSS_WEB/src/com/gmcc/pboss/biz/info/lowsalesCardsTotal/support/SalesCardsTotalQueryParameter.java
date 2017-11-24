package com.gmcc.pboss.biz.info.lowsalesCardsTotal.support;

import java.util.Date;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class SalesCardsTotalQueryParameter  extends QueryParameter   {

	public SalesCardsTotalQueryParameter(){
		setAction(QueryAction.SECTION);
	}
	
	private String wayid;
    private String waymagcode;
    private String brand;
    private String branddtl;
    private String countyid;
    private String svccode;
    private Date startoprtime;
    private Date endoprtime;
    private Date startactivedate;
    private Date endactivedate;
    private String starlevel;
    private String startoprtimes;
    private String endoprtimes;
    private String startactivedates;
    private String endactivedates;
    //查看明细传过来的
    private String officetel;
    private String employeename;
    //业务编码
	private String opnid;
	private String opniddtl;
	//店员姓名-工号(实际上通过工号查询)
	private String oprcode;
	private String employeeid;
	
	//sms表要用到cityid
	private String cityid;
	
	public String getOprcode() {
		return oprcode;
	}
	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}
	public String getOpnid() {
		return opnid;
	}
	public void setOpnid(String opnid) {
		this.opnid = opnid;
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
	public Date getStartactivedate() {
		return startactivedate;
	}
	public void setStartactivedate(Date startactivedate) {
		this.startactivedate = startactivedate;
	}
	public Date getEndactivedate() {
		return endactivedate;
	}
	public void setEndactivedate(Date endactivedate) {
		this.endactivedate = endactivedate;
	}
	public String getStartoprtimes() {
		return startoprtimes;
	}
	public void setStartoprtimes(String startoprtimes) {
		this.startoprtimes = startoprtimes;
	}
	public String getEndoprtimes() {
		return endoprtimes;
	}
	public void setEndoprtimes(String endoprtimes) {
		this.endoprtimes = endoprtimes;
	}
	public String getStartactivedates() {
		return startactivedates;
	}
	public void setStartactivedates(String startactivedates) {
		this.startactivedates = startactivedates;
	}
	public String getEndactivedates() {
		return endactivedates;
	}
	public void setEndactivedates(String endactivedates) {
		this.endactivedates = endactivedates;
	}
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
	public String getWaymagcode() {
		return waymagcode;
	}
	public void setWaymagcode(String waymagcode) {
		this.waymagcode = waymagcode;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
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
	public String getOfficetel() {
		return officetel;
	}
	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getBranddtl() {
		return branddtl;
	}
	public void setBranddtl(String branddtl) {
		this.branddtl = branddtl;
	}
	public String getOpniddtl() {
		return opniddtl;
	}
	public void setOpniddtl(String opniddtl) {
		this.opniddtl = opniddtl;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	
	
	
}
