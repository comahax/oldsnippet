/**
* auto-generated code
* Fri Aug 25 11:29:29 CST 2006
*/
package com.sunrise.boss.ui.cms.waycompact;

import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactVO;

/**
 * <p>Title: WaycompactForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class WaycompactForm extends BaseActionForm {
	
	private String _se_wayid;
	
	private String _sk_compactno;
	
	private String _sk_compactname;
	
    /** identifier field */
    private String wayid;

    /** persistent field */
    private String compactno;

    /** persistent field */
    private String compactname;

    /** persistent field */
    private java.sql.Date begintime;

    /** persistent field */
    private java.sql.Date endtime;

    /** persistent field */
    private java.sql.Date signtime;

    /** nullable persistent field */
    private Short coptype;

    /** nullable persistent field */
    private String copbound;

    /** nullable persistent field */
    private String recomrule;

    /** nullable persistent field */
    private String compact;
    
    private String licenceno;
    
    private String compactpath;
    
    private String licencepath;
    
    private Short runareatype;
    
    private String principal;
    
    private Double bail;
    
    private Short bailstatus;
    
    private Short compacttype;
    
    private Short isb2m;

	//新增
	private String subtype;
	
	private FormFile compactfile; // 文本
	
	private FormFile licencefile; // 合同
	
	
	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

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

	public String getCompact() {
		return compact;
	}

	public void setCompact(String compact) {
		this.compact = compact;
	}

	public String getCompactname() {
		return compactname;
	}

	public void setCompactname(String compactname) {
		this.compactname = compactname;
	}

	public String getCompactno() {
		return compactno;
	}

	public void setCompactno(String compactno) {
		this.compactno = compactno;
	}

	public String getCopbound() {
		return copbound;
	}

	public void setCopbound(String copbound) {
		this.copbound = copbound;
	}

	public Short getCoptype() {
		return coptype;
	}

	public void setCoptype(Short coptype) {
		this.coptype = coptype;
	}


	public String getRecomrule() {
		return recomrule;
	}

	public void setRecomrule(String recomrule) {
		this.recomrule = recomrule;
	}

	public java.sql.Date getBegintime() {
		return begintime;
	}

	public void setBegintime(java.sql.Date begintime) {
		this.begintime = begintime;
	}

	public java.sql.Date getEndtime() {
		return endtime;
	}

	public void setEndtime(java.sql.Date endtime) {
		this.endtime = endtime;
	}

	public java.sql.Date getSigntime() {
		return signtime;
	}

	public void setSigntime(java.sql.Date signtime) {
		this.signtime = signtime;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_sk_compactname() {
		return _sk_compactname;
	}

	public void set_sk_compactname(String _sk_compactname) {
		this._sk_compactname = _sk_compactname;
	}

	public String get_sk_compactno() {
		return _sk_compactno;
	}

	public void set_sk_compactno(String _sk_compactno) {
		this._sk_compactno = _sk_compactno;
	}

	public FormFile getCompactfile() {
		return compactfile;
	}

	public void setCompactfile(FormFile compactfile) {
		this.compactfile = compactfile;
	}

	public FormFile getLicencefile() {
		return licencefile;
	}

	public void setLicencefile(FormFile licencefile) {
		this.licencefile = licencefile;
	}

	public Short getIsb2m() {
		return isb2m;
	}

	public void setIsb2m(Short isb2m) {
		this.isb2m = isb2m;
	}
    
    
	
}
