package com.gmcc.pboss.business.cms.way.persistent;


import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.cms.waylog.persistent.WaylogVO;

public class AGWayVO {
	/** identifier field */
	private String wayid;

	/** persistent field */
	private String wayname;

	/** persistent field */
	private String waytype;

	/** nullable persistent field */
	private String waysubtype;

	/** nullable persistent field */
	private String custtype;

	/** nullable persistent field */
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

	private String smsmobileno;
	
	private Short isb2m;

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

	private String sendaddr;

	private String recpers;

	private String recconntel;

	private String reccertno;

	private String linkman;

	private String linkmantel;

	private String compactno;

	private String compactname;

	private java.sql.Date begintime;

	private java.sql.Date cmpendtime;

	private java.sql.Date signtime;

	private Short compacttype;

	private String licenceno;

	private String compactpath;

	private String licencepath;

	private Double bail;

	private Short bailstatus;

	private Short bailtype;

	private Short servbound;

	private Date licvalidate;

	private Double baillwrlmt;

	private Integer accid;

	private Short chargetype;

	private Short accttype;

	private String acctno;

	private String acctname;

	private String bankname;

	private String acctfid;

	private Date intime;

	private String officetel;

	private Short oldstate;

	private Short isopen;

	private String provcode;

	private String deacctno;

	private String deacctname;

	private String debankname;
	
	//添加用于受理单打印处理
	private String sendFlag;//是否发送短信通知
	
	private String smsMsg;//短信内容

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

	public java.sql.Date getBegintime() {
		return begintime;
	}

	public Short getIsstraitprd() {
		return isstraitprd;
	}

	public void setIsstraitprd(Short isstraitprd) {
		this.isstraitprd = isstraitprd;
	}

	public void setBegintime(java.sql.Date begintime) {
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

	public java.sql.Date getCmpendtime() {
		return cmpendtime;
	}

	public void setCmpendtime(java.sql.Date cmpendtime) {
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

	public java.sql.Date getSigntime() {
		return signtime;
	}

	public void setSigntime(java.sql.Date signtime) {
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

	public Class logVOClass() {
		return WaylogVO.class;
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
}
