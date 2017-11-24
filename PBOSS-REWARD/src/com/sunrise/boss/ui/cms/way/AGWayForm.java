/**
 * auto-generated code
 * Thu Aug 24 15:28:14 CST 2006
 */
package com.sunrise.boss.ui.cms.way;

import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.common.utils.PWDHandle;
import com.sunrise.boss.ui.base.BaseActionForm;

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
 * @author zengjianxin
 * @version 1.0
 */
public class AGWayForm extends BaseActionForm {
	/** identifier field */
	private String wayid;

	/** persistent field */
	private String wayname;

	/** persistent field */
	private String waytype;

	/** nullable persistent field */
	private String custtype;

	/** persistent field */
	private String upperwayid;

	/** nullable persistent field */
	private String busicode;

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

	private Long buzarea;

	private Short mainlayer;

	private Short sublayer;

	private String buzphoneno;

	private Short cooperator;

	private Integer alarmbizamount;

	private Long prtsource;// 物业来源分类

	private Long isconnected;// 是否联网

	private Long connecttype;// 联网方式

	private Long runmode;// 经营模式

	private Long iscoreway;// 是否中心渠道

	private Long starlevel;// 星级

	private Long pt;// 排他性

	private String chainhead;// 连锁总店编码

	private Long signstatus;// 签约状态（状态）

	private Long empnumber;// 营业人员数量

	private Long magnumber;// 管理人员数量

	private Long terminumber;// 终端数量

	private java.util.Date updatedate;// 信息更新时间

	private Short isstraitprd;

	private String upperwayname;

	private String _ne_waytype;

	private String deacctno;

	private String deacctname;

	private String debankname;
	
	private Short isb2m;
	
	private Short isunpb;
	
	//添加用于受理单打印处理
	private String sendFlag;//是否发送短信通知
	
	private String smsMsg;//短信内容
	
	private String oldValueStr;//原表单信息

	// ---------Bchcontact----------------
	/** identifier field */
	// private String wayid;
	/** persistent field */
	// private String principal;
	/** persistent field */
	private String principaltel;

	/** persistent field */
	private String linkman;

	/** persistent field */
	private String linkmantel;

	/** nullable persistent field */
	private String hotline;

	/** nullable persistent field */
	private String fax;

	/** nullable persistent field */
	// private String address;
	/** nullable persistent field */
	private String zipcode;

	private String principalphone;

	private String principalemail;

	private String linkmanemail;

	private String reccerino;

	private String company;

	private String busnum;

	private Integer coplevel;

	private Integer certitype;

	private String certinum;

	private String regadress;

	private Long regcapital;

	// ----------Waycompact------------------
	/** identifier field */
	// private String wayid;
	/** persistent field */
	private String compactno;

	/** persistent field */
	private String compactname;

	/** persistent field */
	private java.sql.Date begintime;

	/** persistent field */
	private java.sql.Date signtime;

	/** nullable persistent field */
	private Short coptype;

	/** nullable persistent field */
	private String copbound;

	/** nullable persistent field */
	private String recomrule;

	/** nullable persistent field */
	private String compact;

	private String licenceno;

	private String compactpath;

	private String licencepath;

	private Short runareatype;

	private String principal;

	private Double bail;

	private Short bailstatus;

	private Short bailtype;

	private Short servbound;

	private Short compacttype;

	private FormFile compactfile; // 文本

	private FormFile licencefile; // 合同

	// =================wayaccount=========================
	/** identifier field */
	private Integer accid;

	/** identifier field */
	// private String wayid;
	/** persistent field */
	private Short chargetype;

	/** persistent field */
	private Short accttype;

	/** nullable persistent field */
	private String acctno;

	/** nullable persistent field */
	private String acctname;

	/** persistent field */
	private String bankname;

	/** nullable persistent field */
	private String dsbank;

	/** nullable persistent field */
	private String bankaddr;

	/** nullable persistent field */
	private String contact;

	/** nullable persistent field */
	private String contel;

	/** nullable persistent field */
	private java.sql.Date rectime;

	/** nullable persistent field */
	private java.sql.Date cmpendtime;

	/** nullable persistent field */
	private String bossarea;

	private String acctfid;

	// ==========cooperator================
	/** identifier field */
	private String cooperauid;

	/** persistent field */
	private String cooperaname;

	/** persistent field */
	private String cpabbrname;

	/** nullable persistent field */
	private String cocheckname;

	/** persistent field */
	private String cooperadel;

	/** persistent field */
	private String postaddr;

