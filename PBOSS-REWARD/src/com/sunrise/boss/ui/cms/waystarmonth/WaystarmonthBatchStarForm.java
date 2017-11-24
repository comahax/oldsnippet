package com.sunrise.boss.ui.cms.waystarmonth;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class WaystarmonthBatchStarForm extends UploadFileForm{
	
	public WaystarmonthBatchStarForm() {
		super.setCheckFormat(new WaystarmonthBatchStarCheck());
	}
	
}
