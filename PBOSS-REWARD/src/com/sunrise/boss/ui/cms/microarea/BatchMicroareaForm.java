package com.sunrise.boss.ui.cms.microarea;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchMicroareaForm extends UploadFileForm {
	private String _se_svccode;
	public BatchMicroareaForm() {
		this.setCheckFormat(new BatchMicroareaCheck());
	}
	public String get_se_svccode() {
		return _se_svccode;
	}
	public void set_se_svccode(String _se_svccode) {
		this._se_svccode = _se_svccode;
	}
}