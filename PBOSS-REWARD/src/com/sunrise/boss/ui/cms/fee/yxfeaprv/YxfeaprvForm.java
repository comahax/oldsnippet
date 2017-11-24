/**
* auto-generated code
* Fri Dec 08 11:45:12 CST 2006
*/
package com.sunrise.boss.ui.cms.fee.yxfeaprv;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.fee.yxfeaprv.persistent.YxfeaprvVO;

/**
 * <p>Title: YxfeaprvForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxfeaprvForm extends BaseActionForm {

	   /** identifier field */
    private Long seq;

    /** persistent field */
    private String wayid;

    /** persistent field */
    private java.sql.Timestamp apptime;

    /** persistent field */
    private String appoprcode;

    /** persistent field */
    private String appfee;

    /** nullable persistent field */
    private java.sql.Timestamp extime;

    /** nullable persistent field */
    private String exoprcode;

    /** nullable persistent field */
    private Double exfee;

    /** nullable persistent field */
    private String opinion;

    /** nullable persistent field */
    private Double recvfee;

    /** nullable persistent field */
    private String recvoprcode;

    /** nullable persistent field */
    private java.sql.Timestamp recvtime;

    /** persistent field */
    private String yxfeeuse;

    /** persistent field */
    private Short state;
    
    private String curoprcode;

    /** full constructor */
    public YxfeaprvForm(java.lang.Long seq, java.lang.String wayid, java.sql.Timestamp apptime, java.lang.String appoprcode, java.lang.String appfee, java.sql.Timestamp extime, java.lang.String exoprcode, java.lang.Double exfee, java.lang.String opinion, java.lang.Double recvfee, java.lang.String recvoprcode, java.sql.Timestamp recvtime, java.lang.String yxfeeuse, java.lang.Short state) {
        this.seq = seq;
        this.wayid = wayid;
        this.apptime = apptime;
        this.appoprcode = appoprcode;
        this.appfee = appfee;
        this.extime = extime;
        this.exoprcode = exoprcode;
        this.exfee = exfee;
        this.opinion = opinion;
        this.recvfee = recvfee;
        this.recvoprcode = recvoprcode;
        this.recvtime = recvtime;
        this.yxfeeuse = yxfeeuse;
        this.state = state;
    }

    /** default constructor */
    public YxfeaprvForm() {
    }

    /** minimal constructor */
    public YxfeaprvForm(java.lang.Long seq, java.lang.String wayid, java.sql.Timestamp apptime, java.lang.String appoprcode, java.lang.String appfee, java.lang.String yxfeeuse, java.lang.Short state) {
        this.seq = seq;
        this.wayid = wayid;
        this.apptime = apptime;
        this.appoprcode = appoprcode;
        this.appfee = appfee;
        this.yxfeeuse = yxfeeuse;
        this.state = state;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.sql.Timestamp getApptime() {
        return this.apptime;
    }

    public void setApptime(java.sql.Timestamp apptime) {
        this.apptime = apptime;
    }

    public java.lang.String getAppoprcode() {
        return this.appoprcode;
    }

    public void setAppoprcode(java.lang.String appoprcode) {
        this.appoprcode = appoprcode;
    }

    public java.lang.String getAppfee() {
    	
    	String fee_str = "";
    	if(appfee != null && !"".equals(appfee)){
    		Double fee = Double.valueOf(appfee);
    	
    		java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");     
    		fee_str = df.format(fee);   
    	}
    	
        return fee_str;
    }

    public void setAppfee(java.lang.String appfee) {
        this.appfee = appfee;
    }

    public java.sql.Timestamp getExtime() {
        return this.extime;
    }

    public void setExtime(java.sql.Timestamp extime) {
        this.extime = extime;
    }

    public java.lang.String getExoprcode() {
        return this.exoprcode;
    }

    public void setExoprcode(java.lang.String exoprcode) {
        this.exoprcode = exoprcode;
    }

    public java.lang.Double getExfee() {
        return this.exfee;
    }

    public void setExfee(java.lang.Double exfee) {
        this.exfee = exfee;
    }

    public java.lang.String getOpinion() {
        return this.opinion;
    }

    public void setOpinion(java.lang.String opinion) {
        this.opinion = opinion;
    }

    public java.lang.Double getRecvfee() {
        return this.recvfee;
    }

    public void setRecvfee(java.lang.Double recvfee) {
        this.recvfee = recvfee;
    }

    public java.lang.String getRecvoprcode() {
        return this.recvoprcode;
    }

    public void setRecvoprcode(java.lang.String recvoprcode) {
        this.recvoprcode = recvoprcode;
    }

    public java.sql.Timestamp getRecvtime() {
        return this.recvtime;
    }

    public void setRecvtime(java.sql.Timestamp recvtime) {
        this.recvtime = recvtime;
    }

    public java.lang.String getYxfeeuse() {
        return this.yxfeeuse;
    }

    public void setYxfeeuse(java.lang.String yxfeeuse) {
        this.yxfeeuse = yxfeeuse;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public java.lang.String getCuroprcode() {
        return this.curoprcode;
    }

    public void setCuroprcode(java.lang.String curoprcode) {
        this.curoprcode = curoprcode;
    }
    
	private String _sk_wayid;
	private String _se_state;
	private String _se_appoprcode;
	private String _dnl_apptime;
	private String _dnm_apptime;

	public String get_sk_wayid() {
		return _sk_wayid;
	}

	public void set_sk_wayid(String _sk_wayid) {
		this._sk_wayid = _sk_wayid;
	}	

	public String get_se_state() {
		return _se_state;
	}

	public void set_se_state(String _se_state) {
		this._se_state = _se_state;
	}	

	public String get_se_appoprcode() {
		return _se_appoprcode;
	}

	public void set_se_appoprcode(String _se_appoprcode) {
		this._se_appoprcode = _se_appoprcode;
	}	
	
	public String get_dnl_apptime() {
		return _dnl_apptime;
	}

	public void set_dnl_apptime(String _dnl_apptime) {
		this._dnl_apptime = _dnl_apptime;
	}

	public String get_dnm_apptime() {
		return _dnm_apptime;
	}

	public void set_dnm_apptime(String _dnm_apptime) {
		this._dnm_apptime = _dnm_apptime;
	}

	private String _se_exoprcode;
	private String _dnl_extime;
	private String _dnm_extime;
	
	public String get_se_exoprcode() {
		return _se_exoprcode;
	}

	public void set_se_exoprcode(String _se_exoprcode) {
		this._se_exoprcode = _se_exoprcode;
	}	
	
	public String get_dnl_extime() {
		return _dnl_extime;
	}

	public void set_dnl_extime(String _dnl_extime) {
		this._dnl_extime = _dnl_extime;
	}

	public String get_dnm_extime() {
		return _dnm_extime;
	}

	public void set_dnm_extime(String _dnm_extime) {
		this._dnm_extime = _dnm_extime;
	}

}
