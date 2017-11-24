package net.gmcc.pboss.domain.model.way;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="CH_PW_WAY")
public class WayVO  implements java.io.Serializable {
    // Fields    
	 @Id     
     @Column(name="WAYID", unique=true, nullable=false, length=18)
     private String wayid;
	 @Column(name="SHORTNAME", length=32)
     private String shortname;
	 @Column(name="SVBRCHCODE", length=14)
     private String svbrchcode;
	 @Column(name="SVCCODE", length=14)
     private String svccode;
	 @Column(name="MAREACODE", length=14)
     private String mareacode;
	 @Column(name="BUZTYPECODE", precision=2, scale=0)
     private Byte buztypecode;
     @Column(name="ADTYPECODE", precision=2, scale=0)
     private Byte adtypecode;
     @Column(name="ADDRESS", length=128)
     private String address;
     @Column(name="LOGISCODE", length=18)
     private String logiscode;
     @Column(name="LATITUDE", length=15)
     private String latitude;
     @Column(name="LONGTITUDE", length=15)
     private String longtitude;
     @Column(name="ADACODE", length=18)
     private String adacode;
     @Column(name="WAYMAGCODE", length=18)
     private String waymagcode;
     @Column(name="CATETYPE", precision=2, scale=0)
     private Byte catetype;
     @Column(name="FORMTYPE", precision=2, scale=0)
     private Byte formtype;
     @Temporal(TemporalType.TIMESTAMP)//DATE
     @Column(name="STARTTIME", length=7)
     private Date starttime;
     @Column(name="BUZAREA", precision=5, scale=0)
     private Integer buzarea;
     @Column(name="MAINLAYER", precision=2, scale=0)
     private Byte mainlayer;
     @Column(name="SUBLAYER", precision=2, scale=0)
     private Byte sublayer;
     @Column(name="BUZPHONENO", length=14)
     private String buzphoneno;
     @Column(name="WAYNAME", length=256)
     private String wayname;
     @Column(name="COOPERATOR", precision=2, scale=0)
     private Byte cooperator;
     @Column(name="WAYTYPE", length=4)
     private String waytype;
     @Column(name="WAYSUBTYPE", length=4)
     private String waysubtype;
     @Column(name="CUSTTYPE", length=4)
     private String custtype;
     @Column(name="UPPERWAYID", length=18)
     private String upperwayid;
     @Column(name="BUSICODE", length=10)
     private String busicode;
     @Column(name="COUNTYID", length=14)
     private String countyid;
     @Column(name="CITYID", length=14)
     private String cityid;
     @Column(name="CENTERID", length=14)
     private String centerid;
     @Column(name="CITYLEVEL", precision=3, scale=0)
     private Short citylevel;
     @Column(name="WAYLEVEL", precision=3, scale=0)
     private Short waylevel;
     @Column(name="BCHLEVEL", length=4)
     private String bchlevel;
     @Column(name="FUNCTION")
     private String function;
     @Column(name="MISCODE", length=12)
     private String miscode;
     @Temporal(TemporalType.TIMESTAMP)//DATE
     @Column(name="CREATETIME", length=7)
     private Date createtime;
     @Temporal(TemporalType.TIMESTAMP)//DATE
     @Column(name="DISABLETIME", length=7)
     private Date disabletime;
     @Column(name="WAYSTATE", precision=3, scale=0)
     private Short waystate;
     @Column(name="RUNBYSELF", length=4)
     private String runbyself;
     @Column(name="DEPOTDET", length=20)
     private String depotdet;
     @Column(name="ISSHARE", length=32)
     private String isshare;
     @Column(name="ALARMBIZAMOUNT", precision=10, scale=0)
     private Long alarmbizamount;
     @Column(name="PRTSOURCE", precision=2, scale=0)
     private Byte prtsource;
     @Column(name="ISCONNECTED", precision=2, scale=0)
     private Byte isconnected;
     @Column(name="CONNECTTYPE", precision=2, scale=0)
     private Byte connecttype;
     @Column(name="RUNMODE", precision=2, scale=0)
     private Byte runmode;
     @Column(name="ISCOREWAY", precision=2, scale=0)
     private Byte iscoreway;
     @Column(name="STARLEVEL", precision=2, scale=0)
     private Byte starlevel;
     @Column(name="PT", precision=2, scale=0)
     private Byte pt;
     @Column(name="CHAINHEAD", length=18)
     private String chainhead;
     @Column(name="SIGNSTATUS", precision=2, scale=0)
     private Byte signstatus;
     @Column(name="EMPNUMBER", precision=4, scale=0)
     private Short empnumber;
     @Column(name="MAGNUMBER", precision=4, scale=0)
     private Short magnumber;
     @Column(name="TERMINUMBER", precision=4, scale=0)
     private Short terminumber;
     @Temporal(TemporalType.TIMESTAMP)//DATE
     @Column(name="UPDATEDATE", length=7)
     private Date updatedate;
     @Column(name="ISSTRAITPRD", precision=2, scale=0)
     private Byte isstraitprd;
     @Column(name="TAXTYPE", precision=2, scale=0)
     private Byte taxtype;
     @Column(name="ISTIETONG", precision=2, scale=0)
     private Byte istietong;
     @Column(name="ISKZCZ", precision=3, scale=0)
     private Short iskzcz;
     @Column(name="CALCUMODE", precision=3, scale=0)
     private Short calcumode;
     @Column(name="UNIFORMTIME", length=6)
     private String uniformtime;
     @Column(name="DISTYPE", precision=3, scale=0)
     private Short distype;
     @Column(name="RIVLTYPE", precision=3, scale=0)
     private Short rivltype;
     @Column(name="CHECKED", length=3)
     private String checked;
//     @Column(name="STARLEV", length=1)
//     private String starlev;
     @Column(name="BUZMANAGER", length=64)
     private String buzmanager;
     @Column(name="SUBRUNMODE", precision=2, scale=0)
     private Short subrunmode;
    // Constructors