	/** persistent field */
	private String conntel;

	/** persistent field */
	private String connfaxno;

	/** persistent field */
	private String usremail;

	/** persistent field */
	private Double area;

	/** persistent field */
	private String licenceid;

	/** persistent field */
	private java.util.Date licvalidate;

	/** persistent field */
	private String connpers;

	/** persistent field */
	private String busconntel;

	/** persistent field */
	private String sendaddr;

	/** persistent field */
	private String recpers;

	/** persistent field */
	private String recconntel;

	/** persistent field */
	private String reccertno;

	/** persistent field */
	private String smsmobileno;

	/** persistent field */
	private String districtid;

	/** persistent field */
	private java.util.Date intime;

	/** persistent field */
	private String custmanager;

	/** persistent field */
	private java.util.Date starttime;

	/** persistent field */
	private String servpwd = "123456";

	/** persistent field */
	private Short state;

	/** persistent field */
	private String oldcoopera;

	private Double baillwrlmt = new Double(100);

	// 合作商负责人
	private String servman;

	/** nullable persistent field */
	private String memo;

	// 新增加五个字段
	private String waysubtype;

	private String cityid;

	private String countyid;

	private String svccode;

	private String mareacode;

	private Short taxtype;

	private String officetel;

	private Short oldstate;

	private Short isopen;

	private String _ne_state;

	private String provcode;

	private String _se_chainhead;
	
	private Short istietong;//是否原铁通网点
	
	private String brole;
	
	private String  companytype;
	
	public String getBrole() {
		return brole;
	}

	public void setBrole(String brole) {
		this.brole = brole;
	}

	public String getCompanytype() {
		return companytype;
	}

	public void setCompanytype(String companytype) {
		this.companytype = companytype;
	}

	public String get_se_chainhead() {
		return _se_chainhead;
	}

	public void set_se_chainhead(String _se_chainhead) {
		this._se_chainhead = _se_chainhead;
	}

	public String get_ne_state() {
		return _ne_state;
	}

	public void set_ne_state(String _ne_state) {
		this._ne_state = _ne_state;
	}

	public String getProvcode() {
		return provcode;
	}

	public void setProvcode(String provcode) {
		this.provcode = provcode;
	}

	public Short getTaxtype() {
		return taxtype;
	}

	public void setTaxtype(Short taxtype) {
		this.taxtype = taxtype;
	}

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

	private String _ne_mainlayer;

	private String _ne_starlevel;

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

	// =============Bchcontact===================

	public java.lang.String getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(java.lang.String principal) {
		this.principal = principal;
	}

	public java.lang.String getPrincipaltel() {
		return this.principaltel;
	}

	public void setPrincipaltel(java.lang.String principaltel) {
		this.principaltel = principaltel;
	}

	public java.lang.String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(java.lang.String linkman) {
		this.linkman = linkman;
	}

	public java.lang.String getLinkmantel() {
		return this.linkmantel;
	}

	public String getLinkmanemail() {
		return linkmanemail;
	}

	public void setLinkmanemail(String linkmanemail) {
		this.linkmanemail = linkmanemail;
	}

	public String getPrincipalemail() {
		return principalemail;
	}

	public void setPrincipalemail(String principalemail) {
		this.principalemail = principalemail;
	}

	public String getPrincipalphone() {
		return principalphone;
	}

	public void setPrincipalphone(String principalphone) {
		this.principalphone = principalphone;
	}

	public void setLinkmantel(java.lang.String linkmantel) {
		this.linkmantel = linkmantel;
	}

	public java.lang.String getHotline() {
		return this.hotline;
	}

	public void setHotline(java.lang.String hotline) {
		this.hotline = hotline;
	}

	public java.lang.String getFax() {
		return this.fax;
	}

	public void setFax(java.lang.String fax) {
		this.fax = fax;
	}

	// =========Waycompact=========================

	public Double getBail() {
		return bail;
	}

	public void setBail(Double bail) {
		this.bail = bail;
	}

	public Short getBailstatus() {
		return bailstatus;
	}

	public void setBailstatus(Short bailstatus) {
		this.bailstatus = bailstatus;
	}

	public String getCompactpath() {
		return compactpath;
	}

	public void setCompactpath(String compactpath) {
		this.compactpath = compactpath;
	}

	public Short getCompacttype() {
		return compacttype;
	}

	public void setCompacttype(Short compacttype) {
		this.compacttype = compacttype;
	}

	public String getLicenceno() {
		return licenceno;
	}

	public void setLicenceno(String licenceno) {
		this.licenceno = licenceno;
	}

