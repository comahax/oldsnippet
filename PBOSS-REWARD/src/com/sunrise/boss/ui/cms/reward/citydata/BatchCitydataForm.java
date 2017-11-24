package com.sunrise.boss.ui.cms.reward.citydata;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchCitydataForm extends UploadFileForm {
	
	public BatchCitydataForm() {
		setCheckFormat(new BatchCitydataCheck());
	}
	private String citydatatype;
	private String remark;
	private String[] _selectitem;
	
	private String result;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCitydatatype() {
		return citydatatype;
	}

	public void setCitydatatype(String citydatatype) {
		this.citydatatype = citydatatype;
	}

	public String[] get_selectitem() {
		return _selectitem;
	}

	public void set_selectitem(String[] _selectitem) {
		this._selectitem = _selectitem;
	}
	
}