    /** default constructor */
    public WayVO() {
    }

	/** minimal constructor */
    public WayVO(String wayid) {
        this.wayid = wayid;
    }
    
    /** full constructor */
    public WayVO(String wayid, String shortname, String svbrchcode, String svccode, String mareacode, Byte buztypecode, Byte adtypecode, String address, String logiscode, String latitude, String longtitude, String adacode, String waymagcode, Byte catetype, Byte formtype, Date starttime, Integer buzarea, Byte mainlayer, Byte sublayer, String buzphoneno, String wayname, Byte cooperator, String waytype, String waysubtype, String custtype, String upperwayid, String busicode, String countyid, String cityid, String centerid, Short citylevel, Short waylevel, String bchlevel, String function, String miscode, Date createtime, Date disabletime, Short waystate, String runbyself, String depotdet, String isshare, Long alarmbizamount, Byte prtsource, Byte isconnected, Byte connecttype, Byte runmode, Byte iscoreway, Byte starlevel, Byte pt, String chainhead, Byte signstatus, Short empnumber, Short magnumber, Short terminumber, Date updatedate, Byte isstraitprd, Byte taxtype, Byte istietong, Short iskzcz, Short calcumode, String uniformtime, Short distype, Short rivltype, String checked, java.lang.String buzmanager, java.lang.Short subrunmode) {
    	//, String starlev
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
        this.istietong = istietong;
        this.iskzcz = iskzcz;
        this.calcumode = calcumode;
        this.uniformtime = uniformtime;
        this.distype = distype;
        this.rivltype = rivltype;
        this.checked = checked;
        //this.starlev = starlev;
        this.buzmanager = buzmanager;
        this.subrunmode = subrunmode;
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
    

    public Byte getBuztypecode() {
        return this.buztypecode;
    }
    
    public void setBuztypecode(Byte buztypecode) {
        this.buztypecode = buztypecode;
    }
    
    public Byte getAdtypecode() {
        return this.adtypecode;
    }
    
    public void setAdtypecode(Byte adtypecode) {
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
    
    public Byte getCatetype() {
        return this.catetype;
    }
    
    public void setCatetype(Byte catetype) {
        this.catetype = catetype;
    }
    
    public Byte getFormtype() {
        return this.formtype;
    }
    
    public void setFormtype(Byte formtype) {
        this.formtype = formtype;
    }

    public Date getStarttime() {
        return this.starttime;
    }
    
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Integer getBuzarea() {
        return this.buzarea;
    }
    
    public void setBuzarea(Integer buzarea) {
        this.buzarea = buzarea;
    }
    
    public Byte getMainlayer() {
        return this.mainlayer;
    }
    
    public void setMainlayer(Byte mainlayer) {
        this.mainlayer = mainlayer;
    }
    
    public Byte getSublayer() {
        return this.sublayer;
    }
    
    public void setSublayer(Byte sublayer) {
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
    
    public Byte getCooperator() {
        return this.cooperator;
    }
    
    public void setCooperator(Byte cooperator) {
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
    
    public Short getCitylevel() {
        return this.citylevel;
    }
    
    public void setCitylevel(Short citylevel) {
        this.citylevel = citylevel;
    }
    
    public Short getWaylevel() {
        return this.waylevel;
    }
    
    public void setWaylevel(Short waylevel) {
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
    
    public Short getWaystate() {
        return this.waystate;
    }
    
    public void setWaystate(Short waystate) {
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
    
    public Byte getPrtsource() {
        return this.prtsource;
    }
    
    public void setPrtsource(Byte prtsource) {
        this.prtsource = prtsource;
    }
    
    public Byte getIsconnected() {
        return this.isconnected;
    }
    
    public void setIsconnected(Byte isconnected) {
        this.isconnected = isconnected;
    }
    
    public Byte getConnecttype() {
        return this.connecttype;
    }
    
    public void setConnecttype(Byte connecttype) {
        this.connecttype = connecttype;
    }
    
    
    public Byte getRunmode() {
        return this.runmode;
    }
    
    public void setRunmode(Byte runmode) {
        this.runmode = runmode;
    }
    
    public Byte getIscoreway() {
        return this.iscoreway;
    }
    
    public void setIscoreway(Byte iscoreway) {
        this.iscoreway = iscoreway;
    }
      
    public Byte getStarlevel() {
        return this.starlevel;
    }
    
    public void setStarlevel(Byte starlevel) {
        this.starlevel = starlevel;
    }
    
    public Byte getPt() {
        return this.pt;
    }
    
    public void setPt(Byte pt) {
        this.pt = pt;
    }
    
    public String getChainhead() {
        return this.chainhead;
    }
    
    public void setChainhead(String chainhead) {
        this.chainhead = chainhead;
    }
    
    public Byte getSignstatus() {
        return this.signstatus;
    }
    
    public void setSignstatus(Byte signstatus) {
        this.signstatus = signstatus;
    }
    
    public Short getEmpnumber() {
        return this.empnumber;
    }
    
    public void setEmpnumber(Short empnumber) {
        this.empnumber = empnumber;
    }
    
    public Short getMagnumber() {
        return this.magnumber;
    }
    
    public void setMagnumber(Short magnumber) {
        this.magnumber = magnumber;
    }
    
    public Short getTerminumber() {
        return this.terminumber;
    }
    
    public void setTerminumber(Short terminumber) {
        this.terminumber = terminumber;
    }
    
    public Date getUpdatedate() {
        return this.updatedate;
    }
    
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }
    
    public Byte getIsstraitprd() {
        return this.isstraitprd;
    }
    
    public void setIsstraitprd(Byte isstraitprd) {
        this.isstraitprd = isstraitprd;
    }
    
    public Byte getTaxtype() {
        return this.taxtype;
    }
    
    public void setTaxtype(Byte taxtype) {
        this.taxtype = taxtype;
    }
    
    public Byte getIstietong() {
        return this.istietong;
    }
    
    public void setIstietong(Byte istietong) {
        this.istietong = istietong;
    }
    
    public Short getIskzcz() {
        return this.iskzcz;
    }
    
    public void setIskzcz(Short iskzcz) {
        this.iskzcz = iskzcz;
    }
    
    public Short getCalcumode() {
        return this.calcumode;
    }
    
    public void setCalcumode(Short calcumode) {
        this.calcumode = calcumode;
    }
    
    public String getUniformtime() {
        return this.uniformtime;
    }
    
    public void setUniformtime(String uniformtime) {
        this.uniformtime = uniformtime;
    }
    
    public Short getDistype() {
        return this.distype;
    }
    
    public void setDistype(Short distype) {
        this.distype = distype;
    }
    
    public Short getRivltype() {
        return this.rivltype;
    }
    
    public void setRivltype(Short rivltype) {
        this.rivltype = rivltype;
    }
    
    public String getChecked() {
        return this.checked;
    }
    
    public void setChecked(String checked) {
        this.checked = checked;
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
    
//    public String getStarlev() {
//        return this.starlev;
//    }
//    
//    public void setStarlev(String starlev) {
//        this.starlev = starlev;
//    }
}