	public String getLicencepath() {
		return licencepath;
	}

	public void setLicencepath(String licencepath) {
		this.licencepath = licencepath;
	}

	public Short getRunareatype() {
		return runareatype;
	}

	public void setRunareatype(Short runareatype) {
		this.runareatype = runareatype;
	}

	public java.lang.String getCompactno() {
		return this.compactno;
	}

	public void setCompactno(java.lang.String compactno) {
		this.compactno = compactno;
	}

	public java.lang.String getCompactname() {
		return this.compactname;
	}

	public void setCompactname(java.lang.String compactname) {
		this.compactname = compactname;
	}

	public java.sql.Date getBegintime() {
		return begintime;
	}

	public void setBegintime(java.sql.Date begintime) {
		this.begintime = begintime;
	}

	public java.sql.Date getSigntime() {
		return signtime;
	}

	public void setSigntime(java.sql.Date signtime) {
		this.signtime = signtime;
	}

	public java.lang.Short getCoptype() {
		return this.coptype;
	}

	public void setCoptype(java.lang.Short coptype) {
		this.coptype = coptype;
	}

	public java.lang.String getCopbound() {
		return this.copbound;
	}

	public void setCopbound(java.lang.String copbound) {
		this.copbound = copbound;
	}

	public java.lang.String getRecomrule() {
		return this.recomrule;
	}

	public void setRecomrule(java.lang.String recomrule) {
		this.recomrule = recomrule;
	}

	public java.lang.String getCompact() {
		return this.compact;
	}

	public void setCompact(java.lang.String compact) {
		this.compact = compact;
	}

	// =================wayaccount=========================
	public String getAcctfid() {
		return acctfid;
	}

	public void setAcctfid(String acctfid) {
		this.acctfid = acctfid;
	}

	public java.lang.Integer getAccid() {
		return this.accid;
	}

	public void setAccid(java.lang.Integer accid) {
		this.accid = accid;
	}

	public java.lang.String getWayid() {
		return this.wayid;
	}

	public void setWayid(java.lang.String wayid) {
		this.wayid = wayid;
	}

	public java.lang.Short getChargetype() {
		return this.chargetype;
	}

	public void setChargetype(java.lang.Short chargetype) {
		this.chargetype = chargetype;
	}

	public java.lang.Short getAccttype() {
		return this.accttype;
	}

	public void setAccttype(java.lang.Short accttype) {
		this.accttype = accttype;
	}

	public java.lang.String getAcctno() {
		return this.acctno;
	}

	public void setAcctno(java.lang.String acctno) {
		this.acctno = acctno;
	}

	public java.lang.String getAcctname() {
		return this.acctname;
	}

	public void setAcctname(java.lang.String acctname) {
		this.acctname = acctname;
	}

	public java.lang.String getBankname() {
		return this.bankname;
	}

	public void setBankname(java.lang.String bankname) {
		this.bankname = bankname;
	}

	public java.lang.String getDsbank() {
		return this.dsbank;
	}

	public void setDsbank(java.lang.String dsbank) {
		this.dsbank = dsbank;
	}

	public java.lang.String getBankaddr() {
		return this.bankaddr;
	}

	public void setBankaddr(java.lang.String bankaddr) {
		this.bankaddr = bankaddr;
	}

	public java.lang.String getContact() {
		return this.contact;
	}

	public void setContact(java.lang.String contact) {
		this.contact = contact;
	}

	public java.lang.String getContel() {
		return this.contel;
	}

	public void setContel(java.lang.String contel) {
		this.contel = contel;
	}

	public java.sql.Date getRectime() {
		return this.rectime;
	}

	public void setRectime(java.sql.Date rectime) {
		this.rectime = rectime;
	}


	public java.sql.Date getCmpendtime() {
		return this.cmpendtime;
	}

	public void setCmpendtime(java.sql.Date cmpendtime) {
		this.cmpendtime = cmpendtime;
	}

	public java.lang.String getBossarea() {
		return this.bossarea;
	}

	public void setBossarea(java.lang.String bossarea) {
		this.bossarea = bossarea;
	}

	// ============cooperator================
	public java.lang.String getCooperauid() {
		return this.cooperauid;
	}

	public void setCooperauid(java.lang.String cooperauid) {
		this.cooperauid = cooperauid;
	}

	public java.lang.String getCooperaname() {
		return this.cooperaname;
	}

	public void setCooperaname(java.lang.String cooperaname) {
		this.cooperaname = cooperaname;
	}

