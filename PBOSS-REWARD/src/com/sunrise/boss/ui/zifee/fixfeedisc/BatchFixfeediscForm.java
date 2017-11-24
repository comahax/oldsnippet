package com.sunrise.boss.ui.zifee.fixfeedisc;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchFixfeediscForm extends UploadFileForm {
	private String _ne_yxplanid;

	private String areacode;

	private String yxplanid;

	private String lockOject;

	private String operType;

	public BatchFixfeediscForm() {
		this.setCheckFormat(new BatchFixfeediscCheck());
	}

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	public String get_ne_yxplanid() {
		return _ne_yxplanid;
	}

	public void set_ne_yxplanid(String _ne_yxplanid) {
		this._ne_yxplanid = _ne_yxplanid;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getLockOject() {
		return lockOject;
	}

	public void setLockOject(String lockOject) {
		this.lockOject = lockOject;
	}

	public String getYxplanid() {
		return yxplanid;
	}

	public void setYxplanid(String yxplanid) {
		this.yxplanid = yxplanid;
	}

}