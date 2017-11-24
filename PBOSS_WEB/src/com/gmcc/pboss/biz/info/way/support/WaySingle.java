package com.gmcc.pboss.biz.info.way.support;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * ChPwWay entity. @author MyEclipse Persistence Tools
 */

public class WaySingle implements java.io.Serializable {

	// Fields

	private String wayid;
	private String shortname;
	private String svbrchcode;
	private String svccode;
	private String mareacode;
	private Byte buztypecode;
	private Byte adtypecode;
	private String address;
	private String logiscode;
	private String latitude;
	private String longtitude;
	private String adacode;
	private String waymagcode;
	private Byte catetype;
	private Byte formtype;
	private Date starttime;
	private Integer buzarea;
	private Byte mainlayer;
	private Byte sublayer;
	private String buzphoneno;
	private String wayname;
	private Byte cooperator;
	private String waytype;
	private String waysubtype;
	private String custtype;
	private String upperwayid;
	private String busicode;
	private String countyid;
	private String cityid;
	private String centerid;
	private Short citylevel;
	private Short waylevel;
	private String bchlevel;
	private String function;
	private String miscode;
	private Date createtime;
	private Date disabletime;
	private Short waystate;
	private String runbyself;
	private String depotdet;
	private String isshare;
	private Long alarmbizamount;
	private Byte prtsource;
	private Byte isconnected;
	private Byte connecttype;
	private Byte runmode;
	private Byte iscoreway;
	private Byte starlevel;
	private Byte pt;
	private String chainhead;
	private Byte signstatus;
	private Short empnumber;
	private Short magnumber;
	private Short terminumber;
	private Date updatedate;
	private Byte isstraitprd;
	private Byte taxtype;
	/**
	 * ÇþµÀÐÇ¼¶·­Òë
	 */
	private String strStarlevel;

	// Constructors

	/** default constructor */
	public WaySingle() {
	}

	/** minimal constructor */
	public WaySingle(String wayid,String wayname) {
		this.wayid = wayid;
		this.wayname = wayname;
	}

	/** full constructor */
	public WaySingle(String wayid, String shortname, String svbrchcode, String svccode, String mareacode, Byte buztypecode, Byte adtypecode, String address,
			String logiscode, String latitude, String longtitude, String adacode, String waymagcode, Byte catetype, Byte formtype, Date starttime,
			Integer buzarea, Byte mainlayer, Byte sublayer, String buzphoneno, String wayname, Byte cooperator, String waytype, String waysubtype,
			String custtype, String upperwayid, String busicode, String countyid, String cityid, String centerid, Short citylevel, Short waylevel,
			String bchlevel, String function, String miscode, Date createtime, Date disabletime, Short waystate, String runbyself, String depotdet,
			String isshare, Long alarmbizamount, Byte prtsource, Byte isconnected, Byte connecttype, Byte runmode, Byte iscoreway, Byte starlevel, Byte pt,
			String chainhead, Byte signstatus, Short empnumber, Short magnumber, Short terminumber, Date updatedate, Byte isstraitprd, Byte taxtype) {
		this.wayid = wayid;
		this.shortname = shortname;
		this.svbrchcode = svbrchcode;
		this.svccode = svccode;
		this.mareacode = mareacode;
		this.buztypecode = buztypecode;
		this.adtypecode = adtypecode;
		this.address = address;
		this.logiscode = logiscode;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.adacode = adacode;
		this.waymagcode = waymagcode;
		this.catetype = catetype;
		this.formtype = formtype;
		this.starttime = starttime;
		this.buzarea = buzarea;
		this.mainlayer = mainlayer;
		this.sublayer = sublayer;
		this.buzphoneno = buzphoneno;
		this.wayname = wayname;
		this.cooperator = cooperator;
		this.waytype = waytype;
		this.waysubtype = waysubtype;
		this.custtype = custtype;
		this.upperwayid = upperwayid;
		this.busicode = busicode;
		this.countyid = countyid;
		this.cityid = cityid;
		this.centerid = centerid;
		this.citylevel = citylevel;
		this.waylevel = waylevel;
		this.bchlevel = bchlevel;
		this.function = function;
		this.miscode = miscode;
		this.createtime = createtime;
		this.disabletime = disabletime;
		this.waystate = waystate;
		this.runbyself = runbyself;
		this.depotdet = depotdet;
		this.isshare = isshare;
		this.alarmbizamount = alarmbizamount;
		this.prtsource = prtsource;
		this.isconnected = isconnected;
		this.connecttype = connecttype;
		this.runmode = runmode;
		this.iscoreway = iscoreway;
		this.starlevel = starlevel;
		this.pt = pt;
		this.chainhead = chainhead;
		this.signstatus = signstatus;
		this.empnumber = empnumber;
		this.magnumber = magnumber;
		this.terminumber = terminumber;
		this.updatedate = updatedate;
		this.isstraitprd = isstraitprd;
		this.taxtype = taxtype;
	}

