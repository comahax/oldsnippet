package com.sunrise.boss.ui.cms.waystarmonth;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class WaystarmonthBatchForm extends UploadFileForm{
	
	public WaystarmonthBatchForm() {
		super.setCheckFormat(new WaystarmonthBatchCheck());
	}
	
}
