/**
* auto-generated code
* Fri Dec 08 17:16:19 CST 2006
*/
package com.sunrise.boss.ui.cms.fee.bail;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.fee.bail.persistent.BailVO;

/**
 * <p>Title: BailForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class BailForm extends BaseActionForm {

    /** identifier field */
    private Long seq;

    /** persistent field */
    private String wayid;

    /** persistent field */
    private Short bailtype;

    /** persistent field */
    private String money;

    /** nullable persistent field */
    private java.util.Date givetime;
    private String givetimestr;
    /** persistent field */
    private Short opertype;

    /** nullable persistent field */
    private String recvoprcode;

    /** nullable persistent field */
    private java.util.Date recvtime;
    private String recvtimestr;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public BailForm(java.lang.Long seq, java.lang.String wayid, java.lang.Short bailtype, java.lang.String money, java.util.Date givetime, java.lang.Short opertype, java.lang.String recvoprcode, java.util.Date recvtime, java.lang.String memo) {
        this.seq = seq;
        this.wayid = wayid;
        this.bailtype = bailtype;
        this.money = money;
        this.givetime = givetime;
        this.opertype = opertype;
        this.recvoprcode = recvoprcode;
        this.recvtime = recvtime;
        this.memo = memo;
    }

    /** default constructor */
    public BailForm() {
    }

    /** minimal constructor */
    public BailForm(java.lang.Long seq, java.lang.String wayid, java.lang.Short bailtype, java.lang.String money, java.lang.Short opertype) {
        this.seq = seq;
        this.wayid = wayid;
        this.bailtype = bailtype;
        this.money = money;
        this.opertype = opertype;
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

    public java.lang.Short getBailtype() {
        return this.bailtype;
    }

    public void setBailtype(java.lang.Short bailtype) {
        this.bailtype = bailtype;
    }

    public java.lang.String getMoney() {
        return this.money;
    }

    public void setMoney(java.lang.String money) {
        this.money = money;
    }

    public java.util.Date getGivetime() {
        return this.givetime;
    }

    public void setGivetime(java.util.Date givetime) {
        this.givetime = givetime;
    }
    public java.lang.String getGivetimestr() {
    	String result = "";
    	if (givetime != null) {
    	java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
    	return format.format(givetime);
    	}
    	return result;
    }

    public void setGivetimestr(java.lang.String givetimestr) throws Exception {
    	try {
    		if ((givetimestr != null) && (givetimestr.length() > 0)) {
    			java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
    			givetime = format.parse(givetimestr);
    		} else {
    			givetime = null;
    		}
    		} catch (Exception exp) {
//    		 指定的日期字符串格式不对，应为yyyy-mm-dd
    		throw new Exception("have a NG date format");
    		} 		

    	this.givetimestr = givetimestr;
    }
    public java.lang.Short getOpertype() {
        return this.opertype;
    }

    public void setOpertype(java.lang.Short opertype) {
        this.opertype = opertype;
    }

    public java.lang.String getRecvoprcode() {
        return this.recvoprcode;
    }

    public void setRecvoprcode(java.lang.String recvoprcode) {
        this.recvoprcode = recvoprcode;
    }

    public java.util.Date getRecvtime() {
        return this.recvtime;
    }

    public void setRecvtime(java.util.Date recvtime) {
        this.recvtime = recvtime;
    }

    public java.lang.String getRecvtimestr() {
    	String result = "";
    	if (recvtime != null) {
    	java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
    	return format.format(recvtime);
    	}
    	return result;
    }

    public void setRecvtimestr(java.lang.String recvtimestr) throws Exception {
    	try {
    		if ((recvtimestr != null) && (recvtimestr.length() > 0)) {
    			java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
    			recvtime = format.parse(recvtimestr);
    		} else {
    			recvtime = null;
    		}
    		} catch (Exception exp) {
//    		 指定的日期字符串格式不对，应为yyyy-mm-dd
    		throw new Exception("have a NG date format");
    		} 		

    	this.recvtimestr = recvtimestr;
    }
    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }
	private String _sk_wayid;
	private String _se_bailtype;
	private String _se_opertype;
	private String _se_recvoprcode;
	private String _dnl_recvtime;
	private String _dnm_recvtime;

	public String get_sk_wayid() {
		return _sk_wayid;
	}

	public void set_sk_wayid(String _sk_wayid) {
		this._sk_wayid = _sk_wayid;
	}	

	public String get_se_bailtype() {
		return _se_bailtype;
	}

	public void set_se_bailtype(String _se_bailtype) {
		this._se_bailtype = _se_bailtype;
	}	

	public String get_se_opertype() {
		return _se_opertype;
	}

	public void set_se_opertype(String _se_opertype) {
		this._se_opertype = _se_opertype;
	}		

	public String get_se_recvoprcode() {
		return _se_recvoprcode;
	}

	public void set_se_recvoprcode(String _se_recvoprcode) {
		this._se_recvoprcode = _se_recvoprcode;
	}	
	
	public String get_dnl_recvtime() {
		return _dnl_recvtime;
	}

	public void set_dnl_recvtime(String _dnl_recvtime) {
		//_dnl_recvtime = _dnl_recvtime + " 00:00:00";
		this._dnl_recvtime = _dnl_recvtime;
	}

	public String get_dnm_recvtime() {
		return _dnm_recvtime;
	}

	public void set_dnm_recvtime(String _dnm_recvtime) {
		//_dnm_recvtime = _dnm_recvtime + " 23:59:59";
		this._dnm_recvtime = _dnm_recvtime;
	}


}
