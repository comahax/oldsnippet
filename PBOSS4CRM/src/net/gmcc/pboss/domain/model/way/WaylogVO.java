package net.gmcc.pboss.domain.model.way;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="CH_PW_WAYLOG")// ,schema="PBOSS_ZS"
public class WaylogVO  implements java.io.Serializable {
    // Fields    
     private Long logid;
     private Date optime;
     private String oprcode;
     private String oprtype;
     private String success;
     private String wayid;
     private String shortname;
     private String svbrchcode;
     private String svccode;
     private String mareacode;
     private Byte buztypecode;
     private Byte adtypecode;
     private String address;
     private String logiscode;
     private String latitude;
     private String longtitude;
     private String adacode;
     private String waymagcode;
     private Byte catetype;
     private Byte formtype;
     private Date starttime;
     private Integer buzarea;
     private Byte mainlayer;
     private Byte sublayer;
     private String buzphoneno;
     private String wayname;
     private Byte cooperator;
     private String waytype;
     private String waysubtype;
     private String custtype;
     private String upperwayid;
     private String busicode;
     private String countyid;
     private String cityid;
     private String centerid;
     private Short citylevel;
     private Short waylevel;
     private String bchlevel;
     private String function;
     private String miscode;
     private Date createtime;
     private Date disabletime;
     private Short waystate;
     private String runbyself;
     private String depotdet;
     private String isshare;
     private Long alarmbizamount;
     private Byte prtsource;
     private Byte isconnected;
     private Byte connecttype;
     private Byte runmode;
     private Byte iscoreway;
     private Byte starlevel;
     private Byte pt;
     private String chainhead;
     private Byte signstatus;
     private Short empnumber;
     private Short magnumber;
     private Short terminumber;
     private Date updatedate;
     private Byte isstraitprd;
     private Byte taxtype;
     private Short iskzcz;
     private Short calcumode;
     private String uniformtime;
     private Short distype;
     private Short rivltype;
     private String checked;
     private Byte istietong;
     private String starlev;
     private String buzmanager;
     private Short subrunmode;

    // Constructors

    /** default constructor */
    public WaylogVO() {
    }

	/** minimal constructor */
    public WaylogVO(Date optime, String oprcode, String oprtype) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
    }
    
    /** full constructor */
    public WaylogVO(Date optime, String oprcode, String oprtype, String success, String wayid, String shortname, String svbrchcode, String svccode, String mareacode, Byte buztypecode, Byte adtypecode, String address, String logiscode, String latitude, String longtitude, String adacode, String waymagcode, Byte catetype, Byte formtype, Date starttime, Integer buzarea, Byte mainlayer, Byte sublayer, String buzphoneno, String wayname, Byte cooperator, String waytype, String waysubtype, String custtype, String upperwayid, String busicode, String countyid, String cityid, String centerid, Short citylevel, Short waylevel, String bchlevel, String function, String miscode, Date createtime, Date disabletime, Short waystate, String runbyself, String depotdet, String isshare, Long alarmbizamount, Byte prtsource, Byte isconnected, Byte connecttype, Byte runmode, Byte iscoreway, Byte starlevel, Byte pt, String chainhead, Byte signstatus, Short empnumber, Short magnumber, Short terminumber, Date updatedate, Byte isstraitprd, Byte taxtype, Short iskzcz, Short calcumode, String uniformtime, Short distype, Short rivltype, String checked, Byte istietong, String starlev, java.lang.String buzmanager, java.lang.Short subrunmode) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
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
        this.iskzcz = iskzcz;
        this.calcumode = calcumode;
        this.uniformtime = uniformtime;
        this.distype = distype;
        this.rivltype = rivltype;
        this.checked = checked;
        this.istietong = istietong;
        this.starlev = starlev;
        this.buzmanager = buzmanager;
        this.subrunmode = subrunmode;
    }

   
    // Property accessors
    @Id 
