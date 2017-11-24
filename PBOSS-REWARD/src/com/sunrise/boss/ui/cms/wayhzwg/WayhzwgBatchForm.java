package com.sunrise.boss.ui.cms.wayhzwg;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class WayhzwgBatchForm extends UploadFileForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WayhzwgBatchForm() {
		super.setCheckFormat(new WayhzwgBatchCheck());
	}
}
