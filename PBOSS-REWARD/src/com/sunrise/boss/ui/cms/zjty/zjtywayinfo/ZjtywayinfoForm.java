package com.sunrise.boss.ui.cms.zjty.zjtywayinfo;

import java.util.Date;

import com.sunrise.boss.ui.base.BaseActionForm;

public class ZjtywayinfoForm extends BaseActionForm {
	private String _se_wayid;

	private String _sk_wayname;
	
	private String basewayid;

	private String _se_upperwayid;

	private String _se_svbrchcode;

	private String _se_bchlevel;

	private String _se_cityid;

	private String _se_waysubtype;

	private String _se_mareacode;

	private String _se_countyid;

	private String _se_svccode;
	
	private Short _ne_waystate ;

	private String wayid;

	private String wayname;

	private String waytype;

	private String waysubtype;

	private String upperwayid;

	private String busicode;

	private String countyid;

	private String cityid;

	private String svbrchcode;

	private String svccode;

	private String mareacode;

	private Short buztypecode;

	private Short adtypecode;

	private String address;

	private String latitude;

	private String longtitude;

	private String adacode;

	private String waymagcode;

	private Long buzarea;

	private Short mainlayer;

	private Short sublayer;

	private String buzphoneno;

	private Short cooperator;
	
	private String bchlevel;
	
	private Long prtsource;//物业来源分类
    private Long isconnected;//是否联网
    private Long connecttype;//联网方式
    private Long runmode;//经营模式
    
    private Short waystate;//渠道状态
    
    private Long iscoreway;
    
    private Long starlevel;
    private String chainhead;//连锁总店编码
    
    private String isshare;
    
	public String getChainhead() {
		return chainhead;
	}



	public void setChainhead(String chainhead) {
		this.chainhead = chainhead;
	}



	public ZjtywayinfoForm() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Long getIscoreway() {
		return iscoreway;
	}



	public void setIscoreway(Long iscoreway) {
		this.iscoreway = iscoreway;
	}



	public Long getStarlevel() {
		return starlevel;
	}



	public void setStarlevel(Long starlevel) {
		this.starlevel = starlevel;
	}



	public Short get_ne_waystate() {
		return _ne_waystate;
	}



	public void set_ne_waystate(Short _ne_waystate) {
		this._ne_waystate = _ne_waystate;
	}



	public Short getWaystate() {
		return waystate;
	}



	public void setWaystate(Short waystate) {
		this.waystate = waystate;
	}



	public Long getConnecttype() {
		return connecttype;
	}



	public void setConnecttype(Long connecttype) {
		this.connecttype = connecttype;
	}



	public Long getIsconnected() {
		return isconnected;
	}



	public void setIsconnected(Long isconnected) {
		this.isconnected = isconnected;
	}



	public Long getPrtsource() {
		return prtsource;
	}



	public void setPrtsource(Long prtsource) {
		this.prtsource = prtsource;
	}



	public Long getRunmode() {
		return runmode;
	}



	public void setRunmode(Long runmode) {
		this.runmode = runmode;
	}



	public String getBasewayid() {
		return basewayid;
	}



	public void setBasewayid(String basewayid) {
		this.basewayid = basewayid;
	}



	public String getBchlevel() {
		return bchlevel;
	}

	public void setBchlevel(String bchlevel) {
		this.bchlevel = bchlevel;
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

	public String getBusicode() {
		return busicode;
	}

	public void setBusicode(String busicode) {
		this.busicode = busicode;
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

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public Short getCooperator() {
		return cooperator;
	}

	public void setCooperator(Short cooperator) {
		this.cooperator = cooperator;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
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

	public String getUpperwayid() {
		return upperwayid;
	}

	public void setUpperwayid(String upperwayid) {
		this.upperwayid = upperwayid;
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

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public String getWaysubtype() {
		return waysubtype;
	}

	public void setWaysubtype(String waysubtype) {
		this.waysubtype = waysubtype;
	}

	public String getWaytype() {
		return waytype;
	}

	public void setWaytype(String waytype) {
		this.waytype = waytype;
	}

	public String get_se_bchlevel() {
		return _se_bchlevel;
	}

	public void set_se_bchlevel(String _se_bchlevel) {
		this._se_bchlevel = _se_bchlevel;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_se_countyid() {
		return _se_countyid;
	}

	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}

	public String get_se_mareacode() {
		return _se_mareacode;
	}

	public void set_se_mareacode(String _se_mareacode) {
		this._se_mareacode = _se_mareacode;
	}

	public String get_se_svbrchcode() {
		return _se_svbrchcode;
	}

	public void set_se_svbrchcode(String _se_svbrchcode) {
		this._se_svbrchcode = _se_svbrchcode;
	}

	public String get_se_svccode() {
		return _se_svccode;
	}

	public void set_se_svccode(String _se_svccode) {
		this._se_svccode = _se_svccode;
	}

	public String get_se_upperwayid() {
		return _se_upperwayid;
	}

	public void set_se_upperwayid(String _se_upperwayid) {
		this._se_upperwayid = _se_upperwayid;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_se_waysubtype() {
		return _se_waysubtype;
	}

	public void set_se_waysubtype(String _se_waysubtype) {
		this._se_waysubtype = _se_waysubtype;
	}

	public String get_sk_wayname() {
		return _sk_wayname;
	}

	public void set_sk_wayname(String _sk_wayname) {
		this._sk_wayname = _sk_wayname;
	}



	public String getIsshare() {
		return isshare;
	}



	public void setIsshare(String isshare) {
		this.isshare = isshare;
	}

}
