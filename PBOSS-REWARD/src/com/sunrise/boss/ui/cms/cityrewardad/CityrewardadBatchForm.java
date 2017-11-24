package com.sunrise.boss.ui.cms.cityrewardad;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class CityrewardadBatchForm extends UploadFileForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CityrewardadBatchForm() {
		super.setCheckFormat(new CityrewardadBatchCheck());
	}
}
