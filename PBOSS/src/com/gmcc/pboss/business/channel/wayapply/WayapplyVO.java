package com.gmcc.pboss.business.channel.wayapply;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.channel.wayapplylog.WayapplylogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;
import com.sunrise.jop.infrastructure.sysadmin.BusinessRepointLog;

/** @author Hibernate CodeGenerator */
public class WayapplyVO extends BaseVO implements BusinessRepointLog {

	/** identifier field */
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
	
	private Byte isunpb;

	/** nullable persistent field */
	private Byte isb2m;

	private Long smsmobileno;

	private String nextstepid;

	private String stepid;
	
	//���stepid���һ�����֣������ж������Ѿ����е��ڼ���
	private String lastStepid;

	private String content;

	private Short auditstatus_work;

	private Long seqid;

	private String waytype;

	private String oprcode;

	private String debankid;

	private Byte destate;

	private String custtype;

	private Short istietong;
	
	private Long connecttype;
	
	private Short sublayer;
	
	private Short buztypecode;
	
	// �����ֶ�
	// ����ע����
	private String regid;
	// �Ƿ���Ȩ����
	private String checked;
	// �Ƿ������г�ֵƽ̨
	private Short isKzcz;
	// �Ǽ��ֲ�
	private String starlev;
	// ȫ��ͳһ��������
	private String uniquewayid;
	// ����
	private String town;
	// ������������
	private Short provtype;
	// �Ƿ��ֻ�����
	private Short mobilemall;
	// ǰ̨Ӫҵ������O��
	private Double frontarea;
	// ��Ӫ��ISP���뷽ʽ
	private Short ispconntype;
	// �����㼶
	private Short mainlayer;
	// ҵ����ϵ����
	private String buzphoneno;
	// ������
	private Short cooperator;
	// ��˰��ʽ
	private Short taxtype;
	// ����������
	private Short distype;
	// ��ϵ��
	private String linkman;
	// ��ϵ�绰
	private String linkmantel;
	// ҵ����ϵ�˵�������
	private String linkmanemail;
	// ������λ
	private String company;
	// �����̼���
	private Short coplevel;
	// ���̺�
	private String busnum;
	// ֤�����
	private Short certitype;
	// ע���ַ
	private String regadress;
	// ע���ʽ�
	private Long regcapital;
	// ��˾����
	private String companytype;
	// ְλ
	private String brole;
	// ֤������
	private String certinum;
	// ����ҵ��Χ
	private String copbound;
	// ��Ӫ��������
	private Short runareatype;
	// ����ģʽ
	private Short calcumode;
	// ͳһģʽ��ʼʱ��
	private String uniformtime;
	// ����������Դ
	private String comefrom;	
	// ��ͬЭ��ԭ��·��
	private String compactpath;
	// Ӫҵִ���ļ�·��
	private String licencepath;
	
	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}
	
	////��ѯ��½�Ĺ����Ƿ�������������ɫ����
	private String hasRight;
	
	//
	private String worktype;
	
    //�����Ƿ�top����
    private String istop;

	public String getWorktype() {
		return worktype;
	}

	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}

	/** full constructor */
	public WayapplyVO(java.lang.Long applyno, java.util.Date optime,
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
			java.lang.Short bailstatus,java.lang.Byte isunpb, java.lang.Byte isb2m,
			java.lang.String nextstepid, java.lang.String content,
			java.lang.Short auditstatus_work, 
			String regid,
			String checked,
			Short isKzcz,
			String starlev,
			String uniquewayid,
			String town,
			Short provtype,
			Short mobilemall,
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
			java.lang.Long seqid,Long connecttype,Short istietong,Short sublayer,Short buztypecode,String istop) {
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
		this.isunpb = isunpb;
		this.isb2m = isb2m;
		this.nextstepid = nextstepid;
		this.content = content;
		this.seqid = seqid;
		this.auditstatus_work = auditstatus_work;
		this.connecttype=connecttype;
		this.buztypecode=buztypecode;
		this.istietong=istietong;
		this.sublayer=sublayer;
		
		// �����ֶ�
		 this.regid =  regid; 
		 this.checked = checked;   
		 this.isKzcz = isKzcz; 
		 this.starlev = starlev;   
		 this.uniquewayid = uniquewayid; 
		 this.town =  town;  
		 this.provtype =   provtype;  
		 this.mobilemall =  mobilemall; 
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
	public WayapplyVO() {
	}

	/** minimal constructor */
	public WayapplyVO(java.lang.Long applyno) {
		this.applyno = applyno;
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
	
	public Byte getIsunpb() {
		return isunpb;
	}

	public void setIsunpb(Byte isunpb) {
		this.isunpb = isunpb;
	}

	public java.lang.Byte getIsb2m() {
		return this.isb2m;
	}

	public void setIsb2m(java.lang.Byte isb2m) {
		this.isb2m = isb2m;
	}

	public String toString() {
		return new ToStringBuilder(this).append("applyno", getApplyno())
				.toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof WayapplyVO))
			return false;
		WayapplyVO castOther = (WayapplyVO) other;
		return new EqualsBuilder().append(this.getApplyno(),
				castOther.getApplyno()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getApplyno()).toHashCode();
	}

	public Long getSmsmobileno() {
		return smsmobileno;
	}

	public void setSmsmobileno(Long smsmobileno) {
		this.smsmobileno = smsmobileno;
	}

	public String getNextstepid() {
		return nextstepid;
	}

	public void setNextstepid(String nextstepid) {
		this.nextstepid = nextstepid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Short getAuditstatus_work() {
		return auditstatus_work;
	}

	public void setAuditstatus_work(Short auditstatus_work) {
		this.auditstatus_work = auditstatus_work;
	}

	public Long getSeqid() {
		return seqid;
	}

	public void setSeqid(Long seqid) {
		this.seqid = seqid;
	}

	public String getStepid() {
		return stepid;
	}

	public void setStepid(String stepid) {
		this.stepid = stepid;
	}

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return WayapplylogVO.class;
	}

	public String getWaytype() {
		return waytype;
	}

	public void setWaytype(String waytype) {
		this.waytype = waytype;
	}

	public String[] repointLogProperites() {
		// TODO Auto-generated method stub
		return new String[] { "logid", "opntime", "opncode", "oprtype", null };
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

	public String getCusttype() {
		return custtype;
	}

	public void setCusttype(String custtype) {
		this.custtype = custtype;
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

	public String getHasRight() {
		return hasRight;
	}

	public void setHasRight(String hasRight) {
		this.hasRight = hasRight;
	}

	public String getLastStepid() {
		return lastStepid;
	}

	public void setLastStepid(String lastStepid) {
		this.lastStepid = lastStepid;
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
