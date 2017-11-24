package com.sunrise.boss.ui.cms.examine.oprnwayid;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class OprnwayidBatchForm extends UploadFileForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OprnwayidBatchForm() {
		super.setCheckFormat(new OprnwayidBatchCheck());
	}
}
