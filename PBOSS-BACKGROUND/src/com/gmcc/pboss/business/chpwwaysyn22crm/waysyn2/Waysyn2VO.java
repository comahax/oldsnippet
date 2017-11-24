package com.gmcc.pboss.business.chpwwaysyn22crm.waysyn2;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class Waysyn2VO extends BaseVO implements Serializable {

    /** identifier field */
    private Long itemid;

    /** persistent field */
    private String wayid;

    /** nullable persistent field */
    private String shortname;

    /** nullable persistent field */
    private String svbrchcode;

    /** nullable persistent field */
    private String svccode;

    /** nullable persistent field */
    private String mareacode;

    /** nullable persistent field */
    private Short buztypecode;

    /** nullable persistent field */
    private Short adtypecode;

    /** nullable persistent field */
    private String address;

    /** nullable persistent field */
    private String logiscode;

    /** nullable persistent field */
    private String latitude;

    /** nullable persistent field */
    private String longtitude;

    /** nullable persistent field */
    private String adacode;

    /** nullable persistent field */
    private String waymagcode;

    /** nullable persistent field */
    private Short catetype;

    /** nullable persistent field */
    private Short formtype;

    /** nullable persistent field */
    private java.util.Date starttime;

    /** nullable persistent field */
    private Integer buzarea;

    /** nullable persistent field */
    private Short mainlayer;

    /** nullable persistent field */
    private Short sublayer;

    /** nullable persistent field */
    private String buzphoneno;

    /** persistent field */
    private String wayname;

    /** nullable persistent field */
    private Short cooperator;

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
    private java.util.Date createtime;

    /** nullable persistent field */
    private java.util.Date disabletime;

    /** nullable persistent field */
    private Short waystate;

    /** nullable persistent field */
    private String runbyself;

    /** nullable persistent field */
    private String depotdet;

    /** nullable persistent field */
    private String isshare;

    /** nullable persistent field */
    private Long alarmbizamount;

    /** nullable persistent field */
    private Short prtsource;

    /** nullable persistent field */
    private Short isconnected;

    /** nullable persistent field */
    private Short connecttype;

    /** nullable persistent field */
    private Short runmode;

    /** nullable persistent field */
    private Short iscoreway;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private Short pt;

    /** nullable persistent field */
    private String chainhead;

    /** nullable persistent field */
    private Short signstatus;

    /** nullable persistent field */
    private Short empnumber;

    /** nullable persistent field */
    private Short magnumber;

    /** nullable persistent field */
    private Short terminumber;

    /** nullable persistent field */
    private java.util.Date updatedate;

    /** nullable persistent field */
    private Short isstraitprd;

    /** nullable persistent field */
    private Short taxtype;

    /** nullable persistent field */
    private Short istietong;

    /** nullable persistent field */
    private Short calcumode;

    /** nullable persistent field */
    private String uniformtime;

    /** nullable persistent field */
    private Short iskzcz;

    /** nullable persistent field */
    private String checked;

    /** nullable persistent field */
    private Short distype;

    /** nullable persistent field */
    private Short rivltype;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private Short opract;

    private String buzmanager;

    private Short subrunmode;

    /** full constructor */
    public Waysyn2VO(java.lang.Long itemid, java.lang.String wayid, java.lang.String shortname, java.lang.String svbrchcode, java.lang.String svccode, java.lang.String mareacode, java.lang.Short buztypecode, java.lang.Short adtypecode, java.lang.String address, java.lang.String logiscode, java.lang.String latitude, java.lang.String longtitude, java.lang.String adacode, java.lang.String waymagcode, java.lang.Short catetype, java.lang.Short formtype, java.util.Date starttime, java.lang.Integer buzarea, java.lang.Short mainlayer, java.lang.Short sublayer, java.lang.String buzphoneno, java.lang.String wayname, java.lang.Short cooperator, java.lang.String waytype, java.lang.String waysubtype, java.lang.String custtype, java.lang.String upperwayid, java.lang.String busicode, java.lang.String countyid, java.lang.String cityid, java.lang.String centerid, java.lang.Short citylevel, java.lang.Short waylevel, java.lang.String bchlevel, java.lang.String function, java.lang.String miscode, java.util.Date createtime, java.util.Date disabletime, java.lang.Short waystate, java.lang.String runbyself, java.lang.String depotdet, java.lang.String isshare, java.lang.Long alarmbizamount, java.lang.Short prtsource, java.lang.Short isconnected, java.lang.Short connecttype, java.lang.Short runmode, java.lang.Short iscoreway, java.lang.Short starlevel, java.lang.Short pt, java.lang.String chainhead, java.lang.Short signstatus, java.lang.Short empnumber, java.lang.Short magnumber, java.lang.Short terminumber, java.util.Date updatedate, java.lang.Short isstraitprd, java.lang.Short taxtype, java.lang.Short istietong, java.lang.Short calcumode, java.lang.String uniformtime, java.lang.Short iskzcz, java.lang.String checked, java.lang.Short distype, java.lang.Short rivltype, java.lang.String oprtype, java.util.Date oprtime, java.lang.Short opract, java.lang.String buzmanager, java.lang.Short subrunmode) {
        this.itemid = itemid;
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
        this.calcumode = calcumode;
        this.uniformtime = uniformtime;
        this.iskzcz = iskzcz;
        this.checked = checked;
        this.distype = distype;
        this.rivltype = rivltype;
        this.oprtype = oprtype;
        this.oprtime = oprtime;
        this.opract = opract;
        this.buzmanager = buzmanager;
        this.subrunmode = subrunmode;
    }

    /** default constructor */
    public Waysyn2VO() {
    }

    /** minimal constructor */
    public Waysyn2VO(java.lang.Long itemid, java.lang.String wayid, java.lang.String wayname, java.lang.String waytype) {
        this.itemid = itemid;
        this.wayid = wayid;
        this.wayname = wayname;
        this.waytype = waytype;
    }

    public java.lang.Long getItemid() {
        return this.itemid;
    }

    public void setItemid(java.lang.Long itemid) {
        this.itemid = itemid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getShortname() {
        return this.shortname;
    }

    public void setShortname(java.lang.String shortname) {
        this.shortname = shortname;
    }

    public java.lang.String getSvbrchcode() {
        return this.svbrchcode;
    }

    public void setSvbrchcode(java.lang.String svbrchcode) {
        this.svbrchcode = svbrchcode;
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

    public java.lang.Short getBuztypecode() {
        return this.buztypecode;
    }

    public void setBuztypecode(java.lang.Short buztypecode) {
        this.buztypecode = buztypecode;
    }

    public java.lang.Short getAdtypecode() {
        return this.adtypecode;
    }

    public void setAdtypecode(java.lang.Short adtypecode) {
        this.adtypecode = adtypecode;
    }

    public java.lang.String getAddress() {
        return this.address;
    }

    public void setAddress(java.lang.String address) {
        this.address = address;
    }

    public java.lang.String getLogiscode() {
        return this.logiscode;
    }

    public void setLogiscode(java.lang.String logiscode) {
        this.logiscode = logiscode;
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

    public java.lang.String getAdacode() {
        return this.adacode;
    }

    public void setAdacode(java.lang.String adacode) {
        this.adacode = adacode;
    }

    public java.lang.String getWaymagcode() {
        return this.waymagcode;
    }

    public void setWaymagcode(java.lang.String waymagcode) {
        this.waymagcode = waymagcode;
    }

    public java.lang.Short getCatetype() {
        return this.catetype;
    }

    public void setCatetype(java.lang.Short catetype) {
        this.catetype = catetype;
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

    public java.lang.Short getMainlayer() {
        return this.mainlayer;
    }

    public void setMainlayer(java.lang.Short mainlayer) {
        this.mainlayer = mainlayer;
    }

    public java.lang.Short getSublayer() {
        return this.sublayer;
    }

    public void setSublayer(java.lang.Short sublayer) {
        this.sublayer = sublayer;
    }

    public java.lang.String getBuzphoneno() {
        return this.buzphoneno;
    }

    public void setBuzphoneno(java.lang.String buzphoneno) {
        this.buzphoneno = buzphoneno;
    }

    public java.lang.String getWayname() {
        return this.wayname;
    }

    public void setWayname(java.lang.String wayname) {
        this.wayname = wayname;
    }

    public java.lang.Short getCooperator() {
        return this.cooperator;
    }

    public void setCooperator(java.lang.Short cooperator) {
        this.cooperator = cooperator;
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

    public java.lang.String getBusicode() {
        return this.busicode;
    }

    public void setBusicode(java.lang.String busicode) {
        this.busicode = busicode;
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

    public java.lang.Short getWaystate() {
        return this.waystate;
    }

    public void setWaystate(java.lang.Short waystate) {
        this.waystate = waystate;
    }

    public java.lang.String getRunbyself() {
        return this.runbyself;
    }

    public void setRunbyself(java.lang.String runbyself) {
        this.runbyself = runbyself;
    }

    public java.lang.String getDepotdet() {
        return this.depotdet;
    }

    public void setDepotdet(java.lang.String depotdet) {
        this.depotdet = depotdet;
    }

    public java.lang.String getIsshare() {
        return this.isshare;
    }

    public void setIsshare(java.lang.String isshare) {
        this.isshare = isshare;
    }

    public java.lang.Long getAlarmbizamount() {
        return this.alarmbizamount;
    }

    public void setAlarmbizamount(java.lang.Long alarmbizamount) {
        this.alarmbizamount = alarmbizamount;
    }

    public java.lang.Short getPrtsource() {
        return this.prtsource;
    }

    public void setPrtsource(java.lang.Short prtsource) {
        this.prtsource = prtsource;
    }

    public java.lang.Short getIsconnected() {
        return this.isconnected;
    }

    public void setIsconnected(java.lang.Short isconnected) {
        this.isconnected = isconnected;
    }

    public java.lang.Short getConnecttype() {
        return this.connecttype;
    }

    public void setConnecttype(java.lang.Short connecttype) {
        this.connecttype = connecttype;
    }

    public java.lang.Short getRunmode() {
        return this.runmode;
    }

    public void setRunmode(java.lang.Short runmode) {
        this.runmode = runmode;
    }

    public java.lang.Short getIscoreway() {
        return this.iscoreway;
    }

    public void setIscoreway(java.lang.Short iscoreway) {
        this.iscoreway = iscoreway;
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

    public java.lang.String getChainhead() {
        return this.chainhead;
    }

    public void setChainhead(java.lang.String chainhead) {
        this.chainhead = chainhead;
    }

    public java.lang.Short getSignstatus() {
        return this.signstatus;
    }

    public void setSignstatus(java.lang.Short signstatus) {
        this.signstatus = signstatus;
    }

    public java.lang.Short getEmpnumber() {
        return this.empnumber;
    }

    public void setEmpnumber(java.lang.Short empnumber) {
        this.empnumber = empnumber;
    }

    public java.lang.Short getMagnumber() {
        return this.magnumber;
    }

    public void setMagnumber(java.lang.Short magnumber) {
        this.magnumber = magnumber;
    }

    public java.lang.Short getTerminumber() {
        return this.terminumber;
    }

    public void setTerminumber(java.lang.Short terminumber) {
        this.terminumber = terminumber;
    }

    public java.util.Date getUpdatedate() {
        return this.updatedate;
    }

    public void setUpdatedate(java.util.Date updatedate) {
        this.updatedate = updatedate;
    }

    public java.lang.Short getIsstraitprd() {
        return this.isstraitprd;
    }

    public void setIsstraitprd(java.lang.Short isstraitprd) {
        this.isstraitprd = isstraitprd;
    }

    public java.lang.Short getTaxtype() {
        return this.taxtype;
    }

    public void setTaxtype(java.lang.Short taxtype) {
        this.taxtype = taxtype;
    }

    public java.lang.Short getIstietong() {
        return this.istietong;
    }

    public void setIstietong(java.lang.Short istietong) {
        this.istietong = istietong;
    }

    public java.lang.Short getCalcumode() {
        return this.calcumode;
    }

    public void setCalcumode(java.lang.Short calcumode) {
        this.calcumode = calcumode;
    }

    public java.lang.String getUniformtime() {
        return this.uniformtime;
    }

    public void setUniformtime(java.lang.String uniformtime) {
        this.uniformtime = uniformtime;
    }

    public java.lang.Short getIskzcz() {
        return this.iskzcz;
    }

    public void setIskzcz(java.lang.Short iskzcz) {
        this.iskzcz = iskzcz;
    }

    public java.lang.String getChecked() {
        return this.checked;
    }

    public void setChecked(java.lang.String checked) {
        this.checked = checked;
    }

    public java.lang.Short getDistype() {
        return this.distype;
    }

    public void setDistype(java.lang.Short distype) {
        this.distype = distype;
    }

    public java.lang.Short getRivltype() {
        return this.rivltype;
    }

    public void setRivltype(java.lang.Short rivltype) {
        this.rivltype = rivltype;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.Short getOpract() {
        return this.opract;
    }

    public void setOpract(java.lang.Short opract) {
        this.opract = opract;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("itemid", getItemid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof Waysyn2VO) ) return false;
        Waysyn2VO castOther = (Waysyn2VO) other;
        return new EqualsBuilder()
            .append(this.getItemid(), castOther.getItemid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getItemid())
            .toHashCode();
    }

}
