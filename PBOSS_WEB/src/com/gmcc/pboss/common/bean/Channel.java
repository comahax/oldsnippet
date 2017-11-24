package com.gmcc.pboss.common.bean;

import java.util.Date;


/**
 * 
 * @author Administrator
 *	渠道javabean
 */
public class Channel  implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -348662238060294574L;
	/**渠道编码*/
	private String wayid;
	/**名称简称*/
	private String shortname;
	/**服务厅类别*/
	private String svbrchcode;
	/**服务销售中心编码*/
	private String svccode;
	/**微区域编码*/
	private String mareacode;
	/**商圈类型编码*/
	private Long buztypecode;
	/**区域类型编码*/
	private Long adtypecode;
	/**详细地址*/
	private String address;
	/**所属物流商编码*/
	private String logiscode;
	/**办公地点纬度*/
	private String latitude;
	/**办公地点经度*/
	private String longtitude;
	/**办公地点经度*/
	private String adacode;
	/**渠道经理工号*/
	private String waymagcode;
	/**连锁性质*/
	private Long catetype;
	/**业态类型*/
	private Long formtype;
	/**开业时间*/
	private Date starttime;
	/**营业面积*/
	private Long buzarea;
	/**主分层*/
	private Long mainlayer;
	/**子分层*/
	private Long sublayer;
	/**业务手机号*/
	private String buzphoneno;
	/**渠道名称*/
	private String wayname;
	/**合作方*/
	private Long cooperator;
	/**渠道类别*/
	private String waytype;
	/**渠道子类别*/
	private String waysubtype;
	/**分公司自定义类别*/
	private String custtype;
	/**上级渠道*/
	private String upperwayid;
	/**营业点标识*/
	private String busicode;
	/**县公司标识*/
	private String countyid;
	/**市公司标识*/
	private String cityid;
	/**区域中心标识*/
	private String centerid;
	/**城市级别*/
	private Long citylevel;
	/**渠道级别*/
	private Long waylevel;
	/**渠道等级(网点级别)*/
	private String bchlevel;
	/**职能描述*/
	private String function;
	/**渠道MIS编码*/
	private String miscode;
	/**创建时间*/
	private Date createtime;
	/**停用时间*/
	private Date disabletime;
	/**渠道状态*/
	private Long waystate;
	/**自营标志*/
	private String runbyself;
	/**渠道中间代码*/
	private String depotdet;
	/**是否共享*/
	private String isshare;
	/**业务预警量*/
	private Long alarmbizamount;
	/**物业来源分类*/
	private Long prtsource;
	/**是否联网*/
	private Long isconnected;
	/**联网方式*/
	private Long connecttype;
	/**经营模式*/
	private Long runmode;
	/**是否中心渠道*/
	private Long iscoreway;
	/**星级*/
	private Long starlevel;
	/**排他性*/
	private Long pt;
	/**连锁总店编码*/
	private String chainhead;
	/**签约状态*/
	private Long signstatus;
	/**营业人员数量*/
	private Long empnumber;
	/**管理人员数量*/
	private Long magnumber;
	/**终端数量*/
	private Long terminumber;
	/**信息更新时间*/
	private Date updatedate;
	/**是否直供*/
	private Long isstraitprd;
	/**扣税方式*/
	private Long taxtype;
    /**
     * 渠道星级翻译
     */
	private String strStarLevel;


    // Constructors

    /** default constructor */
    public Channel() {
    }

	/** minimal constructor */
    public Channel(String wayid) {
        this.wayid = wayid;
    }
    
    /** full constructor */
    public Channel(String wayid, String shortname, String svbrchcode, String svccode, String mareacode, Long buztypecode, Long adtypecode, String address, String logiscode, String latitude, String longtitude, String adacode, String waymagcode, Long catetype, Long formtype, Date starttime, Long buzarea, Long mainlayer, Long sublayer, String buzphoneno, String wayname, Long cooperator, String waytype, String waysubtype, String custtype, String upperwayid, String busicode, String countyid, String cityid, String centerid, Long citylevel, Long waylevel, String bchlevel, String function, String miscode, Date createtime, Date disabletime, Long waystate, String runbyself, String depotdet, String isshare, Long alarmbizamount, Long prtsource, Long isconnected, Long connecttype, Long runmode, Long iscoreway, Long starlevel, Long pt, String chainhead, Long signstatus, Long empnumber, Long magnumber, Long terminumber, Date updatedate, Long isstraitprd, Long taxtype) {
        this.wayid = wayid;
        this.shortname = shortname;
        this.svbrchcode = svbrchcode;
        this.svccode = svccode;
        this.mareacode = mareacode;
        this.buztypecode = buztypecode;
        this.adtypecode = adtypecode;
        this.address = address;
        this.logiscode = logiscode;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.adacode = adacode;
        this.waymagcode = waymagcode;
        this.catetype = catetype;
        this.formtype = formtype;
        this.starttime = starttime;
        this.buzarea = buzarea;
        this.mainlayer = mainlayer;
        this.sublayer = sublayer;
        this.buzphoneno = buzphoneno;
        this.wayname = wayname;
        this.cooperator = cooperator;
        this.waytype = waytype;
        this.waysubtype = waysubtype;
        this.custtype = custtype;
        this.upperwayid = upperwayid;
        this.busicode = busicode;
        this.countyid = countyid;
        this.cityid = cityid;
        this.centerid = centerid;
        this.citylevel = citylevel;
        this.waylevel = waylevel;
        this.bchlevel = bchlevel;
        this.function = function;
        this.miscode = miscode;
        this.createtime = createtime;
        this.disabletime = disabletime;
        this.waystate = waystate;
        this.runbyself = runbyself;
        this.depotdet = depotdet;
        this.isshare = isshare;
        this.alarmbizamount = alarmbizamount;
        this.prtsource = prtsource;
        this.isconnected = isconnected;
        this.connecttype = connecttype;
        this.runmode = runmode;
        this.iscoreway = iscoreway;
        this.starlevel = starlevel;
        this.pt = pt;
        this.chainhead = chainhead;
        this.signstatus = signstatus;
        this.empnumber = empnumber;
        this.magnumber = magnumber;
        this.terminumber = terminumber;
        this.updatedate = updatedate;
        this.isstraitprd = isstraitprd;
        this.taxtype = taxtype;
    }

   
    // Property accessors

    public String getWayid() {
        return this.wayid;
    }
    
    public void setWayid(String wayid) {
        this.wayid = wayid;
    }

    public String getShortname() {
        return this.shortname;
    }
    
    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getSvbrchcode() {
        return this.svbrchcode;
    }
    
    public void setSvbrchcode(String svbrchcode) {
        this.svbrchcode = svbrchcode;
    }

    public String getSvccode() {
        return this.svccode;
    }
    
    public void setSvccode(String svccode) {
        this.svccode = svccode;
    }

    public String getMareacode() {
        return this.mareacode;
    }
    
    public void setMareacode(String mareacode) {
        this.mareacode = mareacode;
    }

    public Long getBuztypecode() {
        return this.buztypecode;
    }
    
    public void setBuztypecode(Long buztypecode) {
        this.buztypecode = buztypecode;
    }

    public Long getAdtypecode() {
        return this.adtypecode;
    }
    
    public void setAdtypecode(Long adtypecode) {
        this.adtypecode = adtypecode;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogiscode() {
        return this.logiscode;
    }
    
    public void setLogiscode(String logiscode) {
        this.logiscode = logiscode;
    }

    public String getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return this.longtitude;
    }
    
    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getAdacode() {
        return this.adacode;
    }
    
    public void setAdacode(String adacode) {
        this.adacode = adacode;
    }

    public String getWaymagcode() {
        return this.waymagcode;
    }
    
    public void setWaymagcode(String waymagcode) {
        this.waymagcode = waymagcode;
    }

    public Long getCatetype() {
        return this.catetype;
    }
    
    public void setCatetype(Long catetype) {
        this.catetype = catetype;
    }

    public Long getFormtype() {
        return this.formtype;
    }
    
    public void setFormtype(Long formtype) {
        this.formtype = formtype;
    }

    public Date getStarttime() {
        return this.starttime;
    }
    
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Long getBuzarea() {
        return this.buzarea;
    }
    
    public void setBuzarea(Long buzarea) {
        this.buzarea = buzarea;
    }

    public Long getMainlayer() {
        return this.mainlayer;
    }
    
    public void setMainlayer(Long mainlayer) {
        this.mainlayer = mainlayer;
    }

    public Long getSublayer() {
        return this.sublayer;
    }
    
    public void setSublayer(Long sublayer) {
        this.sublayer = sublayer;
    }

    public String getBuzphoneno() {
        return this.buzphoneno;
    }
    
    public void setBuzphoneno(String buzphoneno) {
        this.buzphoneno = buzphoneno;
    }

    public String getWayname() {
        return this.wayname;
    }
    
    public void setWayname(String wayname) {
        this.wayname = wayname;
    }

    public Long getCooperator() {
        return this.cooperator;
    }
    
    public void setCooperator(Long cooperator) {
        this.cooperator = cooperator;
    }

    public String getWaytype() {
        return this.waytype;
    }
    
    public void setWaytype(String waytype) {
        this.waytype = waytype;
    }

    public String getWaysubtype() {
        return this.waysubtype;
    }
    
    public void setWaysubtype(String waysubtype) {
        this.waysubtype = waysubtype;
    }

    public String getCusttype() {
        return this.custtype;
    }
    
    public void setCusttype(String custtype) {
        this.custtype = custtype;
    }

    public String getUpperwayid() {
        return this.upperwayid;
    }
    
    public void setUpperwayid(String upperwayid) {
        this.upperwayid = upperwayid;
    }

    public String getBusicode() {
        return this.busicode;
    }
    
    public void setBusicode(String busicode) {
        this.busicode = busicode;
    }

    public String getCountyid() {
        return this.countyid;
    }
    
    public void setCountyid(String countyid) {
        this.countyid = countyid;
    }

    public String getCityid() {
        return this.cityid;
    }
    
    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getCenterid() {
        return this.centerid;
    }
    
    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public Long getCitylevel() {
        return this.citylevel;
    }
    
    public void setCitylevel(Long citylevel) {
        this.citylevel = citylevel;
    }

    public Long getWaylevel() {
        return this.waylevel;
    }
    
    public void setWaylevel(Long waylevel) {
        this.waylevel = waylevel;
    }

    public String getBchlevel() {
        return this.bchlevel;
    }
    
    public void setBchlevel(String bchlevel) {
        this.bchlevel = bchlevel;
    }

    public String getFunction() {
        return this.function;
    }
    
    public void setFunction(String function) {
        this.function = function;
    }

    public String getMiscode() {
        return this.miscode;
    }
    
    public void setMiscode(String miscode) {
        this.miscode = miscode;
    }

    public Date getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getDisabletime() {
        return this.disabletime;
    }
    
    public void setDisabletime(Date disabletime) {
        this.disabletime = disabletime;
    }

    public Long getWaystate() {
        return this.waystate;
    }
    
    public void setWaystate(Long waystate) {
        this.waystate = waystate;
    }

    public String getRunbyself() {
        return this.runbyself;
    }
    
    public void setRunbyself(String runbyself) {
        this.runbyself = runbyself;
    }

    public String getDepotdet() {
        return this.depotdet;
    }
    
    public void setDepotdet(String depotdet) {
        this.depotdet = depotdet;
    }

    public String getIsshare() {
        return this.isshare;
    }
    
    public void setIsshare(String isshare) {
        this.isshare = isshare;
    }

    public Long getAlarmbizamount() {
        return this.alarmbizamount;
    }
    
    public void setAlarmbizamount(Long alarmbizamount) {
        this.alarmbizamount = alarmbizamount;
    }

    public Long getPrtsource() {
        return this.prtsource;
    }
    
    public void setPrtsource(Long prtsource) {
        this.prtsource = prtsource;
    }

    public Long getIsconnected() {
        return this.isconnected;
    }
    
    public void setIsconnected(Long isconnected) {
        this.isconnected = isconnected;
    }

    public Long getConnecttype() {
        return this.connecttype;
    }
    
    public void setConnecttype(Long connecttype) {
        this.connecttype = connecttype;
    }

    public Long getRunmode() {
        return this.runmode;
    }
    
    public void setRunmode(Long runmode) {
        this.runmode = runmode;
    }

    public Long getIscoreway() {
        return this.iscoreway;
    }
    
    public void setIscoreway(Long iscoreway) {
        this.iscoreway = iscoreway;
    }

    public Long getStarlevel() {
        return this.starlevel;
    }
    
    public void setStarlevel(Long starlevel) {
        this.starlevel = starlevel;
    }

    public Long getPt() {
        return this.pt;
    }
    
    public void setPt(Long pt) {
        this.pt = pt;
    }

    public String getChainhead() {
        return this.chainhead;
    }
    
    public void setChainhead(String chainhead) {
        this.chainhead = chainhead;
    }

    public Long getSignstatus() {
        return this.signstatus;
    }
    
    public void setSignstatus(Long signstatus) {
        this.signstatus = signstatus;
    }

    public Long getEmpnumber() {
        return this.empnumber;
    }
    
    public void setEmpnumber(Long empnumber) {
        this.empnumber = empnumber;
    }

    public Long getMagnumber() {
        return this.magnumber;
    }
    
    public void setMagnumber(Long magnumber) {
        this.magnumber = magnumber;
    }

    public Long getTerminumber() {
        return this.terminumber;
    }
    
    public void setTerminumber(Long terminumber) {
        this.terminumber = terminumber;
    }

    public Date getUpdatedate() {
        return this.updatedate;
    }
    
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Long getIsstraitprd() {
        return this.isstraitprd;
    }
    
    public void setIsstraitprd(Long isstraitprd) {
        this.isstraitprd = isstraitprd;
    }

    public Long getTaxtype() {
        return this.taxtype;
    }
    
    public void setTaxtype(Long taxtype) {
        this.taxtype = taxtype;
    }

	public String getStrStarLevel() {
		return strStarLevel;
	}

	public void setStrStarLevel(String strStarLevel) {
		this.strStarLevel = strStarLevel;
	}
   








}