	public java.lang.String getCpabbrname() {
		return this.cpabbrname;
	}

	public void setCpabbrname(java.lang.String cpabbrname) {
		this.cpabbrname = cpabbrname;
	}

	public java.lang.String getCocheckname() {
		return this.cocheckname;
	}

	public void setCocheckname(java.lang.String cocheckname) {
		this.cocheckname = cocheckname;
	}

	public java.lang.String getCooperadel() {
		return this.cooperadel;
	}

	public void setCooperadel(java.lang.String cooperadel) {
		this.cooperadel = cooperadel;
	}

	public java.lang.String getPostaddr() {
		return this.postaddr;
	}

	public void setPostaddr(java.lang.String postaddr) {
		this.postaddr = postaddr;
	}

	public java.lang.String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(java.lang.String zipcode) {
		this.zipcode = zipcode;
	}

	public java.lang.String getConntel() {
		return this.conntel;
	}

	public void setConntel(java.lang.String conntel) {
		this.conntel = conntel;
	}

	public java.lang.String getConnfaxno() {
		return this.connfaxno;
	}

	public void setConnfaxno(java.lang.String connfaxno) {
		this.connfaxno = connfaxno;
	}

	public java.lang.String getUsremail() {
		return this.usremail;
	}

	public void setUsremail(java.lang.String usremail) {
		this.usremail = usremail;
	}

	public java.lang.Double getArea() {
		return this.area;
	}

	public void setArea(java.lang.Double area) {
		this.area = area;
	}

	public java.lang.String getLicenceid() {
		return this.licenceid;
	}

	public void setLicenceid(java.lang.String licenceid) {
		this.licenceid = licenceid;
	}

	public java.util.Date getLicvalidate() {
		return this.licvalidate;
	}

	public void setLicvalidate(java.util.Date licvalidate) {
		this.licvalidate = licvalidate;
	}

	public java.lang.String getConnpers() {
		return this.connpers;
	}

	public void setConnpers(java.lang.String connpers) {
		this.connpers = connpers;
	}

	public java.lang.String getBusconntel() {
		return this.busconntel;
	}

	public void setBusconntel(java.lang.String busconntel) {
		this.busconntel = busconntel;
	}

	public java.lang.String getSendaddr() {
		return this.sendaddr;
	}

	public void setSendaddr(java.lang.String sendaddr) {
		this.sendaddr = sendaddr;
	}

	public java.lang.String getRecpers() {
		return this.recpers;
	}

	public void setRecpers(java.lang.String recpers) {
		this.recpers = recpers;
	}

	public java.lang.String getRecconntel() {
		return this.recconntel;
	}

	public void setRecconntel(java.lang.String recconntel) {
		this.recconntel = recconntel;
	}

	public java.lang.String getReccertno() {
		return this.reccertno;
	}

	public void setReccertno(java.lang.String reccertno) {
		this.reccertno = reccertno;
	}

	public java.lang.String getSmsmobileno() {
		return this.smsmobileno;
	}

	public void setSmsmobileno(java.lang.String smsmobileno) {
		this.smsmobileno = smsmobileno;
	}

	public java.lang.String getDistrictid() {
		return this.districtid;
	}

	public void setDistrictid(java.lang.String districtid) {
		this.districtid = districtid;
	}

	public java.util.Date getIntime() {
		return this.intime;
	}

	public void setIntime(java.util.Date intime) {
		this.intime = intime;
	}

	public String getCustmanager() {
		return custmanager;
	}

	public void setCustmanager(String custmanager) {
		this.custmanager = custmanager;
	}

	public void setStarttime(java.util.Date starttime) {
		this.starttime = starttime;
	}

	public java.lang.String getServpwd() {
		return PWDHandle.encrypt(servpwd);
	}

	public void setServpwd(java.lang.String servpwd) {
		this.servpwd = PWDHandle.decrypt(servpwd);
	}

	public java.lang.Short getState() {
		return this.state;
	}

	public void setState(java.lang.Short state) {
		this.state = state;
	}

	public java.lang.String getOldcoopera() {
		return this.oldcoopera;
	}

	public void setOldcoopera(java.lang.String oldcoopera) {
		this.oldcoopera = oldcoopera;
	}

