package com.sunrise.boss.ui.cms.examine.itemgraded;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ItemgradedBatchForm extends UploadFileForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemgradedBatchForm() {
		super.setCheckFormat(new ItemgradedBatchCheck());
	}
}
