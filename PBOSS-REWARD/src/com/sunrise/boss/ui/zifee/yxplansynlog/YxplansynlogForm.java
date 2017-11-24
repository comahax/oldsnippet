/**
 * auto-generated code
 * Thu Dec 11 16:31:58 CST 2008
 */
package com.sunrise.boss.ui.zifee.yxplansynlog;

import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.zifee.yxplansynlog.persistent.YxplansynlogVO;

/**
 * <p>
 * Title: YxplansynlogForm
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
 * @author Jerimy
 * @version 1.0
 */
public class YxplansynlogForm extends BaseActionForm {

	private Long logid;

	private java.util.Date createtime;

	private java.util.Date modifytime;

	private String oprcode;

	private String yxplanid;

	private String syntype;

	private String oprresult;

	private String oprstate;

	private String oprobject;

	private String remark;

	private String batchaction;

	private String reInfo;

	private FormFile inputFile; // 批量上传文件

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public java.util.Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public java.util.Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(java.util.Date modifytime) {
		this.modifytime = modifytime;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getYxplanid() {
		return yxplanid;
	}

	public void setYxplanid(String yxplanid) {
		this.yxplanid = yxplanid;
	}

	public String getSyntype() {
		return syntype;
	}

	public void setSyntype(String syntype) {
		this.syntype = syntype;
	}

	public String getOprresult() {
		return oprresult;
	}

	public void setOprresult(String oprresult) {
		this.oprresult = oprresult;
	}

	public String getOprstate() {
		return oprstate;
	}

	public void setOprstate(String oprstate) {
		this.oprstate = oprstate;
	}

	public String getOprobject() {
		return oprobject;
	}

	public void setOprobject(String oprobject) {
		this.oprobject = oprobject;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBatchaction() {
		return batchaction;
	}

	public void setBatchaction(String batchaction) {
		this.batchaction = batchaction;
	}

	public String getReInfo() {
		return reInfo;
	}

	public void setReInfo(String reInfo) {
		this.reInfo = reInfo;
	}

	public FormFile getInputFile() {
		return inputFile;
	}

	public void setInputFile(FormFile inputFile) {
		this.inputFile = inputFile;
	}

}
