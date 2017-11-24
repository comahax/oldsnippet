package com.sunrise.boss.ui.cms.servcent;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchServcentForm extends UploadFileForm {
	private String _se_countyid;

	public BatchServcentForm() {
		this.setCheckFormat(new BatchServcentCheck());
	}

	public String get_se_countyid() {
		return _se_countyid;
	}

	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}
}
