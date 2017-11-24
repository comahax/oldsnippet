package com.gmcc.pboss.business.channel.way;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

public class AGWayVO extends BaseVO implements Serializable{
	/** identifier field */
	private String wayid;

	/** persistent field */
	private String wayname;

	/** persistent field */
	private String waytype;


	/** nullable persistent field */
	private String custtype;

	/** nullable persistent field */
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

	
	private Short isb2m;
	
	private Short isunpb;

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

	/** 结束 */

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

	private String principal;

	private String principaltel;

	private String principalphone;

	private String principalemail;

	private String linkman;

	private String linkmantel;

	// ----------Waycompact------------------
	private String compactno;

	private String compactname;

	private java.util.Date begintime;

	private java.util.Date cmpendtime;

	private java.util.Date signtime;
	
    private Short coptype;
	
	private String copbound;
	
	private String recomrule;
	
	private String compact;

	private Short compacttype;

	private String licenceno;

	private String compactpath;

	private String licencepath;
	
	private Short runareatype;

	private Double bail;

	private Short bailstatus;

	private Short bailtype;

	private Short servbound;

	// =================wayaccount=========================
	private Integer accid;

	private Short chargetype;

	private Short accttype;

	private String acctno;

	private String acctname;

	private String bankname;

	private String acctfid;

	private String deacctno;

	private String deacctname;

	private String debankname;
	
	private String debankid;

	private Byte destate;
	
	private String dsbank;


	private String bankaddr;


	private String contact;


	private String contel;


	private java.util.Date rectime;
	
	private String bossarea;
	/*
	 * 12-21加
	 */
	private String fax;
	
	private String zipcode;

	private String linkmanemail;

	private String reccerino;

	private String company;

	private String busnum;

	private Integer coplevel;

	private Integer certitype;

	private String certinum;

	private String regadress;

	private Long regcapital;
	
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
	private String servpwd;

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
	
	private String upperwayname;

	private String _ne_waytype;
	private String oldValueStr;//原表单信息
	
	private String hotline;
	
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
	
	private String brole;
	    
	private String companytype;
	    
///	增加 特殊网点标志用来区分铁通网点
	
	private Short istietong;
	
	//配送商content页面新增字段
	private String employeename;
	/*
	 * 结束
	 */
	//添加用于受理单打印处理
	private String sendFlag;//是否发送短信通知
	
	private String smsMsg;//短信内容
	
    private Short calcumode;
    
    private String uniformtime;
    private Short distype;//合作商类型
    
    //新增网点注册码字段
    private String regid;
    
    //新增是否授权网点字段
    private String checked;
    
    //新增是否接入空中充值平台
    private Long isKzcz;
    
	//新增星级分层
    private String starlev;
    
    //WayprovinceVO
    //全网统一渠道编码
    private String uniquewayid;
    //乡镇
    private String town;
    //渠道基础类型
    private Short provtype;
    //是否手机卖场
    private Short mobilemall;
    //前台营业面积（㎡）
    private Double frontarea;
    //运营商ISP接入方式
    private Short ispconntype;
    
    
    private String istop;
    
    private String rewardkind;//社会渠道类型
    private String buscno;//商圈编码
    private String waymod;//连锁加盟渠道系数
    private String wayattr;//连锁加盟渠道属性
    
    private String creditlevel;//信用等级
    
    private Short taxcertificate;//税务资质
    
	public String getCreditlevel() {
		return creditlevel;
	}

	public void setCreditlevel(String creditlevel) {
		this.creditlevel = creditlevel;
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

	public Short getOldstate() {
		return oldstate;
	}

	public void setOldstate(Short oldstate) {
		this.oldstate = oldstate;
	}

	public String getAcctfid() {
		return acctfid;
	}

	public void setAcctfid(String acctfid) {
		this.acctfid = acctfid;
	}

	public String getAcctname() {
		return acctname;
	}

	public void setAcctname(String acctname) {
		this.acctname = acctname;
	}

	public String getAcctno() {
		return acctno;
	}

	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}

	public Double getBail() {
		return bail;
	}

	public void setBail(Double bail) {
		this.bail = bail;
	}

	public Double getBaillwrlmt() {
		return baillwrlmt;
	}

