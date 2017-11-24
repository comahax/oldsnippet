/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */
package com.sunrise.boss.ui.cms.bbc.operationlog;

import java.util.Date;
import java.util.Iterator;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.cms.commons.ApplyResBean;
import com.sunrise.boss.ui.cms.commons.CMSConstant;
import com.sunrise.boss.ui.cms.commons.CMSUtils;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: OperationForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class BBCoperationlogForm extends BaseActionForm {
	private Long logid;
	private Date optime;
	private String oprcode;
	private String oprtype;
	private String success;
	private String opnid;
	private String name;
	private String parentid;
	private String remark;
	private Short state;
	private Date startdate;
	private Date enddate;
	private Short isbusi;
	private Short opnlevel;
	private Short busikind;
	private String busibelong;
	private String _se_logid;
	public String get_se_logid() {
		return _se_logid;
	}
	public void set_se_logid(String _se_logid) {
		this._se_logid = _se_logid;
	}
	public String getBusibelong() {
		return busibelong;
	}
	public void setBusibelong(String busibelong) {
		this.busibelong = busibelong;
	}
	public Short getBusikind() {
		return busikind;
	}
	public void setBusikind(Short busikind) {
		this.busikind = busikind;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public Short getIsbusi() {
		return isbusi;
	}
	public void setIsbusi(Short isbusi) {
		this.isbusi = isbusi;
	}
	public Long getLogid() {
		return logid;
	}
	public void setLogid(Long logid) {
		this.logid = logid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpnid() {
		return opnid;
	}
	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}
	public String getOprcode() {
		return oprcode;
	}
	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}
	public String getOprtype() {
		return oprtype;
	}
	public Date getOptime() {
		return optime;
	}
	public void setOptime(Date optime) {
		this.optime = optime;
	}
	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Short getState() {
		return state;
	}
	public void setState(Short state) {
		this.state = state;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public Short getOpnlevel() {
		return opnlevel;
	}
	public void setOpnlevel(Short opnlevel) {
		this.opnlevel = opnlevel;
	}

}
