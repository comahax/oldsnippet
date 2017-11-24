package com.sunrise.boss.ui.qsmanage.paramsmanage.eboxgroup;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.pub.tools.PublicUtils;

public class EboxGroupForm extends BaseActionForm {

	private Long matchid;

	private String chgreason;

	private String menulist;

	private String curmenu;

	private Long eboxunitid;

	private String eboxunitname;

	private Integer eboxunittype;

	private Short eboxunitstate;

	private Short canwithd;

	private Short canprintinv;

	private Short isneedpayway;

	private Short canjiezhuan;

	private Short iscommon;

	private Short canwoff;

	private Long woffpri;

	private Short canpaybehalf;

	private Long billitemid;

	private String brand;

	private Short eboxtype;

	private Long acctid;

	private Short type;

	private java.util.Date begintime;

	private java.util.Date endtime;

	private Long pri;

	private String memo;

	private String strBegintime;

	private String strEndtime;

	public String getStrBegintime() {

		return PublicUtils.utilDateToStr(begintime);
	}

	public Long getAcctid() {
		return acctid;
	}

	public void setAcctid(Long acctid) {
		this.acctid = acctid;
	}

	public java.util.Date getBegintime() {
		return begintime;
	}

	public void setBegintime(java.util.Date begintime) {
		this.begintime = begintime;
	}

	public java.util.Date getEndtime() {
		return endtime;
	}

	public void setEndtime(java.util.Date endtime) {
		this.endtime = endtime;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Long getPri() {
		return pri;
	}

	public void setPri(Long pri) {
		this.pri = pri;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public void setStrBegintime(String strBegintime) throws Exception {

		begintime = PublicUtils.UtilStrToDate(strBegintime);
		this.strBegintime = strBegintime;
	}

	public String getStrEndtime() {
		return PublicUtils.utilDateToStr(endtime);
	}

	public void setStrEndtime(String strEndtime) throws Exception {
		endtime = PublicUtils.UtilStrToDate(strEndtime);
		this.strEndtime = strEndtime;
	}

	public Long getBillitemid() {
		return billitemid;
	}

	public void setBillitemid(Long billitemid) {
		this.billitemid = billitemid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Short getCanjiezhuan() {
		return canjiezhuan;
	}

	public void setCanjiezhuan(Short canjiezhuan) {
		this.canjiezhuan = canjiezhuan;
	}

	public Short getCanpaybehalf() {
		return canpaybehalf;
	}

	public void setCanpaybehalf(Short canpaybehalf) {
		this.canpaybehalf = canpaybehalf;
	}

	public Short getCanprintinv() {
		return canprintinv;
	}

	public void setCanprintinv(Short canprintinv) {
		this.canprintinv = canprintinv;
	}

	public Short getCanwithd() {
		return canwithd;
	}

	public void setCanwithd(Short canwithd) {
		this.canwithd = canwithd;
	}

	public Short getCanwoff() {
		return canwoff;
	}

	public void setCanwoff(Short canwoff) {
		this.canwoff = canwoff;
	}

	public Long getEboxunitid() {
		return eboxunitid;
	}

	public void setEboxunitid(Long eboxunitid) {
		this.eboxunitid = eboxunitid;
	}

	public String getEboxunitname() {
		return eboxunitname;
	}

	public void setEboxunitname(String eboxunitname) {
		this.eboxunitname = eboxunitname;
	}

	public Short getEboxunitstate() {
		return eboxunitstate;
	}

	public void setEboxunitstate(Short eboxunitstate) {
		this.eboxunitstate = eboxunitstate;
	}

	public Integer getEboxunittype() {
		return eboxunittype;
	}

	public void setEboxunittype(Integer eboxunittype) {
		this.eboxunittype = eboxunittype;
	}

	public Short getIscommon() {
		return iscommon;
	}

	public void setIscommon(Short iscommon) {
		this.iscommon = iscommon;
	}

	public Short getIsneedpayway() {
		return isneedpayway;
	}

	public void setIsneedpayway(Short isneedpayway) {
		this.isneedpayway = isneedpayway;
	}

	public Long getWoffpri() {
		return woffpri;
	}

	public void setWoffpri(Long woffpri) {
		this.woffpri = woffpri;
	}

	public String getChgreason() {
		return chgreason;
	}

	public void setChgreason(String chgreason) {
		this.chgreason = chgreason;
	}

	public String getCurmenu() {
		return curmenu;
	}

	public void setCurmenu(String curmenu) {
		this.curmenu = curmenu;
	}

	public Long getMatchid() {
		return matchid;
	}

	public void setMatchid(Long matchid) {
		this.matchid = matchid;
	}

	public String getMenulist() {
		return menulist;
	}

	public void setMenulist(String menulist) {
		this.menulist = menulist;
	}

	public Short getEboxtype() {
		return eboxtype;
	}

	public void setEboxtype(Short eboxtype) {
		this.eboxtype = eboxtype;
	}

}
