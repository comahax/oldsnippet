package com.gmcc.pboss.business.channel.wayapplylog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WayapplylogVO extends BaseVO implements BusinessLog {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date opntime;

    /** nullable persistent field */
    private String opncode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private Long applyno;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private Short auditstatus;

    /** nullable persistent field */
    private String description;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private String waysubtype;

    /** nullable persistent field */
    private String upperwayid;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private Short pt;

    /** nullable persistent field */
    private Short waystate;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String svccode;

    /** nullable persistent field */
    private String mareacode;

    /** nullable persistent field */
    private Short isstraitprd;

    /** nullable persistent field */
    private Short adtypecode;

    /** nullable persistent field */
    private String adacode;

    /** nullable persistent field */
    private Short formtype;

    /** nullable persistent field */
    private java.util.Date starttime;

    /** nullable persistent field */
    private Integer buzarea;

    /** nullable persistent field */
    private String logiscode;

    /** nullable persistent field */
    private String waymagcode;

    /** nullable persistent field */
    private String bchlevel;

    /** nullable persistent field */
    private String officetel;

    /** nullable persistent field */
    private Long alarmbizamount;

    /** nullable persistent field */
    private String address;

    /** nullable persistent field */
    private String latitude;

    /** nullable persistent field */
    private String longtitude;

    /** nullable persistent field */
    private String principal;

    /** nullable persistent field */
    private String principaltel;

    /** nullable persistent field */
    private String principalphone;

    /** nullable persistent field */
    private String principalemail;

    /** nullable persistent field */
    private String sendaddr;

    /** nullable persistent field */
    private String acctno;

    /** nullable persistent field */
    private String acctname;

    /** nullable persistent field */
    private String bankname;

    /** nullable persistent field */
    private String acctfid;

    /** nullable persistent field */
    private String deacctno;

    /** nullable persistent field */
    private String deacctname;

    /** nullable persistent field */
    private String debankname;

    /** nullable persistent field */
    private Short accttype;

    /** nullable persistent field */
    private java.util.Date intime;

    /** nullable persistent field */
    private Short catetype;

    /** nullable persistent field */
    private String chainhead;

    /** nullable persistent field */
    private String recpers;

    /** nullable persistent field */
    private String recconntel;

    /** nullable persistent field */
    private String reccertno;

    /** nullable persistent field */
    private Short signstatus;

    /** nullable persistent field */
    private String provcode;

    /** nullable persistent field */
    private Short bailtype;

    /** nullable persistent field */
    private Short servbound;

    /** nullable persistent field */
    private String compactno;

    /** nullable persistent field */
    private String compactname;

    /** nullable persistent field */
    private java.util.Date begintime;

    /** nullable persistent field */
    private java.util.Date endtime;

    /** nullable persistent field */
    private java.util.Date signtime;

    /** nullable persistent field */
    private Short compacttype;

    /** nullable persistent field */
    private String licenceno;

    /** nullable persistent field */
    private Double bail;

    /** nullable persistent field */
    private Double baillwrlmt;

    /** nullable persistent field */
    private java.util.Date licvalidate;

    /** nullable persistent field */
    private Short bailstatus;

    /** nullable persistent field */
    private Byte isb2m;

    /** nullable persistent field */
    private String smsmobileno;
    
    private Byte isunpb;

	private Short istietong;
	
	private Long connecttype;
	
	private Short sublayer;
	
	private Short buztypecode;
	
	// 新增字段
	// 网点注册码
	private String regid;
	// 是否授权网点
	private String checked;
	// 是否接入空中充值平台
	private Short isKzcz;
	// 星级分层
	private String starlev;
	// 全网统一渠道编码
	private String uniquewayid;
	// 乡镇
	private String town;
	// 渠道基础类型
	private Short provtype;
	// 是否手机卖场
	private Short mobilemail;
	// 前台营业面积（㎡）
	private Double frontarea;
	// 运营商ISP接入方式
	private Short ispconntype;
	// 合作层级
	private Short mainlayer;
	// 业务联系号码
	private String buzphoneno;
	// 合作方
	private Short cooperator;
	// 扣税方式
	private Short taxtype;
	// 合作商类型
	private Short distype;
	// 联系人
	private String linkman;
	// 联系电话
	private String linkmantel;
	// 业务联系人电子邮箱
	private String linkmanemail;
	// 合作单位
	private String company;
	// 合作商级别
	private Short coplevel;
	// 工商号
	private String busnum;
	// 证件类别
	private Short certitype;
	// 注册地址
	private String regadress;
	// 注册资金
	private Long regcapital;
	// 公司类型
	private String companytype;
	// 职位
	private String brole;
	// 证件编码
	private String certinum;
	// 合作业务范围
	private String copbound;
	// 经营区域类型
	private Short runareatype;
	// 管理模式
	private Short calcumode;
	// 统一模式开始时间
	private String uniformtime;
	// 审批数据来源
	private String comefrom;
	// 合同协议原件路径
	private String compactpath;
	// 营业执照文件路径
	private String licencepath;
	
	//是否TOP网点
	private String istop;
	
    /** full constructor */
    public WayapplylogVO(java.lang.Long logid, java.util.Date opntime,
			java.lang.String opncode, java.lang.String oprtype,
			java.lang.Long applyno, java.util.Date optime,
			java.lang.Short auditstatus, java.lang.String description,
			java.lang.String wayid, java.lang.String wayname,
			java.lang.String waysubtype, java.lang.String upperwayid,
			java.lang.Short starlevel, java.lang.Short pt,
			java.lang.Short waystate, java.lang.String cityid,
			java.lang.String countyid, java.lang.String svccode,
			java.lang.String mareacode, java.lang.Short isstraitprd,
			java.lang.Short adtypecode, java.lang.String adacode,
			java.lang.Short formtype, java.util.Date starttime,
			java.lang.Integer buzarea, java.lang.String logiscode,
			java.lang.String waymagcode, java.lang.String bchlevel,
			java.lang.String officetel, java.lang.Long alarmbizamount,
			java.lang.String address, java.lang.String latitude,
			java.lang.String longtitude, java.lang.String principal,
			java.lang.String principaltel, java.lang.String principalphone,
			java.lang.String principalemail, java.lang.String sendaddr,
			java.lang.String acctno, java.lang.String acctname,
			java.lang.String bankname, java.lang.String acctfid,
			java.lang.String deacctno, java.lang.String deacctname,
			java.lang.String debankname, java.lang.Short accttype,
			java.util.Date intime, java.lang.Short catetype,
			java.lang.String chainhead, java.lang.String recpers,
			java.lang.String recconntel, java.lang.String reccertno,
			java.lang.Short signstatus, java.lang.String provcode,
			java.lang.Short bailtype, java.lang.Short servbound,
			java.lang.String compactno, java.lang.String compactname,
			java.util.Date begintime, java.util.Date endtime,
			java.util.Date signtime, java.lang.Short compacttype,
			java.lang.String licenceno, java.lang.Double bail,
			java.lang.Double baillwrlmt, java.util.Date licvalidate,
			java.lang.Short bailstatus, java.lang.Byte isb2m,
			java.lang.Byte isunpb, java.lang.String smsmobileno,
			String regid,
			String checked,
			Short isKzcz,
			String starlev,
			String uniquewayid,
			String town,
			Short provtype,
			Short mobilemail,
			Double frontarea,
			Short ispconntype,
			Short mainlayer,
			String buzphoneno,
			Short cooperator,
			Short taxtype,
			Short distype,
			String linkman,
			String linkmantel,
			String linkmanemail,
			String company,
			Short coplevel,
			String busnum,
			Short certitype,
			String regadress,
			Long regcapital,
			String companytype,
			String brole,
			String certinum,
			String copbound,
			Short runareatype,
			Short calcumode,
			String uniformtime,
			String comefrom,
			String compactpath,
			String licencepath,
			Long connecttype,Short istietong,Short sublayer,Short buztypecode,String istop) {
        this.logid = logid;
        this.opntime = opntime;
        this.opncode = opncode;
        this.oprtype = oprtype;
        this.applyno = applyno;
        this.optime = optime;
        this.auditstatus = auditstatus;
        this.description = description;
        this.wayid = wayid;
        this.wayname = wayname;
        this.waysubtype = waysubtype;
        this.upperwayid = upperwayid;
        this.starlevel = starlevel;
        this.pt = pt;
        this.waystate = waystate;
        this.cityid = cityid;
        this.countyid = countyid;
        this.svccode = svccode;
        this.mareacode = mareacode;
        this.isstraitprd = isstraitprd;
        this.adtypecode = adtypecode;
        this.adacode = adacode;
        this.formtype = formtype;
        this.starttime = starttime;
        this.buzarea = buzarea;
        this.logiscode = logiscode;
        this.waymagcode = waymagcode;
        this.bchlevel = bchlevel;
        this.officetel = officetel;
        this.alarmbizamount = alarmbizamount;
        this.address = address;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.principal = principal;
        this.principaltel = principaltel;
        this.principalphone = principalphone;
        this.principalemail = principalemail;
        this.sendaddr = sendaddr;
        this.acctno = acctno;
        this.acctname = acctname;
        this.bankname = bankname;
        this.acctfid = acctfid;
        this.deacctno = deacctno;
        this.deacctname = deacctname;
        this.debankname = debankname;
        this.accttype = accttype;
        this.intime = intime;
        this.catetype = catetype;
        this.chainhead = chainhead;
        this.recpers = recpers;
        this.recconntel = recconntel;
        this.reccertno = reccertno;
        this.signstatus = signstatus;
        this.provcode = provcode;
        this.bailtype = bailtype;
        this.servbound = servbound;
        this.compactno = compactno;
        this.compactname = compactname;
        this.begintime = begintime;
        this.endtime = endtime;
        this.signtime = signtime;
        this.compacttype = compacttype;
        this.licenceno = licenceno;
        this.bail = bail;
        this.baillwrlmt = baillwrlmt;
        this.licvalidate = licvalidate;
        this.bailstatus = bailstatus;
        this.isb2m = isb2m;
        this.isunpb = isunpb;
        this.smsmobileno = smsmobileno;
    	this.connecttype=connecttype;
		this.buztypecode=buztypecode;
		this.istietong=istietong;
		this.sublayer=sublayer;
		
		// 新增字段
		 this.regid =  regid; 
		 this.checked = checked;   
		 this.isKzcz = isKzcz; 
		 this.starlev = starlev;   
		 this.uniquewayid = uniquewayid; 
		 this.town =  town;  
		 this.provtype =   provtype;  
		 this.mobilemail =  mobilemail; 
		 this.frontarea =  frontarea;  
		 this.ispconntype = ispconntype; 
		 this.mainlayer =  mainlayer;  
		 this.buzphoneno =  buzphoneno; 
		 this.cooperator =  cooperator; 
		 this.taxtype = taxtype;   
		 this.distype = distype;   
		 this.linkman = linkman;   
		 this.linkmantel =  linkmantel; 
		 this.linkmanemail = linkmanemail;
		 this.company = company;   
		 this.coplevel =   coplevel;  
		 this.busnum = busnum; 
		 this.certitype =  certitype;  
		 this.regadress =  regadress;  
		 this.regcapital =  regcapital; 
		 this.companytype = companytype; 
		 this.brole =  brole; 
		 this.certinum =   certinum;  
		 this.copbound =   copbound;  
		 this.runareatype = runareatype; 
		 this.calcumode =  calcumode;  
		 this.uniformtime = uniformtime; 
		 this.comefrom =   comefrom; 
		 this.compactpath =   compactpath; 
		 this.licencepath =   licencepath; 
		 this.istop = istop;
    }

    /** default constructor */
    public WayapplylogVO() {
    }

    /** minimal constructor */
    public WayapplylogVO(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOpntime() {
        return this.opntime;
    }

    public void setOpntime(java.util.Date opntime) {
        this.opntime = opntime;
    }

    public java.lang.String getOpncode() {
        return this.opncode;
    }

    public void setOpncode(java.lang.String opncode) {
        this.opncode = opncode;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.Long getApplyno() {
        return this.applyno;
    }

    public void setApplyno(java.lang.Long applyno) {
        this.applyno = applyno;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.Short getAuditstatus() {
        return this.auditstatus;
    }

    public void setAuditstatus(java.lang.Short auditstatus) {
        this.auditstatus = auditstatus;
    }

    public java.lang.String getDescription() {
        return this.description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
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

    public java.lang.String getWaysubtype() {
        return this.waysubtype;
    }

    public void setWaysubtype(java.lang.String waysubtype) {
        this.waysubtype = waysubtype;
    }

    public java.lang.String getUpperwayid() {
        return this.upperwayid;
    }

    public void setUpperwayid(java.lang.String upperwayid) {
        this.upperwayid = upperwayid;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.Short getPt() {
        return this.pt;
    }

    public void setPt(java.lang.Short pt) {
        this.pt = pt;
    }

    public java.lang.Short getWaystate() {
        return this.waystate;
    }

    public void setWaystate(java.lang.Short waystate) {
        this.waystate = waystate;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getSvccode() {
        return this.svccode;
    }

    public void setSvccode(java.lang.String svccode) {
        this.svccode = svccode;
    }

    public java.lang.String getMareacode() {
        return this.mareacode;
    }

    public void setMareacode(java.lang.String mareacode) {
        this.mareacode = mareacode;
    }

    public java.lang.Short getIsstraitprd() {
        return this.isstraitprd;
    }

    public void setIsstraitprd(java.lang.Short isstraitprd) {
        this.isstraitprd = isstraitprd;
    }

    public java.lang.Short getAdtypecode() {
        return this.adtypecode;
    }

    public void setAdtypecode(java.lang.Short adtypecode) {
        this.adtypecode = adtypecode;
    }

    public java.lang.String getAdacode() {
        return this.adacode;
    }

    public void setAdacode(java.lang.String adacode) {
        this.adacode = adacode;
    }

    public java.lang.Short getFormtype() {
        return this.formtype;
    }

    public void setFormtype(java.lang.Short formtype) {
        this.formtype = formtype;
    }

    public java.util.Date getStarttime() {
        return this.starttime;
    }

    public void setStarttime(java.util.Date starttime) {
        this.starttime = starttime;
    }

    public java.lang.Integer getBuzarea() {
        return this.buzarea;
    }

    public void setBuzarea(java.lang.Integer buzarea) {
        this.buzarea = buzarea;
    }

    public java.lang.String getLogiscode() {
        return this.logiscode;
    }

    public void setLogiscode(java.lang.String logiscode) {
        this.logiscode = logiscode;
    }

    public java.lang.String getWaymagcode() {
        return this.waymagcode;
    }

    public void setWaymagcode(java.lang.String waymagcode) {
        this.waymagcode = waymagcode;
    }

    public java.lang.String getBchlevel() {
        return this.bchlevel;
    }

    public void setBchlevel(java.lang.String bchlevel) {
        this.bchlevel = bchlevel;
    }

    public java.lang.String getOfficetel() {
        return this.officetel;
    }

    public void setOfficetel(java.lang.String officetel) {
        this.officetel = officetel;
    }

    public java.lang.Long getAlarmbizamount() {
        return this.alarmbizamount;
    }

    public void setAlarmbizamount(java.lang.Long alarmbizamount) {
        this.alarmbizamount = alarmbizamount;
    }

    public java.lang.String getAddress() {
        return this.address;
    }

    public void setAddress(java.lang.String address) {
        this.address = address;
    }

    public java.lang.String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(java.lang.String latitude) {
        this.latitude = latitude;
    }

    public java.lang.String getLongtitude() {
        return this.longtitude;
    }

    public void setLongtitude(java.lang.String longtitude) {
        this.longtitude = longtitude;
    }

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

    public java.lang.String getPrincipalphone() {
        return this.principalphone;
    }

    public void setPrincipalphone(java.lang.String principalphone) {
        this.principalphone = principalphone;
    }

    public java.lang.String getPrincipalemail() {
        return this.principalemail;
    }

    public void setPrincipalemail(java.lang.String principalemail) {
        this.principalemail = principalemail;
    }

    public java.lang.String getSendaddr() {
        return this.sendaddr;
    }

    public void setSendaddr(java.lang.String sendaddr) {
        this.sendaddr = sendaddr;
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

    public java.lang.String getAcctfid() {
        return this.acctfid;
    }

    public void setAcctfid(java.lang.String acctfid) {
        this.acctfid = acctfid;
    }

    public java.lang.String getDeacctno() {
        return this.deacctno;
    }

    public void setDeacctno(java.lang.String deacctno) {
        this.deacctno = deacctno;
    }

    public java.lang.String getDeacctname() {
        return this.deacctname;
    }

    public void setDeacctname(java.lang.String deacctname) {
        this.deacctname = deacctname;
    }

    public java.lang.String getDebankname() {
        return this.debankname;
    }

    public void setDebankname(java.lang.String debankname) {
        this.debankname = debankname;
    }

    public java.lang.Short getAccttype() {
        return this.accttype;
    }

    public void setAccttype(java.lang.Short accttype) {
        this.accttype = accttype;
    }

    public java.util.Date getIntime() {
        return this.intime;
    }

    public void setIntime(java.util.Date intime) {
        this.intime = intime;
    }

    public java.lang.Short getCatetype() {
        return this.catetype;
    }

    public void setCatetype(java.lang.Short catetype) {
        this.catetype = catetype;
    }

    public java.lang.String getChainhead() {
        return this.chainhead;
    }

    public void setChainhead(java.lang.String chainhead) {
        this.chainhead = chainhead;
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

    public java.lang.Short getSignstatus() {
        return this.signstatus;
    }

    public void setSignstatus(java.lang.Short signstatus) {
        this.signstatus = signstatus;
    }

    public java.lang.String getProvcode() {
        return this.provcode;
    }

    public void setProvcode(java.lang.String provcode) {
        this.provcode = provcode;
    }

    public java.lang.Short getBailtype() {
        return this.bailtype;
    }

    public void setBailtype(java.lang.Short bailtype) {
        this.bailtype = bailtype;
    }

    public java.lang.Short getServbound() {
        return this.servbound;
    }

    public void setServbound(java.lang.Short servbound) {
        this.servbound = servbound;
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

    public java.util.Date getBegintime() {
        return this.begintime;
    }

    public void setBegintime(java.util.Date begintime) {
        this.begintime = begintime;
    }

    public java.util.Date getEndtime() {
        return this.endtime;
    }

    public void setEndtime(java.util.Date endtime) {
        this.endtime = endtime;
    }

    public java.util.Date getSigntime() {
        return this.signtime;
    }

    public void setSigntime(java.util.Date signtime) {
        this.signtime = signtime;
    }

    public java.lang.Short getCompacttype() {
        return this.compacttype;
    }

    public void setCompacttype(java.lang.Short compacttype) {
        this.compacttype = compacttype;
    }

    public java.lang.String getLicenceno() {
        return this.licenceno;
    }

    public void setLicenceno(java.lang.String licenceno) {
        this.licenceno = licenceno;
    }

    public java.lang.Double getBail() {
        return this.bail;
    }

    public void setBail(java.lang.Double bail) {
        this.bail = bail;
    }

    public java.lang.Double getBaillwrlmt() {
        return this.baillwrlmt;
    }

    public void setBaillwrlmt(java.lang.Double baillwrlmt) {
        this.baillwrlmt = baillwrlmt;
    }

    public java.util.Date getLicvalidate() {
        return this.licvalidate;
    }

    public void setLicvalidate(java.util.Date licvalidate) {
        this.licvalidate = licvalidate;
    }

    public java.lang.Short getBailstatus() {
        return this.bailstatus;
    }

    public void setBailstatus(java.lang.Short bailstatus) {
        this.bailstatus = bailstatus;
    }

    public java.lang.Byte getIsb2m() {
        return this.isb2m;
    }

    public void setIsb2m(java.lang.Byte isb2m) {
        this.isb2m = isb2m;
    }

    public Byte getIsunpb() {
		return isunpb;
	}

	public void setIsunpb(Byte isunpb) {
		this.isunpb = isunpb;
	}

	public java.lang.String getSmsmobileno() {
        return this.smsmobileno;
    }

    public void setSmsmobileno(java.lang.String smsmobileno) {
        this.smsmobileno = smsmobileno;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WayapplylogVO) ) return false;
        WayapplylogVO castOther = (WayapplylogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return WayapplylogVO.class;
	}

	public Short getIstietong() {
		return istietong;
	}

	public void setIstietong(Short istietong) {
		this.istietong = istietong;
	}

	public Long getConnecttype() {
		return connecttype;
	}

	public void setConnecttype(Long connecttype) {
		this.connecttype = connecttype;
	}

	public Short getSublayer() {
		return sublayer;
	}

	public void setSublayer(Short sublayer) {
		this.sublayer = sublayer;
	}

	public Short getBuztypecode() {
		return buztypecode;
	}

	public void setBuztypecode(Short buztypecode) {
		this.buztypecode = buztypecode;
	}

	public String getRegid() {
		return regid;
	}

	public void setRegid(String regid) {
		this.regid = regid;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public Short getIsKzcz() {
		return isKzcz;
	}

	public void setIsKzcz(Short isKzcz) {
		this.isKzcz = isKzcz;
	}

	public String getStarlev() {
		return starlev;
	}

	public void setStarlev(String starlev) {
		this.starlev = starlev;
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

	public Short getMobilemail() {
		return mobilemail;
	}

	public void setMobilemail(Short mobilemail) {
		this.mobilemail = mobilemail;
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

	public Short getMainlayer() {
		return mainlayer;
	}

	public void setMainlayer(Short mainlayer) {
		this.mainlayer = mainlayer;
	}

	public String getBuzphoneno() {
		return buzphoneno;
	}

	public void setBuzphoneno(String buzphoneno) {
		this.buzphoneno = buzphoneno;
	}

	public Short getCooperator() {
		return cooperator;
	}

	public void setCooperator(Short cooperator) {
		this.cooperator = cooperator;
	}

	public Short getTaxtype() {
		return taxtype;
	}

	public void setTaxtype(Short taxtype) {
		this.taxtype = taxtype;
	}

	public Short getDistype() {
		return distype;
	}

	public void setDistype(Short distype) {
		this.distype = distype;
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

	public String getLinkmanemail() {
		return linkmanemail;
	}

	public void setLinkmanemail(String linkmanemail) {
		this.linkmanemail = linkmanemail;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Short getCoplevel() {
		return coplevel;
	}

	public void setCoplevel(Short coplevel) {
		this.coplevel = coplevel;
	}

	public String getBusnum() {
		return busnum;
	}

	public void setBusnum(String busnum) {
		this.busnum = busnum;
	}

	public Short getCertitype() {
		return certitype;
	}

	public void setCertitype(Short certitype) {
		this.certitype = certitype;
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

	public String getCompanytype() {
		return companytype;
	}

	public void setCompanytype(String companytype) {
		this.companytype = companytype;
	}

	public String getBrole() {
		return brole;
	}

	public void setBrole(String brole) {
		this.brole = brole;
	}

	public String getCertinum() {
		return certinum;
	}

	public void setCertinum(String certinum) {
		this.certinum = certinum;
	}

	public String getCopbound() {
		return copbound;
	}

	public void setCopbound(String copbound) {
		this.copbound = copbound;
	}

	public Short getRunareatype() {
		return runareatype;
	}

	public void setRunareatype(Short runareatype) {
		this.runareatype = runareatype;
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

	public String getComefrom() {
		return comefrom;
	}

	public void setComefrom(String comefrom) {
		this.comefrom = comefrom;
	}

	public String getCompactpath() {
		return compactpath;
	}

	public void setCompactpath(String compactpath) {
		this.compactpath = compactpath;
	}

	public String getLicencepath() {
		return licencepath;
	}

	public void setLicencepath(String licencepath) {
		this.licencepath = licencepath;
	}
	
	public String getIstop() {
		return istop;
	}

	public void setIstop(String istop) {
		this.istop = istop;
	}
}
