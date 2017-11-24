package com.gmcc.pboss.biz.info.salesCardsTotal.support;

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
    
    //sms表要用到cityid
	private String cityid;
    
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
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	
	
	
}
