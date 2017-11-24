package com.gmcc.pboss.web.channel.zjty.zjtywayinfo;

import java.util.Date;



import com.gmcc.pboss.business.channel.way.WayVO;

public class ZjtywayinfoForm extends WayVO {
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
	
	private String _ne_waystate ;

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
	
	private Long prtsource;//��ҵ��Դ����
    private Long isconnected;//�Ƿ�����
    private Long connecttype;//������ʽ
    private Long runmode;//��Ӫģʽ
    
    private int waystate;//����״̬
    
    private Long iscoreway;
    
    private Long starlevel;
    private String chainhead;//�����ܵ����
    
    private String isshare;
    
//    ί�з���˾���ơ�1����ע��š�2���˴���3���֤���룻4ί�о�Ӫ��Ϣ��5ǩԼ��š�6Э��ǩ����Чʱ�䣨��ʽ��YYYYMMDD����
//    7Э���ֹʱ�䣨��ʽ��YYYYMMDD����������8ȫ��ͳһ�������롢9����10�����������͡�11�Ƿ��ֻ�������12ǰ̨Ӫҵ������O����
//    13�����ŶӽкŻ���14����POS����15����24Сʱ����Ӫҵ����16����VIPרϯ��17����VIP�ҡ�18G3���������
    
    
   // CH_PW_BCHCONTACT��
    //ί�з���˾���ơ�����ע��š����˴������֤����,�����˵绰
    /**
     * ����ע���
     */
    private String busnum;
    /**
     * ���˴���
     */
    private String principal;
    /**
     * ���֤����
     */
    private String certinum;
    /**
     * ί�з���˾����
     */
    private String company;
    
	private String principaltel;
	
	
    
    
    //�����ֶα��浽CH_PW_WAYCOMPACT��
   // ǩԼ��š�Э��ǩ����Чʱ�䣨��ʽ��YYYYMMDD����Э���ֹʱ�䣨��ʽ��YYYYMMDD����ǩԼʱ�䣬��ͬЭ������
    /**
     * ǩԼ���
     */
    private String compactno;
    /**
     * Э��ǩ����Чʱ�䣨��ʽ��YYYYMMDD��
     */
    private Date begintime;
    /**
     * Э���ֹʱ�䣨��ʽ��YYYYMMDD��
     */
    private Date endtime;    
    
    private java.util.Date signtime;
    
    private String compactname;
    
    //�����ֶα��浽����ʡ��˾���Ա�(ch_pw_wayprovince)��
    //ȫ��ͳһ�������롢���������������͡��Ƿ��ֻ�������ǰ̨Ӫҵ������O����
    //�����ŶӽкŻ�������POS��������24Сʱ����Ӫҵ��������VIPרϯ������VIP�ҡ�G3�����������
    //¼��ɹ�Ҫ�Ǽ������־������ʡ��˾������־��(ch_pw_wayprovincelog)��
    /**
     * ȫ��ͳһ��������
     */
    private String uniquewayid;
    /**
     * ����
     */
    private String town;
    /**
     * ������������
     */
    private Short provtype;
    /**
     * �Ƿ��ֻ�����
     */
    private Short mobilemall;
    /**
     * ǰ̨Ӫҵ������O��
     */
    private Double frontarea;
    /**
     * �����ŶӽкŻ�
     */
    private Short haswaitmach;
    /**
     * ����POS��
     */
    private Short hasposmach;
    /**
     * ����24Сʱ����Ӫҵ��
     */
    private Short has24mall;
    /**
     * ����VIP��
     */
    private Short hasviproom;
    /**
     * ����VIPרϯ
     */
    private Short hasvipseat;
    /**
     * G3���������
     */
    private Double g3area;
    
    
    

    
    
    
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





//	public int getWaystate() {
//		return waystate;
//	}
//
//
//
//	public void setWaystate(int waystate) {
//		this.waystate = waystate;
//	}



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

//	public int getAdtypecode() {
//		return adtypecode;
//	}
//
//	public void setAdtypecode(int adtypecode) {
//		this.adtypecode = adtypecode;
//	}

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

//	public int getBuztypecode() {
//		return buztypecode;
//	}
//
//	public void setBuztypecode(int buztypecode) {
//		this.buztypecode = buztypecode;
//	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

//	public int getCooperator() {
//		return cooperator;
//	}
//
//	public void setCooperator(int cooperator) {
//		this.cooperator = cooperator;
//	}

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

//	public int getMainlayer() {
//		super.getMainlayer()
//		return mainlayer;
//	}
//
//	public void setMainlayer(int mainlayer) {
//		this.mainlayer = mainlayer;
//	}

	public String getMareacode() {
		return mareacode;
	}

	public void setMareacode(String mareacode) {
		this.mareacode = mareacode;
	}

//	public int getSublayer() {
//		return sublayer;
//	}
//
//	public void setSublayer(int sublayer) {
//		this.sublayer = sublayer;
//	}

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



	public String get_ne_waystate() {
		return _ne_waystate;
	}



	public void set_ne_waystate(String _ne_waystate) {
		this._ne_waystate = _ne_waystate;
	}


}
