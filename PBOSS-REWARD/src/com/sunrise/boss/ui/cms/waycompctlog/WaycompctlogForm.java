/**
* auto-generated code
* Wed Oct 18 14:54:55 CST 2006
*/
package com.sunrise.boss.ui.cms.waycompctlog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.waycompctlog.persistent.WaycompctlogVO;

/**
 * <p>Title: WaycompctlogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WaycompctlogForm extends BaseActionForm {
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
		private String compactno;
		private String compactname;
		private java.util.Date begintime;
		private java.util.Date endtime;
		private java.util.Date signtime;
		private Short coptype;
		private String copbound;
		private String recomrule;
		private String compact;
	    private Short isb2m;
	    
	    private String licenceno;
	    
	    private String compactpath;
	    
	    private String licencepath;
	    
	    private Short runareatype;
	    
	    private String principal;
	    
	    private Double bail;
	    
	    private Short bailstatus;
	    
	    private Short compacttype;

    public Double getBail() {
			return bail;
		}

		public void setBail(Double bail) {
			this.bail = bail;
		}

		public Short getBailstatus() {
			return bailstatus;
		}

		public void setBailstatus(Short bailstatus) {
			this.bailstatus = bailstatus;
		}

		public String getCompactpath() {
			return compactpath;
		}

		public void setCompactpath(String compactpath) {
			this.compactpath = compactpath;
		}

		public Short getCompacttype() {
			return compacttype;
		}

		public void setCompacttype(Short compacttype) {
			this.compacttype = compacttype;
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

		public String getPrincipal() {
			return principal;
		}

		public void setPrincipal(String principal) {
			this.principal = principal;
		}

		public Short getRunareatype() {
			return runareatype;
		}

		public void setRunareatype(Short runareatype) {
			this.runareatype = runareatype;
		}

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
		public  String getCompactno() {
        return compactno;
    }
		public void setCompactno(String compactno) {
        this.compactno=compactno;
    }
		public  String getCompactname() {
        return compactname;
    }
		public void setCompactname(String compactname) {
        this.compactname=compactname;
    }
		public  java.util.Date getBegintime() {
        return begintime;
    }
		public void setBegintime(java.util.Date begintime) {
        this.begintime=begintime;
    }
		public  java.util.Date getEndtime() {
        return endtime;
    }
		public void setEndtime(java.util.Date endtime) {
        this.endtime=endtime;
    }
		public  java.util.Date getSigntime() {
        return signtime;
    }
		public void setSigntime(java.util.Date signtime) {
        this.signtime=signtime;
    }
		public  Short getCoptype() {
        return coptype;
    }
		public void setCoptype(Short coptype) {
        this.coptype=coptype;
    }
		public  String getCopbound() {
        return copbound;
    }
		public void setCopbound(String copbound) {
        this.copbound=copbound;
    }
		public  String getRecomrule() {
        return recomrule;
    }
		public void setRecomrule(String recomrule) {
        this.recomrule=recomrule;
    }
		public  String getCompact() {
        return compact;
    }
		public void setCompact(String compact) {
        this.compact=compact;
    }

		public Short getIsb2m() {
			return isb2m;
		}

		public void setIsb2m(Short isb2m) {
			this.isb2m = isb2m;
		}

}
