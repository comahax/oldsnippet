package com.gmcc.pboss.business.channel.way;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.channel.waylog.WaylogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class WayVO extends BaseVO implements BusinessLog {

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

	/** �������ֶ� */
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

	private java.util.Date starttime;

	private Long buzarea;

	private Short mainlayer;

	private Short sublayer;

	private String buzphoneno;

	private Short cooperator;

	private Integer alarmbizamount;

	/** ���� */

	private Long prtsource;// ��ҵ��Դ����

	private Long isconnected;// �Ƿ�����

	private Long connecttype;// ������ʽ

	private Long runmode;// ��Ӫģʽ

	private Long iscoreway;// �Ƿ���������

	private Long starlevel;// �Ǽ�

	private Long pt;// ������

	private String chainhead;// �����ܵ����

	private Long signstatus;// ǩԼ״̬��״̬��

	private Long empnumber;// Ӫҵ��Ա����

	private Long magnumber;// ������Ա����

	private Long terminumber;// �ն�����

	private java.util.Date updatedate;// ��Ϣ����ʱ��

	private Short isstraitprd;

	private Short taxtype;
	
	private String paytype;
	
	private String delitype;
	
	//���� ���������־����������ͨ����
	
	private Short istietong;

	// �ж��ǲ��Ǻ��������洫������vo
	private String isCooperator;
	
	private Short calcumode; //����ģʽ
	private String uniformtime;//ͳһģʽ��ʼʱ��
	private Short distype;//����������
	//�����Ƿ���Ȩ�����ֶ�
    private String checked;
    
    //�����Ƿ������г�ֵƽ̨
    private Long isKzcz;
 
	//�����Ǽ��ֲ�
    private String starlev;
    
    private String istop;
    
    private String rewardkind;//�����������
    private String buscno;//��Ȧ����
    private String wayattr;//����������������
    private String waymod;//������������ϵ��
    
    private String creditlevel;//���õȼ�
    
    private Short taxcertificate;//˰������
    
	private Short netwaylevel;//�����㼶
	
	private String buzmanager;//��Ӫģʽ������
	private Short subrunmode;//���澭��
	
	public String getCreditlevel() {
		return creditlevel;
	}

	public void setCreditlevel(String creditlevel) {
		this.creditlevel = creditlevel;
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

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
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

	public Short getDistype() {
		return distype;
	}

	public void setDistype(Short distype) {
		this.distype = distype;
	}

	public Short getIsstraitprd() {
		return isstraitprd;
	}

	public void setIsstraitprd(Short isstraitprd) {
		this.isstraitprd = isstraitprd;
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

	/** full constructor */
	public WayVO(java.lang.String depotdet, java.lang.String runbyself,
			java.lang.String wayid, java.lang.String wayname,
			java.lang.String waytype, java.lang.String waysubtype,
			java.lang.String custtype, java.lang.String upperwayid,
			java.lang.String countyid, java.lang.String cityid,
			java.lang.String centerid, java.lang.Short citylevel,
			java.lang.Short waylevel, java.lang.String bchlevel,
			java.lang.String function, java.lang.String miscode,
			java.lang.Short waystate, java.util.Date createtime,
			java.util.Date disabletime, java.lang.String isshare,
			java.lang.Short calcumode, java.lang.String uniformtime,
			Integer alarmbizamount, java.lang.Long runmode,java.lang.Short istietong,
			java.lang.String checked,java.lang.Long connecttype,
			java.lang.String starlev,java.lang.Long isKzcz,java.lang.String istop,
			java.lang.String creditlevel) {
		this.wayid = wayid;
		this.wayname = wayname;
		this.waytype = waytype;
		this.waysubtype = waysubtype;
		this.custtype = custtype;
		this.upperwayid = upperwayid;
		this.countyid = countyid;
		this.cityid = cityid;
		this.centerid = centerid;
		this.citylevel = citylevel;
		this.waylevel = waylevel;
		this.bchlevel = bchlevel;
		this.function = function;
		this.miscode = miscode;
		this.waystate = waystate;
		this.createtime = createtime;
		this.disabletime = disabletime;
		this.runbyself = runbyself;
		this.depotdet = depotdet;
		this.isshare = isshare;
		this.alarmbizamount = alarmbizamount;
		this.runmode = runmode;
		this.istietong=istietong;
		this.calcumode = calcumode;
		this.uniformtime=uniformtime;
		this.checked=checked;
		this.connecttype = connecttype;
		this.isKzcz = isKzcz;
		this.starlev = starlev;
		this.istop = istop;
		this.creditlevel=creditlevel;
	}

	/** default constructor */
	public WayVO() {
	}

	/** minimal constructor */
	public WayVO(java.lang.String wayid, java.lang.String wayname,
			java.lang.String waytype) {
		this.wayid = wayid;
		this.wayname = wayname;
		this.waytype = waytype;
	}

	/** minimal constructor */
	public WayVO(java.lang.String wayid, java.lang.String wayname,
			java.lang.String upperwayid, Short waystate) {
		this.wayid = wayid;
		this.wayname = wayname;
		this.upperwayid = upperwayid;
		this.waystate = waystate;
	}

	public WayVO(java.lang.String wayid, java.lang.String wayname,
			java.lang.String upperwayid, Short waystate, String waytype,
			String waysubtype, Long runmode) {
		this.wayid = wayid;
		this.wayname = wayname;
		this.upperwayid = upperwayid;
		this.waystate = waystate;
		this.waytype = waytype;
		this.waysubtype = waysubtype;
		this.runmode = runmode;
	}
	
	public WayVO(String wayid, String upperwayid) {
		this.wayid = wayid;
		this.upperwayid = upperwayid;
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

	public java.util.Date getStarttime() {
		return starttime;
	}

	public void setStarttime(java.util.Date starttime) {
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

	public Short getTaxtype() {
		return taxtype;
	}

	public void setTaxtype(Short taxtype) {
		this.taxtype = taxtype;
	}

	public String getIsCooperator() {
		return isCooperator;
	}

	public void setIsCooperator(String isCooperator) {
		this.isCooperator = isCooperator;
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public String getDelitype() {
		return delitype;
	}

	public void setDelitype(String delitype) {
		this.delitype = delitype;
	}

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return WaylogVO.class;
	}

	public Short getIstietong() {
		return istietong;
	}

	public void setIstietong(Short istietong) {
		this.istietong = istietong;
	}

	public Long getIsKzcz() {
		return isKzcz;
	}

	public void setIsKzcz(Long isKzcz) {
		this.isKzcz = isKzcz;
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

	public Short getNetwaylevel() {
		return netwaylevel;
	}

	public void setNetwaylevel(Short netwaylevel) {
		this.netwaylevel = netwaylevel;
	}

	public String getBuzmanager() {
		return buzmanager;
	}

	public void setBuzmanager(String buzmanager) {
		this.buzmanager = buzmanager;
	}

	public Short getSubrunmode() {
		return subrunmode;
	}

	public void setSubrunmode(Short subrunmode) {
		this.subrunmode = subrunmode;
	}

}