	public java.lang.String getMemo() {
		return this.memo;
	}

	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}

	public Double getBaillwrlmt() {
		return baillwrlmt;
	}

	public void setBaillwrlmt(Double baillwrlmt) {
		this.baillwrlmt = baillwrlmt;
	}

	public String getServman() {
		return servman;
	}

	public void setServman(String servman) {
		this.servman = servman;
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

	public java.util.Date getStarttime() {
		return starttime;
	}

	public String getReccerino() {
		return reccerino;
	}

	public void setReccerino(String reccerino) {
		this.reccerino = reccerino;
	}

	public FormFile getCompactfile() {
		return compactfile;
	}

	public void setCompactfile(FormFile compactfile) {
		this.compactfile = compactfile;
	}

	public FormFile getLicencefile() {
		return licencefile;
	}

	public void setLicencefile(FormFile licencefile) {
		this.licencefile = licencefile;
	}

	public String get_ne_mainlayer() {
		return _ne_mainlayer;
	}

	public void set_ne_mainlayer(String _ne_mainlayer) {
		this._ne_mainlayer = _ne_mainlayer;
	}

	public String get_ne_starlevel() {
		return _ne_starlevel;
	}

	public void set_ne_starlevel(String _ne_starlevel) {
		this._ne_starlevel = _ne_starlevel;
	}

	public Short getIsstraitprd() {
		return isstraitprd;
	}

	public void setIsstraitprd(Short isstraitprd) {
		this.isstraitprd = isstraitprd;
	}

	public String getUpperwayname() {
		return upperwayname;
	}

	public void setUpperwayname(String upperwayname) {
		this.upperwayname = upperwayname;
	}

	public Short getBailtype() {
		return bailtype;
	}

	public void setBailtype(Short bailtype) {
		this.bailtype = bailtype;
	}

	public Short getServbound() {
		return servbound;
	}

	public void setServbound(Short servbound) {
		this.servbound = servbound;
	}

	public String getBusnum() {
		return busnum;
	}

	public void setBusnum(String busnum) {
		this.busnum = busnum;
	}

	public Integer getCertitype() {
		return certitype;
	}

	public void setCertitype(Integer certitype) {
		this.certitype = certitype;
	}

	public String getCertnum() {
		return certinum;
	}

	public void setCertnum(String certinum) {
		this.certinum = certinum;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getCoplever() {
		return coplevel;
	}

	public void setCoplever(Integer coplevel) {
		this.coplevel = coplevel;
	}

	public String getRegadress() {
		return regadress;
	}

	public void setRegadress(String regadress) {
		this.regadress = regadress;
	}

	public Long getRegcapital() {
		return regcapital;
	}

	public void setRegcapital(Long regcapital) {
		this.regcapital = regcapital;
	}

	public String getCertinum() {
		return certinum;
	}

	public void setCertinum(String certinum) {
		this.certinum = certinum;
	}

	public Integer getCoplevel() {
		return coplevel;
	}

	public void setCoplevel(Integer coplevel) {
		this.coplevel = coplevel;
	}

	public String getOfficetel() {
		return officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

	public Short getOldstate() {
		return oldstate;
	}

	public void setOldstate(Short oldstate) {
		this.oldstate = oldstate;
	}

	public Short getIsopen() {
		return isopen;
	}

	public void setIsopen(Short isopen) {
		this.isopen = isopen;
	}

	public String get_ne_waytype() {
		return _ne_waytype;
	}

	public void set_ne_waytype(String _ne_waytype) {
		this._ne_waytype = _ne_waytype;
	}

	public String getDeacctname() {
		return deacctname;
	}

	public void setDeacctname(String deacctname) {
		this.deacctname = deacctname;
	}

	public String getDeacctno() {
		return deacctno;
	}

	public void setDeacctno(String deacctno) {
		this.deacctno = deacctno;
	}

	public String getDebankname() {
		return debankname;
	}

	public void setDebankname(String debankname) {
		this.debankname = debankname;
	}

	public Short getIsb2m() {
		return isb2m;
	}

	public void setIsb2m(Short isb2m) {
		this.isb2m = isb2m;
	}

	public String getSendFlag() {
		return sendFlag;
	}

	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}

	public String getSmsMsg() {
		return smsMsg;
	}

	public void setSmsMsg(String smsMsg) {
		this.smsMsg = smsMsg;
	}

	public String getOldValueStr() {
		return oldValueStr;
	}

	public void setOldValueStr(String oldValueStr) {
		this.oldValueStr = oldValueStr;
	}

	public Short getIsunpb() {
		return isunpb;
	}

	public void setIsunpb(Short isunpb) {
		this.isunpb = isunpb;
	}

	public Short getIstietong() {
		return istietong;
	}

	public void setIstietong(Short istietong) {
		this.istietong = istietong;
	}
}