	public void setBaillwrlmt(Double baillwrlmt) {
		this.baillwrlmt = baillwrlmt;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public java.util.Date getBegintime() {
		return begintime;
	}

	public Short getIsstraitprd() {
		return isstraitprd;
	}

	public void setIsstraitprd(Short isstraitprd) {
		this.isstraitprd = isstraitprd;
	}

	public void setBegintime(java.util.Date begintime) {
		this.begintime = begintime;
	}

	public String getCompactname() {
		return compactname;
	}

	public void setCompactname(String compactname) {
		this.compactname = compactname;
	}

	public String getCompactno() {
		return compactno;
	}

	public void setCompactno(String compactno) {
		this.compactno = compactno;
	}

	public String getCompactpath() {
		return compactpath;
	}

	public void setCompactpath(String compactpath) {
		this.compactpath = compactpath;
	}

	public java.util.Date getCmpendtime() {
		return cmpendtime;
	}

	public void setCmpendtime(java.util.Date cmpendtime) {
		this.cmpendtime = cmpendtime;
	}

	public Date getIntime() {
		return intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
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

	public Date getLicvalidate() {
		return licvalidate;
	}

	public void setLicvalidate(Date licvalidate) {
		this.licvalidate = licvalidate;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
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

	public String getPrincipaltel() {
		return principaltel;
	}

	public void setPrincipaltel(String principaltel) {
		this.principaltel = principaltel;
	}

	public String getReccertno() {
		return reccertno;
	}

	public void setReccertno(String reccertno) {
		this.reccertno = reccertno;
	}

	public String getRecconntel() {
		return recconntel;
	}

	public void setRecconntel(String recconntel) {
		this.recconntel = recconntel;
	}

	public String getRecpers() {
		return recpers;
	}

	public void setRecpers(String recpers) {
		this.recpers = recpers;
	}

	public String getSendaddr() {
		return sendaddr;
	}

	public void setSendaddr(String sendaddr) {
		this.sendaddr = sendaddr;
	}

	public java.util.Date getSigntime() {
		return signtime;
	}

	public void setSigntime(java.util.Date signtime) {
		this.signtime = signtime;
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

	public String getIsshare() {
		return isshare;
	}

	public void setIsshare(String isshare) {
		this.isshare = isshare;
	}

	public java.lang.String getWayid() {
		return this.wayid;
	}

	public void setWayid(java.lang.String wayid) {
		this.wayid = wayid;
	}

	public java.lang.String getWayname() {
		return this.wayname;
	}

	public void setWayname(java.lang.String wayname) {
		this.wayname = wayname;
	}

	public java.lang.String getWaytype() {
		return this.waytype;
	}

	public void setWaytype(java.lang.String waytype) {
		this.waytype = waytype;
	}

	public java.lang.String getWaysubtype() {
		return this.waysubtype;
	}

	public void setWaysubtype(java.lang.String waysubtype) {
		this.waysubtype = waysubtype;
	}

	public java.lang.String getCusttype() {
		return this.custtype;
	}

	public void setCusttype(java.lang.String custtype) {
		this.custtype = custtype;
	}

	public java.lang.String getUpperwayid() {
		return this.upperwayid;
	}

	public void setUpperwayid(java.lang.String upperwayid) {
		this.upperwayid = upperwayid;
	}

	public java.lang.String getCountyid() {
		return this.countyid;
	}

	public void setCountyid(java.lang.String countyid) {
		this.countyid = countyid;
	}

	public java.lang.String getCityid() {
		return this.cityid;
	}

	public void setCityid(java.lang.String cityid) {
		this.cityid = cityid;
	}

	public java.lang.String getCenterid() {
		return this.centerid;
	}

	public void setCenterid(java.lang.String centerid) {
		this.centerid = centerid;
	}

	public java.lang.Short getCitylevel() {
		return this.citylevel;
	}

	public void setCitylevel(java.lang.Short citylevel) {
		this.citylevel = citylevel;
	}

	public java.lang.Short getWaylevel() {
		return this.waylevel;
	}

	public void setWaylevel(java.lang.Short waylevel) {
		this.waylevel = waylevel;
	}

	public java.lang.String getBchlevel() {
		return this.bchlevel;
	}

	public void setBchlevel(java.lang.String bchlevel) {
		this.bchlevel = bchlevel;
	}

	public java.lang.String getFunction() {
		return this.function;
	}

	public void setFunction(java.lang.String function) {
		this.function = function;
	}

	public java.lang.String getMiscode() {
		return this.miscode;
	}

	public void setMiscode(java.lang.String miscode) {
		this.miscode = miscode;
	}

	public java.lang.Short getWaystate() {
		return this.waystate;
	}

	public void setWaystate(java.lang.Short waystate) {
		this.waystate = waystate;
	}

	public java.util.Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public java.util.Date getDisabletime() {
		return this.disabletime;
	}

	public void setDisabletime(java.util.Date disabletime) {
		this.disabletime = disabletime;
	}

	public String toString() {
		return new ToStringBuilder(this).append("wayid", getWayid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof WayVO))
			return false;
		WayVO castOther = (WayVO) other;
		return new EqualsBuilder()
				.append(this.getWayid(), castOther.getWayid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getWayid()).toHashCode();
	}

	public String getBusicode() {
		return busicode;
	}

	public void setBusicode(String busicode) {
		this.busicode = busicode;
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

	public Integer getAlarmbizamount() {
		return alarmbizamount;
	}

	public void setAlarmbizamount(Integer alarmbizamount) {
		this.alarmbizamount = alarmbizamount;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinkmantel() {
		return linkmantel;
	}

	public void setLinkmantel(String linkmantel) {
		this.linkmantel = linkmantel;
	}

	public Short getBailstatus() {
		return bailstatus;
	}

	public void setBailstatus(Short bailstatus) {
		this.bailstatus = bailstatus;
	}

	public Integer getAccid() {
		return accid;
	}

	public void setAccid(Integer accid) {
		this.accid = accid;
	}

	public Short getAccttype() {
		return accttype;
	}

	public void setAccttype(Short accttype) {
		this.accttype = accttype;
	}

	public Short getChargetype() {
		return chargetype;
	}

	public void setChargetype(Short chargetype) {
		this.chargetype = chargetype;
	}

	public String getSmsmobileno() {
		return smsmobileno;
	}

	public void setSmsmobileno(String smsmobileno) {
		this.smsmobileno = smsmobileno;
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

	public Short getCompacttype() {
		return compacttype;
	}

	public void setCompacttype(Short compacttype) {
		this.compacttype = compacttype;
	}

	public String getOfficetel() {
		return officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

	public Short getIsopen() {
		return isopen;
	}

	public void setIsopen(Short isopen) {
		this.isopen = isopen;
	}

	public String getProvcode() {
		return provcode;
	}

	public void setProvcode(String provcode) {
		this.provcode = provcode;
	}

	public Short getIsb2m() {
		return isb2m;
	}

	public void setIsb2m(Short isb2m) {
		this.isb2m = isb2m;
	}

	public Short getIsunpb() {
		return isunpb;
	}

	public void setIsunpb(Short isunpb) {
		this.isunpb = isunpb;
	}

	public Short getCoptype() {
		return coptype;
	}

	public void setCoptype(Short coptype) {
		this.coptype = coptype;
	}

	public String getCopbound() {
		return copbound;
	}

	public void setCopbound(String copbound) {
		this.copbound = copbound;
	}

	public String getRecomrule() {
		return recomrule;
	}

	public void setRecomrule(String recomrule) {
		this.recomrule = recomrule;
	}

	public String getCompact() {
		return compact;
	}

	public void setCompact(String compact) {
		this.compact = compact;
	}

	public Short getRunareatype() {
		return runareatype;
	}

	public void setRunareatype(Short runareatype) {
		this.runareatype = runareatype;
	}

	public String getDsbank() {
		return dsbank;
	}

	public void setDsbank(String dsbank) {
		this.dsbank = dsbank;
	}

	public String getBankaddr() {
		return bankaddr;
	}

	public void setBankaddr(String bankaddr) {
		this.bankaddr = bankaddr;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContel() {
		return contel;
	}

	public void setContel(String contel) {
		this.contel = contel;
	}

	public java.util.Date getRectime() {
		return rectime;
	}

	public void setRectime(java.util.Date rectime) {
		this.rectime = rectime;
	}

	public String getBossarea() {
		return bossarea;
	}

	public void setBossarea(String bossarea) {
		this.bossarea = bossarea;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getLinkmanemail() {
		return linkmanemail;
	}

	public void setLinkmanemail(String linkmanemail) {
		this.linkmanemail = linkmanemail;
	}

	public String getReccerino() {
		return reccerino;
	}

	public void setReccerino(String reccerino) {
		this.reccerino = reccerino;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getBusnum() {
		return busnum;
	}

	public void setBusnum(String busnum) {
		this.busnum = busnum;
	}

	public Integer getCoplevel() {
		return coplevel;
	}

	public void setCoplevel(Integer coplevel) {
		this.coplevel = coplevel;
	}

	public Integer getCertitype() {
		return certitype;
	}

	public void setCertitype(Integer certitype) {
		this.certitype = certitype;
	}

	public String getCertinum() {
		return certinum;
	}

	public void setCertinum(String certinum) {
		this.certinum = certinum;
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

	public String getCooperauid() {
		return cooperauid;
	}

	public void setCooperauid(String cooperauid) {
		this.cooperauid = cooperauid;
	}

	public String getCooperaname() {
		return cooperaname;
	}

	public void setCooperaname(String cooperaname) {
		this.cooperaname = cooperaname;
	}

	public String getCpabbrname() {
		return cpabbrname;
	}

	public void setCpabbrname(String cpabbrname) {
		this.cpabbrname = cpabbrname;
	}

	public String getCocheckname() {
		return cocheckname;
	}

	public void setCocheckname(String cocheckname) {
		this.cocheckname = cocheckname;
	}

	public String getCooperadel() {
		return cooperadel;
	}

	public void setCooperadel(String cooperadel) {
		this.cooperadel = cooperadel;
	}

	public String getPostaddr() {
		return postaddr;
	}

	public void setPostaddr(String postaddr) {
		this.postaddr = postaddr;
	}

	public String getConntel() {
		return conntel;
	}

	public void setConntel(String conntel) {
		this.conntel = conntel;
	}

	public String getConnfaxno() {
		return connfaxno;
	}

	public void setConnfaxno(String connfaxno) {
		this.connfaxno = connfaxno;
	}

	public String getUsremail() {
		return usremail;
	}

	public void setUsremail(String usremail) {
		this.usremail = usremail;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public String getLicenceid() {
		return licenceid;
	}

	public void setLicenceid(String licenceid) {
		this.licenceid = licenceid;
	}

	public String getConnpers() {
		return connpers;
	}

	public void setConnpers(String connpers) {
		this.connpers = connpers;
	}

	public String getBusconntel() {
		return busconntel;
	}

	public void setBusconntel(String busconntel) {
		this.busconntel = busconntel;
	}

	public String getDistrictid() {
		return districtid;
	}

	public void setDistrictid(String districtid) {
		this.districtid = districtid;
	}

	public String getCustmanager() {
		return custmanager;
	}

	public void setCustmanager(String custmanager) {
		this.custmanager = custmanager;
	}

	public String getServpwd() {
		if (this.servpwd == null || "".equals(servpwd)) {
			return "JONNAEIDFNHM";
		} else {
			return servpwd;
		}
	}

	public void setServpwd(String servpwd) {
		this.servpwd = servpwd;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public String getOldcoopera() {
		return oldcoopera;
	}

	public void setOldcoopera(String oldcoopera) {
		this.oldcoopera = oldcoopera;
	}

	public String getServman() {
		return servman;
	}

	public void setServman(String servman) {
		this.servman = servman;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Short getTaxtype() {
		return taxtype;
	}

	public void setTaxtype(Short taxtype) {
		this.taxtype = taxtype;
	}

	public String get_ne_state() {
		return _ne_state;
	}

	public void set_ne_state(String _ne_state) {
		this._ne_state = _ne_state;
	}

	public String get_se_chainhead() {
		return _se_chainhead;
	}

	public void set_se_chainhead(String _se_chainhead) {
		this._se_chainhead = _se_chainhead;
	}

	public String getUpperwayname() {
		return upperwayname;
	}

	public void setUpperwayname(String upperwayname) {
		this.upperwayname = upperwayname;
	}

	public String get_ne_waytype() {
		return _ne_waytype;
	}

	public void set_ne_waytype(String _ne_waytype) {
		this._ne_waytype = _ne_waytype;
	}

	public String getOldValueStr() {
		return oldValueStr;
	}

	public void setOldValueStr(String oldValueStr) {
		this.oldValueStr = oldValueStr;
	}

	public String getHotline() {
		return hotline;
	}

	public void setHotline(String hotline) {
		this.hotline = hotline;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_sk_wayid() {
		return _sk_wayid;
	}

	public void set_sk_wayid(String _sk_wayid) {
		this._sk_wayid = _sk_wayid;
	}

	public String get_se_upperwayid() {
		return _se_upperwayid;
	}

	public void set_se_upperwayid(String _se_upperwayid) {
		this._se_upperwayid = _se_upperwayid;
	}

	public String get_sk_wayname() {
		return _sk_wayname;
	}

	public void set_sk_wayname(String _sk_wayname) {
		this._sk_wayname = _sk_wayname;
	}

	public String get_se_waytype() {
		return _se_waytype;
	}

	public void set_se_waytype(String _se_waytype) {
		this._se_waytype = _se_waytype;
	}

	public String get_se_waysubtype() {
		return _se_waysubtype;
	}

	public void set_se_waysubtype(String _se_waysubtype) {
		this._se_waysubtype = _se_waysubtype;
	}

	public String get_se_countyid() {
		return _se_countyid;
	}

	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_se_centerid() {
		return _se_centerid;
	}

	public void set_se_centerid(String _se_centerid) {
		this._se_centerid = _se_centerid;
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

	public String get_ne_cooperator() {
		return _ne_cooperator;
	}

	public void set_ne_cooperator(String _ne_cooperator) {
		this._ne_cooperator = _ne_cooperator;
	}

	public String get_se_svccode() {
		return _se_svccode;
	}

	public void set_se_svccode(String _se_svccode) {
		this._se_svccode = _se_svccode;
	}

	public String get_se_mareacode() {
		return _se_mareacode;
	}

	public void set_se_mareacode(String _se_mareacode) {
		this._se_mareacode = _se_mareacode;
	}

	public String get_sql_waysubtype() {
		return _sql_waysubtype;
	}

	public void set_sql_waysubtype(String _sql_waysubtype) {
		this._sql_waysubtype = _sql_waysubtype;
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

	public String getDebankid() {
		return debankid;
	}

	public void setDebankid(String debankid) {
		this.debankid = debankid;
	}

	public Byte getDestate() {
		return destate;
	}

	public void setDestate(Byte destate) {
		this.destate = destate;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

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

	public Short getIstietong() {
		return istietong;
	}

	public void setIstietong(Short istietong) {
		this.istietong = istietong;
	}

	public Short getCalcumode() {
		return calcumode;
	}

	public void setCalcumode(Short calcumode) {
		this.calcumode = calcumode;
	}

	public String getUniformtime() {
		return uniformtime;
	}

	public void setUniformtime(String uniformtime) {
		this.uniformtime = uniformtime;
	}

	public String getRegid() {
		return regid;
	}

	public void setRegid(String regid) {
		this.regid = regid;
	}

	public Short getDistype() {
		return distype;
	}

	public void setDistype(Short distype) {
		this.distype = distype;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public Long getIsKzcz() {
		return isKzcz;
	}

	public void setIsKzcz(Long isKzcz) {
		this.isKzcz = isKzcz;
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

	public Short getIspconntype() {
		return ispconntype;
	}

	public void setIspconntype(Short ispconntype) {
		this.ispconntype = ispconntype;
	}

	public String getStarlev() {
		return starlev;
	}

	public void setStarlev(String starlev) {
		this.starlev = starlev;
	}

	public String getIstop() {
		return istop;
	}

	public void setIstop(String istop) {
		this.istop = istop;
	}

	public String getRewardkind() {
		return rewardkind;
	}

	public void setRewardkind(String rewardkind) {
		this.rewardkind = rewardkind;
	}

	public String getBuscno() {
		return buscno;
	}

	public void setBuscno(String buscno) {
		this.buscno = buscno;
	}

	public String getWaymod() {
		return waymod;
	}

	public void setWaymod(String waymod) {
		this.waymod = waymod;
	}

	public String getWayattr() {
		return wayattr;
	}

	public void setWayattr(String wayattr) {
		this.wayattr = wayattr;
	}

	public Short getTaxcertificate() {
		return taxcertificate;
	}

	public void setTaxcertificate(Short taxcertificate) {
		this.taxcertificate = taxcertificate;
	}	
	
}