	// Property accessors

	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getShortname() {
		return this.shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getSvbrchcode() {
		return this.svbrchcode;
	}

	public void setSvbrchcode(String svbrchcode) {
		this.svbrchcode = svbrchcode;
	}

	public String getSvccode() {
		return this.svccode;
	}

	public void setSvccode(String svccode) {
		this.svccode = svccode;
	}

	public String getMareacode() {
		return this.mareacode;
	}

	public void setMareacode(String mareacode) {
		this.mareacode = mareacode;
	}

	public Byte getBuztypecode() {
		return this.buztypecode;
	}

	public void setBuztypecode(Byte buztypecode) {
		this.buztypecode = buztypecode;
	}

	public Byte getAdtypecode() {
		return this.adtypecode;
	}

	public void setAdtypecode(Byte adtypecode) {
		this.adtypecode = adtypecode;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLogiscode() {
		return this.logiscode;
	}

	public void setLogiscode(String logiscode) {
		this.logiscode = logiscode;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongtitude() {
		return this.longtitude;
	}

	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public String getAdacode() {
		return this.adacode;
	}

	public void setAdacode(String adacode) {
		this.adacode = adacode;
	}

	public String getWaymagcode() {
		return this.waymagcode;
	}

	public void setWaymagcode(String waymagcode) {
		this.waymagcode = waymagcode;
	}

	public Byte getCatetype() {
		return this.catetype;
	}

	public void setCatetype(Byte catetype) {
		this.catetype = catetype;
	}

	public Byte getFormtype() {
		return this.formtype;
	}

	public void setFormtype(Byte formtype) {
		this.formtype = formtype;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Integer getBuzarea() {
		return this.buzarea;
	}

	public void setBuzarea(Integer buzarea) {
		this.buzarea = buzarea;
	}

	public Byte getMainlayer() {
		return this.mainlayer;
	}

	public void setMainlayer(Byte mainlayer) {
		this.mainlayer = mainlayer;
	}

	public Byte getSublayer() {
		return this.sublayer;
	}

	public void setSublayer(Byte sublayer) {
		this.sublayer = sublayer;
	}

	public String getBuzphoneno() {
		return this.buzphoneno;
	}

	public void setBuzphoneno(String buzphoneno) {
		this.buzphoneno = buzphoneno;
	}

	public String getWayname() {
		return this.wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public Byte getCooperator() {
		return this.cooperator;
	}

	public void setCooperator(Byte cooperator) {
		this.cooperator = cooperator;
	}

	public String getWaytype() {
		return this.waytype;
	}

	public void setWaytype(String waytype) {
		this.waytype = waytype;
	}

	public String getWaysubtype() {
		return this.waysubtype;
	}

	public void setWaysubtype(String waysubtype) {
		this.waysubtype = waysubtype;
	}

	public String getCusttype() {
		return this.custtype;
	}

	public void setCusttype(String custtype) {
		this.custtype = custtype;
	}

	public String getUpperwayid() {
		return this.upperwayid;
	}

	public void setUpperwayid(String upperwayid) {
		this.upperwayid = upperwayid;
	}

	public String getBusicode() {
		return this.busicode;
	}

	public void setBusicode(String busicode) {
		this.busicode = busicode;
	}

	public String getCountyid() {
		return this.countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getCityid() {
		return this.cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getCenterid() {
		return this.centerid;
	}

	public void setCenterid(String centerid) {
		this.centerid = centerid;
	}

	public Short getCitylevel() {
		return this.citylevel;
	}

	public void setCitylevel(Short citylevel) {
		this.citylevel = citylevel;
	}

	public Short getWaylevel() {
		return this.waylevel;
	}

	public void setWaylevel(Short waylevel) {
		this.waylevel = waylevel;
	}

	public String getBchlevel() {
		return this.bchlevel;
	}

	public void setBchlevel(String bchlevel) {
		this.bchlevel = bchlevel;
	}

	public String getFunction() {
		return this.function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getMiscode() {
		return this.miscode;
	}

	public void setMiscode(String miscode) {
		this.miscode = miscode;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getDisabletime() {
		return this.disabletime;
	}

	public void setDisabletime(Date disabletime) {
		this.disabletime = disabletime;
	}

	public Short getWaystate() {
		return this.waystate;
	}

	public void setWaystate(Short waystate) {
		this.waystate = waystate;
	}

	public String getRunbyself() {
		return this.runbyself;
	}

	public void setRunbyself(String runbyself) {
		this.runbyself = runbyself;
	}

	public String getDepotdet() {
		return this.depotdet;
	}

	public void setDepotdet(String depotdet) {
		this.depotdet = depotdet;
	}

	public String getIsshare() {
		return this.isshare;
	}

	public void setIsshare(String isshare) {
		this.isshare = isshare;
	}

	public Long getAlarmbizamount() {
		return this.alarmbizamount;
	}

	public void setAlarmbizamount(Long alarmbizamount) {
		this.alarmbizamount = alarmbizamount;
	}

	public Byte getPrtsource() {
		return this.prtsource;
	}

	public void setPrtsource(Byte prtsource) {
		this.prtsource = prtsource;
	}

	public Byte getIsconnected() {
		return this.isconnected;
	}

	public void setIsconnected(Byte isconnected) {
		this.isconnected = isconnected;
	}

	public Byte getConnecttype() {
		return this.connecttype;
	}

	public void setConnecttype(Byte connecttype) {
		this.connecttype = connecttype;
	}

	public Byte getRunmode() {
		return this.runmode;
	}

	public void setRunmode(Byte runmode) {
		this.runmode = runmode;
	}

	public Byte getIscoreway() {
		return this.iscoreway;
	}

	public void setIscoreway(Byte iscoreway) {
		this.iscoreway = iscoreway;
	}

	public Byte getStarlevel() {
		return this.starlevel;
	}

	public void setStarlevel(Byte starlevel) {
		this.starlevel = starlevel;
	}

	public Byte getPt() {
		return this.pt;
	}

	public void setPt(Byte pt) {
		this.pt = pt;
	}

	public String getChainhead() {
		return this.chainhead;
	}

	public void setChainhead(String chainhead) {
		this.chainhead = chainhead;
	}

	public Byte getSignstatus() {
		return this.signstatus;
	}

	public void setSignstatus(Byte signstatus) {
		this.signstatus = signstatus;
	}

	public Short getEmpnumber() {
		return this.empnumber;
	}

	public void setEmpnumber(Short empnumber) {
		this.empnumber = empnumber;
	}

	public Short getMagnumber() {
		return this.magnumber;
	}

	public void setMagnumber(Short magnumber) {
		this.magnumber = magnumber;
	}

	public Short getTerminumber() {
		return this.terminumber;
	}

	public void setTerminumber(Short terminumber) {
		this.terminumber = terminumber;
	}

	public Date getUpdatedate() {
		return this.updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public Byte getIsstraitprd() {
		return this.isstraitprd;
	}

	public void setIsstraitprd(Byte isstraitprd) {
		this.isstraitprd = isstraitprd;
	}

	public Byte getTaxtype() {
		return this.taxtype;
	}

	public void setTaxtype(Byte taxtype) {
		this.taxtype = taxtype;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getStrStarlevel() {
		return strStarlevel;
	}

	public void setStrStarlevel(String strStarlevel) {
		this.strStarlevel = strStarlevel;
	}

}