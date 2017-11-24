/**
 * auto-generated code
 * Thu Aug 24 15:28:14 CST 2006
 */
package com.sunrise.boss.ui.cms.way;

import java.util.Date;

import com.sunrise.boss.ui.base.*;

/**
 * <p>
 * Title: WayForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author He Kun
 * @version 1.0
 */
public class WayForm extends BaseActionForm {
	/** identifier field */
	private String wayid;

	/** persistent field */
	private String wayname;

	/** persistent field */
	private String waytype;

	/** persistent field */
	private String waysubtype;

	/** nullable persistent field */
	private String custtype;

	/** persistent field */
	private String upperwayid;

	/** nullable persistent field */
	private String busicode;

	/** nullable persistent field */
	private String countyid;

	/** nullable persistent field */
	private String cityid;

	/** nullable persistent field */
	private String centerid;

	/** nullable persistent field */
	private Short citylevel;

	/** nullable persistent field */
	private Short waylevel;

	/** nullable persistent field */
	private String bchlevel;

	/** nullable persistent field */
	private String function;

	/** nullable persistent field */
	private String miscode;

	/** nullable persistent field */
	private Short waystate;

	/** nullable persistent field */
	private java.util.Date createtime;

	/** nullable persistent field */
	private java.util.Date disabletime;

	/** nullable persistent field */
	private String runbyself;

	/** nullable persistent field */
	private String depotdet;

	/** add by caijianhui */
	private String isshare;

	/** 新增的字段 */
	private String shortname;

	private String svbrchcode;

	private String svccode;

	private String mareacode;

	private Short buztypecode;

	private Short adtypecode;

	private String address;

	private String logiscode;

	private String latitude;

	private String longtitude;

	private String adacode;

	private String waymagcode;

	private Short catetype;

	private Short formtype;

	private Date starttime;

	private Long buzarea;

	private Short mainlayer;

	private Short sublayer;

	private String buzphoneno;

	private Short cooperator;

	private Integer alarmbizamount;
	
    private Long prtsource;//物业来源分类
    private Long isconnected;//是否联网
    private Long connecttype;//联网方式
    private Long runmode;//经营模式
    private Long iscoreway;//是否中心渠道
    private Long starlevel;//星级
    private Long pt;//排他性
    private String chainhead;//连锁总店编码
    private Long signstatus;//签约状态（状态）
    private Long empnumber;//营业人员数量
    private Long magnumber;//管理人员数量
    private Long terminumber;//终端数量
    private java.util.Date updatedate;//信息更新时间
    private String taxtype;
    
    private Short isstraitprd;

	public Integer getAlarmbizamount() {
		return alarmbizamount;
	}

	public void setAlarmbizamount(Integer alarmbizamount) {
		this.alarmbizamount = alarmbizamount;
	}

	/** 结束 */

	public String getIsshare() {
		return isshare;
	}

	public void setIsshare(String isshare) {
		this.isshare = isshare;
	}

	private String _se_wayid;

	private String _sk_wayid;

	private String _se_upperwayid;

	private String _sk_wayname;

	private String _se_waytype;

	private String _se_waysubtype;

	private String _se_countyid;

	private String _se_cityid;

	private String _se_centerid;

	private Short _ne_waystate;

	private boolean showDisabled;

    
    private String _ne_cooperator;
    
    private String _se_svccode;
    
    private String _se_mareacode;
    
    private String _sql_waysubtype;
    
	public String get_sql_waysubtype() {
		return _sql_waysubtype;
	}

	public void set_sql_waysubtype(String _sql_waysubtype) {
		this._sql_waysubtype = _sql_waysubtype;
	}

	/**
	 * @return Returns the _se_centerid.
	 */
	public String get_se_centerid() {
		return _se_centerid;
	}

	/**
	 * @param _se_centerid
	 *            The _se_centerid to set.
	 */
	public void set_se_centerid(String _se_centerid) {
		this._se_centerid = _se_centerid;
	}

