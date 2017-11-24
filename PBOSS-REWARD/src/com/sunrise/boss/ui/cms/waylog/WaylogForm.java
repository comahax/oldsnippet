/**
* auto-generated code
* Wed Oct 18 14:48:22 CST 2006
*/
package com.sunrise.boss.ui.cms.waylog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.waylog.persistent.WaylogVO;

/**
 * <p>Title: WaylogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WaylogForm extends BaseActionForm {
    private String _dnl_optime;
    private String _dnm_optime;
    private String _sk_oprcode;
    private String _se_oprtype;
    private String _se_success;

		private Long logid;
		private java.util.Date optime;
		private String oprcode;
		private String oprtype;
		private String success;
		private String wayid;
		private String wayname;
		private String waytype;
		private String waysubtype;
		private String custtype;
		private String upperwayid;
		private String countyid;
		private String cityid;
		private String centerid;
		private Short citylevel;
		private Short waylevel;
		private String bchlevel;
		private String function;
		private String miscode;
		private Short waystate;
		
		private Long prtsource;
	    private Long isconnected;
	    private Long connecttype;
	    private Long runmode;
	    private Long iscoreway;
	    private Long starlevel;
	    private Long pt;
	    private String chainhead;
	    private Long signstatus;
	    private Long empnumber;
	    private Long magnumber;
	    private Long terminumber;
	    private java.util.Date updatedate;
	    private Short isstraitprd;
	    private Short taxtype;

    public String get_dnl_optime(){
        return _dnl_optime;
    }

    public void set_dnl_optime(String _dnl_optime){
        this._dnl_optime = _dnl_optime;
    }
    public String get_dnm_optime(){
        return _dnm_optime;
    }

    public void set_dnm_optime(String _dnm_optime){
        this._dnm_optime = _dnm_optime;
    }
    public String get_sk_oprcode(){
        return _sk_oprcode;
    }

    public void set_sk_oprcode(String _sk_oprcode){
        this._sk_oprcode = _sk_oprcode;
    }
    public String get_se_oprtype(){
        return _se_oprtype;
    }

    public void set_se_oprtype(String _se_oprtype){
        this._se_oprtype = _se_oprtype;
    }
    public String get_se_success(){
        return _se_success;
    }

    public void set_se_success(String _se_success){
        this._se_success = _se_success;
    }

		public  Long getLogid() {
        return logid;
    }
		public void setLogid(Long logid) {
        this.logid=logid;
    }
		public  java.util.Date getOptime() {
        return optime;
    }
		public void setOptime(java.util.Date optime) {
        this.optime=optime;
    }
		public  String getOprcode() {
        return oprcode;
    }
		public void setOprcode(String oprcode) {
        this.oprcode=oprcode;
    }
		public  String getOprtype() {
        return oprtype;
    }
		public void setOprtype(String oprtype) {
        this.oprtype=oprtype;
    }
		public  String getSuccess() {
        return success;
    }
		public void setSuccess(String success) {
        this.success=success;
    }
		public  String getWayid() {
        return wayid;
    }
		public void setWayid(String wayid) {
        this.wayid=wayid;
    }
		public  String getWayname() {
        return wayname;
    }
		public void setWayname(String wayname) {
        this.wayname=wayname;
    }
		public  String getWaytype() {
        return waytype;
    }
		public void setWaytype(String waytype) {
        this.waytype=waytype;
    }
		public  String getWaysubtype() {
        return waysubtype;
    }
		public void setWaysubtype(String waysubtype) {
        this.waysubtype=waysubtype;
    }
		public  String getCusttype() {
        return custtype;
    }
		public void setCusttype(String custtype) {
        this.custtype=custtype;
    }
		public  String getUpperwayid() {
        return upperwayid;
    }
		public void setUpperwayid(String upperwayid) {
        this.upperwayid=upperwayid;
    }
		public  String getCountyid() {
        return countyid;
    }
		public void setCountyid(String countyid) {
        this.countyid=countyid;
    }
		public  String getCityid() {
        return cityid;
    }
		public void setCityid(String cityid) {
        this.cityid=cityid;
    }
		public  String getCenterid() {
        return centerid;
    }
		public void setCenterid(String centerid) {
        this.centerid=centerid;
    }
		public  Short getCitylevel() {
        return citylevel;
    }
		public void setCitylevel(Short citylevel) {
        this.citylevel=citylevel;
    }
		public  Short getWaylevel() {
        return waylevel;
    }
		public void setWaylevel(Short waylevel) {
        this.waylevel=waylevel;
    }
		public  String getBchlevel() {
        return bchlevel;
    }
		public void setBchlevel(String bchlevel) {
        this.bchlevel=bchlevel;
    }
		public  String getFunction() {
        return function;
    }
		public void setFunction(String function) {
        this.function=function;
    }
		public  String getMiscode() {
        return miscode;
    }
		public void setMiscode(String miscode) {
        this.miscode=miscode;
    }
		public  Short getWaystate() {
        return waystate;
    }
		public void setWaystate(Short waystate) {
        this.waystate=waystate;
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

		public Short getIsstraitprd() {
			return isstraitprd;
		}

		public void setIsstraitprd(Short isstraitprd) {
			this.isstraitprd = isstraitprd;
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

		public Short getTaxtype() {
			return taxtype;
		}

		public void setTaxtype(Short taxtype) {
			this.taxtype = taxtype;
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

}