//    @SequenceGenerator(name="CH_PW_WAYLOG_SEQ")
//    @GeneratedValue(strategy=SEQUENCE, generator="CH_PW_WAYLOG_SEQ")  
    @GeneratedValue(strategy = SEQUENCE, generator = "SeqGenerator")
	@SequenceGenerator(name = "SeqGenerator", sequenceName = "CH_PW_WAYLOG_SEQ", allocationSize=1)
    @Column(name="LOGID", unique=true, nullable=false, precision=14, scale=0)

    public Long getLogid() {
        return this.logid;
    }
    
    public void setLogid(Long logid) {
        this.logid = logid;
    }
    @Temporal(TemporalType.TIMESTAMP)//DATE
    @Column(name="OPTIME", nullable=false, length=7)

    public Date getOptime() {
        return this.optime;
    }
    
    public void setOptime(Date optime) {
        this.optime = optime;
    }
    
    @Column(name="OPRCODE", nullable=false, length=15)

    public String getOprcode() {
        return this.oprcode;
    }
    
    public void setOprcode(String oprcode) {
        this.oprcode = oprcode;
    }
    
    @Column(name="OPRTYPE", nullable=false, length=8)

    public String getOprtype() {
        return this.oprtype;
    }
    
    public void setOprtype(String oprtype) {
        this.oprtype = oprtype;
    }
    
    @Column(name="SUCCESS", length=8)

    public String getSuccess() {
        return this.success;
    }
    
    public void setSuccess(String success) {
        this.success = success;
    }
    
    @Column(name="WAYID", length=18)

    public String getWayid() {
        return this.wayid;
    }
    
    public void setWayid(String wayid) {
        this.wayid = wayid;
    }
    
    @Column(name="SHORTNAME", length=32)

    public String getShortname() {
        return this.shortname;
    }
    
    public void setShortname(String shortname) {
        this.shortname = shortname;
    }
    
    @Column(name="SVBRCHCODE", length=14)

    public String getSvbrchcode() {
        return this.svbrchcode;
    }
    
    public void setSvbrchcode(String svbrchcode) {
        this.svbrchcode = svbrchcode;
    }
    
    @Column(name="SVCCODE", length=14)

    public String getSvccode() {
        return this.svccode;
    }
    
    public void setSvccode(String svccode) {
        this.svccode = svccode;
    }
    
    @Column(name="MAREACODE", length=14)

    public String getMareacode() {
        return this.mareacode;
    }
    
    public void setMareacode(String mareacode) {
        this.mareacode = mareacode;
    }
    
    @Column(name="BUZTYPECODE", precision=2, scale=0)

    public Byte getBuztypecode() {
        return this.buztypecode;
    }
    
    public void setBuztypecode(Byte buztypecode) {
        this.buztypecode = buztypecode;
    }
    
    @Column(name="ADTYPECODE", precision=2, scale=0)

    public Byte getAdtypecode() {
        return this.adtypecode;
    }
    
    public void setAdtypecode(Byte adtypecode) {
        this.adtypecode = adtypecode;
    }
    
    @Column(name="ADDRESS", length=128)

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Column(name="LOGISCODE", length=18)

    public String getLogiscode() {
        return this.logiscode;
    }
    
    public void setLogiscode(String logiscode) {
        this.logiscode = logiscode;
    }
    
    @Column(name="LATITUDE", length=15)

    public String getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    
    @Column(name="LONGTITUDE", length=15)

    public String getLongtitude() {
        return this.longtitude;
    }
    
    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }
    
    @Column(name="ADACODE", length=18)

    public String getAdacode() {
        return this.adacode;
    }
    
    public void setAdacode(String adacode) {
        this.adacode = adacode;
    }
    
    @Column(name="WAYMAGCODE", length=18)

    public String getWaymagcode() {
        return this.waymagcode;
    }
    
    public void setWaymagcode(String waymagcode) {
        this.waymagcode = waymagcode;
    }
    
    @Column(name="CATETYPE", precision=2, scale=0)

    public Byte getCatetype() {
        return this.catetype;
    }
    
    public void setCatetype(Byte catetype) {
        this.catetype = catetype;
    }
    
    @Column(name="FORMTYPE", precision=2, scale=0)

    public Byte getFormtype() {
        return this.formtype;
    }
    
    public void setFormtype(Byte formtype) {
        this.formtype = formtype;
    }
    @Temporal(TemporalType.TIMESTAMP)//DATE
    @Column(name="STARTTIME", length=7)

    public Date getStarttime() {
        return this.starttime;
    }
    
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }
    
    @Column(name="BUZAREA", precision=5, scale=0)

    public Integer getBuzarea() {
        return this.buzarea;
    }
    
    public void setBuzarea(Integer buzarea) {
        this.buzarea = buzarea;
    }
    
    @Column(name="MAINLAYER", precision=2, scale=0)

    public Byte getMainlayer() {
        return this.mainlayer;
    }
    
    public void setMainlayer(Byte mainlayer) {
        this.mainlayer = mainlayer;
    }
    
    @Column(name="SUBLAYER", precision=2, scale=0)

    public Byte getSublayer() {
        return this.sublayer;
    }
    
    public void setSublayer(Byte sublayer) {
        this.sublayer = sublayer;
    }
    
    @Column(name="BUZPHONENO", length=14)

    public String getBuzphoneno() {
        return this.buzphoneno;
    }
    
    public void setBuzphoneno(String buzphoneno) {
        this.buzphoneno = buzphoneno;
    }
    
    @Column(name="WAYNAME", length=256)

    public String getWayname() {
        return this.wayname;
    }
    
    public void setWayname(String wayname) {
        this.wayname = wayname;
    }
    
    @Column(name="COOPERATOR", precision=2, scale=0)

    public Byte getCooperator() {
        return this.cooperator;
    }
    
    public void setCooperator(Byte cooperator) {
        this.cooperator = cooperator;
    }
    
    @Column(name="WAYTYPE", length=4)

    public String getWaytype() {
        return this.waytype;
    }
    
    public void setWaytype(String waytype) {
        this.waytype = waytype;
    }
    
    @Column(name="WAYSUBTYPE", length=4)

    public String getWaysubtype() {
        return this.waysubtype;
    }
    
    public void setWaysubtype(String waysubtype) {
        this.waysubtype = waysubtype;
    }
    
    @Column(name="CUSTTYPE", length=4)

    public String getCusttype() {
        return this.custtype;
    }
    
    public void setCusttype(String custtype) {
        this.custtype = custtype;
    }
    
    @Column(name="UPPERWAYID", length=18)

    public String getUpperwayid() {
        return this.upperwayid;
    }
    
    public void setUpperwayid(String upperwayid) {
        this.upperwayid = upperwayid;
    }
    
    @Column(name="BUSICODE", length=10)

    public String getBusicode() {
        return this.busicode;
    }
    
    public void setBusicode(String busicode) {
        this.busicode = busicode;
    }
    
    @Column(name="COUNTYID", length=14)

    public String getCountyid() {
        return this.countyid;
    }
    
    public void setCountyid(String countyid) {
        this.countyid = countyid;
    }
    
    @Column(name="CITYID", length=14)

    public String getCityid() {
        return this.cityid;
    }
    
    public void setCityid(String cityid) {
        this.cityid = cityid;
    }
    
    @Column(name="CENTERID", length=14)

    public String getCenterid() {
        return this.centerid;
    }
    
    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }
    
    @Column(name="CITYLEVEL", precision=3, scale=0)

    public Short getCitylevel() {
        return this.citylevel;
    }
    
    public void setCitylevel(Short citylevel) {
        this.citylevel = citylevel;
    }
    
    @Column(name="WAYLEVEL", precision=3, scale=0)

    public Short getWaylevel() {
        return this.waylevel;
    }
    
    public void setWaylevel(Short waylevel) {
        this.waylevel = waylevel;
    }
    
    @Column(name="BCHLEVEL", length=4)

    public String getBchlevel() {
        return this.bchlevel;
    }
    
    public void setBchlevel(String bchlevel) {
        this.bchlevel = bchlevel;
    }
    
    @Column(name="FUNCTION")

    public String getFunction() {
        return this.function;
    }
    
    public void setFunction(String function) {
        this.function = function;
    }
    
    @Column(name="MISCODE", length=12)

    public String getMiscode() {
        return this.miscode;
    }
    
    public void setMiscode(String miscode) {
        this.miscode = miscode;
    }
    @Temporal(TemporalType.TIMESTAMP)//DATE
    @Column(name="CREATETIME", length=7)

    public Date getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    @Temporal(TemporalType.TIMESTAMP)//DATE
    @Column(name="DISABLETIME", length=7)

    public Date getDisabletime() {
        return this.disabletime;
    }
    
    public void setDisabletime(Date disabletime) {
        this.disabletime = disabletime;
    }
    
    @Column(name="WAYSTATE", precision=3, scale=0)

    public Short getWaystate() {
        return this.waystate;
    }
    
    public void setWaystate(Short waystate) {
        this.waystate = waystate;
    }
    
    @Column(name="RUNBYSELF", length=4)

    public String getRunbyself() {
        return this.runbyself;
    }
    
    public void setRunbyself(String runbyself) {
        this.runbyself = runbyself;
    }
    
    @Column(name="DEPOTDET", length=20)

    public String getDepotdet() {
        return this.depotdet;
    }
    
    public void setDepotdet(String depotdet) {
        this.depotdet = depotdet;
    }
    
    @Column(name="ISSHARE", length=32)

    public String getIsshare() {
        return this.isshare;
    }
    
    public void setIsshare(String isshare) {
        this.isshare = isshare;
    }
    
    @Column(name="ALARMBIZAMOUNT", precision=10, scale=0)

    public Long getAlarmbizamount() {
        return this.alarmbizamount;
    }
    
    public void setAlarmbizamount(Long alarmbizamount) {
        this.alarmbizamount = alarmbizamount;
    }
    
    @Column(name="PRTSOURCE", precision=2, scale=0)

    public Byte getPrtsource() {
        return this.prtsource;
    }
    
    public void setPrtsource(Byte prtsource) {
        this.prtsource = prtsource;
    }
    
    @Column(name="ISCONNECTED", precision=2, scale=0)

    public Byte getIsconnected() {
        return this.isconnected;
    }
    
    public void setIsconnected(Byte isconnected) {
        this.isconnected = isconnected;
    }
    
    @Column(name="CONNECTTYPE", precision=2, scale=0)

    public Byte getConnecttype() {
        return this.connecttype;
    }
    
    public void setConnecttype(Byte connecttype) {
        this.connecttype = connecttype;
    }
    
    @Column(name="RUNMODE", precision=2, scale=0)

    public Byte getRunmode() {
        return this.runmode;
    }
    
    public void setRunmode(Byte runmode) {
        this.runmode = runmode;
    }
    
    @Column(name="ISCOREWAY", precision=2, scale=0)

    public Byte getIscoreway() {
        return this.iscoreway;
    }
    
    public void setIscoreway(Byte iscoreway) {
        this.iscoreway = iscoreway;
    }
    
    @Column(name="STARLEVEL", precision=2, scale=0)

    public Byte getStarlevel() {
        return this.starlevel;
    }
    
    public void setStarlevel(Byte starlevel) {
        this.starlevel = starlevel;
    }
    
    @Column(name="PT", precision=2, scale=0)

    public Byte getPt() {
        return this.pt;
    }
    
    public void setPt(Byte pt) {
        this.pt = pt;
    }
    
    @Column(name="CHAINHEAD", length=18)

    public String getChainhead() {
        return this.chainhead;
    }
    
    public void setChainhead(String chainhead) {
        this.chainhead = chainhead;
    }
    
    @Column(name="SIGNSTATUS", precision=2, scale=0)

    public Byte getSignstatus() {
        return this.signstatus;
    }
    
    public void setSignstatus(Byte signstatus) {
        this.signstatus = signstatus;
    }
    
    @Column(name="EMPNUMBER", precision=4, scale=0)

    public Short getEmpnumber() {
        return this.empnumber;
    }
    
    public void setEmpnumber(Short empnumber) {
        this.empnumber = empnumber;
    }
    
    @Column(name="MAGNUMBER", precision=4, scale=0)

    public Short getMagnumber() {
        return this.magnumber;
    }
    
    public void setMagnumber(Short magnumber) {
        this.magnumber = magnumber;
    }
    
    @Column(name="TERMINUMBER", precision=4, scale=0)

    public Short getTerminumber() {
        return this.terminumber;
    }
    
    public void setTerminumber(Short terminumber) {
        this.terminumber = terminumber;
    }
    @Temporal(TemporalType.TIMESTAMP)//DATE
    @Column(name="UPDATEDATE", length=7)

    public Date getUpdatedate() {
        return this.updatedate;
    }
    
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }
    
    @Column(name="ISSTRAITPRD", precision=2, scale=0)

    public Byte getIsstraitprd() {
        return this.isstraitprd;
    }
    
    public void setIsstraitprd(Byte isstraitprd) {
        this.isstraitprd = isstraitprd;
    }
    
    @Column(name="TAXTYPE", precision=2, scale=0)

    public Byte getTaxtype() {
        return this.taxtype;
    }
    
    public void setTaxtype(Byte taxtype) {
        this.taxtype = taxtype;
    }
    
    @Column(name="ISKZCZ", precision=3, scale=0)

    public Short getIskzcz() {
        return this.iskzcz;
    }
    
    public void setIskzcz(Short iskzcz) {
        this.iskzcz = iskzcz;
    }
    
    @Column(name="CALCUMODE", precision=3, scale=0)

    public Short getCalcumode() {
        return this.calcumode;
    }
    
    public void setCalcumode(Short calcumode) {
        this.calcumode = calcumode;
    }
    
    @Column(name="UNIFORMTIME", length=6)

    public String getUniformtime() {
        return this.uniformtime;
    }
    
    public void setUniformtime(String uniformtime) {
        this.uniformtime = uniformtime;
    }
    
    @Column(name="DISTYPE", precision=3, scale=0)

    public Short getDistype() {
        return this.distype;
    }
    
    public void setDistype(Short distype) {
        this.distype = distype;
    }
    
    @Column(name="RIVLTYPE", precision=3, scale=0)

    public Short getRivltype() {
        return this.rivltype;
    }
    
    public void setRivltype(Short rivltype) {
        this.rivltype = rivltype;
    }
    
    @Column(name="CHECKED", length=3)

    public String getChecked() {
        return this.checked;
    }
    
    public void setChecked(String checked) {
        this.checked = checked;
    }
    
    @Column(name="ISTIETONG", precision=2, scale=0)

    public Byte getIstietong() {
        return this.istietong;
    }
    
    public void setIstietong(Byte istietong) {
        this.istietong = istietong;
    }
    
    @Column(name="STARLEV", length=1)

    public String getStarlev() {
        return this.starlev;
    }
    
    public void setStarlev(String starlev) {
        this.starlev = starlev;
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