package com.gmcc.pboss.business.channel.zjty.zjtywayinfo;



import java.io.Serializable;
import java.util.Date;





public class ZjtywayinfoVO  implements Serializable {
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
	
	private int _ne_waystate ;

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

	private int buztypecode;

	private int adtypecode;

	private String address;

	private String latitude;

	private String longtitude;

	private String adacode;

	private String waymagcode;

	private Long buzarea;

	private int mainlayer;

	private int sublayer;

	private String buzphoneno;

	private int cooperator;
	
	private String bchlevel;
	
	private Long prtsource;//物业来源分类
    private Long isconnected;//是否联网
    private Long connecttype;//联网方式
    private Long runmode;//经营模式
    
    private Long waystate;//渠道状态
    
    private Long iscoreway;
    
    private Long starlevel;
    private String chainhead;//连锁总店编码
    
    private String isshare;
    
//    委托方公司名称、1工商注册号、2法人代表、3身份证号码；4委托经营信息：5签约编号、6协议签署生效时间（格式：YYYYMMDD）、
//    7协议截止时间（格式：YYYYMMDD）。其他：8全网统一渠道编码、9乡镇、10渠道基础类型、11是否手机卖场、12前台营业面积（㎡）、
//    13有无排队叫号机、14有无POS机、15有无24小时自助营业厅、16有无VIP专席、17有无VIP室、18G3体验区面积
    
    
   // CH_PW_BCHCONTACT表：
    //委托方公司名称、工商注册号、法人代表、身份证号码,负责人电话
    /**
     * 工商注册号
     */
    private String busnum;
    /**
     * 法人代表
     */
    private String principal;
    /**
     * 身份证号码
     */
    private String certinum;
    /**
     * 委托方公司名称
     */
    private String company;
    
	private String principaltel;
	
	
    
    
    //以下字段保存到CH_PW_WAYCOMPACT表：
   // 签约编号、协议签署生效时间（格式：YYYYMMDD）、协议截止时间（格式：YYYYMMDD），签约时间，合同协议名称
    /**
     * 签约编号
     */
    private String compactno;
    /**
     * 协议签署生效时间（格式：YYYYMMDD）
     */
    private Date begintime;
    /**
     * 协议截止时间（格式：YYYYMMDD）
     */
    private Date endtime;    
    
    private java.util.Date signtime;
    
    private String compactname;
    
    //以下字段保存到渠道省公司属性表(ch_pw_wayprovince)：
    //全网统一渠道编码、乡镇、渠道基础类型、是否手机卖场、前台营业面积（㎡）、
    //有无排队叫号机、有无POS机、有无24小时自助营业厅、有无VIP专席、有无VIP室、G3体验区面积；
    //录入成功要登记相关日志到渠道省公司属性日志表(ch_pw_wayprovincelog)。
    /**
     * 全网统一渠道编码
     */
    private String uniquewayid;
    /**
     * 乡镇
     */
    private String town;
    /**
     * 渠道基础类型
     */
    private Short provtype;
    /**
     * 是否手机卖场
     */
    private Short mobilemall;
    /**
     * 前台营业面积（㎡）
     */
    private Double frontarea;
    /**
     * 有无排队叫号机
     */
    private Short haswaitmach;
    /**
     * 有无POS机
     */
    private Short hasposmach;
    /**
     * 有无24小时自助营业厅
     */
    private Short has24mall;
    /**
     * 有无VIP室
     */
    private Short hasviproom;
    /**
     * 有无VIP专席
     */
    private Short hasvipseat;
    /**
     * G3体验区面积
     */
    private Double g3area;
    
    
	public String getChainhead() {
		return chainhead;
	}



	public void setChainhead(String chainhead) {
		this.chainhead = chainhead;
	}
	
	
	
	public ZjtywayinfoVO() {
		super();
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



	public int get_ne_waystate() {
		return _ne_waystate;
	}



	public void set_ne_waystate(int _ne_waystate) {
		this._ne_waystate = _ne_waystate;
	}







	public Long getWaystate() {
		return waystate;
	}



	public void setWaystate(Long waystate) {
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

	public int getAdtypecode() {
		return adtypecode;
	}

	public void setAdtypecode(int adtypecode) {
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

	public int getBuztypecode() {
		return buztypecode;
	}

	public void setBuztypecode(int buztypecode) {
		this.buztypecode = buztypecode;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public int getCooperator() {
		return cooperator;
	}

	public void setCooperator(int cooperator) {
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

	public int getMainlayer() {
		return mainlayer;
	}

	public void setMainlayer(int mainlayer) {
		this.mainlayer = mainlayer;
	}

	public String getMareacode() {
		return mareacode;
	}

	public void setMareacode(String mareacode) {
		this.mareacode = mareacode;
	}

	public int getSublayer() {
		return sublayer;
	}

	public void setSublayer(int sublayer) {
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



	public String getBusnum() {
		return busnum;
	}



	public void setBusnum(String busnum) {
		this.busnum = busnum;
	}



	public String getPrincipal() {
		return principal;
	}



	public void setPrincipal(String principal) {
		this.principal = principal;
	}



	public String getCertinum() {
		return certinum;
	}



	public void setCertinum(String certinum) {
		this.certinum = certinum;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public String getCompactno() {
		return compactno;
	}



	public void setCompactno(String compactno) {
		this.compactno = compactno;
	}



	public Date getBegintime() {
		return begintime;
	}



	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}



	public Date getEndtime() {
		return endtime;
	}



	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}



	public String getUniquewayid() {
		return uniquewayid;
	}



	public void setUniquewayid(String uniquewayid) {
		this.uniquewayid = uniquewayid;
	}






	public String getTown() {
		return town;
	}



	public void setTown(String town) {
		this.town = town;
	}



	public Short getProvtype() {
		return provtype;
	}



	public void setProvtype(Short provtype) {
		this.provtype = provtype;
	}



	public Short getMobilemall() {
		return mobilemall;
	}



	public void setMobilemall(Short mobilemall) {
		this.mobilemall = mobilemall;
	}



	public Double getFrontarea() {
		return frontarea;
	}



	public void setFrontarea(Double frontarea) {
		this.frontarea = frontarea;
	}



	public Short getHaswaitmach() {
		return haswaitmach;
	}



	public void setHaswaitmach(Short haswaitmach) {
		this.haswaitmach = haswaitmach;
	}



	public Short getHasposmach() {
		return hasposmach;
	}



	public void setHasposmach(Short hasposmach) {
		this.hasposmach = hasposmach;
	}



	public Short getHas24mall() {
		return has24mall;
	}



	public void setHas24mall(Short has24mall) {
		this.has24mall = has24mall;
	}



	public Short getHasviproom() {
		return hasviproom;
	}



	public void setHasviproom(Short hasviproom) {
		this.hasviproom = hasviproom;
	}



	public Short getHasvipseat() {
		return hasvipseat;
	}



	public void setHasvipseat(Short hasvipseat) {
		this.hasvipseat = hasvipseat;
	}



	public Double getG3area() {
		return g3area;
	}



	public void setG3area(Double g3area) {
		this.g3area = g3area;
	}



	public String getPrincipaltel() {
		return principaltel;
	}



	public void setPrincipaltel(String principaltel) {
		this.principaltel = principaltel;
	}



	public java.util.Date getSigntime() {
		return signtime;
	}



	public void setSigntime(java.util.Date signtime) {
		this.signtime = signtime;
	}



	public String getCompactname() {
		return compactname;
	}



	public void setCompactname(String compactname) {
		this.compactname = compactname;
	}


}