	/**
	 * @return Returns the _se_cityid.
	 */
	public String get_se_cityid() {
		return _se_cityid;
	}

	/**
	 * @param _se_cityid
	 *            The _se_cityid to set.
	 */
	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	/**
	 * @return Returns the _se_countyid.
	 */
	public String get_se_countyid() {
		return _se_countyid;
	}

	/**
	 * @param _se_countyid
	 *            The _se_countyid to set.
	 */
	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}

	/**
	 * @return Returns the _se_upperwayid.
	 */
	public String get_se_upperwayid() {
		return _se_upperwayid;
	}

	/**
	 * @param _se_upperwayid
	 *            The _se_upperwayid to set.
	 */
	public void set_se_upperwayid(String _se_upperwayid) {
		this._se_upperwayid = _se_upperwayid;
	}

	/**
	 * @return Returns the _se_wayid.
	 */
	public String get_se_wayid() {
		return _se_wayid;
	}

	/**
	 * @param _se_wayid
	 *            The _se_wayid to set.
	 */
	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	/**
	 * @return Returns the _se_waysubtype.
	 */
	public String get_se_waysubtype() {
		return _se_waysubtype;
	}

	/**
	 * @param _se_waysubtype
	 *            The _se_waysubtype to set.
	 */
	public void set_se_waysubtype(String _se_waysubtype) {
		this._se_waysubtype = _se_waysubtype;
	}

	/**
	 * @return Returns the _se_waytype.
	 */
	public String get_se_waytype() {
		return _se_waytype;
	}

	/**
	 * @param _se_waytype
	 *            The _se_waytype to set.
	 */
	public void set_se_waytype(String _se_waytype) {
		this._se_waytype = _se_waytype;
	}

	/**
	 * @return Returns the _sk_wayname.
	 */
	public String get_sk_wayname() {
		return _sk_wayname;
	}

	/**
	 * @param _sk_wayname
	 *            The _sk_wayname to set.
	 */
	public void set_sk_wayname(String _sk_wayname) {
		this._sk_wayname = _sk_wayname;
	}

	/**
	 * @return Returns the bchlevel.
	 */
	public String getBchlevel() {
		return bchlevel;
	}

	/**
	 * @param bchlevel
	 *            The bchlevel to set.
	 */
	public void setBchlevel(String bchlevel) {
		this.bchlevel = bchlevel;
	}

	/**
	 * @return Returns the centerid.
	 */
	public String getCenterid() {
		return centerid;
	}

	/**
	 * @param centerid
	 *            The centerid to set.
	 */
	public void setCenterid(String centerid) {
		this.centerid = centerid;
	}

	/**
	 * @return Returns the cityid.
	 */
	public String getCityid() {
		return cityid;
	}

	/**
	 * @param cityid
	 *            The cityid to set.
	 */
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	/**
	 * @return Returns the citylevel.
	 */
	public Short getCitylevel() {
		return citylevel;
	}

	/**
	 * @param citylevel
	 *            The citylevel to set.
	 */
	public void setCitylevel(Short citylevel) {
		this.citylevel = citylevel;
	}

	/**
	 * @return Returns the countyid.
	 */
	public String getCountyid() {
		return countyid;
	}

	/**
	 * @param countyid
	 *            The countyid to set.
	 */
	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	/**
	 * @return Returns the custtype.
	 */
	public String getCusttype() {
		return custtype;
	}

	/**
	 * @param custtype
	 *            The custtype to set.
	 */
	public void setCusttype(String custtype) {
		this.custtype = custtype;
	}

	/**
	 * @return Returns the function.
	 */
	public String getFunction() {
		return function;
	}

	/**
	 * @param function
	 *            The function to set.
	 */
	public void setFunction(String function) {
		this.function = function;
	}

	/**
	 * @return Returns the miscode.
	 */
	public String getMiscode() {
		return miscode;
	}

	/**
	 * @param miscode
	 *            The miscode to set.
	 */
	public void setMiscode(String miscode) {
		this.miscode = miscode;
	}

	/**
	 * @return Returns the upperwayid.
	 */
	public String getUpperwayid() {
		return upperwayid;
	}

	/**
	 * @param upperwayid
	 *            The upperwayid to set.
	 */
	public void setUpperwayid(String upperwayid) {
		this.upperwayid = upperwayid;
	}

	/**
	 * @return Returns the wayid.
	 */
	public String getWayid() {
		return wayid;
	}

	/**
	 * @param wayid
	 *            The wayid to set.
	 */
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	/**
	 * @return Returns the waylevel.
	 */
	public Short getWaylevel() {
		return waylevel;
	}

	/**
	 * @param waylevel
	 *            The waylevel to set.
	 */
	public void setWaylevel(Short waylevel) {
		this.waylevel = waylevel;
	}

	/**
	 * @return Returns the wayname.
	 */
	public String getWayname() {
		return wayname;
	}

	/**
	 * @param wayname
	 *            The wayname to set.
	 */
	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	/**
	 * @return Returns the waystate.
	 */
	public Short getWaystate() {
		return waystate;
	}

	/**
	 * @param waystate
	 *            The waystate to set.
	 */
	public void setWaystate(Short waystate) {
		this.waystate = waystate;
	}

	/**
	 * @return Returns the waysubtype.
	 */
	public String getWaysubtype() {
		return waysubtype;
	}

	/**
	 * @param waysubtype
	 *            The waysubtype to set.
	 */
	public void setWaysubtype(String waysubtype) {
		this.waysubtype = waysubtype;
	}

	/**
	 * @return Returns the waytype.
	 */
	public String getWaytype() {
		return waytype;
	}

	/**
	 * @param waytype
	 *            The waytype to set.
	 */
	public void setWaytype(String waytype) {
		this.waytype = waytype;
	}

	public java.util.Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public java.util.Date getDisabletime() {
		return disabletime;
	}

	public void setDisabletime(java.util.Date disabletime) {
		this.disabletime = disabletime;
	}

	public String getBusicode() {
		return busicode;
	}

	public void setBusicode(String busicode) {
		this.busicode = busicode;
	}

	public String get_sk_wayid() {
		return _sk_wayid;
	}

	public void set_sk_wayid(String _sk_wayid) {
		this._sk_wayid = _sk_wayid;
	}

	public Short get_ne_waystate() {
		return _ne_waystate;
	}

	public void set_ne_waystate(Short _ne_waystate) {
		this._ne_waystate = _ne_waystate;
	}

	public boolean isShowDisabled() {
		return showDisabled;
	}

	public void setShowDisabled(boolean showDisabled) {
		this.showDisabled = showDisabled;
	}

	public String getRunbyself() {
		return runbyself;
	}

	public void setRunbyself(String runbyself) {
		this.runbyself = runbyself;
	}

	public String getDepotdet() {
		return depotdet;
	}

	public void setDepotdet(String depotdet) {
		this.depotdet = depotdet;
	}

	public String getAdacode() {
		return adacode;
	}

	public void setAdacode(String adacode) {
		this.adacode = adacode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Short getAdtypecode() {
		return adtypecode;
	}

	public void setAdtypecode(Short adtypecode) {
		this.adtypecode = adtypecode;
	}

	public Long getBuzarea() {
		return buzarea;
	}

	public void setBuzarea(Long buzarea) {
		this.buzarea = buzarea;
	}

	public String getBuzphoneno() {
		return buzphoneno;
	}

	public void setBuzphoneno(String buzphoneno) {
		this.buzphoneno = buzphoneno;
	}

	public Short getBuztypecode() {
		return buztypecode;
	}

	public void setBuztypecode(Short buztypecode) {
		this.buztypecode = buztypecode;
	}

	public Short getCatetype() {
		return catetype;
	}

	public void setCatetype(Short catetype) {
		this.catetype = catetype;
	}

	public Short getCooperator() {
		return cooperator;
	}

	public void setCooperator(Short cooperator) {
		this.cooperator = cooperator;
	}

	public Short getFormtype() {
		return formtype;
	}

	public void setFormtype(Short formtype) {
		this.formtype = formtype;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLogiscode() {
		return logiscode;
	}

	public void setLogiscode(String logiscode) {
		this.logiscode = logiscode;
	}

	public String getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public Short getMainlayer() {
		return mainlayer;
	}

	public void setMainlayer(Short mainlayer) {
		this.mainlayer = mainlayer;
	}

	public String getMareacode() {
		return mareacode;
	}

	public void setMareacode(String mareacode) {
		this.mareacode = mareacode;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Short getSublayer() {
		return sublayer;
	}

	public void setSublayer(Short sublayer) {
		this.sublayer = sublayer;
	}

	public String getSvbrchcode() {
		return svbrchcode;
	}

	public void setSvbrchcode(String svbrchcode) {
		this.svbrchcode = svbrchcode;
	}

	public String getSvccode() {
		return svccode;
	}

	public void setSvccode(String svccode) {
		this.svccode = svccode;
	}

	public String getWaymagcode() {
		return waymagcode;
	}

	public void setWaymagcode(String waymagcode) {
		this.waymagcode = waymagcode;
	}

	public String get_ne_cooperator() {
		return _ne_cooperator;
	}

	public void set_ne_cooperator(String _ne_cooperator) {
		this._ne_cooperator = _ne_cooperator;
	}

	public String get_se_mareacode() {
		return _se_mareacode;
	}

	public void set_se_mareacode(String _se_mareacode) {
		this._se_mareacode = _se_mareacode;
	}

	public String get_se_svccode() {
		return _se_svccode;
	}

	public void set_se_svccode(String _se_svccode) {
		this._se_svccode = _se_svccode;
	}

	public String getChainhead() {
		return chainhead;
	}

	public void setChainhead(String chainhead) {
		this.chainhead = chainhead;
	}

	public Long getConnecttype() {
		return connecttype;
	}

	public void setConnecttype(Long connecttype) {
		this.connecttype = connecttype;
	}

	public Long getEmpnumber() {
		return empnumber;
	}

	public void setEmpnumber(Long empnumber) {
		this.empnumber = empnumber;
	}

	public Long getIsconnected() {
		return isconnected;
	}

	public void setIsconnected(Long isconnected) {
		this.isconnected = isconnected;
	}

	public Long getIscoreway() {
		return iscoreway;
	}

	public void setIscoreway(Long iscoreway) {
		this.iscoreway = iscoreway;
	}

	public Long getMagnumber() {
		return magnumber;
	}

	public void setMagnumber(Long magnumber) {
		this.magnumber = magnumber;
	}

	public Long getPrtsource() {
		return prtsource;
	}

	public void setPrtsource(Long prtsource) {
		this.prtsource = prtsource;
	}

	public Long getPt() {
		return pt;
	}

	public void setPt(Long pt) {
		this.pt = pt;
	}

	public Long getRunmode() {
		return runmode;
	}

	public void setRunmode(Long runmode) {
		this.runmode = runmode;
	}

	public Long getSignstatus() {
		return signstatus;
	}

	public void setSignstatus(Long signstatus) {
		this.signstatus = signstatus;
	}

	public Long getStarlevel() {
		return starlevel;
	}

	public void setStarlevel(Long starlevel) {
		this.starlevel = starlevel;
	}

	public Long getTerminumber() {
		return terminumber;
	}

	public void setTerminumber(Long terminumber) {
		this.terminumber = terminumber;
	}

	public java.util.Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(java.util.Date updatedate) {
		this.updatedate = updatedate;
	}

	public Short getIsstraitprd() {
		return isstraitprd;
	}

	public void setIsstraitprd(Short isstraitprd) {
		this.isstraitprd = isstraitprd;
	}

	public String getTaxtype() {
		return taxtype;
	}

	public void setTaxtype(String taxtype) {
		this.taxtype = taxtype;
	}
}
